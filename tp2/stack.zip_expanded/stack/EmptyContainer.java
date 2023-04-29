package stack;

public class EmptyContainer extends SuperContainer {

	public boolean isEmpty() {
		return true;
	}

	public SuperContainer push(Object object) {
		return new ContainerWithItem( this, object );
	}

	public SuperContainer pop() {
		throw new Error( OOStack.stackEmptyErrorDescription );
	}

	public Object top() {
		throw new Error( OOStack.stackEmptyErrorDescription );
	}

	public int size() {
		return 0;
	}

}
