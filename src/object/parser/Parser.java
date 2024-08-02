package src.object.parser;

import java.io.File;
import java.util.Scanner;

public class Parser {
    private Parser() {}

    private static class SingletonHolder {
        private static final Parser INSTANCE = new Parser();
    }

    public static Parser getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void parse(String filePath)  throws Exception {
        Scanner scanner = new Scanner(new File(filePath));
        String line = scanner.nextLine();
        System.out.println(line);
        scanner.close();
    }
    
}
