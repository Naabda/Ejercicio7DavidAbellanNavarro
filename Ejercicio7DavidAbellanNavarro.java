//David Abellán Navarro 1ºDAM
//https://github.com/Naabda/Ejercicio7DavidAbellanNavarro/blob/main/Ejercicio7DavidAbellanNavarro.java

import java.util.Scanner;

public class Ejercicio7DavidAbellanNavarro {


	private static Scanner teclado = new Scanner (System.in);
	//Vector para nombres
	private static String [] aNombre;
	//Matriz donde
	//Columna 0 es Tamaño, Columna 1 es Densidad y Columna 2 es el tamaño por densidad.
	private static int [][] mValores;
	//Contador aux.
	private static int contador;
	private static int sumando;


	//Asignacion de las variables a los diferentes terrenos.
	private static void asignacion () {

		//Predefinicion matrices.
		aNombre=new String [5];
		mValores= new int [5][3];
		//Inicializacion y predefinicion variables aux.
		String [] aNombreNew= new String [5];
		int [][] mValoresNew = new int [5][3];
		int Infinito=1;
		contador=0;
		sumando=5;
		String Respuesta;
		boolean extractor=true;
		for (int i = 0; i < aNombre.length; i++) {
			aNombre[i]= "Sin nombre";
		}

		//Entrada datos.
		for (int i = 0; i < Infinito; i++) {
			for (int j = (sumando-5); j < sumando; j++) {
				System.out.println("Vamos a crear el "+(contador+1)+"º terreno");
				System.out.println("¿Cómo se llama este terreno?");
				String Nombre=teclado.next();
				aNombre [j]=Nombre;
				System.out.println("¿Qué tamaño tiene?");
				int tamaño=teclado.nextInt();
				mValores [j][0]=tamaño;
				System.out.println("¿Y la densidad del terreno?");
				int densidad=teclado.nextInt();
				mValores [j][1]= densidad;
				mValores [j][2]= mValores[j][0]*mValores[j][1];

				contador++;

				System.out.println("¿Quieres añadir otro terreno? si/no");
				Respuesta=teclado.next();
				if (Respuesta.equals("si")) {

				} 
				if (Respuesta.equals("no")) {
					extractor = false;
					break;
				}
			}
			if (extractor==false) {
				break;
			}
			sumando= sumando +5;

			aNombreNew= new String [sumando];
			mValoresNew= new int[sumando][3];
			//Iniciamos el array String con valor sin nombre.
			for (int k = 0; k < aNombreNew.length; k++) {
				aNombreNew[k]= "Sin nombre";
			}
			//Copiamos valores en array.
			for (int j = 0; j < (sumando-5); j++) {
				aNombreNew[j] = aNombre[j];
			}
			//Copiamos valores en matriz
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < (sumando-5); k++) {
					mValoresNew[k][j]=mValores[k][j];
				}
			}
			//Reincorporamos valores.
			aNombre=aNombreNew;
			mValores=mValoresNew;
			Infinito++;
		}
	}

	//Vamos a mostrar los resultados de lo recogido anteriormente.
	private static void consulterrenos () {

		System.out.println("Estos son los terrenos ingresados.");
		for (int i = 0; i < aNombre.length; i++) {

			if (aNombre[i] != "Sin nombre") {
				System.out.println((i+1)+". "+aNombre[i]);
			}
		}

		System.out.println("Número de terreno a consultar");
		int Nterreno=teclado.nextInt();
		Nterreno--;
		System.out.println("El terreno "+(Nterreno+1)+". "+aNombre[Nterreno]+" hay que reforestarlo con "+mValores[Nterreno][2]+" árboles.\n");
	}
	//Calculamos y mostramos el total de lo anterior.


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Programa que representando la situación copiada en la libreta nos diga la cantidad
		// de árboles que necesitamos para reforestar cada zona y cuantos árboles necesitamos en total.

		//Definimos variables.
		int opcion;
		int Total=0;
		boolean continuar=true;

		System.out.println("Vamos a crear un mapa");

		//Creamos un menú para poder realizar las acciones más facilmente.
		do {
			//Definir opciones menú
			System.out.println("1. Asignación de los terrenos.");
			System.out.println("2. Consultas terrenos.");
			System.out.println("3. Consulta total árboles.");
			System.out.println("4. Salir.");
			opcion = teclado.nextInt();
			switch(opcion) {
			case 1:
				asignacion ();
				break;
			case 2:
				consulterrenos ();
				break;
			case 3:
				for (int i = 0; i < mValores.length; i++) {
					Total= mValores[i][2]+Total;
				}
				System.out.println("El total de árboles que necesitamos es: "+Total+"\n");
				break;
			case 4:
				continuar = false;
				break;
			default:
				System.out.println("Inserte una opción correcta");
				break;
			}
		}
		while (continuar);

	}//Fin programa
}
