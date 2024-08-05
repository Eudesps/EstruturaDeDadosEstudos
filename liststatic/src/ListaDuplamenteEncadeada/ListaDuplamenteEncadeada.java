	package ListaDuplamenteEncadeada;


public class ListaDuplamenteEncadeada {
	private No inicio;
	private No fim;
	private int tamanho;
	
	private boolean posicaoValida(int posicao) {
		return posicao >= 0 && posicao < this.tamanho;
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
	
	public void adicionaNoInicio(Object elemento) {
        if(this.tamanho == 0) {
            No novo = new No(elemento);
            this.inicio = novo;
            this.fim = novo;            
        }
        else {
            No novo = new No(elemento, this.inicio);
            this.inicio.setAnterior(novo);
            this.inicio = novo;
        }
        this.tamanho++;
    }
   
    public void adicionaNoFinal(Object elemento) {
        if(this.tamanho == 0) {
            this.adicionaNoInicio(elemento);
        }
        else {
            No novo = new No(elemento);
            this.fim.setProximo(novo);
            novo.setAnterior(this.fim);
            this.fim = novo;
            this.tamanho++;
        }
    }
    
    public void adiciona(int posicao, Object elemento) {
		if(this.posicaoValida(posicao)) {
			if(posicao == 0) {
				this.adicionaNoInicio(elemento);
			}else {
				No anterior = this.pegaNo(posicao-1);
				No proximo = anterior.getProximo();
				No novo = new No(elemento, proximo);
				anterior.setProximo(novo);
				proximo.setAnterior(novo);
				novo.setAnterior(anterior);
								
				this.tamanho++;
				
			}
		}else if(posicao == this.tamanho){
			this.adicionaNoFinal(elemento);
		}else{
			System.out.println("Posição inválida!");
		}	
    }
    
   public void removeDoInicio() {
		if(this.tamanho > 1) {
			this.inicio = this.inicio.getProximo();
			this.inicio.setAnterior(null);
		}else {
			this.inicio = null;
			this.fim = null;
		}
		this.tamanho--;
   }
    
    public void removeDoFinal() {
    	if(this.tamanho > 1) {
	    	No NovoFim = this.fim.getAnterior();
	    	NovoFim.setProximo(null);
	    	this.fim = this.fim.getAnterior();
	    	this.tamanho--;  
    	}
    	else {
    		this.removeDoInicio();
    	}
    }
    
    public void remove(int posicao) {
    	if(this.posicaoValida(posicao)) {
    		if(posicao == 0) {
    			this.removeDoInicio();
    		}else if(posicao == this.tamanho-1) {
    			this.removeDoFinal();
    		}else {    		
	    		No no = this.pegaNo(posicao);
	    		No anterior = no.getAnterior();
	    		No proximo = no.getProximo();	    		
	    		anterior.setProximo(proximo);
	    		proximo.setAnterior(anterior);	    		
	    		this.tamanho--;
    		}
    	}else{
    		System.out.println("Posição inválida!");
    	}
    }
    
    //MÉTODOS CRIADOS PARA MODIFICAR E/OU MANIPULAR A LISTA DUPLAMENTE ENCADEADA
    
    public ListaDuplamenteEncadeada juntaListaNoFim(ListaDuplamenteEncadeada l1, ListaDuplamenteEncadeada l2) {
    	ListaDuplamenteEncadeada l3 = new ListaDuplamenteEncadeada();
    	l3.inicio = l1.inicio;
    	l3.fim = l2.fim;
    	
    	No ultimal1 = l1.pegaNo(l1.tamanho-1);
    	No primeirol2 = l2.pegaNo(0);
    	
    	ultimal1.setProximo(primeirol2);
    	primeirol2.setAnterior(ultimal1);
    	
    	l3.setTamanho(l1.tamanho + l2.tamanho);
    	
    	return l3;
    }
    
    //Método que recebe e inverte uma lista duplamente encadeada
    public ListaDuplamenteEncadeada inverteLista(ListaDuplamenteEncadeada l1) {
    	ListaDuplamenteEncadeada aux = new ListaDuplamenteEncadeada();
    	
    	No atual = l1.fim;
    	
    	while(atual.getAnterior()!= null) {
    		No anteriorAtual = atual.getAnterior();

    		if(l1.fim.getElemento() == atual.getElemento()) {
    			atual.setProximo(atual.getAnterior());
    			atual.setAnterior(null);
    			aux.inicio = l1.fim;
    			aux.fim = l1.inicio;
    		}else {
    			No proximo = atual.getProximo();
    			No anterior = atual.getAnterior();
    			
    			atual.setProximo(anterior);
    			atual.setAnterior(proximo);
    		}
    		atual = anteriorAtual;
    	}
    	aux.setTamanho(l1.getTamanho());
    	
    	return aux;
    }
    
    /*Adicione um método removeDuplicados que remova todos os elementos duplicados da lista.*/
    public void removeDuplicados(ListaDuplamenteEncadeada l1) {
    	No comp1;
    	No comp2;
    	for(int i = 0; i<= l1.tamanho-1; i++) {
    		comp1 = l1.pegaNo(i);
    		for(int j = 0; j<= l1.tamanho-1; j++) {
    			if(i != j) {
    				comp2 = l1.pegaNo(j);
    				if(comp1.getElemento().equals(comp2.getElemento())) {
        				l1.remove(j);
        				j--;
        			}
    			}
    			
    		}
    	}
    }
    
    //Método que recebe 2 listas e adicione os elementos dessas 2 listas intercalados em uma terceira lista 
    public ListaDuplamenteEncadeada intercala (ListaDuplamenteEncadeada l1, ListaDuplamenteEncadeada l2) {
    	ListaDuplamenteEncadeada l3 = new ListaDuplamenteEncadeada();
    	
    	for(int i = 0; i < l1.tamanho; i++ ){    		
    		l3.adicionaNoFinal(l1.pegaNo(i).getElemento());
    		l3.adicionaNoFinal(l2.pegaNo(i).getElemento());	
    	} 	
    	return l3;
    }
    
    public void insere_esq(int k, ListaDuplamenteEncadeada l1, Object elemento) {    	
    	l1.adiciona(k, elemento);
    }
    
    //Um método para concatenar duas listas.
    public ListaDuplamenteEncadeada concatenar(ListaDuplamenteEncadeada l1, ListaDuplamenteEncadeada l2) {
    	ListaDuplamenteEncadeada l3 = new ListaDuplamenteEncadeada();
    	
    	l3.setInicio(l1.getInicio());
    	l3.setFim(l2.getFim());
    	
    	No fiml1 = l1.getFim();
    	No iniciol2 = l2.getInicio();
    	
    	fiml1.setProximo(iniciol2);
    	iniciol2.setAnterior(fiml1);
    	
    	l3.setTamanho(l1.getTamanho() + l2.getTamanho());
    	return l3;
    }   
    
    //Um método que separa uma lista em duas novas listas.
    public void separaLista(ListaDuplamenteEncadeada l1) {
    	ListaDuplamenteEncadeada aux1 = new ListaDuplamenteEncadeada();
		ListaDuplamenteEncadeada aux2 = new ListaDuplamenteEncadeada();
		
    	if(l1.getTamanho()% 2 == 0) {    		
    		No separacao = l1.pegaNo((l1.getTamanho()/2)-1);
    		No proximo = separacao.getProximo();
    		
    		aux1.inicio = l1.inicio;
    		aux1.fim = separacao;
    		aux1.setTamanho(l1.tamanho/2);
    		
    		aux2.inicio = proximo;
    		aux2.fim = l1.fim;
    		aux2.setTamanho(l1.tamanho/2);
    		
    		System.out.println("lista1: " + aux1);
    		System.out.println("lista2: " + aux2);
    		
    	}else {
    		No separacao = l1.pegaNo(tamanho/2);
    		No proximo = separacao.getProximo();
    		
    		aux1.inicio = l1.inicio;
    		aux1.fim = separacao;
    		aux1.setTamanho((l1.tamanho/2) + 1);
    		
    		aux2.inicio = proximo;
    		aux2.fim = l1.fim;
    		aux2.setTamanho(l1.tamanho/2);
    		
    		System.out.println("lista1: " + aux1);
    		System.out.println("lista2: " + aux2);
    	}
    }

	
    @Override
	public String toString() {
		if(this.tamanho==0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		No atual = this.inicio;
		for(int i=0; i<this.tamanho-1; i++) {
			builder.append(atual.getElemento());
			builder.append(", ");
			atual = atual.getProximo();
		}
		builder.append(atual.getElemento());
		builder.append("]");
		
		return builder.toString();
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
	
	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	
	
}
