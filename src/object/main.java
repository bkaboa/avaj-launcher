package src.object;

import src.object.parser.Parser;

public class main {
    static final Parser parser = Parser.getInstance();

    public static void main(String[] args) {
        System.err.println("args: " + args[0]);
        try {
            parser.parse(args[0]);
        } catch (Exception e) {
            System.out.println("error");
        }
    }
}
