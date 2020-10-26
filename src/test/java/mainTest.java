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
        assertEquals('*', main.board.get(0).get(2));
        assertEquals('*', main.board.get(1).get(2));
        assertEquals('*', main.board.get(1).get(6));
        assertEquals('*', main.board.get(2).get(3));
        assertEquals('*', main.board.get(3).get(4));

    }

    @Test
    void DoesBoardUpdateCorrectly(){
        Main main = new Main();
        main.readBoard();
        main.printBoard();
        main.updateBoard();
        main.printBoard();
    }

    @Test
    void DoCellsKnowTheirNeighboursStates(){
        Main main = new Main();
        main.readBoard();
        Piece piece = new Piece(0,2);
        assertEquals(2,main.numberOfLivingNeighbours(piece));
    }

    @Test
    void DoCellsDieOfUnderpop(){
//1,7
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