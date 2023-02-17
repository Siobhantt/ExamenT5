package maquinaGolosinas;

import java.util.Arrays;

public class FuncionesMaquina {
	/**
	 * Tabla con los nombres de los productos
	 */
	static String[][] nombresGolosinas = { { "KitKat", "Chicles de fresa", "Lacasitos", "Palotes" },
			{ "Kinder Bueno", "Bolsa variada Haribo", "Chetoos", "Twix" },
			{ "Kinder Bueno", "M&M'S", "Papa Delta", "Chicles de menta" },
			{ "Lacasitos", "Crunch", "Milkybar", "KitKat" } };

	/**
	 * Tabla con los precios de los productos
	 */
	static double[][] precio = { { 1.1, 0.8, 1.5, 0.9 }, { 1.8, 1, 1.2, 1 }, { 1.8, 1.3, 1.2, 0.8 },
			{ 1.5, 1.1, 1.1, 1.1 } };

	/**
	 * Tabla con las cantidades de los productos
	 */
	static int[][] cantidades = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };

	/**
	 * Tabla con los elementos vendidos
	 */
	static String ventas[] = { " " };

	/**
	 * Variable para guardar el total vendido
	 */
	static double total;

	/**
	 * Funcion que llena con la cantidad deseada la tabla
	 * 
	 * @param num Recibe por parametro la cantidad con que se quiere llenar una
	 *            posicion de la tabla
	 */
	static void rellenarMatriz(int num) {

		for (int fila = 0; fila < cantidades.length; fila++) {
			for (int col = 0; col < cantidades[0].length; col++) {
				cantidades[fila][col] = num;
			}
		}

	}// fin del metodo

	/**
	 * Metodo que muestra el codigo, el nombre de la golosina y el precio Imprime la
	 * informacion pero no devuelve nada
	 */
	static void mostrarGolosinas() {

		for (int fila = 0; fila < nombresGolosinas.length; fila++) {
			for (int col = 0; col < nombresGolosinas[0].length; col++) {
				System.out.print("Codigo: " + fila + "" + col + " ");
				System.out.print(nombresGolosinas[fila][col] + " ");
				System.out.print("Precio: " + precio[fila][col]);
				System.out.println();
			}
			System.out.println();
		}
	}// fin del metodo

	/**
	 * Funcion que verifica que la posicion introducida este entre los limites de
	 * las tablas
	 * 
	 * @param fila    coordenada de la tabla
	 * @param columna coordenada de la tabla
	 * @return devuelve true en caso de ser valido
	 */
	static boolean validarPos(int fila, int columna) {
		boolean valido = false;
		if (fila <= nombresGolosinas.length && columna <= nombresGolosinas[0].length) {
			valido = true;
		}

		return valido;
	}// fin de validarPosicion

	/**
	 * Funcion que verifica que en la tabla cantidades en una casilla especifica
	 * haya un valor mayor a 0
	 * 
	 * @param fila    se introduce la fila a verificar
	 * @param columna se introduce la columna a verificar
	 * @return devuelve si en esa casilla hay un valor mayor a 0
	 */
	static boolean hayValorPosicion(int fila, int columna) {
		return cantidades[fila][columna]>0 ? true : false;
/*		boolean hayExistencia = false;
		if (cantidades[fila][columna] > 0) {
			hayExistencia = true;
		}
		return hayExistencia;*/
	}// fin de hayValorPosicion

	/**
	 * Funcion a la que se le introduce una coordenada y a lo que este ahi se le
	 * suma la cantidad deseada
	 * 
	 * @param fila     coordenada de la fila
	 * @param columna  coordenada de la columna
	 * @param cantidad cantidad deseada a sumar
	 */

	static void aumentarPosicion(int fila, int columna, int cantidad) {
		validarPos(fila, columna);
		cantidades[fila][columna] += cantidad;
	}// fin de aumentar posicion

	/**
	 * Funcion que valida la posicion y reduce la cantidad de objetos sacados de la
	 * maquina
	 * 
	 * @param fila     recibe la fila a reducir
	 * @param columna  recibe la columnna a reducir
	 * @param cantidad recibe la cantidad a reducir
	 */

	static void reducirPosicion(int fila, int columna, int cantidad) {
		validarPos(fila, columna);
		cantidades[fila][columna] -= cantidad;
	}// fin de reducir posicion

	/**
	 * Añade a la tabla de ventas el nombre de la golosina seleccionada y le suma a
	 * la variable total el precio de la golosina seleccionada.
	 * 
	 * @param fila    coordenada de la golosina
	 * @param columna coordenada de la golosina
	 */

	static void anyadirVenta(int fila, int columna) {
		for (int i = 0; i < ventas.length; i++) {
			ventas[i] += nombresGolosinas[fila][columna] + "\n";
			total += precio[fila][columna];
		}

	}// fin del metodo

	/**
	 * Metodo que imprime el total de las ventas y el nombre de los articulos
	 * vendidos
	 */
	static void imprimirVentasTotales() {
		System.out.println("Hasta la proxima! El total de ventas fue: ");
		for (int i = 0; i < ventas.length; i++) {
			System.out.println(ventas[i]);
		}
		System.out.println("Total: "+total+" €");
	}// fin del metodo
}
