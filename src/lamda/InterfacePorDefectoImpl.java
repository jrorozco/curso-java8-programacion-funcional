package lamda;

public class InterfacePorDefectoImpl  implements InterfacePorDefecto{

	@Override
	public void monstraNombre(String nombre) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		InterfacePorDefecto porDefecto = new InterfacePorDefectoImpl();
		System.out.println(porDefecto.nombrePorDefecto("Rene"));
	}

}
