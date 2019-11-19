package implementaciones;
import api.GrafosTDA;

public class GrafoDinamic implements GrafosTDA {
	NodoGrafo nodo;
	int cantidad;


	public void inicializarGrafo(int num) {
		nodo = null;
	    cantidad=num;
		
	}
	
	public void eliminarVertice(int v) {
		NodoGrafo aux = encontrarNodo(v);
		
		if(aux != null) {
			aux = nodo; 
			if(aux.valor == v) {
				nodo = aux.sig;
				System.out.println("1");
			}
			while(aux != null) {
				this.eliminarArista(aux.valor, v);	
				if(aux.sig == this.encontrarNodo(v) && aux.sig != null) {
					aux.sig = aux.sig.sig;
					cantidad--;
					System.out.println("1");
				}
					aux = aux.sig;
					System.out.println("2");
			}
			
		}else {
			System.out.println("El vertice no existe");
		}

		
	}

	public void agregarVertice(int v) {
		if(this.encontrarNodo(v) == null) {
			
		
			NodoGrafo aux = new NodoGrafo();
			aux.valor = v;
			aux.lista = null;
			aux.sig = nodo;
			aux.Visitado = false;
			aux.marcado = false;
			nodo = aux;
			 cantidad++;
		}	
			
	}

	
	public int[] vertices() {
		int n= 100;
		int[] e = new int[n];
		int i = 0;
		NodoGrafo aux = nodo;
		while(aux != null && i < n-1) {
			e[i] = aux.valor;
			aux = aux.sig;
			i++;
		}
		
		return e;
	}

	public void agregarArista(int v1, int v2, int peso) {
		if(this.encontrarNodo(v1) != null && this.encontrarNodo(v2) != null) {
			NodoArista aux = new NodoArista();
			aux.origen = v1;
			aux.peso = peso;
			aux.Visitado = false;
			aux.apunta = this.encontrarNodo(v2);
			aux.sig = encontrarNodo(v1).lista;
			encontrarNodo(v1).lista = aux; 
			
		}else {
			System.out.println("No existe alguino de los noods");
		}
	}
	

	
	public void eliminarArista(int v1, int v2) {
		NodoGrafo nodo = encontrarNodo(v1);
		NodoArista arista = nodo.lista;
		if(arista != null) {
			if(arista.apunta.valor == v2) {				
				nodo.lista = arista.sig;
			}
			else {
				while(arista.sig != null && arista.apunta.valor == v2) {
					arista = arista.sig;
				}
				if(arista.sig != null) {
					arista.sig = arista.sig.sig;
				}				
			}			
		}
	}
	



	public boolean existeArista(int v1, int v2) {
		NodoGrafo aux = encontrarNodo(v1);
		NodoArista arista = aux.lista ;
		while(arista != null) {
			if(arista.apunta.valor ==v2) {
				return true;
			}
			arista = arista.sig;
		}		
		return false;
	}

	public int pesoArista(int v1, int v2) {
		NodoGrafo n1 = encontrarNodo(v1);
		NodoArista aux = n1.lista;
		while(aux.apunta.valor != v2) {
			aux = aux.sig;
		}
		
		return aux.peso;
	}


	public void mostrarMatriz() {
		NodoGrafo aux = nodo;
		NodoArista arista;
		while(aux != null) {
		System.out.print(aux.valor + "\t" );
		arista = aux.lista;
			while(arista != null) {
				
				System.out.print(arista.peso + " "  + arista.apunta.valor +  "\t");
				arista = arista.sig;
			}
			System.out.println();
			aux = aux.sig;
		}
	}
	
	
	public void imprimirVertices() {
		NodoGrafo aux = nodo;
		
		while(aux != null) {
		System.out.print("{"+aux.valor + "} - " );
			aux = aux.sig;
		}
		System.out.print("\n");
	}

	public boolean pertenece(int x) {
		if (this.encontrarNodo(x) != null) {
			return true;
		}
		return false;
	}

	public int mayorArista(int v) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int[] conjuntoAislados() {
		int aislados[]= new int [cantidad];
		int i = 0;
		NodoGrafo aux = nodo;
		
		while(aux != null) {
			if(aux.lista == null) {
				aislados[i]= aux.valor;
				i++;
				aux = aux.sig;
			}
		}
		return aislados;
	}

	public void imparAristas() {
		
		
	}
	
	public NodoGrafo encontrarNodo(int v) {
		NodoGrafo aux = nodo;
		while(aux != null) {
			if(aux.valor == v) {
				return aux;
			}
			aux = aux.sig;
		}
		return null;
	}



  
//////////////////////////////
private void DFSArista(int v){
    NodoGrafo n=encontrarNodo(v);
    n.Visitado=true;
    NodoArista Arist = n.lista;
    
		   while(Arist != null){
		        if(Arist.apunta.Visitado == false) {
		        	
		       	  DFSArista(Arist.apunta.valor);
		        }
		       
		        Arist=Arist.sig;
		    }
    	System.out.print("vertice:{"+n.valor+"}-\n");
}

public void dephtFirstSearch() {
	 System.out.print("--- DFS:----\n");
	NodoGrafo aux;
	aux=nodo;
	while(aux!=null) {
		
		if(aux.Visitado == false) {
			DFSArista(aux.valor);
		}
		aux=aux.sig;
	}
	System.out.print("-----------\n");
}
//////////////////////////////////////////////////////


@Override
public int[][] grafoPrim() {
	// TODO Auto-generated method stub
	return null;
}


@Override
public int[] dijkstra(int inicio, int maxVertices) {
	// TODO Auto-generated method stub
	return null;
}
}

