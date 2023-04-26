package proyecto.grupo07.idat.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import proyecto.grupo07.idat.model.Categoria;
import proyecto.grupo07.idat.model.Producto;
import proyecto.grupo07.idat.model.ProductoPersonalizado;
import proyecto.grupo07.idat.service.CategoriaService;
import proyecto.grupo07.idat.service.ProductoService;

@Controller
@RequestMapping("/Producto")
public class ProductoController {
	
	@Autowired
	public ProductoService serviceProducto;
	
	@Autowired
	public CategoriaService servicioCategoria;
	
	/*@GetMapping(value="/IMAGENES/{filename:.+}")
	public ResponseEntity<Resource> verImagen(@PathVariable String filename){
		Path pathFoto = Paths.get("IMAGENES").resolve(filename).toAbsolutePath();
		Resource recurso = null;
		try {
			recurso = new UrlResource(pathFoto.toUri());
			if (!recurso.exists() || !recurso.isReadable()) {
				throw new RuntimeException("Error: no se puede cargar la imagen: "+pathFoto.toString());
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=\""+recurso.getFilename()+"\"").body(recurso);
	}
	*/
	@GetMapping("/CategoriaTortasStandard")
	public String CategoriaTortasStandard(Model model) {
		String x = null;
		List<Producto> productosStandard = serviceProducto.listar(x);
		model.addAttribute("productos", productosStandard);
		return "/SeccionVentas/CategoriaTortasStandard";
	}
	
	@GetMapping("/CategoriaTortasStandardU")
	public String CategoriaTortasStandardU(Model model) {
		String x = null;
		List<Producto> productosStandard = serviceProducto.listar(x);
		model.addAttribute("productos", productosStandard);
		return "/SeccionVentas/CategoriaTortasStandardU";
	}
	
	@GetMapping("/CategoriaTortasPersonalizadas")
	public String CategoriaTortasPersonalizadas(Model model) {
		String x = null;
		List<Producto> productosPersonalizados = serviceProducto.listar(x);
		model.addAttribute("productosP", productosPersonalizados);
		return "/SeccionVentas/CategoriaTortasPersonalizadas";
	}
	
	@GetMapping("/CategoriaTortasPersonalizadasU")
	public String CategoriaTortasPersonalizadasU(Model model) {
		String x = null;
		List<Producto> productosPersonalizados = serviceProducto.listar(x);
		model.addAttribute("productosP", productosPersonalizados);
		return "/SeccionVentas/CategoriaTortasPersonalizadasU";
	}
	
	
	@GetMapping("/InfoTortaStandard")
	public String InfoTortaStandard(Model model) {	
		return "/SeccionVentas/InfoTortaStandard";
	}
	
	@GetMapping("/InfoTortaStandardU")
	public String InfoTortaStandardU(Model model) {
		return "/SeccionVentas/InfoTortaStandardU";
	}
	
	
	
	
	@GetMapping("/MenuAdministrativo")
	public String MenuAdministrativo(Model model) {
		return "/SeccionAdministrativa/MenuAdministrativo";
	}
	
	@GetMapping("/InfoTortaStandard/{id}")
	public String InfoTortaStandard(@PathVariable("id") int idproducto, Model model) {
		List<Producto> prod = serviceProducto.listar(null);
		List<Producto> aleatorios = new ArrayList<Producto>();
		int cantidad = prod.size();
		int contador = 0;
		int diferente[] = new int[4];
		while(contador < 4) {
			int ale = (int)(Math.random()*cantidad);
			
			if (prod.get(ale).getIdCategoria() != 7 && prod.get(ale).getIdCategoria() != 8 &&
				prod.get(ale).getIdCategoria() != 9 && prod.get(ale).getIdCategoria() != 10 &&
				prod.get(ale).getIdCategoria() != 11) {
				boolean verificar = false;
				if (contador == 0) {
					diferente[contador] = ale;}
				else {
					for (int i =0; i < diferente.length;i++) {
						if (diferente[i] == ale) {
							verificar = true;
							break;
						}
						verificar = false;}
				}
				System.out.println(diferente.length);
				if (verificar == false) {
					diferente[contador] = ale;
					aleatorios.add(prod.get(ale)); //AQUI FALTA LA CONDICIÓN POR CATEGORIA
					contador+=1;
				}
			}
		}
		Producto producto = null;
		producto = serviceProducto.listarId(idproducto);
		model.addAttribute("producto", producto);
		model.addAttribute("aleatorios", aleatorios);
		return "/SeccionVentas/InfoTortaStandard";
	}
	
	@GetMapping("/InfoTortaStandardU/{id}")
	public String InfoTortaStandardU(@PathVariable("id") int idproducto, Model model) {
		List<Producto> prod = serviceProducto.listar(null);
		List<Producto> aleatorios = new ArrayList<Producto>();
		int cantidad = prod.size();
		int contador = 0;
		int diferente[] = new int[4];
		while(contador < 4) {
			int ale = (int)(Math.random()*cantidad);
			
			if (prod.get(ale).getIdCategoria() != 7 && prod.get(ale).getIdCategoria() != 8 &&
				prod.get(ale).getIdCategoria() != 9 && prod.get(ale).getIdCategoria() != 10 &&
				prod.get(ale).getIdCategoria() != 11) {
				boolean verificar = false;
				if (contador == 0) {
					diferente[contador] = ale;}
				else {
					for (int i =0; i < diferente.length;i++) {
						if (diferente[i] == ale) {
							verificar = true;
							break;
						}
						verificar = false;}
				}
				System.out.println(diferente.length);
				if (verificar == false) {
					diferente[contador] = ale;
					aleatorios.add(prod.get(ale)); //AQUI FALTA LA CONDICIÓN POR CATEGORIA
					contador+=1;
				}
			}
		}
		Producto producto = null;
		producto = serviceProducto.listarId(idproducto);
		model.addAttribute("producto", producto);
		model.addAttribute("aleatorios", aleatorios);
		return "/SeccionVentas/InfoTortaStandardU";
	}
	
	@GetMapping("/InfoTortaPersonalizadaU/{id}")
	public String InfoTortaPersonalizadaU(@PathVariable("id") int idproducto, Model model) {
		ProductoPersonalizado productoPersonalizado = new ProductoPersonalizado();
		List<Producto> prod = serviceProducto.listar(null);
		List<Producto> aleatorios = new ArrayList<Producto>();
		int cantidad = prod.size();
		int contador = 0;
		int diferente[] = new int[4];
		while(contador < 4) {
			int ale = (int)(Math.random()*cantidad);
			
			if (prod.get(ale).getIdCategoria() != 1 && prod.get(ale).getIdCategoria() != 2 &&
				prod.get(ale).getIdCategoria() != 3 && prod.get(ale).getIdCategoria() != 4 &&
				prod.get(ale).getIdCategoria() != 5 && prod.get(ale).getIdCategoria() != 6) {
				boolean verificar = false;
				if (contador == 0) {
					diferente[contador] = ale;}
				else {
					for (int i =0; i < diferente.length;i++) {
						if (diferente[i] == ale) {
							verificar = true;
							break;
						}
						verificar = false;}
				}
				System.out.println(diferente.length);
				if (verificar == false) {
					diferente[contador] = ale;
					aleatorios.add(prod.get(ale)); //AQUI FALTA LA CONDICIÓN POR CATEGORIA
					contador+=1;
				}
			}
		}
		Producto producto = null;
		producto = serviceProducto.listarId(idproducto);
		model.addAttribute("producto", producto);
		model.addAttribute("aleatorios", aleatorios);
		model.addAttribute("pp", productoPersonalizado);
		return "/SeccionVentas/InfoTortaPersonalizadaU";
	}
	
	@GetMapping("/InfoTortaPersonalizada/{id}")
	public String InfoTortaPersonalizada(@PathVariable("id") int idproducto, Model model) {
		ProductoPersonalizado productoPersonalizado = new ProductoPersonalizado();
		List<Producto> prod = serviceProducto.listar(null);
		List<Producto> aleatorios = new ArrayList<Producto>();
		int cantidad = prod.size();
		int contador = 0;
		int diferente[] = new int[4];
		while(contador < 4) {
			int ale = (int)(Math.random()*cantidad);
			
			if (prod.get(ale).getIdCategoria() != 1 && prod.get(ale).getIdCategoria() != 2 &&
					prod.get(ale).getIdCategoria() != 3 && prod.get(ale).getIdCategoria() != 4 &&
					prod.get(ale).getIdCategoria() != 5 && prod.get(ale).getIdCategoria() != 6) {
				boolean verificar = false;
				if (contador == 0) {
					diferente[contador] = ale;}
				else {
					for (int i =0; i < diferente.length;i++) {
						if (diferente[i] == ale) {
							verificar = true;
							break;
						}
						verificar = false;}
				}
				System.out.println(diferente.length);
				if (verificar == false) {
					diferente[contador] = ale;
					aleatorios.add(prod.get(ale)); //AQUI FALTA LA CONDICIÓN POR CATEGORIA
					contador+=1;
				}
			}
		}
		Producto producto = null;
		producto = serviceProducto.listarId(idproducto);
		model.addAttribute("producto", producto);
		model.addAttribute("aleatorios", aleatorios);
		model.addAttribute("pp", productoPersonalizado);
		return "/SeccionVentas/InfoTortaPersonalizada";
	}
	
	/*ADMINISTRACION*/
	
	@GetMapping("/RegistroDeProducto")
	public String RegistroDeProducto(Model model) {
		List<Categoria> categorias = servicioCategoria.listarCategorias();
		model.addAttribute("producto", new Producto());
		model.addAttribute("categorias", categorias);
		return "/SeccionAdministrativa/RegistroDeProducto";
	}
	
	@PostMapping("/GuardarProducto")
	public String GuardarProducto(@Valid Producto producto, @RequestParam("file") MultipartFile imagen,Model model, RedirectAttributes attribute) {
		/*Path directorioImagenes = Paths.get("src//main//resources//static/IMAGENES");*/
		String UFile = UUID.randomUUID().toString() + "_" + imagen.getOriginalFilename();
		Path rutaAbsoluta = Paths.get("IMAGENES").resolve(UFile);  /*directorioImagenes.toFile().getAbsolutePath();	*/	
		Path rutaAbsolutaPath = rutaAbsoluta.toAbsolutePath();
		try {
			Files.copy(imagen.getInputStream(), rutaAbsolutaPath);
			/*byte[] bytesimg = imagen.getBytes();
			Path rutaCompleta = Paths.get(rutaAbsoluta + "//"+ imagen.getOriginalFilename());
			Files.write(rutaCompleta, bytesimg);*/
			producto.setImagenProducto(UFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		serviceProducto.save(producto);
		attribute.addFlashAttribute("registrado", "Productos registrado con éxito");
		return "redirect:/Producto/RegistroDeProducto";
	}
	
	@GetMapping("/ConsultaDeProducto")
	public String ConsultarProducto(Model model, @Param("palabra") String palabra)
	{
		List<Producto> productos = serviceProducto.listar(palabra);
		model.addAttribute("productos", productos);
		model.addAttribute("palabra", palabra);
		return "/SeccionAdministrativa/ConsultaDeProducto";
	}
	@GetMapping("/EditarProducto/{id}")
	public String EditarProducto(@PathVariable int id,Model model) {
		Producto producto = serviceProducto.listarId(id);
		List<Categoria> categorias = servicioCategoria.listarCategorias();
		model.addAttribute("producto", producto);
		model.addAttribute("categorias", categorias);
		return "/SeccionAdministrativa/EditarProducto";
	}
	
	@PostMapping("/GuardarProductoEditado")
	public String GuardarProductoEditado(Producto producto, RedirectAttributes attribute) {
		serviceProducto.save(producto);
		attribute.addFlashAttribute("editado", "Producto editado con éxito");
		return "redirect:/Producto/ConsultaDeProducto";
	}
	
	@GetMapping("/EliminarProducto/{id}")
	public String EliminarProducto(Model model, @PathVariable int id) {
		serviceProducto.delete(id);
		return "redirect:/Producto/ConsultaDeProducto";
	}
	
}
