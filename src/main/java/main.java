import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class main {

    private int[][] board;

    public static void readBoard() {
        try{
            String file = "src/inputTest.txt";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));

            String curLine;
            while ((curLine = bufferedReader.readLine()) != null){
                //process the line as you require
                System.out.println(curLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    }

