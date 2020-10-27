import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//TODO: Refactor code with object to remove constant listIndex and subIndex usage
//TODO: Refactor code so board is List of Pieces


public class Main {

    private int numberOfLines = 0;
    private int numberOfArrays = 0;
    private int lineLength = 0;
    private int generation = 0;
   public List<List<Cell>> board = new ArrayList<List<Cell>>();


    public void readBoard() {
        try{
            String file = "src/inputTest.txt";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String curLine;
            while ((curLine = bufferedReader.readLine()) != null){
                numberOfLines++;
                List<Cell> mylist = new ArrayList<>();
                if (numberOfLines>1){
                    for (int i = 0; i < curLine.length(); i++) {
                        mylist.add(new Cell(curLine.charAt(i),numberOfLines-2, i));
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

    public int numberOfLivingNeighbours(Cell cell){
        int numberOfLivingNeighbours = 0;
        int listIndex = cell.getListIndex();
        int subIndex = cell.getSubIndex();
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
        else return String.valueOf(board.get(listIndex).get(subIndex).getCharacter()).equals("*");

    }


    public void printBoard(){
        System.out.println("Generation " + generation + ":");
        for (List<Cell> list :board
        ) {
            String line = new String();
            for (Cell cell : list
            ) {
                line += cell.getCharacter();
            }
            System.out.println(line);
        }
    }

    public void updateBoard(){
        for (List<Cell> list :board
             ) {
            for (Cell cell : list
                 ) {
                checkIfCellStateNeedsUpdating(cell);
            }
        }
        updateAllCells();
        generation++;
    }

    private void updateAllCells() {
        for (List<Cell> list :board
        ) {
            for (Cell cell : list
            ) {
                if (cell.isPendingChange()){
                    changeCellState(cell);
                }
            }
        }
    }

    public void checkIfCellStateNeedsUpdating(Cell cell){
        boolean isAlive = String.valueOf(cell.getCharacter()).equals("*");
        if (isAlive){
            doesCellDieFromOverOrUnderPop(cell);
        }
        else{
            doesCellRevive(cell);
        }
    }

    private void doesCellRevive(Cell cell) {

        if (numberOfLivingNeighbours(cell)==3){
            markCellAsPendingChange(cell);
        }
    }

    private void doesCellDieFromOverOrUnderPop(Cell cell) {
        if ((numberOfLivingNeighbours(cell)<2)||(numberOfLivingNeighbours(cell)>3)){
            markCellAsPendingChange(cell);
        }
    }

    private void markCellAsPendingChange(Cell cell){
        board.get(cell.getListIndex()).get(cell.subIndex).setPendingChange(true);
    }

    private void changeCellState(Cell cell) {
        if (String.valueOf(cell.getCharacter()).equals("*")){
            cell.setCharacter('.');
        }
        else if (String.valueOf(cell.getCharacter()).equals(".")){
            cell.setCharacter('*');
        }
    }


}

