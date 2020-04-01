package referencia;

public class User {
	
	private String nombre;

	public User(String nombre) {
		this.nombre = nombre;
	}
	
	public static void referenciaAMetodoStatico() {
		System.out.println("Probando referencia a Metodo estico");
		
	}
	
	public void referenciaAMetodoParticular() {
		System.out.println("Probando referencia a Metodo de Objeto particular");
	}
	
	public void mostrarNombre() {
		System.out.println(nombre);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
