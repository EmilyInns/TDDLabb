import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class mainTest {

    @Test
    void DoesBoardSetUpCorrectly(){

    }

    @Test
    void DoesBoardReadInCorrectly(){
        Main main = new Main();
        main.readBoard();
        assertEquals('*', main.board.get(0).get(2));
        assertEquals('.', main.board.get(1).get(2));
        assertEquals('*', main.board.get(1).get(6));
        assertEquals('*', main.board.get(2).get(3));
        assertEquals('*', main.board.get(3).get(3));

    }

    @Test
    void DoesBoardUpdateCorrectly(){

    }

    @Test
    void DoCellsKnowTheirNeighboursStates(){
        Main main = new Main();
        main.readBoard();
        assertEquals(2,main.numberOfLivingNeighbours(2,2));
    }

    @Test
    void DoCellsDieOfUnderpop(){

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