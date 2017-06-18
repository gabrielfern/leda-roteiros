package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (!this.isFull()) {
			this.top.insert(element);
		}
		else {
			throw new StackOverflowException();
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (!this.top.isEmpty()) {
			T result = this.top();
			this.top.removeLast();
			return result;
		}
		else {
			throw new StackUnderflowException();
		}
	}

	@Override
	public T top() {
		return (((DoubleLinkedListImpl<T>) this.top).getLast())
		.getData();
	}

	@Override
	public boolean isEmpty() {
		return this.top.isEmpty();
	}

	@Override
	public boolean isFull() {
		boolean result = false;
		if (this.top.size() >= this.size) {
			return true;
		}
		return result;
	}
}