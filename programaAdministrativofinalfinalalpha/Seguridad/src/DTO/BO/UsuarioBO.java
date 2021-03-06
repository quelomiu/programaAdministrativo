package DTO.BO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import advancesIqtools.Datetron;
import classes.conexionSingleton.ConexionSingleton;

import classes.modelo.objetos.Usuario;

public class UsuarioBO {
	ArrayList<Usuario> filas = new ArrayList<Usuario>();
	
	public void inicializar() {
		System.out.println("~Iniciando UsuarioBO~");
		try {
			System.out.println("--Conectando");
			Connection conn = ConexionSingleton.getConnection();
			Statement sttm = conn.createStatement();
			System.out.println("--Ejecutando Query");
			ResultSet rs = sttm.executeQuery("select * from Usuario");
			
			System.out.println("--Extrayendo set de resultados");
			while(rs.next()){
				filas.add(new Usuario(
						rs.getInt("ID_USUARIO"), 
						rs.getString("TIPO"), 
						rs.getString("USUARIO"), 
						rs.getString("PASSWORD")
						)
						);
			}
			System.out.println("--Cerrando coneccion");
			sttm.close();
			ConexionSingleton.closeConnection();
			
			System.out.println("--Completado ::)~");
		
		}catch(Exception e){
			System.out.println("Error al inicializar Usuario");
		}
	}
	
	public void filasToString() {
		System.out.println(filas);
	}
	public void agregarFila(Usuario usuario) {
		filas.add(usuario);
	}
	
	public int getFilasLenght() {
		return filas.size();
		
	}
	
	public Usuario encontrarUsuarioPorNombre(String nombre) {
		int contador=0;
		boolean buscando = true;
		Usuario usuarioBuscado = null;
		while(contador<filas.size() && buscando ) {

			if(filas.get(contador).getUsuario().equals(nombre)) {
				
				usuarioBuscado = filas.get(contador);
				buscando = false;
				
			}
			
		contador++;
			
		}
		return usuarioBuscado;
	}

}
