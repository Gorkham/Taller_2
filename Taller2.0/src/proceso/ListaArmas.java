package proceso;

public class ListaArmas {
	private Arma lista[];
	private int max;
	private int cantArmas;
	
	public ListaArmas(int max){
		lista = new Arma [max];
		cantArmas = 0;
		this.max = max;

	} 
	public boolean ingresarArma(Arma arma){

		if (cantArmas < max){
			lista[cantArmas]= arma;
			cantArmas ++;
			return true;
		}
		else{
			return false;
		}

	}
	public boolean buscarCodigoArma(String codigo){
		int i;
		for(i = 0; i < cantArmas; i++){
			if (lista[i].getGun_code().equals(codigo)){
				break;
			}
		}

		if (i == cantArmas){
			return false;
		}
		else{
			return true;
		}
	}

}
