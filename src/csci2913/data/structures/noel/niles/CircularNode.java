package csci2913.data.structures.noel.niles;

/**
 * A CircularNode provides a node for a circular linked list.
 *
 * @author Noel Niles
 *   <a href="mailto:noelniles@gmail.com">noelniles@gmail.com</a>
 */
public class CircularNode<E> {

    private Object data;
    private CircularNode link;


    public CircularNode(Object data, CircularNode link)
    {
        this.data = data;
        this.link = link;
    }

}
