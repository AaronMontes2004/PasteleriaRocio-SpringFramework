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

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name="detalle_pedido")
public class DetallePedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_pedido", nullable = false)
	private int id_detalle_pedido;
	@Column(name="nombre", nullable = false, length = 200)
	private String nombre;
	@Column(name="Cantidad", nullable = false)
	private int cantidad;
	@Column(name="Imagen", nullable = false, length = 200)
	private String imagen;
	@Column(name="Precio", nullable = false)
	private double precio;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "Fecha", nullable = false)
	private Date fecha_emision;
	@Column(name="Total", nullable = false)
	private double total;
	@Column(name="Estado", nullable = false)
	private String estado = "PENDIENTE";
	@Column(name="id_producto", nullable = false)
	private int id_producto;
	@Column(name = "id_cabecera_pedido", nullable = false)
	private int id_pedido;
	
	public DetallePedido() {
	}



	public DetallePedido(int id_detalle_pedido, String nombre, int cantidad, String imagen, double precio,
			Date fecha_emision, double total, String estado, int id_producto, int id_pedido) {
		super();
		this.id_detalle_pedido = id_detalle_pedido;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.imagen = imagen;
		this.precio = precio;
		this.fecha_emision = fecha_emision;
		this.total = total;
		this.estado = estado;
		this.id_producto = id_producto;
		this.id_pedido = id_pedido;
	}



	public int getId_detalle_pedido() {
		return id_detalle_pedido;
	}

	public void setId_detalle_pedido(int id_detalle_pedido) {
		this.id_detalle_pedido = id_detalle_pedido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
