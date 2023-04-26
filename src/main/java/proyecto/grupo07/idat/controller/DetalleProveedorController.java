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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lowagie.text.DocumentException;

import proyecto.grupo07.idat.model.DetalleProveedor;
import proyecto.grupo07.idat.model.ProductoPerso;
import proyecto.grupo07.idat.service.DetalleProveedorService;
import proyecto.grupo07.idat.util.reportes.CompraExporterExcel;
import proyecto.grupo07.idat.util.reportes.CompraExporterPDF;

@Controller
@RequestMapping("/PedidoCompra")
public class DetalleProveedorController {

	@Autowired
	private DetalleProveedorService detalleProveedorServicio;

	@RequestMapping("/index")
	private String Inicio(Model model, @Param("clave") String clave) {
		List<DetalleProveedor> listaProveedor = detalleProveedorServicio.listAll(clave);

		DecimalFormat formatear = new DecimalFormat("#.00");
		String sumaTotal = null;
		double total = 0;
		int cantidad = listaProveedor.size();
		for(DetalleProveedor Total: listaProveedor) {
			total += (Total.getPrecio_insumos() * Total.getCantidad());
			sumaTotal = formatear.format(total);
		}
		
		model.addAttribute("listaProveedor", listaProveedor);
		model.addAttribute("clave", clave);
		model.addAttribute("cantidadDatos", cantidad);
		model.addAttribute("sumaTotal", sumaTotal);

		return "/SeccionAdministrativa/index";
	}

	@RequestMapping("/nuevo")
	public String RegistrarDetalleProveedor(Model model) {
		DetalleProveedor proveedor = new DetalleProveedor();
		model.addAttribute("proveedor", proveedor);
		return "/SeccionAdministrativa/nuevo_proveedor";
	}
	
	@RequestMapping( value="/guardar", method = RequestMethod.POST)
	public String GuardarDetalleProveedor(@ModelAttribute("proveedor") DetalleProveedor proveedor) {
		detalleProveedorServicio.save(proveedor);
		return "redirect:/PedidoCompra/index";
	}
	
	
	@RequestMapping("/editar/{id_detalle_proveedor}")
	public ModelAndView EditarDetalleProveedor(@PathVariable(name="id_detalle_proveedor") Long id_proveedor ) {
		ModelAndView model = new ModelAndView("/SeccionAdministrativa/editar_dProveedor");
		
		DetalleProveedor proveedor = detalleProveedorServicio.get(id_proveedor);
		model.addObject("proveedor",  proveedor);
		
		return model;
		
	}
	
	@RequestMapping("/eliminar/{id_detalle_proveedor}")
	public String eliminarDetalleProveedor(@PathVariable(name="id_detalle_proveedor") Long id_proveedor ) {
		detalleProveedorServicio.delete(id_proveedor);
		return "redirect:/PedidoCompra/index";
		
	}
	/*grafico circular*/
	
	@RequestMapping("/circular")
	public String Contactos() {
		return "circularC";
	}
	
	
	
	
	
	@RequestMapping("/piechart")
	public ResponseEntity<?> getDetalleProveedor(){
		List<DetalleProveedor> databaseData=detalleProveedorServicio.findAll();
		return new ResponseEntity<>(databaseData,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	@GetMapping("/exportarPDF")
	public void exportarListadoDePedidoCompraEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=PedidosdeCompra_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		List<DetalleProveedor> compras = detalleProveedorServicio.findAll();
		
		CompraExporterPDF exporter = new CompraExporterPDF(compras);
		exporter.exportar(response);
	}
	
	@GetMapping("/exportarExcel")
	public void exportarListadoDePedidoCompraEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=PedidoCompras_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<DetalleProveedor> compras = detalleProveedorServicio.findAll();
		
		CompraExporterExcel exporter = new CompraExporterExcel(compras);
		exporter.exportar(response);
	}
	
	

}
