package src.object.logger;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    File file = null;
    FileWriter writer = null;
    private Logger() {}

    private static class SingletonHolder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void setFilePath() throws IOException {
        int i = 0;
        File f = new File("simmulation/");
        if  (!f.exists() || !f.isDirectory()) {
            f.mkdir();
        }
        else {
            String listFiles[] = f.list();
            for (i = 0; i < listFiles.length; i++) {
                if (listFiles[i].equals("log" + i + ".txt"));
                else {
                    break;
                }
            }
        }
        File f1 = new File("simmulation/log" + i + ".txt");
        f1.createNewFile();
        file = f1;
        writer = new FileWriter(file.getPath());
    }

    public void log(String message) throws IOException {
        writer.write(message + "\n");
        writer.close();
        System.out.println(message + "\n");
    }
}
