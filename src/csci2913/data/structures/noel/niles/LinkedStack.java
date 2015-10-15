package csci2913.data.structures.noel.niles;


import java.util.EmptyStackException;

/**
 * A stack implementation using a linked list
 *
 */
public class LinkedStack<E>
{
    // Invariant of the LinkedStack class
    //  1. Items are stored in a linked list. The top of the stack is the head.
    //  2. The instance variable top is the head reference.
    private Node<E> top;

    public LinkedStack()
    {
        this.top = null;
    }

    public boolean empty()
    {
        return (top == null);
    }

    public E peek()
    {
        if (empty())
            throw new EmptyStackException();
        return top.getData();
    }

    public E pop()
    {
        E element;

        if (empty())
            throw new EmptyStackException();
        element = top.getData();
        top = top.getLink();
        return element;
    }

    public void push(E item)
    {
        this.top = new Node<E>(item, top);
    }

    public int size() {
        return 0;
    }
}
