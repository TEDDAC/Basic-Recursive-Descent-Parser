import exceptions.UnexpectedTokenException;
import lexing.Token;
import lexing.Tokenizer;
import nodes.TreeNode;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println(parse("2 + 3").toString());
            System.out.println(parse("2 / 3 + 4").toString());
            System.out.println(parse("2 - 3 * 4").toString());
        } catch (UnexpectedTokenException e) {
            System.err.println(e.getMessage());
        }

    }

    public static TreeNode parse(String input) throws UnexpectedTokenException {
        Tokenizer tokenizer = new Tokenizer();
        List<Token> tokens = tokenizer.tokenize(input);

        Parser parser = new Parser(tokens);

        return parser.parseE();
    }
}