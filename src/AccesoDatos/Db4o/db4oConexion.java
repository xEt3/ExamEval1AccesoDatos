package AccesoDatos.Db4o;
import java.util.Calendar;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;

/** 
 * Proyecto: Examne 1º Evaluacion
 * Establece acceso a la base de datos ventas.db
 * Aplica el patron Singleton.
 * @author: Ignacio Belmonte
 */
public class db4oConexion {

	// Singleton
	private static ObjectContainer db;
	
	private db4oConexion() {
		initConexion();
	}

	/**
	 * Configura la conexion.
	 */
	private void initConexion() {
		String DBferreteria = "ventas.db4o";
		EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();
        config.common().objectClass(Calendar.class).callConstructor(true);
        db = Db4oEmbedded.openFile(config, DBferreteria);
	}
	
	/**
	 *  Método estático de acceso a la instancia única.
	 *  Si no existe la crea invocando al constructor interno.
	 *  Utiliza inicialización diferida.
	 *  Sólo se crea una vez; instancia única -patrón singleton-
	 *  @return instance
	 */
	public static ObjectContainer getDB() {
		if (db == null) {
			new db4oConexion();
		}
		return db;
	}
	
	/**
	 * Cierra conexion.
	 */
	public static void cerrarConexiones() {
		if (db != null) {
			db.close();
		}
	}

}
