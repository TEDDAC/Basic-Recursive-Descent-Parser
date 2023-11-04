package nodes;

import lexing.Token;

public class IntegerNode extends TreeNode{
    private final Token token;

    public IntegerNode(Token token) {
        this.token = token;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("(");
        s.append(token.getValue());
        s.append(")");

        return s.toString();
    }
}
