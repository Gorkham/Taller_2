package proceso;

import java.util.Arrays;

public class ListaPersonas {
	private Personas lista[];
	private int max;
	private int cantPersonas;
	
	public ListaPersonas(int max){
		lista = new Personas [max];
		cantPersonas = 0;
		this.max = max;


}
public boolean ingresarPersona(Personas persona){
		
		if (cantPersonas < max){
			lista[cantPersonas]= persona;
			cantPersonas ++;
			return true;
		}
		else{
			return false;
		}
	}
@Override
public String toString() {
	return "ListaPersonas [lista=" + Arrays.toString(lista) + ", max=" + max + ", cantPersonas=" + cantPersonas + "]";
}
	}
