import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class mainTest {

    Main main = new Main();


    @Test
    @Disabled("Not really a real test.. print method only exists for me to visually double-check results")
    void DoesBoardPrintCorrectly(){
        main.readBoard();
        main.printBoard();
    }


    @BeforeEach
    void ReadBoard(){
        main.readBoard();
    }

    @Test
    void DoesBoardReadInCorrectly(){
        assertEquals('*', main.board.get(0).get(2).character());
        assertEquals('*', main.board.get(1).get(2).character());
        assertEquals('*', main.board.get(1).get(6).character());
        assertEquals('*', main.board.get(2).get(3).character());
        assertEquals('*', main.board.get(3).get(4).character());

    }

    @Test
    void DoesBoardUpdateCorrectly(){
        assertTrue(main.isCellAlive(0,2));
        assertTrue(main.isCellAlive(2,3));
        assertFalse(main.isCellAlive(1,4));
        main.updateBoard();
        assertTrue(main.isCellAlive(0,2));
        assertFalse(main.isCellAlive(2,3));
        assertTrue(main.isCellAlive(1,4));


    }

    @Test
    void DoCellsKnowTheirNeighboursStates(){
        Cell cell = new Cell(0,2);
        assertEquals(2,main.numberOfLivingNeighbours(cell));
    }

    @Test
    void DoCellsDieOfUnderpop(){
        main.updateBoard();
        main.updateBoard();
        assertTrue(main.isCellAlive(1,6));
        main.updateBoard();
        assertFalse(main.isCellAlive(1,6));

    }

    @Test
    void DoCellsDieOfOvercrowding(){
        assertTrue(main.isCellAlive(2,3));
        main.updateBoard();
        assertFalse(main.isCellAlive(2,3));
    }

    @Test
    void DoCellsStayAliveInGoodConditions(){
        assertTrue(main.isCellAlive(0,3));
        main.updateBoard();
        assertTrue(main.isCellAlive(0,3));
    }

    @Test
    void DoCellsReviveWithThreeLivingNeighbours(){
        assertFalse(main.isCellAlive(2,2));
        main.updateBoard();
        assertTrue(main.isCellAlive(2,2));
    }



}