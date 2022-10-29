package proceso;

public class Personas {
	private String nombre;
	private String iD;
	private String especialidad;
	private String equipo;
	public Personas(String nombre, String iD, String especialidad, String equipo) {
		super();
		this.nombre = nombre;
		this.iD = iD;
		this.especialidad = especialidad;
		this.equipo = equipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getiD() {
		return iD;
	}
	public void setiD(String iD) {
		this.iD = iD;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	@Override
	public String toString() {
		return "Personas [nombre=" + nombre + ", iD=" + iD + ", especialidad=" + especialidad + ", equipo=" + equipo
				+ "]";
	}
	
	

}
