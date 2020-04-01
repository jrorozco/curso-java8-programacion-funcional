package optional;

import java.util.Optional;

public class OptionalPrueba {

	public static void main(String[] args) {
		//probarOptional(null);
//		crearOrElseOptional(null);
//		orElseThrow(null);
		isPresent(null);
	}

	
	public static void probarOptional(String nombre) {
		System.out.println(nombre.length());
	}
	
	public static void crearOptional() {
		Optional<String> optional =Optional.empty();
		optional.get();
	}
	
	public static void crearOrElseOptional(String nombre) {
		Optional<String> optionalOfnullable =Optional.ofNullable(nombre); // permite que llegue null
//		Optional<String> optionalOf =Optional.of(nombre);// NO permite que llegue null
		
		String nombreOfNullable = optionalOfnullable.orElse("Vacio");
//		String nombreOf = optionalOf.orElse("Vacio");
		
		System.out.println("nombreOfNullable : " + nombreOfNullable);
//		System.out.println("nombreOf : " + nombreOf);
		
		
	}
	
	public static void orElseThrow(String nombre) {
		Optional<String> optionalOfnullable =Optional.ofNullable(nombre); // permite que llegue null
		String nombreOfNullableThrow = optionalOfnullable.orElseThrow(NullPointerException::new);
		System.out.println("nombreOfNullableThrow : " + nombreOfNullableThrow);
		
		
	}
	
	public static void isPresent(String nombre) {
		Optional<String> optionalIspresent =Optional.ofNullable(nombre); // permite que llegue null
		System.out.println("OptionalIsPresent : " + optionalIspresent.isPresent());
		
		
	}
}
