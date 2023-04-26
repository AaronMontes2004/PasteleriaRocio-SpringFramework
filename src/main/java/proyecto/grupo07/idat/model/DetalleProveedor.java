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
@Table(name = "detalle_proveedor")
public class DetalleProveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_detalle_proveedor")
	private Long id_detalle_proveedor;

	@Column(name = "id_proveedor", nullable = false)
	private int id_proveedor;

	@Column(name = "id_almacen", nullable = false)
	private int id_almacen;

	@Column(name = "Nombre_Insumos", nullable = false, length = 100)
	private String nombre_insumos;

	@Column(name = "cantidad", nullable = false)
	private int cantidad;

	@Column(name = "Descripcion", nullable = false, length = 500)
	private String descripcion;

	@Column(name = "Precio_Insumos", nullable = false, length = 12)
	private double precio_insumos;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "Fecha_Compra_Insumos", nullable = false)
	private Date fecha_compra_insumos;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "Fecha_Entrega_Insumos", nullable = false)
	private Date fecha_entrega_insumos;

	public DetalleProveedor() {
		super();
	}

	public DetalleProveedor(Long id_detalle_proveedor, int id_proveedor, int id_almacen, String nombre_insumos,
			int cantidad, String descripcion, double precio_insumos, Date fecha_compra_insumos,
			Date fecha_entrega_insumos) {
		super();
		this.id_detalle_proveedor = id_detalle_proveedor;
		this.id_proveedor = id_proveedor;
		this.id_almacen = id_almacen;
		this.nombre_insumos = nombre_insumos;
		this.cantidad = cantidad;
		this.descripcion = descripcion;
		this.precio_insumos = precio_insumos;
		this.fecha_compra_insumos = fecha_compra_insumos;
		this.fecha_entrega_insumos = fecha_entrega_insumos;
	}

	public Long getId_detalle_proveedor() {
		return id_detalle_proveedor;
	}

	public void setId_detalle_proveedor(Long id_detalle_proveedor) {
		this.id_detalle_proveedor = id_detalle_proveedor;
	}

	public int getId_proveedor() {
		return id_proveedor;
	}

	public void setId_proveedor(int id_proveedor) {
		this.id_proveedor = id_proveedor;
	}

	public int getId_almacen() {
		return id_almacen;
	}

	public void setId_almacen(int id_almacen) {
		this.id_almacen = id_almacen;
	}

	public String getNombre_insumos() {
		return nombre_insumos;
	}

	public void setNombre_insumos(String nombre_insumos) {
		this.nombre_insumos = nombre_insumos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio_insumos() {
		return precio_insumos;
	}

	public void setPrecio_insumos(double precio_insumos) {
		this.precio_insumos = precio_insumos;
	}

	public Date getFecha_compra_insumos() {
		return fecha_compra_insumos;
	}

	public void setFecha_compra_insumos(Date fecha_compra_insumos) {
		this.fecha_compra_insumos = fecha_compra_insumos;
	}

	public Date getFecha_entrega_insumos() {
		return fecha_entrega_insumos;
	}

	public void setFecha_entrega_insumos(Date fecha_entrega_insumos) {
		this.fecha_entrega_insumos = fecha_entrega_insumos;
	}

}
