import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//TODO: Refactor code with object to remove constant listIndex and subIndex usage


public class Main {

    private int numberOfLines = 0;
    private int numberOfArrays = 0;
    private int lineLength = 0;
    private int generation = 0;
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
                    lineLength = curLine.length();
                }
            }
            numberOfArrays = numberOfLines-1;
            generation = 1;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int numberOfLivingNeighbours(int listIndex, int subIndex){
        int numberOfLivingNeighbours = 0;
        if (isCellAlive(listIndex-1, subIndex-1)) numberOfLivingNeighbours++;
        if (isCellAlive(listIndex-1, subIndex)) numberOfLivingNeighbours++;
        if (isCellAlive(listIndex-1, subIndex+1)) numberOfLivingNeighbours++;
        if (isCellAlive(listIndex, subIndex-1)) numberOfLivingNeighbours++;
        if (isCellAlive(listIndex, subIndex+1)) numberOfLivingNeighbours++;
        if (isCellAlive(listIndex+1, subIndex-1)) numberOfLivingNeighbours++;
        if (isCellAlive(listIndex+1, subIndex)) numberOfLivingNeighbours++;
        if (isCellAlive(listIndex+1, subIndex+1)) numberOfLivingNeighbours++;

        return numberOfLivingNeighbours;
    }

    public boolean isCellAlive(int listIndex, int subIndex){
        if (listIndex<0||subIndex<0||listIndex>=numberOfArrays||subIndex>=lineLength){
            return false;
        }
        else return board.get(listIndex).get(subIndex).equals('*');

    }

    public void printBoard(){
        System.out.println("Generation " + generation + ":");
        for (List<Character> list :board
        ) {
            String line = new String();
            for (Character cha: list
            ) {
                line += cha;
            }
            System.out.println(line);
        }
    }

    public void updateBoard(){
        for (List<Character> list :board
             ) {
            for (Character cha: list
                 ) {
                checkIfCellStateNeedsUpdating(board.indexOf(list),list.indexOf(cha));
            }
        }
        generation++;
    }

    public void checkIfCellStateNeedsUpdating(int listIndex, int subIndex){
        boolean isAlive = board.get(listIndex).get(subIndex).equals('*');
        if (isAlive){
            doesCellDieFromOverOrUnderPop(listIndex, subIndex);
        }
        else{
            doesCellRevive(listIndex,subIndex);
        }
    }

    private void doesCellRevive(int listIndex, int subIndex) {
        if (numberOfLivingNeighbours(listIndex,subIndex)==3){
            changeCellState(listIndex, subIndex);
        }
    }

    private void doesCellDieFromOverOrUnderPop(int listIndex, int subIndex) {
        if ((numberOfLivingNeighbours(listIndex,subIndex)<2)||(numberOfLivingNeighbours(listIndex,subIndex)>3)){
            changeCellState(listIndex,subIndex);
        }
    }

    private void changeCellState(int listIndex, int subIndex) {
        if (board.get(listIndex).get(subIndex).equals('*')){
            board.get(listIndex).set(subIndex,'.');
        }
        else if (board.get(listIndex).get(subIndex).equals('.')){
            board.get(listIndex).set(subIndex,'*');
        }
    }


}

