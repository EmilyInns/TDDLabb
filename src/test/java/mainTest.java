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
        assertEquals('.', main.board.get(1).get(1));

    }

    @Test
    void DoesBoardUpdateCorrectly(){

    }

    @Test
    void DoCellsKnowTheirNeighboursStates(){

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