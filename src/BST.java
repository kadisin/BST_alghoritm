import java.util.NoSuchElementException;

public class BST<T> {

	private Node root;
	

	// dodawanie kluczy
	
	public void addR(int key) {
		root = addR(key,root);
		
	}
	private  Node addR(int key,Node n) {
		if(n == null)
			return new Node(key);
		if(key < n.key) 
			n.left = addR(key,n.left);
		 else 
			n.right = addR(key,n.right);
		return n;
	}
	
	// wyswietlanie kluczy
	public void preOrder() {
		preOrder(root);
		
	}
	private void preOrder(Node n) {
		if(n==null) return;
		System.out.print(n.key + " ");
		preOrder(n.left);
		preOrder(n.right);
		
	}
	
	public void postOrder() {
		postOrder(root);
	}
	private void postOrder(Node n) {
		if(n == null) return;
		postOrder(n.left);
		postOrder(n.right);
		System.out.print(n.key + " ");
		
	}
	
	public void inOrder() {
		inOrder(root);
	}
	private void inOrder(Node n) {
		if(n == null ) return;
		inOrder(n.left);
		System.out.print(n.key + " ");
		inOrder(n.right);
	}
	
	
	//zliczanie liczby wezlow
	public int countNodes() {
		return countNodes(root);
	}
	private int countNodes(Node n) {
		if(n == null) return 0;
		return 1+ countNodes(n.right) + countNodes(n.left);
	}
	//zliczanie wysokosc
	public int countHeight() {
		return countHeight(root);
	}
	private int countHeight(Node n) {
		if(n == null ) return -1;
		return 1 + Max(countHeight(n.left),countHeight(n.right));
	}
	private int Max(int l,int r) {
		if(l > r) return l;
		return r;
	} 
	// zliczanie lisci
	public int countLeaf() {
		return countLeaf(root);
	}
	private int countLeaf(Node n) {
	
		if ( n != null ) {
			if(n.left == null && n.right == null)
			{
				return 1;
			}
			else {
				return countLeaf(n.left) + countLeaf(n.right);
			}
		} else {
			return 0;
		}
		
	}
	
	//wyszukiwanie wezla
	public void findNode(int key) {
		findNode(key,root);
	}
	private void findNode(int key,Node n) {
		if(n == null ) return;
		if(key < n.key) findNode(key,n.left);
		if(key > n.key) findNode(key,n.right);
		if(key == n.key) System.out.println("Wezel o kluczu: " + key +" znajduje sie w drzewie ");
			
	}

	
	// klucz max i min
	public void findMaxKey() {
		findMaxKey(root);
	}
	private void findMaxKey(Node n) {
		if(n.right == null) {
		System.out.println("Max klucz: " + n.key);
		return;
		}
		findMaxKey(n.right);
	}
	
	public void findMinKey() {
		findMinKey(root);
	}
	private void findMinKey(Node n) {
		if(n.left == null) {
		System.out.println("Min klucz: " + n.key);
		return;
		}
		findMinKey(n.left);
	}
	
	// wyswietlanie kluczy poziomami
	public void wyswietlPoziomami() throws EmptyQueueException {
		wyswietlPoziomami(root);
	}
	private void wyswietlPoziomami(Node n) throws EmptyQueueException {
		Queue<Node> kolejka = new Queue<>();
		kolejka.enqueue(n);
		while(kolejka.isEmpty() == false) {
			if(kolejka.first.value.left != null) kolejka.enqueue(kolejka.first.value.left);
			if(kolejka.first.value.right != null) kolejka.enqueue(kolejka.first.value.right);
			System.out.print(kolejka.dequeue().key + " ");
			
			
		}
		
	}
	
	// nastepnik
	

	public int succesor(int key) {
		Node succ =  succesor(root,key);
		return succ == null?null:succ.key;
	}
	private Node succesor(Node node,int key) {
		if(node == null ) throw new NoSuchElementException();
		if(node.key == key) {
			if(node.right != null)
				return getMin(node.right);
			else return null;
		} else if(key - node.key < 0) {
			Node retNode = succesor(node.left,key);
			return retNode == null?node:retNode;
		} else {
			return succesor(node.right,key);
		}
		
	}
	
	public Node getMin(Node node) {
		assert(node!=null);
		while(node.left!=null) 
		node = node.left;
		return node;
		
	}
	
	
	//poprzednik
	
	public int poprzednik(int key) {
		Node succ = poprzednik(root,key);
		return succ == null?null:succ.key;
	}
	public Node poprzednik(Node node,int key) {
		if (node == null ) throw new NoSuchElementException();
		if(node.key == key) {
			if(node.left != null)
				return getMax(node.left);
			else return null;
		} else if(key - node.key > 0) {
			Node retNode = poprzednik(node.right,key);
			return retNode == null?node:retNode;
		} else {
			return poprzednik(node.left,key);
		}
		
	}
	
	public Node getMax(Node node) {
		assert(node!=null);
		while(node.right!=null)
			node = node.right;
		return node;
		
	}

	
	public void delete(int key) {
		root = delete(key,root);
	}
	
	public Node delete(int key,Node node ) {
		if(node == null) throw new NoSuchElementException();
		else {
		if(key - node.key < 0) 
			node.left = delete(key,node.left);
		else if(key - node.key > 0) 
			node.right = delete(key,node.right);
		else if(node.left != null && node.right != null)
			node.right = detachMin(node,node.right);
		else node = (node.left != null ) ? node.left : node.right;
		}
		return node;
			
		}
	public Node detachMin(Node del, Node node) {
		if(node.left != null) node.left = detachMin(del,node.left);
		else {
			del.key = node.key;
			node = node.right;
		}
		return node;
	}
	
}
