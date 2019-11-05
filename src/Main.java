import java.util.ArrayList;
import java.util.Scanner;
import com.db4o.ObjectContainer;
import AccesoDatos.Db4o.db4oConexion;
import AccesoDatos.Sql.sqliteConsultas;
import Modelo.Venta;

public class Main {
	public static Scanner teclado = new Scanner(System.in);
	public static sqliteConsultas sql= new sqliteConsultas();
	public static ObjectContainer db4o = db4oConexion.getDB();
	
	
	public static void main(String[] args) {
		int opcion = -1;
		do {
			System.out.println("Elige la opcion:");
			System.out.println("================");
			System.out.println(" 1.- Ejercicio 1");
			System.out.println(" 2.- Ejercicio 2");
			System.out.println(" 3.- Ejercico 3");
			System.out.println();
			System.out.println(" 4.- Salir");
			try {
				opcion = teclado.nextInt();
				String basura = teclado.nextLine();
			}catch (Exception e) {
				opcion=4;
			}
	

			switch (opcion) {
			case 4:
				System.out.println("HASTA LUEGO");
				break;
			case 1:
				ejercicio1();
				break;
			case 2:
				ejercicio2();
				break;
			case 3:
				ejercico3();
				break;
			default:
				;
				break;

			} // fin switch
		} while (opcion != 4);// fin while

		sql.cerrar(); 
		db4o.close();
		// cerrar base de datos
	
	}

	private static void ejercicio1() {
		System.out.println("Introduce el nombre de la ciudad de las que quieres ver los coches");
		String ciudad = teclado.nextLine();
		String coches = sql.mostrarCochesCiudad(ciudad);
		if(coches.equals("")){
			System.out.println("No hay coches en esa ciudad");
		}else {
			System.out.println(coches);
		}
		
	}
	
	private static void ejercicio2() {
		ArrayList<Venta> ventas = sql.getVentas();
		for (int i = 0; i < ventas.size(); i++) {
			db4o.store(ventas.get(i));
		}
		System.out.println("Datos almacenados");
	}
	
	private static void ejercico3() {
		System.out.println("Introuce el modelo al que se le desea aumentar la cantidad");
		String modelo = teclado.nextLine();
		sql.aumentarDistribucionModelo(modelo);
	}

}
