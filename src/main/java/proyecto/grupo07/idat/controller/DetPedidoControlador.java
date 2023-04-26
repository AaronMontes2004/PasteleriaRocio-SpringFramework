package proyecto.grupo07.idat.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import proyecto.grupo07.idat.model.DetallePedido;
import proyecto.grupo07.idat.model.DetalleProveedor;
import proyecto.grupo07.idat.service.DetPedidoServicio;
import proyecto.grupo07.idat.util.reportes.VentaExporterExcel;
import proyecto.grupo07.idat.util.reportes.VentaExporterPDF;


@Controller
@RequestMapping("/DetallePedido")
public class DetPedidoControlador {
	
	@Autowired
	private DetPedidoServicio detPedidoServicio;
	
	@GetMapping("/ConsultaDetallePedido")
	public String verInicio(Model modelo, @Param("palabraClave") String palabraClave, @Param("Estado") String estado) {
		List<DetallePedido> listadetped = detPedidoServicio.listAll(palabraClave);
		List<DetallePedido> listaDetalleEstado = new ArrayList<DetallePedido>();
		DecimalFormat formatear = new DecimalFormat("#.00");
		
		if(estado == null) {
			estado = "TODOS";
		}
		
		String valor = estado;
		
		try {
			if (estado.equals("TODOS")) {
				String sumaTotal = null;;
				double total = 0;
				int cantidad = listadetped.size();
				for(DetallePedido Total: listadetped) {
					total += Total.getTotal();
					sumaTotal = formatear.format(total);
				}
				
				modelo.addAttribute("listadetped", listadetped);
				modelo.addAttribute("estado", estado);
				modelo.addAttribute("palabraClave", palabraClave);
				modelo.addAttribute("cantidadDatos", cantidad);
				modelo.addAttribute("sumaTotal", sumaTotal);
				return "/SeccionAdministrativa/ConsultaDetallePedido";
			}
			else if(estado.equals("ENTREGADO") || estado.equals("PENDIENTE")) {
				listadetped.stream().filter(x -> x.getEstado().equals(valor)).forEach(i->listaDetalleEstado.add(i));
				int cantidad = listaDetalleEstado.size();
				String sumaTotal = null;;
				double total = 0;
				for(DetallePedido Total: listaDetalleEstado) {
					total += Total.getTotal();
					sumaTotal = formatear.format(total);
				}
				modelo.addAttribute("listadetped", listaDetalleEstado);
				modelo.addAttribute("estado", estado);
				modelo.addAttribute("palabraClave", palabraClave);
				modelo.addAttribute("cantidadDatos", cantidad);
				modelo.addAttribute("sumaTotal", sumaTotal);
				return "/SeccionAdministrativa/ConsultaDetallePedido";
			} else {
				int cantidad = listadetped.size();
				modelo.addAttribute("cantidadDatos", cantidad);
				modelo.addAttribute("listadetped", listadetped);
				return "/SeccionAdministrativa/ConsultaDetallePedido";
			}

		}catch (Exception e) {
			return "/SeccionAdministrativa/ConsultaDetallePedido";
		}
	}
	
	
	
	@RequestMapping( value="/guardar", method = RequestMethod.POST)
	public String GuardarDetallePedido(@ModelAttribute("detallepedido") DetallePedido detallepedido) {
		detPedidoServicio.save(detallepedido);
		return "redirect:/DetallePedido/ConsultaDetallePedido";
	}
	
	
	
	@RequestMapping("/editar/{id_detalle_pedido}")
	public ModelAndView EditarDetallePedido(@PathVariable(name="id_detalle_pedido") Integer id_detalle_pedido) {
		ModelAndView model = new ModelAndView("/SeccionAdministrativa/editar_dPedido");
		
		DetallePedido pedido = detPedidoServicio.get(id_detalle_pedido);
		model.addObject("detallepedido",  pedido);
		
		return model;
		
	}
	
	
	
	
	
	@GetMapping("/exportarPDF")
	public void exportarListadoDePedidosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=PedidosSolicitados_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		List<DetallePedido> pedidos = detPedidoServicio.findAll();
		
		VentaExporterPDF exporter = new VentaExporterPDF(pedidos);
		exporter.exportar(response);
	}
	
	
	@GetMapping("/exportarExcel")
	public void exportarListadoDePedidosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=PedidosSolicitados_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<DetallePedido> pedidos = detPedidoServicio.findAll();
		
		VentaExporterExcel exporter = new VentaExporterExcel(pedidos);
		exporter.exportar(response);
	}
	
	
	
	
	
	
	
}
