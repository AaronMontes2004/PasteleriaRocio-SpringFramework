package proyecto.grupo07.idat.controlador.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import proyecto.grupo07.idat.Order;
import proyecto.grupo07.idat.service.PaypalService;

@Controller
public class PaypalController {
	
	@Autowired
	PaypalService service;

	public static final String SUCCESS_URL = "pay/success";
	public static final String CANCEL_URL = "pay/cancel";

	@GetMapping("/Pagos")
	public String home() {
		return "/RealizarPago";
	}

	@PostMapping("/pay")
	public String payment(@ModelAttribute("order") Order order) {
		try {
			Payment payment = service.createPayment(order.getPrice(), order.getCurrency(), order.getMethod(),
					order.getIntent(), order.getDescription(), "http://localhost:8080/" + CANCEL_URL,
					"http://localhost:8080/" + SUCCESS_URL);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					return "redirect:"+link.getHref();
				}
			}
			
		} catch (PayPalRESTException e) {
		
			e.printStackTrace();
		}
		return "redirect:/carritodecomprasR";
	}
	
	 @GetMapping(value = CANCEL_URL)
	    public String cancelPay() {
	        return "cancel";
	    }

	    @GetMapping(value = SUCCESS_URL)
	    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId, RedirectAttributes attribute) {
	    	attribute.addFlashAttribute("comprado", "Compra realizada con éxito");
	    	try {
	            Payment payment = service.executePayment(paymentId, payerId);
	            System.out.println(payment.toJSON());
	            //if (payment.getState().equals("approved")) {
	            attribute.addFlashAttribute("comprado", "Compra realizada con éxito");
	            return "redirect:/carritodecomprasR";
	            //}
	        } catch (PayPalRESTException e) {
	        	attribute.addFlashAttribute("comprado", "Compra realizada con éxito");
	        	//System.out.println(e.getMessage());
	        }
	        return "redirect:/carritodecomprasR";
	    }
}
