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
public class ProductoPersonalizado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto_perso", nullable = false)
	private int idProductoPersonalizado;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name="imagen", nullable = false)
	private String imagen;
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	@Column(name="precio", nullable = false)
	private double precio;
	@Column(name="Porciones", nullable = false)
	private int porciones;
	@Column(name = "Cake", nullable = false)
	private String cake;
	@Column(name="Relleno", nullable = false)
	private String relleno;
	@Column(name="Accesorios", nullable = true)
	private String accesorio;
	@Column(name="Dedicatoria", nullable = true)
	private String dedicatoria;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "Fecha", nullable = false)
	private Date fecha;
	@Column(name="id_categoria", nullable = false)
	private int idCategoria;
	
	public ProductoPersonalizado() {
	}

	public ProductoPersonalizado(int idProductoPersonalizado, String nombre, String imagen, int cantidad, double precio,
			int porciones, String cake, String relleno, String accesorio, String dedicatoria, Date fecha,
			int idCategoria) {
		super();
		this.idProductoPersonalizado = idProductoPersonalizado;
		this.nombre = nombre;
		this.imagen = imagen;
		this.cantidad = cantidad;
		this.precio = precio;
		this.porciones = porciones;
		this.cake = cake;
		this.relleno = relleno;
		this.accesorio = accesorio;
		this.dedicatoria = dedicatoria;
		this.fecha = fecha;
		this.idCategoria = idCategoria;
	}

	public int getIdProductoPersonalizado() {
		return idProductoPersonalizado;
	}

	public void setIdProductoPersonalizado(int idProductoPersonalizado) {
		this.idProductoPersonalizado = idProductoPersonalizado;
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
		return porciones;
	}

	public void setPorciones(int porciones) {
		this.porciones = porciones;
	}

	public String getCake() {
		return cake;
	}

	public void setCake(String cake) {
		this.cake = cake;
	}

	public String getRelleno() {
		return relleno;
	}

	public void setRelleno(String relleno) {
		this.relleno = relleno;
	}

	public String getAccesorio() {
		return accesorio;
	}

	public void setAccesorio(String accesorio) {
		this.accesorio = accesorio;
	}

	public String getDedicatoria() {
		return dedicatoria;
	}

	public void setDedicatoria(String dedicatoria) {
		this.dedicatoria = dedicatoria;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

}
