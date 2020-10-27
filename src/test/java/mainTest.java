import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class mainTest {

    @Test
    void DoesBoardPrintCorrectly(){
        Main main = new Main();
        main.readBoard();
        main.printBoard();
    }

    @Test
    void DoesBoardReadInCorrectly(){
        Main main = new Main();
        main.readBoard();
        assertEquals('*', main.board.get(0).get(2).getCharacter());
        assertEquals('*', main.board.get(1).get(2).getCharacter());
        assertEquals('*', main.board.get(1).get(6).getCharacter());
        assertEquals('*', main.board.get(2).get(3).getCharacter());
        assertEquals('*', main.board.get(3).get(4).getCharacter());

    }

    @Test
    void DoesBoardUpdateCorrectly(){
        Main main = new Main();
        main.readBoard();
        main.printBoard();
        main.updateBoard();
        main.printBoard();
        main.updateBoard();
        main.printBoard();
        main.updateBoard();
        main.printBoard();
    }

    @Test
    void DoCellsKnowTheirNeighboursStates(){
        Main main = new Main();
        main.readBoard();
        Cell cell = new Cell(0,2);
        assertEquals(2,main.numberOfLivingNeighbours(cell));
    }

    @Test
    void DoCellsDieOfUnderpop(){
        Main main = new Main();
        main.readBoard();
        main.updateBoard();
    }

    @Test
    void DoCellsDieOfOvercrowding(){

    }

    @Test
    void DoCellsStayAliveInGoodConditions(){

    }

    @Test
    void DoCellsReviveWithThreeLivingNeighbours(){

    }



}