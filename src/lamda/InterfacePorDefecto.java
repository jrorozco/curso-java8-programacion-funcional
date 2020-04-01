package lamda;

public interface InterfacePorDefecto {
	
	void monstraNombre(String nombre);
	
	default String nombrePorDefecto(String nombre) {
		return nombre + "Default";
	}
	
	

}
