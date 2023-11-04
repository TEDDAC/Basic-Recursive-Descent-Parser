package nodes;

import lexing.Token;

public class OperatorNode extends TreeNode{
    private final TreeNode left;

    private final Token token;

    private final TreeNode right;

    public OperatorNode(TreeNode left, Token token, TreeNode right) {
        this.left = left;
        this.token = token;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("(operator ");
        s.append(token.getValue());

        s.append(" ");
        s.append(left.toString());

        s.append(" ");
        s.append(right.toString());

        s.append(")");

        return s.toString();
    }
}
