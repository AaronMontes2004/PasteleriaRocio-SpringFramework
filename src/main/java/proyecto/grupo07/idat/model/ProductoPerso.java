package proyecto.grupo07.idat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "Producto_Personalizado")
public class ProductoPerso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto_perso", nullable = false)
	private Long id_producto_perso;
	@Column(name = "nombre", nullable = false, length = 200)
	private String nombre;
	@Column(name = "imagen", nullable = false, length = 100)
	private String imagen;
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	@Column(name = "precio", nullable = false, length = 14)
	private double precio;
	@Column(name = "Porciones", nullable = false)
	private int Porciones;
	@Column(name = "Cake", nullable = false, length = 20)
	private String Cake;
	@Column(name = "Relleno", nullable = false, length = 20)
	private String Relleno;
	@Column(name = "Accesorios", nullable = false, length = 50)
	private String Accesorios;
	@Column(name = "Dedicatoria", nullable = false, length = 50)
	private String Dedicatoria;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha", nullable = false)
	private Date fecha;
	@Column(name = "id_categoria", nullable = false)
	private int id_categoria;

	public ProductoPerso() {
		// TODO Auto-generated constructor stub
	}

	public ProductoPerso(Long id_producto_perso, String nombre, String imagen, int cantidad, double precio,
			int porciones, String cake, String relleno, String accesorios, String dedicatoria, Date fecha,
			int id_categoria) {
		super();
		this.id_producto_perso = id_producto_perso;
		this.nombre = nombre;
		this.imagen = imagen;
		this.cantidad = cantidad;
		this.precio = precio;
		Porciones = porciones;
		Cake = cake;
		Relleno = relleno;
		Accesorios = accesorios;
		Dedicatoria = dedicatoria;
		this.fecha = fecha;
		this.id_categoria = id_categoria;
	}

	public Long getId_producto_perso() {
		return id_producto_perso;
	}

	public void setId_producto_perso(Long id_producto_perso) {
		this.id_producto_perso = id_producto_perso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPorciones() {
		return Porciones;
	}

	public void setPorciones(int porciones) {
		Porciones = porciones;
	}

	public String getCake() {
		return Cake;
	}

	public void setCake(String cake) {
		Cake = cake;
	}

	public String getRelleno() {
		return Relleno;
	}

	public void setRelleno(String relleno) {
		Relleno = relleno;
	}

	public String getAccesorios() {
		return Accesorios;
	}

	public void setAccesorios(String accesorios) {
		Accesorios = accesorios;
	}

	public String getDedicatoria() {
		return Dedicatoria;
	}

	public void setDedicatoria(String dedicatoria) {
		Dedicatoria = dedicatoria;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
