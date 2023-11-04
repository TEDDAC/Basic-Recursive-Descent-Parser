import exceptions.UnexpectedTokenException;
import lexing.Token;
import lexing.TokenType;
import nodes.IntegerNode;
import nodes.OperatorNode;
import nodes.TreeNode;

import java.util.Iterator;
import java.util.List;

public class Parser {
    Iterator<Token> it;

    Token nextToken;
    public Parser(List<Token> tokens){
        it = tokens.iterator();
        scanToken();
    }

    private void scanToken(){
        if(it.hasNext()){
            nextToken = it.next();
        } else {
            nextToken = null;
        }
    }

    public TreeNode parseE() throws UnexpectedTokenException {

        TreeNode left = parseT();

        if(TokenType.Operator.equals(nextToken.getTokenType())){
            if(nextToken.getValue().equals("+") || nextToken.getValue().equals("-")){
                Token operatorToken = nextToken;
                scanToken();
                return new OperatorNode(left, operatorToken, parseE());
            }
        } else if(!TokenType.End.equals(nextToken.getTokenType())){
            throw new UnexpectedTokenException("Unexpected token " + nextToken.getValue());
        }

        return left;
    }

    public TreeNode parseT() throws UnexpectedTokenException {
        TreeNode left = parseF();

        scanToken();
        if(TokenType.Operator.equals(nextToken.getTokenType())){
            if(nextToken.getValue().equals("*") || nextToken.getValue().equals("/")){
                Token operatorToken = nextToken;
                scanToken();
                return new OperatorNode(left, operatorToken, parseT());
            }
        } else if(!TokenType.End.equals(nextToken.getTokenType())){
            throw new UnexpectedTokenException("Unexpected token " + nextToken.getValue());
        }

        return left;
    }

    public TreeNode parseF() throws UnexpectedTokenException {
        if(!TokenType.Integer.equals(nextToken.getTokenType())){
            throw new UnexpectedTokenException("Unexpected token " + nextToken.getValue() + ". Expected integer.");
        }

        return new IntegerNode(nextToken);
    }
}
