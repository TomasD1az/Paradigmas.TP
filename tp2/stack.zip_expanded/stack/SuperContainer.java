package stack;

public abstract class SuperContainer {

	public abstract boolean isEmpty();

	public abstract SuperContainer push(Object object);

	public abstract SuperContainer pop();

	public abstract Object top();

	public abstract int size();

}
