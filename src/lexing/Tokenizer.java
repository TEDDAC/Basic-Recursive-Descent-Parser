package lexing;

import utils.CharArrayIterator;

import java.util.LinkedList;
import java.util.List;

public class Tokenizer {
    public List<Token> tokenize(String input){
        List<Token> tokens = new LinkedList<>();
        char[] splittedInput = input.toCharArray();
        CharArrayIterator it = new CharArrayIterator(splittedInput);

        char c = it.next();

        while (it.hasNext()){
            if(isOperator(c)){
                tokens.add(new Token(TokenType.Operator, String.valueOf(c)));
                c = it.next();
            } else if (Character.isDigit(c)){
                StringBuilder value = new StringBuilder();
                while(Character.isDigit(c)){
                    value.append(c);
                    if(it.hasNext()){
                        c = it.next();
                    }
                }
                tokens.add(new Token(TokenType.Integer, value.toString()));
            } else if(it.hasNext()){
                c = it.next();
            }
        }

        tokens.add(new Token(TokenType.End, "$"));
        return tokens;
    }

    private boolean isOperator(char c){
        return switch (c) {
            case '+', '-', '*', '/' -> true;
            default -> false;
        };
    }
}
