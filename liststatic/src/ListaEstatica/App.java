package ListaEstatica;

public class App {

	public static void main(String[] args) {
		Lista lista = new Lista(5);
		lista.adicionaQualquerPosicao(0,"Salgueiro");
		lista.adicionaQualquerPosicao(1,"Cabrobó");
		lista.adicionaQualquerPosicao(2,"Serrita");
		lista.adicionaQualquerPosicao(3, "Brejo");
		lista.adicionaQualquerPosicao(4, "Salgueiro");
		lista.adicionaQualquerPosicao(5, "Belmonte");
		
		System.out.println("Antes de remover " + lista);
		lista.removerTodosElementos();
		System.out.println("Depois de remover " + lista);
		
		//System.out.println("Ultima ocorrência " + lista.verificaUltimaOcorrecia("Salgueiro"));
		/*System.out.println(lista.capacidade());
		System.out.println(lista);
		
		System.out.println("Tamanho: " + lista.getTamanho());
		System.out.println("lista: " +lista.buscaBasica(1));
		System.out.println("Verifica " + lista.verifica("salgueirO"));
		System.out.println("posição da segunda " + lista.verificaOcorrecia("salgueiro"));
		System.out.println(lista);
		System.out.println(lista.removeElemento("Cabrobó"));
		System.out.println(lista);
		
		ListaObject lista2 = new ListaObject(5);
		lista2.adicionaQualquerPosicao(0, lista);
		lista2.adicionaQualquerPosicao(0, "Sua");
		lista2.adicionaQualquerPosicao(0, 'a');
		lista2.adicionaQualquerPosicao(0, 10);
		System.out.println(lista2);*/
	}

}
