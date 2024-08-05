package ListaDuplamenteEncadeada;

public class App {

	public static void main(String[] args) {
		ListaDuplamenteEncadeada l1 = new ListaDuplamenteEncadeada();
		ListaDuplamenteEncadeada l2 = new ListaDuplamenteEncadeada();
		ListaDuplamenteEncadeada l3 = new ListaDuplamenteEncadeada();
		
		l1.adicionaNoInicio(6);
		l1.adicionaNoInicio(5);
		l1.adicionaNoInicio(10);
		l1.adicionaNoInicio(3);
		l1.adicionaNoInicio(6);
		l1.adicionaNoInicio(7);
		l1.adicionaNoInicio(40);
		l1.adicionaNoInicio(4);
		/*l1.adicionaNoInicio(9);
		l1.adicionaNoInicio(5);*/
		
		/*l2.adicionaNoInicio(3);
		l2.adicionaNoInicio(2);
		l2.adicionaNoInicio(1);*/
		
		System.out.println("l1: " + l1);
		//System.out.println("l2: " + l2);
		System.out.println("-------------");
		
		System.out.println(l2.inverteLista(l1));
		
		

	}

}
