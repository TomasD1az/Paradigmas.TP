package stack;


public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	private SuperContainer container;
	
	public OOStack() {
		container = new EmptyContainer();
	}

	public boolean isEmpty() {
		return container.isEmpty();
	}

	public OOStack push(Object object) {
		container = container.push( object );
		return this;
	}

	public Object pop() {
		Object removedObject = container.top();
		container = container.pop();
		return removedObject;
	}

	public Object top() {
		return container.top();
	}

	public int size() {
		return container.size();
	}

}
