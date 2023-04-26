package proyecto.grupo07.idat.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;

import proyecto.grupo07.idat.model.ProductoPerso;
import proyecto.grupo07.idat.service.ProductoPersoServicio;
import proyecto.grupo07.idat.util.reportes.PersonalizadoExporterExcel;
import proyecto.grupo07.idat.util.reportes.PersonalizadoExporterPDF;



@Controller
@RequestMapping("/ProductoPersonalizado")
public class ProductoPersoControlador {
	@Autowired
	private ProductoPersoServicio productoPersoServicio;
	
	@RequestMapping("/Personalizado")
	public String verIni(Model modelo, @Param("palabraClave") String palabraClave) {
		List<ProductoPerso> listaproduperso = productoPersoServicio.listAll(palabraClave);
		DecimalFormat formatear = new DecimalFormat("#.00");
		String sumaTotal = null;
		double total = 0;
		int cantidad = listaproduperso.size();
		for(ProductoPerso Total: listaproduperso) {
			total += (Total.getPrecio() * Total.getCantidad());
			sumaTotal = formatear.format(total);
		}
		
		modelo.addAttribute("palabraClave", palabraClave);
		modelo.addAttribute("listaproduperso", listaproduperso);
		modelo.addAttribute("cantidadDatos", cantidad);
		modelo.addAttribute("sumaTotal", sumaTotal);
		
		return "/SeccionAdministrativa/indexpersonalizado";
	}
	
	@GetMapping("/VerDetalles/{id}")
	public String VerDetalleProductoPersonalizado(Model model, @PathVariable("id") Long id) {
		ProductoPerso productoPerso = productoPersoServicio.get(id);
		model.addAttribute("producto", productoPerso);
		model.addAttribute("titulo", "Detalle del productos personalizado con código "+productoPerso.getId_producto_perso());
		return "/SeccionAdministrativa/VerDetallePerso";
	}
	
	@RequestMapping( value="/guardar", method = RequestMethod.POST)
	public String GuardarDetallePedidoPersonalizado(@ModelAttribute("detallepedidopersonalizado") ProductoPerso detallepedidopersonalizado) {
		productoPersoServicio.save(detallepedidopersonalizado);
		return "redirect:/ProductoPersonalizado/Personalizado";
	}
	
	
	
	@RequestMapping("/editar/{id_producto_perso}")
	public ModelAndView EditarDetallePedido(@PathVariable(name="id_producto_perso") Long id_detalle_pedidopersonalizado) {
		ModelAndView model = new ModelAndView("/SeccionAdministrativa/editar_dPedidoPersonalizado");
		
		ProductoPerso pedido = productoPersoServicio.get(id_detalle_pedidopersonalizado);
		model.addObject("detallepedidopersonalizado",  pedido);
		
		return model;
		
	}
	
	
	
	
	
	
	
	@GetMapping("/exportarPDF")
	public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=ProductoPersonalizado_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		List<ProductoPerso> empleados = productoPersoServicio.findAll();
		
		PersonalizadoExporterPDF exporter = new PersonalizadoExporterPDF(empleados);
		exporter.exportar(response);
	}
	
	@GetMapping("/exportarExcel")
	public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=ProductosPersonalizados_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<ProductoPerso> empleados = productoPersoServicio.findAll();
		
		PersonalizadoExporterExcel exporter = new PersonalizadoExporterExcel(empleados);
		exporter.exportar(response);
	}
	
	
	/*grafico circular de personalizado*/
	
	@RequestMapping("/grafico")
	public String Grafico() {
		return "graficopersonalizado";
	}
	
	
	
	
	
}
