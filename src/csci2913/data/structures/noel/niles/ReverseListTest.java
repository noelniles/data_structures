package csci2913.data.structures.noel.niles;

/**
 * @author Noel Niles
 *   CSCI 2913 - Data Structures
 */
public class ReverseListTest {

    public static void main(String[] args) {
        IntNode n = new IntNode(1, null);
        n.addNodeAfter(2);
        n.addNodeAfter(3);
        n.addNodeAfter(4);
        n.addNodeAfter(5);

        System.out.println("Original list:");
        IntNode.print(n);

        System.out.println("Reversed list:");
        IntNode reversed = IntNode.reverseList(n);
        IntNode.print(reversed);
    }
}
