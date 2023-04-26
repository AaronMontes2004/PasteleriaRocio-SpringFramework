package proyecto.grupo07.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_proveedor", nullable = false)
	public int idProveedor;
	@Column(name="Nombre_Proveedor",nullable = false, length = 30)
	public String NombreProveedor;
	@Column(name="Telefono_Proveedor",nullable = false, length = 9)
	public int TelefonoProveedor;
	@Column(name="Direccion_Proveedor",nullable = false, length = 50)
	public String DireccionProveedor;
	
	public Proveedor() {
	}

	public Proveedor(int idProveedor, String nombreProveedor, int telefonoProveedor, String direccionProveedor) {
		super();
		this.idProveedor = idProveedor;
		NombreProveedor = nombreProveedor;
		TelefonoProveedor = telefonoProveedor;
		DireccionProveedor = direccionProveedor;
	}

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getNombreProveedor() {
		return NombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		NombreProveedor = nombreProveedor;
	}

	public int getTelefonoProveedor() {
		return TelefonoProveedor;
	}

	public void setTelefonoProveedor(int telefonoProveedor) {
		TelefonoProveedor = telefonoProveedor;
	}

	public String getDireccionProveedor() {
		return DireccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		DireccionProveedor = direccionProveedor;
	}

	
}
