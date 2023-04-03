package stack;

import java.util.ArrayList;

public class OOStack {
	static public String stackEmptyErrorDescription = "Stack is empty";
	private ArrayList<Object> container;

	public OOStack() {
		container = new ArrayList();
	}
	public boolean isEmpty() {
		return container.isEmpty();
	}

	public OOStack push(String string) {
		container.add( string );
		return this;
	}

	public Object pop() {
		assert !this.isEmpty(): stackEmptyErrorDescription;
		return container.remove( container.size() - 1 );
	}

	public Object top() {
		assert !this.isEmpty(): stackEmptyErrorDescription;
		return container.get( container.size() - 1 );
	}

	public int size() {
		return container.size();
	}

}
