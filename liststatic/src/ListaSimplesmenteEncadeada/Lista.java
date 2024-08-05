package ListaSimplesmenteEncadeada;

public class Lista {
	private No inicio;
	private No fim;
	private int totalDeElementos;
	
	public void adicionaNoInicio(Object elemento) {
		No novo = new No(elemento, this.inicio);
		this.inicio = novo;
		if(this.totalDeElementos==0) {
			this.fim = novo; 
		}
		this.totalDeElementos++;
	}
	
	public void adicionaNoFinal(Object elemento) {
		if(this.totalDeElementos==0) {
			this.adicionaNoInicio(elemento);
		}else {
			No novo = new No(elemento);
			this.fim.setProximo(novo);
			this.fim = novo;
			this.totalDeElementos++;
		}
	}

	/*@Override
	public String toString() {
		return "ListaEncadeada [inicio=" + inicio.getElemento() + ", fim=" + fim.getElemento() + ", totalDeElementos=" + totalDeElementos + "]";
	}*/
	
	@Override
	public String toString() {
		if(this.totalDeElementos==0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No atual = this.inicio;
		for(int i=0; i<this.totalDeElementos-1; i++) {
			builder.append(atual.getElemento());
			builder.append(", ");
			atual = atual.getProximo();
		}
		builder.append(atual.getElemento());
		builder.append("]");
		return builder.toString();
	}
	
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao < this.totalDeElementos;
	}
	private No pegaNo (int posicao) {
		if(!this.posicaoValida(posicao)) {
			throw new IllegalArgumentException("Posição Inálida!");
		}
		No atual = this.inicio;
		for(int i = 0; i < posicao; i++) {
			atual = atual.getProximo();
		}
		return atual;
	}
	
	public void adiciona(int posicao, Object elemento) {
		if(posicao==0) {
			this.adicionaNoInicio(elemento);
		}else if(posicao==this.totalDeElementos-1) {
			this.adicionaNoFinal(elemento);
		}else{
			No anterior = this.pegaNo(posicao-1);
			No novo = new No(elemento, anterior.getProximo());
			anterior.setProximo(novo);
			this.totalDeElementos++;
		}
	}
	
	public Object pega(int posicao) {
		return this.pegaNo(posicao).getElemento();
	}
	
	public void removeDoComeco() {
		if(this.totalDeElementos>0) {
			this.inicio = this.inicio.getProximo();
			this.totalDeElementos--;
		}
		if(this.totalDeElementos==0) this.fim = null;	
	}
	
	public void removeDoFinal() {
		if(this.getTotalDeElementos()==0) {
			System.out.println("Lista vazia!");
		}else if(this.totalDeElementos == 1) {
			this.removeDoComeco();
		}else {
			No anterior = this.pegaNo(this.totalDeElementos-2);
			anterior.setProximo(null);
			this.fim = anterior;
			this.totalDeElementos--;
		}
	}
	
	 public boolean remove(int posicao) {
		if(this.posicaoValida(posicao)) {
			if(posicao == 0) {
				this.removeDoComeco();
				return true;
			}else if(posicao == this.totalDeElementos-1) {
				this.removeDoFinal();
				return true;
			}else {
				No anterior  = this.pegaNo(posicao-1);
				No atual = anterior.getProximo();
				No proximo = atual.getProximo();
				anterior.setProximo(proximo);
				this.totalDeElementos--;
				return true;
			}
		}else {
			return false;
		}
	}
	
	public boolean contem(Object elemento) {
		No atual = this.inicio;
		for(int i=0; i<this.totalDeElementos;i++) {
			if(atual.getElemento().equals(elemento)) return true;
			atual = atual.getProximo();
		}
		return false;
	}
	
	public int tamanho() {
		return this.totalDeElementos;
	}

	public No getInicio() {
		return inicio;
	}

	public void setInicio(No inicio) {
		this.inicio = inicio;
	}

	public No getFim() {
		return fim;
	}

	public void setFim(No fim) {
		this.fim = fim;
	}

	public int getTotalDeElementos() {
		return totalDeElementos;
	}

	public void setTotalDeElementos(int totalDeElementos) {
		this.totalDeElementos = totalDeElementos;
	}
	
	/*Implemente uma função que tenha como valor de retorno o comprimento de uma lista encadeada, isto é, que
    calcule o número de nós de uma lista.*/
	
	public int tamanhoLista() {
		int cont = 0;
		No atual = this.inicio;
		for(int i=0; i<this.totalDeElementos;i++) {
			if(atual.getProximo() != null) {
				//atual = atual.getProximo();
				cont ++;
			}
		}
		return cont;
	}
	
	/*Considere listas encadeadas de valores inteiros e implemente uma função 
	 *para retornar o número de nós da lista que possuem o campo info com valores maiores que n.*/
	public void qtdNumNos(int elemento) {
		int cont = 0;
		No atual = this.inicio;
		for(int i=0; i<this.totalDeElementos;i++) {
			if((int)atual.getElemento() > elemento) {
				cont++;
			}
			atual = atual.getProximo();
		}
		System.out.println("Total de campos com valores maiores que " + elemento + ": " + cont);
	}
	
	/* Implemente uma função que receba duas listas encadeadas de valores inteiros e retorne 
	 * a lista resultante da concatenação das duas listas recebidas como parâmetros, isto é, 
	 * após a concatenação, o último elemento da primeira lista deve apontar para o primeiro 
	 * elemento da segunda lista*/
	public Lista concatenaLista(Lista l1, Lista l2) {
	    Lista l3 = new Lista();

	    No Atual = l1.getInicio();
	    while (Atual != null) {
	        l3.adicionaNoFinal(Atual.getElemento());
	        Atual = Atual.getProximo();
	    }

	    Atual = l2.getInicio();
	    while (Atual != null) {
	        l3.adicionaNoFinal(Atual.getElemento());
	        Atual = Atual.getProximo();
	    }
	    return l3;
	}
	
	/*Considere listas de valores inteiros e implemente uma função que receba como parâmetro uma lista 
	 * encadeada e um valor inteiro n, retire da lista todas as ocorrências de n e retorne a lista resultante.*/
	public Lista removeOcorrencias(Lista lista, int n) {
	    Lista listaResultante = new Lista();
	    No atual = lista.getInicio();
	    while (atual != null) {
	        if ((int) atual.getElemento() != n) {
	            listaResultante.adicionaNoFinal(atual.getElemento());
	        }
	        atual = atual.getProximo();
	    }
	    return listaResultante;
	}
    
    public int contaNumerosPares() {
        int count = 0;
        No atual = inicio;
        while (atual != null) {
            if (atual.getElemento() instanceof Integer) {
                int numero = (int) atual.getElemento();
                if (numero % 2 == 0) {
                    count++;
                }
            }
            atual = atual.getProximo();
        }
        return count;
    }
    
    public void trocaNumerosParesPor(Object novoElemento) {
        No atual = inicio;
        while (atual != null) {
            No proximo = atual.getProximo();
            if (atual.getElemento() instanceof Integer && (int) atual.getElemento() % 2 == 0) {
                atual.setElemento(novoElemento);
            }
            atual = proximo;
        }
    }
    
    /*A altura de um nó N em uma lista encadeada é a distância entre N e o fim, 
     * da lista. Mais precisamente, a altura de N é o número de passos do caminho 
     * que leva de N até o último nó da lista. Escreva um método altura(Object elemento)
     * que encontra o nó onde o elementoinformado está armazenado e calcula a altura desse nó. */
	public int altura(Object elemento) {
		int cont = 0;
		int aux = 0;
		No atual = inicio;
		for(int i=0; i<this.totalDeElementos;i++) {
			if((int)elemento == (int)atual.getElemento() ) {
				cont++;
			}if(cont > 0) {
				aux++;
			}
			atual = atual.getProximo();
		}
		return aux -1;
		
	}
	
	
	
	
	
}
