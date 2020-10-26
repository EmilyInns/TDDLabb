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
   // public List<List<Character>> board = new ArrayList<List<Character>>();
   public List<List<Piece>> board = new ArrayList<List<Piece>>();


    public void readBoard() {
        try{
            String file = "src/inputTest.txt";
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));

            String curLine;
            while ((curLine = bufferedReader.readLine()) != null){
                numberOfLines++;
                List<Piece> mylist = new ArrayList<>();
                if (numberOfLines>1){
                    for (int i = 0; i < curLine.length(); i++) {
                        mylist.add(new Piece(curLine.charAt(i),numberOfLines-2, i));
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

    public int numberOfLivingNeighbours(Piece piece){
        int numberOfLivingNeighbours = 0;
        int listIndex = piece.getListIndex();
        int subIndex = piece.getSubIndex();
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
        for (List<Piece> list :board
        ) {
            String line = new String();
            for (Piece piece: list
            ) {
                line += piece.getCharacter();
            }
            System.out.println(line);
        }
    }

    public void updateBoard(){
        for (List<Piece> list :board
             ) {
            for (Piece piece: list
                 ) {
                checkIfCellStateNeedsUpdating(piece);
            }
        }
        updateAllCells();
        generation++;
    }

    private void updateAllCells() {
        for (List<Piece> list :board
        ) {
            for (Piece piece: list
            ) {
                if (piece.isPendingChange()){
                    changeCellState(piece);
                }
            }
        }
    }

    public void checkIfCellStateNeedsUpdating(Piece piece){
        boolean isAlive = String.valueOf(piece.getCharacter()).equals("*");
        if (isAlive){
            doesCellDieFromOverOrUnderPop(piece);
        }
        else{
            doesCellRevive(piece);
        }
    }

    private void doesCellRevive(Piece piece) {

        if (numberOfLivingNeighbours(piece)==3){
            markCellAsPendingChange(piece);
        }
    }

    private void doesCellDieFromOverOrUnderPop(Piece piece) {
        if ((numberOfLivingNeighbours(piece)<2)||(numberOfLivingNeighbours(piece)>3)){
            markCellAsPendingChange(piece);
        }
    }

    private void markCellAsPendingChange(Piece piece){
        board.get(piece.getListIndex()).get(piece.subIndex).setPendingChange(true);
    }

    private void changeCellState(Piece piece) {
        if (String.valueOf(piece.getCharacter()).equals("*")){
            piece.setCharacter('.');
        }
        else if (String.valueOf(piece.getCharacter()).equals(".")){
            piece.setCharacter('*');
        }
    }


}

