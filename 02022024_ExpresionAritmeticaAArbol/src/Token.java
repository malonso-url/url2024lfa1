/**
 * @author Moises Alonso
 */
public class Token {
    private boolean isOperator;
    private byte precedence;
    private String value;

    public boolean isOperator() {
        return isOperator;
    }
    public void setOperator(boolean isOperator) {
        this.isOperator = isOperator;
    }
    public byte getPrecedence() {
        return precedence;
    }
    public void setPrecedence(byte precedence) {
        this.precedence = precedence;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

}
