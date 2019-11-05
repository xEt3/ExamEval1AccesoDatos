package AccesoDatos.Sql;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Modelo.Venta;

/** 
 * Proyecto: Examen 1º Evaluacion
 * Clase creada para realizar todas las operaciones necesarioas con una base de datos.
 * @author: Ignacio Belmonte
 */
public class sqliteConsultas {
	Connection conexion;
	Statement st;
	ResultSet rs;

	public sqliteConsultas() {
		conexion = Conexion.getInstance();
		try {
			st = conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String mostrarCochesCiudad(String ciudad) {
		StringBuilder resultado = new StringBuilder();
		try {
			rs = st.executeQuery(
					"select c.codcoche ,c.nombre ,c.modelo from concesionario natural join venta v inner  join coche c on v.codcoche = c.codcoche where ciudad = '"
							+ ciudad + "'");
			while (rs.next()) {
				resultado.append("Codigo coche :" + rs.getObject(1) + " Nombre coche :" + rs.getObject(2) + " Modelo: "
						+ rs.getObject(3) + "\n");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado.toString();

	}

	public ArrayList<Venta> getVentas() {
		ArrayList<Venta> ventas = new ArrayList<Venta>();
		try {
			rs = st.executeQuery(
					"select v.codcoche , v.cifc , v.cifcl , v.color  ,c.nombre ,c.modelo from concesionario natural join venta v inner  join coche c on v.codcoche = c.codcoche");
			while (rs.next()) {
				Venta venta = new Venta(rs.getObject(1).toString(), rs.getObject(2).toString(),
						rs.getObject(3).toString(), rs.getObject(4).toString(), rs.getObject(5).toString(),
						rs.getObject(6).toString());
				ventas.add(venta);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ventas;
	}

	public void aumentarDistribucionModelo(String modelo) {
		try {
			int registrosActualizados =st.executeUpdate(
					"update distribucion set cantidad=cantidad*1.10 where codcoche in(select codcoche from coche where modelo = '"
							+ modelo + "')");
			if(registrosActualizados==0) {
				System.out.println("No existe ningun coche con ese modelo");
			}else {
				System.out.println("Actializado correctamente la cantidad de los coches con modelo " + modelo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void cerrar() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
