package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPrueba {
	
	private static List<Usuario> usuarios;

	public static void main(String[] args) {
		setUpUser();
		Stream stream =Stream.of(usuarios);
		usuarios.stream();
		
//		usuarios.stream().forEach(u -> u.getNombre());
		usuarios.stream().forEach(u -> u.setNombre(u.getNombre() + " Apellido"));
		imprimirLista();
		
	
		List<String> listaNombres = usuarios.stream().map( u -> u.getNombre()).collect(Collectors.toList());
		//listaNombres.stream().forEach(e -> System.out.println(e));
		listaNombres.stream().forEach( System.out::println);
		
		String datos=usuarios.stream().map(u -> u.getNombre()).toString();
		
		System.out.println(datos.toString());
		
		//filter
		System.out.println("------------------------Filters--------------------------");
		setUpUser();
		List<Usuario> usuariosFiltrados = usuarios.stream()
												   .filter(u -> u.getNombre() !="Roberto")
												   .filter(u -> u.getId() < 5)
												   .collect(Collectors.toList());
		usuariosFiltrados.stream().forEach(System.out::println);
		//FIND FIRST
		System.out.println("------------------------Filters Find First----------------");
		setUpUser();
		Usuario userFirst = usuarios.stream()
								 .filter(u -> u.getNombre() == "Rene")
								 .findFirst()
								 .orElse(null);
		System.out.println(userFirst.getId() + " " + userFirst.getNombre());
		//FLAT MAP
		System.out.println("------------------------Filters Flat Map------------------");
		List<List<String>> nombresVariasListas = new ArrayList<>(
		Arrays.asList(
					new ArrayList<String>(Arrays.asList("Rene","Roberto","Raul")),
					new ArrayList<String>(Arrays.asList("David","Luis","Fernando"))
					
				));
		List<String> unicaLista = nombresVariasListas
								  .stream()
								  .flatMap( l -> l.stream())
								  .collect(Collectors.toList());
		//unicaLista.stream().forEach(e -> System.out.println(e));
		unicaLista.stream().forEach(System.out::println);
		
		//peek
		System.out.println("------------------------Filters Peek----------------");
		setUpUser();
		List<Usuario> usuariosPeek = usuarios.stream()
											 .peek(u -> u.setNombre( u.getNombre() +" Apellido" ))
											 .filter(u -> !u.getNombre().startsWith("Rene"))
											 .collect(Collectors.toList());
//		usuariosPeek.stream().forEach(e -> System.out.println(e));
		usuariosPeek.stream().forEach(System.out::println);
		
		//count
		System.out.println("------------------------Filters Count---------------");
		setUpUser();
		long numeroFiltrado = usuarios.stream()
									  .filter(u -> u.getId() <3)
									  .count();
		System.out.println("[Numero filtrado] " + numeroFiltrado );
		
		//skip limit
		System.out.println("------------------------Filters Count---------------");
		String[] abecedario = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
		List<String> abecedarioList = Arrays.stream(abecedario).skip(2)
															   .limit(4)
															   .collect(Collectors.toList());
		//abecedarioList.stream().forEach(e -> System.out.println(e));
		abecedarioList.stream().forEach(System.out::println);
		//Sorted
		System.out.println("------------------------Filters Sorted--------------");
		setUpUser();
		usuarios =usuarios.stream()
				.sorted(Comparator.comparing(u -> u.getNombre()))
				.collect(Collectors.toList());
		imprimirLista();
		
		
		System.out.println("------------------------Filters Min Max--------------");
		setUpUser();
//		min
		Usuario usuarioMin = usuarios.stream()
									.min(Comparator.comparing(u -> u.getId()))
									.orElse(null);
		System.out.println(usuarioMin);
//		max
		Usuario usuarioMax = usuarios.stream()
				.max(Comparator.comparing(u -> u.getId()))
				.orElse(null);
		System.out.println(usuarioMax);
		
		System.out.println("------------------------Filters Distinct--------------");
		String[] abecedarioDistinct = {"a","b","c","a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p"};
		
		List<String> abcFilterDistinct = Arrays.asList(abecedarioDistinct)
											   .stream()
											   .distinct()
											   .collect(Collectors.toList());
//		abcFilterDistinct.stream().forEach( a -> System.out.println(a));
		abcFilterDistinct.stream().forEach( System.out::println);
		
		System.out.println("-----------Filters allMatch anyMatch nonematch--------------");
		List<Integer> listaNumeros = Arrays.asList(100,200,300,900,5000);
		
		boolean allMatch = listaNumeros.stream().allMatch( e ->  e > 301);
		System.out.println("Todos los elmentos tiene que cumplir con la condicion [allMatch] : " + allMatch);
		
		boolean anyMatch = listaNumeros.stream().anyMatch( e ->  e > 301);
		System.out.println("con un elmento  que cumpla con la condicion [anyMatch] : " + anyMatch);		
//
		boolean nonematch = listaNumeros.stream().noneMatch( e ->  e > 4000);
		System.out.println("con un elmento  que no cumpla con la condicion [nonematch] : " + nonematch);		
		
		System.out.println("------------------------Filters Average  Range --------------");
		setUpUser();
		double result = usuarios.stream()
								.mapToInt(Usuario::getId)
								.average()
								.orElse(0);
		System.out.println(result);
		
		result = usuarios.stream()
						.mapToInt(Usuario::getId)
						.sum();
		System.out.println(result);
		System.out.println(IntStream.range(0,100).sum());
		
		System.out.println("------------------------Filters Reduce  ---------------------");
		setUpUser();
		int numero = usuarios.stream()
							.map(Usuario::getId)
							.reduce(100, Integer::sum);
		System.out.println(numero);
		
		System.out.println("------------------------Filters joining  ---------------------");
		setUpUser();
		String names = usuarios.stream()
								.map(Usuario::getNombre)
								.collect(Collectors.joining(" - "))
								.toString();
		System.out.println(names);
		
		System.out.println("------------------------Filters toSet -------------------------");
		setUpUser();
		Set<String> setNames = usuarios.stream()
								.map(Usuario::getNombre)
								.collect(Collectors.toSet());
//		setNames.stream().forEach(e -> System.out.println(e));
		setNames.stream().forEach(System.out::println);
		
		System.out.println("------------------------Filters summarizingDouble--------------");
		setUpUser();
		DoubleSummaryStatistics statistics = usuarios.stream()
													.collect(Collectors.summarizingDouble(Usuario ::getId));
		System.out.println("La media " + statistics.getAverage() +" El maximo "+ statistics.getMax() + " El min " + statistics.getMin() +" Total de elementos  " + statistics.getCount() + " Suma "+ statistics.getSum());
													
		DoubleSummaryStatistics statistics1 = usuarios.stream()
												.mapToDouble(Usuario:: getId)
												.summaryStatistics();
        System.out.println("La media " + statistics1.getAverage() +" El maximo "+ statistics1.getMax() + " El min " + statistics1.getMin() +" Total de elementos  " + statistics1.getCount() + " Suma "+ statistics1.getSum());

        System.out.println("------------------------Filters partitioninBy--------------");
		setUpUser();
		List<Integer> numeros = Arrays.asList(5,7,34,56,2,3,6,4,98);
		Map<Boolean, List<Integer>> esMayor = numeros.stream()
													.collect(Collectors.partitioningBy(e -> e > 10));
		// verdadero mayor a 10
//		esMayor.get(true).stream().forEach(e -> System.out.println(e));
		esMayor.get(true).stream().forEach(System.out::println);
		
//		false mayor a 10
//		esMayor.get(false).stream().forEach(e -> System.out.println(e));
		esMayor.get(false).stream().forEach(System.out::println);
								
		 System.out.println("------------------------Filters groupingBy--------------");
			setUpUser();
		Map<Character, List<Usuario>> grupoAlfabetico =usuarios.stream()
														.collect(Collectors.groupingBy(e -> new Character(e.getNombre().charAt(0))));
		grupoAlfabetico.get('R').stream().forEach(e -> System.out.println(e.getNombre()));
//		grupoAlfabetico.get('R').stream().forEach(System.out::println);
//		
		grupoAlfabetico.get('D').stream().forEach(e -> System.out.println(e.getNombre()));
//		grupoAlfabetico.get('D').stream().forEach(System.out::println);
//		
		grupoAlfabetico.get('E').stream().forEach(e -> System.out.println(e.getNombre()));
//		grupoAlfabetico.get('E').stream().forEach(System.out::println);
		
		 System.out.println("------------------------Filters mapping ----------------");
			setUpUser();
		List<String> personas = usuarios.stream()
								.collect(Collectors.mapping(Usuario::getNombre, Collectors.toList()));
		personas.stream().forEach(u -> System.out.println(u));

		List<String> personas2 = usuarios.stream()
				.collect(Collectors.mapping(u -> u.getNombre(), Collectors.toList()));
		personas2.stream().forEach(System.out::println);
			
		 System.out.println("------------------------Filters Stream paralelo---------");
			setUpUser();
			long tiempoinicio1 = System.currentTimeMillis();
			personas.stream().forEach(e -> convertirAMayusculas(e));
			long tiempofinal1 = System.currentTimeMillis();
			System.out.println(tiempofinal1 - tiempoinicio1);

			tiempoinicio1 = System.currentTimeMillis();
			personas.parallelStream().forEach(e -> convertirAMayusculas(e));
			long tiempofinal2 = System.currentTimeMillis();
			System.out.println("Paralelo : " + (tiempofinal2 - tiempoinicio1));
		
		
		
		
		
	}

	private static String convertirAMayusculas(String nombre)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return nombre.toUpperCase();
	}
	
	private static void setUpUser() {
		usuarios = new ArrayList();
		usuarios.add(new Usuario(1,"Rene"));
		usuarios.add(new Usuario(2,"Raul"));
		usuarios.add(new Usuario(3,"David"));
		usuarios.add(new Usuario(4,"Roberto"));
		usuarios.add(new Usuario(5,"Rene"));
		usuarios.add(new Usuario(6,"Ester"));
	}
	
	private static void imprimirLista()
	{
		usuarios.stream().forEach(u -> System.out.println(u.getId() + " " + u.getNombre()));
		usuarios.stream().forEach(System.out::println);
	}
}
