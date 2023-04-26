package proyecto.grupo07.idat.controller;

import java.io.IOException;
import java.text.DateFormat;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lowagie.text.DocumentException;

import proyecto.grupo07.idat.model.Almacen;
import proyecto.grupo07.idat.service.AlmacenService;
import proyecto.grupo07.idat.util.reportes.InsumosExporterExcel;
import proyecto.grupo07.idat.util.reportes.InsumosExporterPDF;

@Controller
@RequestMapping("/Almacen")
public class AlmacenController {
	@Autowired
	private AlmacenService productoServicio;
	
	@RequestMapping("/ConsultaAlmacen")
	public String Inicio(Model model, @Param("clave") String clave) {
		List<Almacen> listaProductos = productoServicio.listAll(clave);
		
		model.addAttribute("listaProductos", listaProductos);
		model.addAttribute("clave", clave);
		return "/SeccionAdministrativa/ConsultaDeAlmacen";
		}
	
	@RequestMapping("/RegistroAlmacen")
	public String registrarProducto(Model model) {
		Almacen producto = new Almacen();
		model.addAttribute("producto", producto);
		return "/SeccionAdministrativa/RegistroDeAlmacen";
	}
	
	@RequestMapping(value = "/GuardarAlmacen", method = RequestMethod.POST)
	public String guardarProducto(@ModelAttribute("producto")Almacen producto, RedirectAttributes attribute) {
		productoServicio.save(producto);
		attribute.addFlashAttribute("registrado", "Se registro el productos con exito");
		return "redirect:/Almacen/RegistroAlmacen";
	}
	
	@RequestMapping("/EditarAlmacen/{id_almacen}")
	public ModelAndView editarProducto(@PathVariable(name = "id_almacen") Long id_almacen) {
		
		ModelAndView model = new ModelAndView("/SeccionAdministrativa/EditarAlmacen");
		
		Almacen producto = productoServicio.get(id_almacen);
		model.addObject("producto", producto);
		
		return model;
		
	}
	
	@PostMapping("/GuardarAlmacenEditado")
	public String GuardarALmacenEditado(Almacen producto, RedirectAttributes attribute) {
		attribute.addFlashAttribute("editado", "El insumo fue editado con exito");
		productoServicio.save(producto);
		return "redirect:/Almacen/ConsultaAlmacen";
	}
	
	
	@RequestMapping("/EliminarAlmacen/{id_almacen}")
	public String eliminarProducto(@PathVariable(name="id_almacen") Long id_almacen) {
		productoServicio.delete(id_almacen);
		return "redirect:/Almacen/ConsultaAlmacen";
	}
	
	
	@GetMapping("/exportarPDF")
	public void exportarListadoInsumosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Insumos_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		List<Almacen> insumos = productoServicio.findAll();
		
		InsumosExporterPDF exporter = new InsumosExporterPDF(insumos);
		exporter.exportar(response);
	}
	
	@GetMapping("/exportarExcel")
	public void exportarListadoDeInsumosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=ListaInsumos_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Almacen> insumos = productoServicio.findAll();
		
		InsumosExporterExcel exporter = new InsumosExporterExcel(insumos);
		exporter.exportar(response);
	}
}
