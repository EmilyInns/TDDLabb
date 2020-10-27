import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class mainTest {

    Main main = new Main();


    @Test
    void DoesBoardPrintCorrectly(){
        main.readBoard();
        main.printBoard();
    }

    @Test
    void DoesBoardReadInCorrectly(){
        main.readBoard();
        assertEquals('*', main.board.get(0).get(2).getCharacter());
        assertEquals('*', main.board.get(1).get(2).getCharacter());
        assertEquals('*', main.board.get(1).get(6).getCharacter());
        assertEquals('*', main.board.get(2).get(3).getCharacter());
        assertEquals('*', main.board.get(3).get(4).getCharacter());

    }

    @Test
    void DoesBoardUpdateCorrectly(){
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
        main.readBoard();
        Cell cell = new Cell(0,2);
        assertEquals(2,main.numberOfLivingNeighbours(cell));
    }

    @Test
    void DoCellsDieOfUnderpop(){
        main.readBoard();
        main.updateBoard();
        main.updateBoard();
        assertTrue(main.isCellAlive(1,6));
        main.updateBoard();
        assertFalse(main.isCellAlive(1,6));

    }

    @Test
    void DoCellsDieOfOvercrowding(){
        main.readBoard();
        assertTrue(main.isCellAlive(2,3));
        main.updateBoard();
        assertFalse(main.isCellAlive(2,3));
    }

    @Test
    void DoCellsStayAliveInGoodConditions(){
        main.readBoard();
        assertTrue(main.isCellAlive(0,3));
        main.updateBoard();
        assertTrue(main.isCellAlive(0,3));
    }

    @Test
    void DoCellsReviveWithThreeLivingNeighbours(){
        main.readBoard();
        assertFalse(main.isCellAlive(2,2));
        main.updateBoard();
        assertTrue(main.isCellAlive(2,2));
    }



}