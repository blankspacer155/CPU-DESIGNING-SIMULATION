package Parser;

public interface Token {
    /**
     *  Return true if the tokenizer have a next token
     *
     * @return Return true if the tokenizer have a next token
     *
     * */

    boolean hasNext();
    /**
     *  Return the next token in input stream.
     *
     * @return the next token
     *
     * */

    String peek();

    /**
     *
     * return true if the next token is equals to specified token
     *
     * @param input the specified token
     *
     * @return true if next token is equals to specified token
     *         false if next token is not equals to specified token
     * */

    boolean peek(String input);

    /**
     *
     * Consume one token and using to return.
     *
     * @return consume token
     * @throws SyntaxError if the token is not identified
     *
     * */

    String consume();

    /**
     *
     * Consume the specified token.
     *
     * @param input the specified token
     * @throws SyntaxError if the token is not identified
     * */
    void consume(String input);

}
