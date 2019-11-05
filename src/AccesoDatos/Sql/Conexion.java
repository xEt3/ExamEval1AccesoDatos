package AccesoDatos.Sql;
import java.sql.Connection;
import java.sql.DriverManager;

/** 
 * Proyecto: Examne 1º Evaluacion
 * Establece acceso a la base de datos ejemploCoches.db
 * Aplica el patron Singleton.
 * @author: Ignacio Belmonte
 */
public class Conexion {
	// Singleton
	private static Connection conn;

	/**
	 * Configura la conexion.
	 */
	private Conexion() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:/home/nacho/ejemploCoches.db");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 *  Método estático de acceso a la instancia única.
	 *  Si no existe la crea invocando al constructor interno.
	 *  Utiliza inicialización diferida.
	 *  Sólo se crea una vez; instancia única -patrón singleton-
	 *  @return instance
	 */
	public static Connection getInstance() {
		if (conn == null) {
			new Conexion();
		}
		return conn;
	}
}
