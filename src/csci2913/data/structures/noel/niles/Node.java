package csci2913.data.structures.noel.niles;
/**
 * A generic node for use with a very simple linked list
 *
 * -Note- This class is missing a lot of useful methods, but has been
 *        abbreviated for use with a stack.
 */
public class Node<E>
{
    // Invariant of the Node class.
    //   1. Each Node stores a reference to an Object E in the instance variable
    //      data.
    //   2. The last link is null. Every other link is a reference to the next
    //      node in the list.
    private E data;
    private Node<E> link;

    /**
     * Initialize a node with some data and a link which might be null.
     *
     * @param data
     *   the data for the new node
     * @param link
     *   a reference to the next node -- may be null.
     * @postcondition
     *   This link has some data and a link to the next node.
     */
    public Node(E data, Node link) {
        this.data = data;
        this.link = link;
    }

    /**
     * Add a node after this node.
     */
    public void addAfter(E item)
    {
        this.link = new Node<E>(item, link);
    }

    public E getData()
    {
        return data;
    }

    public Node<E> getLink()
    {
        return this.link;
    }

    public String toString()
    {
        String repr = (String) this.data + "->";
        return repr;
    }


}
