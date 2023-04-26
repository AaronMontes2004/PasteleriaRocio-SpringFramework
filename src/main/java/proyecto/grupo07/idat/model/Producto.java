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
import javax.validation.Valid;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "producto")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto", nullable = false)
	private int idProducto;
	@Column(name="Nombre_Producto",nullable = false, length = 100)
	private String nombreProducto;
	@Column(name="Precio_Producto",nullable = false, length = 12)
	private double precioProducto;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name="Fecha_Vencimiento",nullable = false)
	private Date fechaVencimientoProducto;
	@Column(name="Descripcion", nullable = false, length = 500)
	private String descripcionProducto;
	@Column(name="Stock", nullable = false)
	private int stockProducto;
	@Column(name="Precio_IGV", nullable=false, length = 12)
	private double precioIGVProducto;
	@Column(name="imagen", nullable = false, length = 150)
	private String imagenProducto;
	@Valid
	@Column(name="id_categoria", nullable = false)
	private int idCategoria;
	
	public Producto() {
	}

	public Producto(int idProducto, String nombreProducto, double precioProducto, Date fechaVencimientoProducto,
			String descripcionProducto, int stockProducto, double precioIGVProducto, String imagenProducto,
			int idCategoria) {
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.fechaVencimientoProducto = fechaVencimientoProducto;
		this.descripcionProducto = descripcionProducto;
		this.stockProducto = stockProducto;
		this.precioIGVProducto = precioIGVProducto;
		this.imagenProducto = imagenProducto;
		this.idCategoria = idCategoria;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioProducto() {
		return precioProducto;
	}

	public void setPrecioProducto(double precioProducto) {
		this.precioProducto = precioProducto;
	}

	public Date getFechaVencimientoProducto() {
		return fechaVencimientoProducto;
	}

	public void setFechaVencimientoProducto(Date fechaVencimientoProducto) {
		this.fechaVencimientoProducto = fechaVencimientoProducto;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	public int getStockProducto() {
		return stockProducto;
	}

	public void setStockProducto(int stockProducto) {
		this.stockProducto = stockProducto;
	}

	public double getPrecioIGVProducto() {
		return precioIGVProducto;
	}

	public void setPrecioIGVProducto(double precioIGVProducto) {
		this.precioIGVProducto = precioIGVProducto;
	}

	public String getImagenProducto() {
		return imagenProducto;
	}

	public void setImagenProducto(String imagenProducto) {
		this.imagenProducto = imagenProducto;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
}
