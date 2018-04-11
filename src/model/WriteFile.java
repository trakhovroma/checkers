package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public WriteFile(String YourName, String OppName, Boolean result) {

        File dir = new File(System.getProperty("user.dir"));
        File file = new File(dir, "scores.txt");
        try {
            FileWriter writer = new FileWriter(file, true);
            String gameRes;

            if (result == true) {
                gameRes = "Win";
            } else
                gameRes = "Lose";

            writer.write(String.format("%20s %20s %20s \r\n", YourName, OppName, gameRes));
            writer.flush();
            writer.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
