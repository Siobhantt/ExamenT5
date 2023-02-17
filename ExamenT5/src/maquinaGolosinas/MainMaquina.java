package maquinaGolosinas;

import java.util.Arrays;
import java.util.Scanner;

public class MainMaquina {

	public static void main(String[] args) {
		int cantidad; //
		String contraseñaUser; //Variable que guarda la contraseña que introducirá el usuario
		final String CONTRASEÑA = "Maquina2023"; //Constante con la contraseña
		int opcion; //Opcion del usuario
		int fila; //fila de seleccion del usuario
		int columna; //columna de seleccion del usuario
		Scanner lee = new Scanner(System.in);

		FuncionesMaquina.rellenarMatriz(5); //relleno de la matriz
		
		//bucle con el switch y las opciones
		do  {
			System.out.println("Por favor introduzca la opcion que desee: ");
			System.out.println("1: Mostrar golosinas "+ "\n" + "2: Pedir golosina "+ "\n" + "3: Rellenar golosina " + "\n" + "4: Apagar maquina ");
			opcion = lee.nextInt();
			switch (opcion) {

			case 1 -> {//El primer caso muestra las golosinas y sus precios
				FuncionesMaquina.mostrarGolosinas();
				continue;
			}
	
			case 2 -> {// el segundo caso pide la fila
				System.out.println("Introduzca la fila de la golosina que desea: ");
				fila = lee.nextInt();
				//pide tambien la columna
				System.out.println("Introduzca la columna de la golosina que desea: ");
				columna = lee.nextInt();
				
				System.out.println("Usted ha comprado:  "+FuncionesMaquina.nombresGolosinas[fila][columna]);
				//en caso de que la funcion validarPos sea distinta a true imprime un mensaje informando al user
				if (FuncionesMaquina.validarPos(fila, columna) != true) {
				System.out.println("Posicion no valida");
				}else {//si es true valida la posicion y añade la venta, tambien reduce la cantidad en 1
					if (FuncionesMaquina.hayValorPosicion(fila, columna) == true) {
					FuncionesMaquina.anyadirVenta(fila, columna);
					FuncionesMaquina.reducirPosicion(fila, columna, 1);
					}
				} 
				break;
			} // fin del caso 2
			
			case 3 -> {//el tercer caso pide una contraseña
				System.out.println("Por favor introduzca la contraseña");
				contraseñaUser = lee.next();
				//si la contraseña es iguala la que esta guardada en la constante entonces le da la opcion al usuario de rellenar los valores
				if(contraseñaUser.equals(CONTRASEÑA)) {
					System.out.println("Por favor introduzca la fila que desee rellenar: ");
					fila = lee.nextInt();
					
					System.out.println("Por favor introduzca la columna que desee rellenar: ");
					columna = lee.nextInt();
					System.out.println("Por favor introduzca la cantidad que desee rellenar");
					cantidad =lee.nextInt();
					//antes de rellenar la posicion la valida y luego la funcion aumenta en 1lo que este en la posicion de los parametros
					if(FuncionesMaquina.validarPos(fila, columna)==true) {
						FuncionesMaquina.aumentarPosicion(fila, columna, 1);
					}else {
						System.out.println("Posicion no valida.");
					}
				} 
				else {
					System.out.print("Contraseña incorrecta :/");
				}
				break;
			}//fin del caso3
			//en el caso 4 simplemente sale del bucle
			case 4 -> {
				break;
			}
			default -> {//en caso de no introducir ninguna opcion valida se muestra un mensaje
				System.out.println("Opcion no valida.");
			}
			}
		
		}while(opcion!=4);
		//con este for imprimo todo lo que esta en la tabla ventas
		
		for(int i=0;i<FuncionesMaquina.ventas.length;i++) {
			FuncionesMaquina.imprimirVentasTotales();
		}
		
	}// fin del main

}
