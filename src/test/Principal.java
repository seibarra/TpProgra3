package test;

import api.GrafosTDA;
import implementaciones.GrafoDinamic;
import implementaciones.ImplemEstatica;

public class Principal {
	
	
	public static GrafosTDA gDFS = new GrafoDinamic();
	public static GrafosTDA gPrim = new ImplemEstatica();
	public static GrafosTDA gDijkstra = new ImplemEstatica();
	
	
	
	public static void main(String[] args) {
		
		System.out.println("Prim");
		System.out.println();
		
		gPrim.inicializarGrafo(6);
		gPrim.agregarVertice(1);
		gPrim.agregarVertice(2);
		gPrim.agregarVertice(3);
		gPrim.agregarVertice(4);
		gPrim.agregarVertice(5);
		gPrim.agregarVertice(6);
		gPrim.agregarArista(1, 3, 1);
		gPrim.agregarArista(1, 2, 6);
		gPrim.agregarArista(1, 4, 5);
		gPrim.agregarArista(2, 5, 3);
		gPrim.agregarArista(2, 3, 5);
		gPrim.agregarArista(3, 4, 5);
		gPrim.agregarArista(3, 5, 6);
		gPrim.agregarArista(3, 6, 4);
		gPrim.agregarArista(4, 6, 2);
		gPrim.agregarArista(5, 6, 6);
		
		int[][] prim = gPrim.grafoPrim();
		
		for(int i = 0; i < prim.length ; i++) {
			for (int j = 0; j < prim.length; j++) {
				System.out.print(prim[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println("Dijkstra");
		System.out.println();
		
		gDijkstra.inicializarGrafo(8);
		gDijkstra.agregarVertice(1);
		gDijkstra.agregarVertice(2);
		gDijkstra.agregarVertice(3);
		gDijkstra.agregarVertice(4);
		gDijkstra.agregarVertice(5);
		gDijkstra.agregarVertice(6);
		gDijkstra.agregarVertice(7);
		gDijkstra.agregarVertice(8);
		gDijkstra.agregarArista(1, 2, 80);
		gDijkstra.agregarArista(1, 3, 1);
		gDijkstra.agregarArista(1, 4, 80);
		gDijkstra.agregarArista(2, 5, 80);
		gDijkstra.agregarArista(3, 5, 80);
		gDijkstra.agregarArista(3, 6, 80);
		gDijkstra.agregarArista(3, 7, 1);
		gDijkstra.agregarArista(4, 7, 80);
		gDijkstra.agregarArista(5, 8, 1);
		gDijkstra.agregarArista(6, 5, 1);
		gDijkstra.agregarArista(6, 8, 80);
		gDijkstra.agregarArista(7, 6, 1);
		gDijkstra.agregarArista(7, 8, 80);
		
		gDijkstra.dijkstra(1, 8);
		

		System.out.println();
		System.out.println();
		
		gDFS.inicializarGrafo(4);
		gDFS.agregarVertice(4);
		gDFS.agregarVertice(3);
		gDFS.agregarVertice(2);
		gDFS.agregarVertice(1);
		gDFS.agregarArista(1, 2, 1);
		gDFS.agregarArista(2, 4, 1);
		gDFS.agregarArista(1, 3, 5);
	    
		gDFS.dephtFirstSearch();
	    
	}
	 
	
}
