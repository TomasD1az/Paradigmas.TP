package stack;

public class ContainerWithItem extends SuperContainer {
	private SuperContainer previousContainer;
	private Object element;
	private int size;
	
	public ContainerWithItem( SuperContainer preContainer, Object object) {
		 previousContainer = preContainer;
		 element = object;
		 size = preContainer.size() + 1;
	}
	
	public boolean isEmpty() {
		return false;
	}

	public SuperContainer push(Object object) {
		return new ContainerWithItem( this, object);
	}
 
	public SuperContainer pop() {
		return previousContainer;
	}

	public Object top() {
		return element;
	}

	public int size() {
		return size;
	}

}
