import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    void constructorTest(){
        Cell cell = new Cell(0,2);
        assertEquals(0, cell.listIndex());
        assertEquals(2, cell.subIndex());
    }

    @Test
    void getCharacter() {
    }

    @Test
    void setCharacter() {
    }

    @Test
    void isPendingChange() {
    }

    @Test
    void setPendingChange() {
    }

    @Test
    void getListIndex() {
    }

    @Test
    void getSubIndex() {
    }
}