package proceso;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
public class BOCCHI {

	public static void main(String[] args) throws IOException {
		/* Here we establish all the variables we will need, like the containers and the max space they will carry*/
		Scanner scan = new Scanner(System.in);
		int maxList = 99999;
		ListaPiezas listaPiezas = new ListaPiezas(maxList);
		ListaArmas listaArmas = new ListaArmas(maxList);
		ListaPersonas listaPersonas = new ListaPersonas(maxList);
		leerPiezas(listaPiezas);
		leerArmas(listaArmas);
		int cont = leerPersonas(listaPersonas);
		/*here we check if the person array is empty, if it is, we will ask for it to be filled out*/
		if (cont == 0) {
			crearGrupo(listaPersonas);
			System.out.println(listaPersonas.toString());
			
		}
		System.out.println("Ingrese numero de operacion");
		int i = Integer.valueOf(scan.nextLine());
		while (i != -1) {
			switch(i) {
			case 1:
				{ingresarArmaPieza(listaPiezas,listaArmas);}
			case 3:
				{crearGrupo(listaPersonas);}
				
			
			
			default:
				{System.out.println("Ingrese numero de operacion");
				i = Integer.valueOf(scan.nextLine());}
				}
				
			}

	}
	public static void leerPiezas(ListaPiezas lista) throws IOException {
		File filePiezas = new File("piezas.txt");
		Scanner readPiezas = new Scanner(filePiezas);
		while(readPiezas.hasNextLine()) {
			String linea = readPiezas.nextLine();
			String partes[] = linea.split(", ");
			String nombrePi = partes[0];
			String codPi = partes[1];
			String tipoPi = partes[2];
			String origenPi = partes[3];
			int matsPi = Integer.valueOf(partes[4]);
			Pieza pi = new Pieza(nombrePi,codPi,tipoPi,origenPi,matsPi);
			lista.ingresarPieza(pi);



		}
		readPiezas.close();
	}
	public static void leerArmas(ListaArmas lista) throws IOException{
		File fileArmas = new File("armas.txt");
		Scanner readArmas = new Scanner(fileArmas);
		while(readArmas.hasNextLine()) {
			String linea = readArmas.nextLine();
			String[] partes = linea.split(", ");
			String nombreAr = partes[0];
			String codigoAr = partes[1];
			int ammo = Integer.valueOf(partes[2]);
			String paisAr = partes[3];			
			int matsAr = Integer.valueOf(partes[4]); 
			Arma a = new Arma(nombreAr,codigoAr,ammo,paisAr,matsAr);
			lista.ingresarArma(a);
			
		}
		readArmas.close();
	}
	public static int leerPersonas(ListaPersonas lista) throws IOException {
		int cont = 0;
		File filePersonas = new File("personas.txt");
		Scanner readPersonas = new Scanner(filePersonas);
		while (readPersonas.hasNextLine()) {
			cont++;
			String linea = readPersonas.nextLine();
			String[] partes = linea.split(", ");
			String nombre = partes[0];
			String identificacion = partes[1];
			String ocupacion = partes[2];
			String equipo = partes[3];
			Personas p = new Personas(nombre,identificacion,ocupacion,equipo);
			lista.ingresarPersona(p);
			
			}
		readPersonas.close();
		return cont;
		
		
		
	}
	public static void ingresarArmaPieza(ListaPiezas listaPiezas,ListaArmas listaArmas) {
		String[] tipos = {"cabeza","brazos","piernas","tórax","cualidad"};
		

		Scanner scan = new Scanner(System.in);
		/*In the first case we will start by asking if the 
		 * user wants to add a part to the robot or a weapon*/
		System.out.println("Ingresará pieza o arma? (P/A): ");
		String choice = scan.nextLine().toUpperCase();
		while(!choice.equals("P") && !choice.equals("A")) {
			System.out.println("Tipo no valido, reintentar");
			System.out.println("Ingresará pieza o arma? (P/A): ");
			choice = scan.nextLine().toUpperCase();
		}
		if (choice.equals("P")) {
			/*If they select P, we will ask for each of the components of a part and we will create a class with it*/
			System.out.println("Ingrese información de pieza");
			System.out.println("Nombre pieza: ");
			String nom = scan.nextLine();
			System.out.println("Codigo pieza (Formato XXXXX): ");
			String cod = scan.nextLine();
			/*we will have a little error check, to make sure we didn't repeat any series number
			 * by searching for an equivalent on the already existing ones, if no coincidences are found
			 * we proceed normally*/
			boolean busc = listaPiezas.buscarCodigo(cod);
			while (busc != false) {
				System.out.println("Codigo ya usado, ingrese codigo correcto.");
				System.out.println("Codigo pieza (Formato XXXXX): ");
				cod = scan.nextLine();
				busc = listaPiezas.buscarCodigo(cod);

			}
			System.out.println("Tipo de pieza (cabeza, brazos, torax, piernas, extra:");
			String tip = scan.nextLine().toLowerCase();
			/*here, we will make sure that the type of piece the user inputs
			 * an existing part type, otherwise the program asks again*/
			boolean valid = false;
			for (int x = 0; x < 5; x++) {
				if(tip.equals(tipos[x])) {
					valid = true;
				}
			}
			while(valid == false)  {
				System.out.println("ERROR: Tipo no reconocido");
				System.out.println("Tipo de pieza (cabeza, brazos, tórax, piernas, cualidad):");
				tip = scan.nextLine().toLowerCase();
				for (int x = 0; x < 5; x++) {
					if(tip.equals(tipos[x])) {
						valid = true;
					}
				}
			}
			System.out.println("Ingrese pais de origen: ");
			String pais = scan.nextLine().toLowerCase();
			System.out.println("Ingrese cantidad de material necesario: ");
			int cant = scan.nextInt();
			/*With all of the data gathered we will create a new object and add it
			 * to the object array*/
			Pieza p = new Pieza(nom,cod,tip,pais,cant);
			listaPiezas.ingresarPieza(p);}
		
		else if(choice.equals("A")) {
			System.out.println("Ingrese información de arma");
			System.out.println("Nombre de arma: ");
			String nom_a = scan.nextLine();
			System.out.println("Codigo de arma (Formato XXXXX): ");
			String codA = scan.nextLine();
			/*we will have a little error check, to make sure we didn't repeat any series number
			 * by searching for an equivalent on the already existing ones, if no coincidences are found
			 * we proceed normally*/
			boolean busca = listaArmas.buscarCodigoArma(codA);
			while (busca != false) {
				System.out.println("Codigo ya usado, ingrese codigo correcto.");
				System.out.println("Codigo de arma (Formato XXXXX): ");
				codA = scan.nextLine();
				busca = listaPiezas.buscarCodigo(codA);;


			}
			System.out.println("Cantidad de municion: ");
			int ammo = Integer.valueOf(scan.nextLine());
			System.out.println("Ingrese pais de origen: ");
			String paisA = scan.nextLine().toLowerCase();
			System.out.println("Ingrese cantidad de material necesario: ");
			int cantA = Integer.valueOf(scan.nextLine());
			Arma a = new Arma(nom_a,codA,ammo,paisA,cantA);
			listaArmas.ingresarArma(a);
		}
		
		scan.close();
		
	}
	public static void crearGrupo(ListaPersonas list) {
	System.out.println("Ingrese nombre de persona: ");
	Scanner scan = new Scanner(System.in);
	String nombre = scan.nextLine();
	System.out.println("Ingrese ID: ");
	String iD = scan.nextLine();
	System.out.println("Ingrese especialidad: ");
	String especialidad = scan.nextLine();
	System.out.println("Ingrese Equipo");
	String equipo = scan.nextLine();
	Personas p = new Personas(nombre,iD,especialidad,equipo);
	list.ingresarPersona(p);
	scan.close();
}

}
