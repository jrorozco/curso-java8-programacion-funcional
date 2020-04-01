package funciones.orden.superior;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainOrdenSuperior implements SumarInterface{

	public static void main(String[] args) {
		MainOrdenSuperior os = new MainOrdenSuperior();
		//-------------------funcion--------------------// 
		System.out.println(os.suma(2, 3));
		//-------------------Interfaz-------------------// 
		System.out.println(os.aply(2, 4));
		//-------------------Funcion de alto orden------//
		SumarInterface sumInterfaz = (a,b) -> a+b;
		System.out.println(os.sumaFuncionAltoOrden(sumInterfaz, 3, 4));
		Function<String, String> convetirAMayusculas = e-> e.toUpperCase();
		os.imprimiMayusculas(convetirAMayusculas, "rene");
		//-------------------Interfaz fucional Predicate------//
		/*
		 * interface BiFunction<T,U,R>
		 * {
		 * 	R apply(T t, U u)
		 * }
		 * 
		 * 
		 * interface Predicate<T>
		 * {
		 * 		Boolean text(T t)
		 * }
		 * 
		 */
		 List<Integer>	numeros = Arrays.asList(6,23,-5,4,68, -9, -67,46);
		 BiFunction<List<Integer>, Predicate<Integer>, List<Integer>> filtrar;
		 filtrar = (lista, predicado) -> lista.stream().filter(e -> predicado.test(e)).collect(Collectors.toList());
		 System.out.println(filtrar.apply(numeros, e -> e > 0));
		
		
	}
	
	
	public int suma(int a, int b) {
		return a +b ;
	}


	@Override
	public int aply(int a, int b) {
		return a + b;
	}
	
	public int sumaFuncionAltoOrden(SumarInterface sumInterface, int a, int b) {
		return	sumInterface.aply(a, b);
	}
	
	public void imprimiMayusculas(Function<String, String> funcion, String nombre ) {
		System.out.println(funcion.apply(nombre));
	}
}
