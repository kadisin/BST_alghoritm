
public class MAIN {

	public static void main(String[] args) throws EmptyQueueException {
		
		BST drzewo = new BST();
		drzewo.addR(35);
		drzewo.addR(60);
		drzewo.addR(15);
		drzewo.addR(20);
		drzewo.addR(43);
		drzewo.addR(8);
		drzewo.addR(50);
		drzewo.addR(82);
		drzewo.addR(70);
		drzewo.addR(30);
		
		System.out.println("Wypisanie drzewa BST preOreder:");
		drzewo.preOrder();
		System.out.println("\nWypisanie drzewa BST postOreder:");
		drzewo.postOrder();
		System.out.println("\nWypisanie drzewa BST inOreder:");
		drzewo.inOrder();
		
	
		System.out.println("");
		drzewo.findNode(8);
		drzewo.findNode(11);
		System.out.println("");
		
		drzewo.findMaxKey();
		drzewo.findMinKey();
		
		System.out.println("Wysokosc drzewa: " + drzewo.countHeight());
		System.out.println("Ilosc wezlow: "+ drzewo.countNodes());
		System.out.println("Ilosc lisci: " + drzewo.countLeaf());
		
		System.out.println("\nWypisanie drzewa BST poziomami:");
		drzewo.wyswietlPoziomami();	
		
		System.out.println("\nNastepnik do 50: " + drzewo.succesor(50));
		
		System.out.println("Poprzednik do 50: " + drzewo.poprzednik(50));
		
		drzewo.delete(60);
		System.out.println("\nWypisanie drzewa BST poziomami(bez 60):");
		drzewo.wyswietlPoziomami();	
		
	
	}

}
