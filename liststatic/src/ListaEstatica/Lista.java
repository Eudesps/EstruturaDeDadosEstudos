package ListaEstatica;

public class Lista {
	private String[] elementos;
	private int tamanho;
	
	public Lista(int capacidade) {
		this.elementos = new String[capacidade];
		this.tamanho = 0;
	}
	
	public void adicionar(String elemento) {
		for(int i=0; i < elementos.length; i++) {
			if(elementos[i].equals(null)) {
				this.elementos[i] = elemento;
				break;
			}
		}
	}
	/*
	public boolean adiciona(String elemento) {
		if(this.tamanho < this.elementos.length) {
			this.elementos[this.tamanho] = elemento;
			this.tamanho++;
			return true;
		}
		return false;
	}
	/*Imprime, mas com os nulos
	public String toString() {
		return Arrays.toString(elementos);
	}*/
	/*
	public String toString() {
		if(this.tamanho() > 0) {
			String s = "[";
			for(int i = 0; i < tamanho-1; i++) {
				s += this.elementos[i]+", ";
			}
			s += this.elementos[this.tamanho -1] +"]";
			return s;
		}
		return null;
	}*/
	
	public String toString() {
		if(this.tamanho() > 0){
			StringBuilder s = new StringBuilder();
			s.append("[");
			for(int i = 0; i < tamanho-1; i++) {
				s.append(this.elementos[i]);
				s.append(", ");
			}
			s.append(this.elementos[this.tamanho -1]);
			s.append("]");
			return s.toString();
		}
		return null;
	}
	
	public String buscaBasica(int posicao) {
		try {
			return this.elementos[posicao];
		}catch(Exception e){
			return e.getMessage();
		}
	}
	
	public int verifica(String elemento) {
		for(int i = 0 ; i < this.tamanho;i++) {
			if(elemento.equalsIgnoreCase(this.elementos[i])) return i;
		}
		return -1;
	}
	
	public int verificaOcorrecia(String elemento) {
		int contador = 0;
		for(int i = 0 ; i < this.tamanho;i++) {
			if(elemento.equalsIgnoreCase(this.elementos[i])) {
				contador++;
				if(contador == 2) {
					return i;
				}
			}
		}
		return -1;
	}
	
	public int verificaUltimaOcorrecia(String elemento) {
		//int index = 0;
		for(int i = this.tamanho -1 ; i >= 0;i--) {
			if(elemento.equalsIgnoreCase(this.elementos[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public boolean adicionaQualquerPosicao(int posicao, String elemento) {
		try {
			if(!elemento.equals(null) && (posicao <= tamanho)) {
				if(this.tamanho >= this.elementos.length) {
					this.aumentaCapacidade();
				}				
				for (int i = this.tamanho-1; i >= posicao; i--) {
					this.elementos[i+1] = this.elementos[i];
				}
				this.elementos[posicao]=elemento;								
				this.tamanho++;
				return true;			
			}else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("ERRO: Não foi possível inserir no vetor");
			System.out.println("Posição inválida ou tipo de dado não ceito.");			
			return false;
		}
	}
	
	public void aumentaCapacidade() {
		String[] elementosNovos = new String[this.elementos.length*2];
		for(int i=0; i<this.elementos.length; i++) {
			elementosNovos[i] = this.elementos[i];
		}
		this.elementos = elementosNovos;
	}
	
	//remove com base na posição informoda 
	public void remove(int posicao) {		
		if((posicao >= 0) && (posicao < this.tamanho)) {
			for(int i = posicao; i < this.tamanho; i++) {
				this.elementos[i] = this.elementos[i+1];
			}
			this.tamanho--;
		}else {
			System.out.println("ERRO: Não foi possível remover no vetor.");
			System.out.println("Posição inválida!");
		}		
	}
	
	public void removerTodosElementos() {
		//Opção 1
		//this.tamanho = 0;
		
		//Opção 2
		for(int i = 0; i < this.tamanho; i++) {
			this.elementos[i] = null;
		}
		this.tamanho = 0;
	}
	
	//remove com base no elemento informado
	public boolean removeElemento(String elemento) {		
		int posicao = this.verifica(elemento);
		if(posicao > -1) {
			for(int i=posicao; i<tamanho-1;i++) {
				this.elementos[i] = this.elementos[i+1];
			}
			this.tamanho--;	
			return true;
		}
		return false;
	}
	
	public int tamanho(){
		return this.tamanho;
	}
	
	public String[] getElementos() {
		return elementos;
	}

	public void setElementos(String[] elementos) {
		this.elementos = elementos;
	}
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	
	public int capacidade() {
		int capacidade = this.elementos.length;
		return capacidade;
	}
}
