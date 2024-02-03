import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShuntingYardTest {
    @Test
    public void testBasicExpression() throws Exception{
        ShuntingYard evaluator = new ShuntingYard();

        TreeNode<Token> root = evaluator.getExpressionTreeFromString("32 + 4");

        assertEquals("+", root.getValue().getValue());
        assertEquals("32", root.getLeftChild().getValue().getValue());
        assertEquals("4", root.getRightChild().getValue().getValue());
    }

    @Test
    public void testPrecedence() throws Exception{
        ShuntingYard evaluator = new ShuntingYard();

        TreeNode<Token> root = evaluator.getExpressionTreeFromString("32 + 4 * 5");

        assertEquals("+", root.getValue().getValue());
        assertEquals("32", root.getLeftChild().getValue().getValue());
        assertEquals("*", root.getRightChild().getValue().getValue());
        assertEquals("5", root.getRightChild().getRightChild().getValue().getValue());
        assertEquals("4", root.getRightChild().getLeftChild().getValue().getValue());
    }

    @Test
    public void testParenthesisPrecedence() throws Exception{
        ShuntingYard evaluator = new ShuntingYard();

        TreeNode<Token> root = evaluator.getExpressionTreeFromString("(32 + 4) * 5");

        assertEquals("*", root.getValue().getValue());
        assertEquals("+", root.getLeftChild().getValue().getValue());
        assertEquals("5", root.getRightChild().getValue().getValue());
        assertEquals("4", root.getLeftChild().getRightChild().getValue().getValue());
        assertEquals("32", root.getLeftChild().getLeftChild().getValue().getValue());
    }

    @Test
    public void testComplexExpression() throws Exception{
        ShuntingYard evaluator = new ShuntingYard();

        TreeNode<Token> root = evaluator.getExpressionTreeFromString("3 + 56 * ( 22 - 8 ) / 41");

        assertEquals("+", root.getValue().getValue());
        assertEquals("3", root.getLeftChild().getValue().getValue());
        assertEquals("/", root.getRightChild().getValue().getValue());
        assertEquals("41", root.getRightChild().getRightChild().getValue().getValue());
        assertEquals("*", root.getRightChild().getLeftChild().getValue().getValue());
        assertEquals("56", root.getRightChild().getLeftChild().getLeftChild().getValue().getValue());
        assertEquals("-", root.getRightChild().getLeftChild().getRightChild().getValue().getValue());
        assertEquals("22", root.getRightChild().getLeftChild().getRightChild().getLeftChild().getValue().getValue());
        assertEquals("8", root.getRightChild().getLeftChild().getRightChild().getRightChild().getValue().getValue());
    }
}
