package proceso;

public class Pieza {
	private String nombre;
	private String codigo;
	private String tipo;
	private String pais;
	private int cantMats;
	
	public Pieza(String nombre,String codigo,String tipo,String pais,int cantMats) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.tipo = tipo;
		this.pais = pais;
		this.cantMats = cantMats;
		
	}

	@Override
	public String toString() {
		return "Pieza [nombre=" + nombre + ", codigo=" + codigo + ", tipo=" + tipo + ", pais=" + pais + ", cantMats="
				+ cantMats + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getCantMats() {
		return cantMats;
	}

	public void setCantMats(int cantMats) {
		this.cantMats = cantMats;
	}
	

}
