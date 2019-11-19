package api;

import implementaciones.NodoGrafo;

public interface GrafosTDA {
	
	public void inicializarGrafo(int num);
	
	public void eliminarVertice(int v);
	
	public void agregarVertice(int v) ;
		
	public int [] vertices();
	
	public void agregarArista(int v1, int v2, int peso);
	
	public void eliminarArista(int v1, int v2);
	
	public boolean existeArista(int v1, int v2);
	
	public int pesoArista(int v1, int v2);
	
	public void mostrarMatriz();
	
	public boolean pertenece(int x);
	
	public int mayorArista(int v);
	
	public int[] conjuntoAislados();
	
	public void imparAristas();
	
	public void dephtFirstSearch();

	public void imprimirVertices();
	
	
	public int[][] grafoPrim();
	
	public int[] dijkstra(int inicio ,int maxVertices);
}