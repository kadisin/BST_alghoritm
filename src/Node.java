
public class Node{
		int key;
		Node left;
		Node right;
		public Node(int key) {

			this.key = key;
			
		}
		
		public Node(int k,Node leftnode, Node rightnode) {
			key = k;

			left = leftnode;
			right = rightnode;
		}
		
		
		
	}