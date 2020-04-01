package referencia;

import java.util.ArrayList;
import java.util.List;

public class ReferenciaMetodo {
	
	
	
	public static void main(String[] args) {
	
		/**
		 * Referencia a Metodo statico
		 * Syntaxis -- Class::staticMethod 
		 * Method Reference User::referenciaAMetodoStatico 
		 * Expresion Lambda -- u -> User.referenciaAMetodoStatico();
		 */
		
		// con java 7
		Trabajo trabajo = new Trabajo(){

			@Override
			public void accion() {
				User.referenciaAMetodoStatico();
				
			}
			
		};
		
		// con lambda
		Trabajo trabajoLamda = () -> User.referenciaAMetodoStatico();
		
		// con referencia a metodo
		Trabajo trabajoReferenciaAMetodoRef = User::referenciaAMetodoStatico;
		trabajoReferenciaAMetodoRef.accion();
		
		
		/**
		 * Referencia a un Metodo de instancia Particular
		 * Syntaxis -- Intancia::metodoDeInstancia  
		 * Method Reference User::referenciaAMetodoParticular 
		 * Expresion Lambda -- () -> User.referenciaAMetodoParticular();
		 */
		
		// con java 7
				User user =new User("Rene");
				Trabajo trabajoInstPart = new Trabajo(){

					@Override
					public void accion() {
						user.referenciaAMetodoParticular();
						
					}
					
				};
	   // con lambda	
		Trabajo trabajoInstPartLambda = () -> user.referenciaAMetodoParticular();
		// Referencia a metodo...
		Trabajo trabajoInstPartRefeMetod = user::referenciaAMetodoParticular;
				trabajoInstPartRefeMetod.accion();
			
				
		/**
		 * Referencia a un Metodo de instancia Objeto Arbitrario de un tipo particular
		 * Syntaxis -- Class::metodoDeInstanciaArbitDeTipoPart
		 * Method Reference User::referenciaAMetodoParticular 
		 * Expresion Lambda -- () -> User.referenciaAMetodoParticular();
		 */
		//lambda
		TrabajoToString trabajoStringLambda = (palabra) -> palabra.toUpperCase();
		// Metodo a Referencia
		TrabajoToString trabajoStringMetodoAReferencia = String::toUpperCase;
		System.out.println(trabajoStringMetodoAReferencia.accion("rene"));
		
		List<User> users = new ArrayList();
		users.add(new User("Rene"));
		users.add(new User("Raul"));
		users.add(new User("Pedro"));
		users.add(new User("Alex"));
		users.add(new User("Victor"));
		
		//lambda
		users.forEach(nombre -> nombre.mostrarNombre());
		//Metodo A referencia
		users.forEach(User::mostrarNombre);
		
		
		/**
		 * Referencia a un Constructor
		 * Syntaxis -- Class::new
		 * Method Reference User::new
		 * Expresion Lambda -- (u) -> new u(nombre);
		 */
		
		IUser iuser = new IUser() {
			@Override
			public User crear(String nombre) {
				// TODO Auto-generated method stub
				return new User(nombre);
			}
		};
		User userJava7 =iuser.crear("Rene Java7");
		System.out.println(userJava7.getNombre());
		
		IUser iuserLambda = (nombre) -> new User(nombre);
		User ulambda =iuserLambda.crear("Rene Lambda");
		
		System.out.println(ulambda.getNombre());
		
		IUser iuserRefMetodo = User::new;
		User u =iuserRefMetodo.crear("Rene RefMetodo");
		System.out.println(u.getNombre());
		
		
		
		
		
	}

}
