package Modelo;
/**
 * Clase creada para guardad objetos de tipo Venta guardados en la base de datos
 * Sql, en esta clase se guardan con dos atributos extra que osn nombreCoche y
 * modeloCoche
 * 
 * @author IgnacioBelmonte
 *
 */
public class Venta {
	private String codcoche;
	private String cifc;
	private String cifcl;
	private String color;
	private String nombreCoche;
	private String modeloCoche;

	public Venta(String codcoche, String cifc, String cifcl, String color, String nombreCoche, String modeloCoche) {
		super();
		this.codcoche = codcoche;
		this.cifc = cifc;
		this.cifcl = cifcl;
		this.color = color;
		this.nombreCoche = nombreCoche;
		this.modeloCoche = modeloCoche;
	}

	public String getCodcoche() {
		return codcoche;
	}

	public void setCodcoche(String codcoche) {
		this.codcoche = codcoche;
	}

	public String getCifc() {
		return cifc;
	}

	public void setCifc(String cifc) {
		this.cifc = cifc;
	}

	public String getCifcl() {
		return cifcl;
	}

	public void setCifcl(String cifcl) {
		this.cifcl = cifcl;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getNombreCoche() {
		return nombreCoche;
	}

	public void setNombreCoche(String nombreCoche) {
		this.nombreCoche = nombreCoche;
	}

	public String getModeloCoche() {
		return modeloCoche;
	}

	public void setModeloCoche(String modeloCoche) {
		this.modeloCoche = modeloCoche;
	}

}
