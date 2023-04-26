package proyecto.grupo07.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_categoria", nullable = false)
	private int IdCategoria;
	@Column(name = "Tipo_Categoria", nullable = false, length = 50)
	private String TipoCategoria;
	
	public Categoria() {
	}

	public Categoria(int idCategoria, String tipoCategoria) {
		IdCategoria = idCategoria;
		TipoCategoria = tipoCategoria;
	}

	public int getIdCategoria() {
		return IdCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		IdCategoria = idCategoria;
	}

	public String getTipoCategoria() {
		return TipoCategoria;
	}

	public void setTipoCategoria(String tipoCategoria) {
		TipoCategoria = tipoCategoria;
	}
}
