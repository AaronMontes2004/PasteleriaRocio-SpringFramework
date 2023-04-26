package proyecto.grupo07.idat.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lowagie.text.DocumentException;

import proyecto.grupo07.idat.model.Proveedor;
import proyecto.grupo07.idat.service.ProveedorService;
import proyecto.grupo07.idat.util.reportes.ProveedorExporterExcel;
import proyecto.grupo07.idat.util.reportes.ProveedorExporterPDF;

@Controller
@RequestMapping("/Proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorService serviceProveedor;
	
	@GetMapping("/ConsultaDeProveedor")
	public String ConsultaDeProveedor(Model model, @Param("palabra") String palabra) {
		List<Proveedor> proveedores = serviceProveedor.listar(palabra);
		model.addAttribute("proveedores", proveedores);
		model.addAttribute("palabra", palabra);
		return "/SeccionAdministrativa/ConsultaDeProveedor";
	}
	
	@GetMapping("/RegistroDeProveedor")
	public String RegistroDeProveedor(Model model) {
		model.addAttribute("proveedor", new Proveedor());
		return "/SeccionAdministrativa/RegistroDeProveedor";
	}
	
	@PostMapping("/GuardarProveedor")
	public String GuardarProveedor(@Valid Proveedor proveedor,Model model, RedirectAttributes attribute) {
		attribute.addFlashAttribute("registrado", "El proveedor fue registrado con exito");
		serviceProveedor.save(proveedor);
		return "redirect:/Proveedor/RegistroDeProveedor";
	}
	
	@GetMapping("/EditarProveedor/{id}")
	public String EditarProducto(@PathVariable int id,Model model, RedirectAttributes attribute) {
		Proveedor proveedor = serviceProveedor.listarId(id);
		//attribute.addFlashAttribute("editado", "Proveedor editado con exito");
		model.addAttribute("proveedor", proveedor);
		return "/SeccionAdministrativa/RegistroDeProveedor";
	}
	
	@GetMapping("/EliminarProveedor/{id}")
	public String EliminarProveedor(@PathVariable int id,Model model){
		serviceProveedor.delete(id);
		return "redirect:/Proveedor/ConsultaDeProveedor";
	}
	
	@GetMapping("/exportarPDF")
	public void exportarListadoDeProveedoresEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Proveedores_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		List<Proveedor> proveedores = serviceProveedor.findAll();
		
		ProveedorExporterPDF exporter = new ProveedorExporterPDF(proveedores);
		exporter.exportar(response);
	}
	
	
	@GetMapping("/exportarExcel")
	public void exportarListadoDeProveedorEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Proveedores_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Proveedor> proveedores = serviceProveedor.findAll();
		
		ProveedorExporterExcel exporter = new ProveedorExporterExcel(proveedores);
		exporter.exportar(response);
	}
	
	
	
}
