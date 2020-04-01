package lamda;

public class Lamda {
	
	
	public static void main(String[] args) {
			MiNombre miMetodoAnonimo = new MiNombre() {

				@Override
				public String miNombre() {
					return "Rene";
				}
				
			};
			
			System.out.println("Mi nombre metodo anomimo" + miMetodoAnonimo.miNombre());
			
			MiNombre minombreLambda = ()-> "Rene";
			System.out.println("Mi nombre Lambda " + miMetodoAnonimo.miNombre());
			
			
			Sumar sumar = new Sumar() {

				@Override
				public int suma(int a, int b) {
					// TODO Auto-generated method stub
					return a + b;
				}
				
			};
			System.out.println(sumar.suma(2, 3));
			
			Sumar sumalamda =(a,b) -> a + b;
			System.out.println(sumalamda.suma(2, 3));
			
			Sumar sumaConMasLineas = (a,b) -> {
			    a = b * b;
			    a += a + b;
			    System.out.println("Mensaje cualquiera");
			    return a;
			};
			System.out.println(sumaConMasLineas.suma(2, 3));
	}
}
