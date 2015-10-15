package csci2913.data.structures.noel.niles;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Evaluate boolean expression using a stack.
 */
public class BoolEval {

    private LinkedStack<Integer> numbers;
    private LinkedStack<Character> operations;

    private static final Pattern INT = Pattern.compile("[+-]?\\d+.*?");
    private static final Pattern CHAR = Pattern.compile("\\S.*?");

    /**
     * Evaluate a boolean expression.
     *
     * @return
     *   true or false
     */
    public Integer eval()
    {
        this.numbers = new LinkedStack<Integer>();
        this.operations = new LinkedStack<Character>();

        Scanner input = new Scanner(System.in);

        boolean has = input.hasNext();

        String next;

        while (has)
        {
            if (input.hasNext(INT))
            {
                next = input.findInLine(INT);
                this.numbers.push(new Integer(next));
            }
            else
            {
                next = input.findInLine(CHAR);

                switch (next.charAt(0))
                {
                    case '<': // less than, or less than or equal to
                    case '>': // greater than, or greater than or equal to
                    case '=': // equal to
                    case '!': // not, or not equal to
                        operations.push(next.charAt(0));
                        break;
                    case ')':
                        evalTop(numbers, operations);
                        break;
                    case '(':
                        break;
                    default:
                        throw new IllegalArgumentException("Illegal character");
                }
            }
        }
        if (numbers.size() != 1)
            throw new IllegalArgumentException("Illegal input expression");
        return numbers.pop();
    }

    private void evalTop(LinkedStack<Integer> numbers, LinkedStack<Character> operation) {
    }


    public static void main(String[] args)
    {
    }
}
