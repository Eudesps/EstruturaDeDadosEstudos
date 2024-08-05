package ListaSimplesmenteEncadeada;

public class App {

	public static void main(String[] args) {
		Lista l1 = new Lista();
		l1.adicionaNoInicio(5);
		l1.adicionaNoInicio(8);
		l1.adicionaNoFinal(9);
		l1.adicionaNoFinal(10);
		
		System.out.println(l1);
		System.out.println(l1.altura(9));
		

	}

}
