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
    private static final Pattern AND = Pattern.compile("(&&).*?");
    private static final Pattern EQU = Pattern.compile("(==).*?");

    /**
     * Evaluate a boolean expression.
     *
     * @return
     *   true or false
     */
    public static Boolean eval(String expression)
    {
        LinkedStack<Integer> numbers = new LinkedStack<Integer>();
        LinkedStack<Character> operations = new LinkedStack<Character>();

        Scanner input = new Scanner(expression);

        String next;

        while (input.hasNext())
        {
            if (input.hasNext(INT))
            {
                next = input.findInLine(INT);
                System.out.printf("Operand: %s\n", next);
                numbers.push(new Integer(next));
            }
            else if (input.hasNext(AND))
            {
                next = input.findInLine(AND);
                System.out.printf("Operator: %s\n", next);
                operations.push(new Character(next.charAt(0)));
                System.out.printf("Added %c to stack\n", operations.peek());
            }
            else if (input.hasNext(EQU))
            {
                next = input.findInLine(EQU);
                System.out.printf("Operator: %s \n", next);
                operations.push(new Character('='));
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
        if (numbers.size() != 1) {
            System.out.printf("Number stack is too full: %d\n", numbers.size());
            throw new IllegalArgumentException("Illegal expression");
        }
        Boolean result = (numbers.pop() == 1);
        return result;
    }

    private static void evalTop(LinkedStack<Integer> numbers, LinkedStack<Character> operations)
    {
        int lval, rval;

        if ((numbers.size() < 1) || (operations.empty())) {
            System.out.printf("numbers stack size: %d\n", numbers.size());
            System.out.printf("operations.empty(): %b\n", operations.empty());
            throw new IllegalArgumentException("Illegal expression");
        }
        rval = numbers.pop();
        lval = numbers.pop();
        System.out.printf("Top of operation stack: %c\n", operations.peek());
        switch (operations.pop())
        {
            case '&':
                System.out.printf("lval: %d, rval: %d\n", lval, rval);
                numbers.push(lval & rval);
                System.out.printf("operands anded: %b\n", (lval & rval));
                System.out.printf("\tEval: %d & %d = %d\n", lval, rval, ((lval & rval)));
                break;
            case '|':
                numbers.push(lval | rval);
                System.out.printf("\tEval: %d | %d = %d\n", lval, rval, ((lval | rval)));
                break;
            case '!':
                numbers.push(~(lval));
                System.out.printf("\tEval: ! %d = %d\n", lval, (~(lval)));
                break;
            case '=':
                numbers.push((lval == rval)? 1 : 0);
                System.out.printf("\tEval: %b == %b = %b\n", lval, rval, ((lval == rval)));
                break;
            case '<':
                System.out.printf("\tEval: %d < %d = %d\n", lval, rval, ((lval < rval)? 1 : 0));
                numbers.push((lval < rval) ? 1 : 0);
                break;
            case '>':
                System.out.printf("\tEval: %d > %d = %d\n", lval, rval, ((lval > rval)? 1 : 0));
                numbers.push((lval > rval) ? 1 : 0);
                break;
        }
    }

    public static void main(String[] args)
    {
        String FandF = "(4 < 4) && (1 < 1)";
        String TandF = "(4 == 4) && (1 < 1)";
        String TandT = "(4 < 5) && (1 < 2)";
        String FandT = "((5 < 4) && (2 > 1))";

        System.out.printf("Expression: %s, Answer: %b\n", FandF, BoolEval.eval(FandF));
        System.out.printf("Expression: %s, Answer: %b\n", TandF, BoolEval.eval(TandF));
        System.out.printf("Expression: %s, Answer: %b\n", TandT, BoolEval.eval(TandT));
        System.out.printf("Expression: %s, Answer: %b\n", FandT, BoolEval.eval(FandT));
    }
}
