package proyecto.grupo07.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="almacen")
public class Almacen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_almacen")
	private Long id_almacen;
	
	@Column(name="Insumos", nullable = false, length = 30)
	private String insumos;
	
	@Column(name="Cantidad",nullable = false)
	private int cantidad;
	
	@Column(name="id_producto" , nullable = false)
	private int id_producto;

	

	public Almacen(Long id_almacen, String insumos, int cantidad, int id_producto) {
		super();
		this.id_almacen = id_almacen;
		this.insumos = insumos;
		this.cantidad = cantidad;
		this.id_producto = id_producto;
	}

	public Almacen() {
	}

	public Long getId_almacen() {
		return id_almacen;
	}

	public void setId_almacen(Long id_almacen) {
		this.id_almacen = id_almacen;
	}

	public String getInsumos() {
		return insumos;
	}

	public void setInsumos(String insumos) {
		this.insumos = insumos;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}

	
}
