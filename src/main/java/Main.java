import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Main {

    private int numberOfLines = 0;
    public List<List<Character>> board = new ArrayList<List<Character>>();

    public void readBoard() {
        try{
            String file = "src/inputTest.txt";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String curLine;
            while ((curLine = bufferedReader.readLine()) != null){
                numberOfLines++;
                List<Character> mylist = new ArrayList<>();
                if (numberOfLines>1){
                    for (int i = 0; i < curLine.length(); i++) {
                        mylist.add(curLine.charAt(i));
                    }
                    board.add(mylist);
                }
                System.out.println(curLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

