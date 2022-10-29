package proceso;


public class ListaPiezas {
	private Pieza lista[];
	private int cantidadPiezas;
	private int max;

	public ListaPiezas(int max){
		lista = new Pieza [max];
		cantidadPiezas = 0;
		this.max = max;

	}public boolean ingresarPieza(Pieza pieza){

		if (cantidadPiezas < max){
			lista[cantidadPiezas]= pieza;
			cantidadPiezas ++;
			return true;
		}
		else{
			return false;
		}

	}
	public boolean buscarCodigo(String codigo){
		int i;
		for(i = 0; i < cantidadPiezas; i++){
			if (lista[i].getCodigo().equals(codigo)){
				break;
			}
		}

		if (i == cantidadPiezas){
			return false;
		}
		else{
			return true;
		}
	}
}

