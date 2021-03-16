
public class Queue<T> {

	Element<T> first;
	
	public Queue() {
		first = null;
	}
	   
	
	public boolean isEmpty() {
		if(first == null ) return true;
		return false;
	}
	
	public void enqueue(T towar) {
		Element<T> pomocniczy = first;
		if(first == null) {
			Element<T> newEl = new Element<T>(towar);
			first=newEl;
			return;
		}
		while(pomocniczy.next != null) {
			pomocniczy = pomocniczy.next;
		}
		Element<T> newEl = new Element<T>(towar);
		pomocniczy.next = newEl;
		
	}
	
	public T dequeue() throws EmptyQueueException {
		if(first == null) {
			throw new EmptyQueueException();
		}
		T toReturn = first.value;
		first = first.next;
		return toReturn;
		
	}
	
	public void WyswietlKolejke() {
		Element pom = first;
		while(pom!= null) {
			System.out.println(pom.value.toString());
			pom = pom.next;
		}
		
	}
	public int size() {
		int licznik =0;
		Element pom = first;
		if(first == null) {
			return 0;
		}
		while(pom != null) {
			licznik++;
			pom = pom.next;
		}
		return licznik;
	}
	
}
