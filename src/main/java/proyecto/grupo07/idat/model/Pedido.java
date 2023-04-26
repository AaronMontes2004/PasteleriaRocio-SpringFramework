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
@Table(name = "cabecera_pedido")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cabecera_pedido", nullable = false)
	private int id_pedido;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "Fecha", nullable = false)
	private Date fecha_emision;
	@Column(name="Num_Pedido", nullable = false)
	private int num_pedido;
	@Column(name="Subtotal", nullable = false)
	private double subtotal;
	@Column(name="IGV", nullable = false)
	private double igv;
	@Column(name="Total", nullable = false)
	private double total;
	@Column(name = "id_user", nullable = true)
	private int id_user;
	
	public Pedido() {
	}

	public Pedido(int id_pedido, Date fecha_emision, int num_pedido, double subtotal, double igv, double total,
			int id_user) {
		this.id_pedido = id_pedido;
		this.fecha_emision = fecha_emision;
		this.num_pedido = num_pedido;
		this.subtotal = subtotal;
		this.igv = igv;
		this.total = total;
		this.id_user = id_user;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Date getFecha_emision() {
		return fecha_emision;
	}

	public void setFecha_emision(Date fecha_emision) {
		this.fecha_emision = fecha_emision;
	}

	public int getNum_pedido() {
		return num_pedido;
	}

	public void setNum_pedido(int num_pedido) {
		this.num_pedido = num_pedido;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIgv() {
		return igv;
	}

	public void setIgv(double igv) {
		this.igv = igv;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	
	
}
