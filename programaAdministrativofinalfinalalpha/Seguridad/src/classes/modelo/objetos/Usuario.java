package classes.modelo.objetos;

import java.util.Date;

public class Usuario {
	int id;
	String tipo;
	String usuario;
	String contraseņa;
	
	Date fecha;
	//hora

	public Usuario(int id, String tipo, String usuario, String contraseņa, Date fecha) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.usuario = usuario;
		this.contraseņa = contraseņa;
		this.fecha = fecha;
	}
	
	
	
}
