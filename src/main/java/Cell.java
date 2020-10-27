public class Cell {

    private char character;
    private boolean isPendingChange;
    private int listIndex;
    private int subIndex;


    public Cell(char charAt, int list, int sub) {
        character = charAt;
        isPendingChange = false;
        listIndex = list;
        subIndex = sub;
    }

    //This constructor is only to be used in tests
    public Cell(int list, int sub) {
        listIndex = list;
        subIndex = sub;
        isPendingChange = false;
    }

    public char character() {
        return character;
    }

    public void changeCharacter(char character) {
        this.character = character;
    }

    public boolean isPendingChange() {
        return isPendingChange;
    }

    public void setPendingChange(boolean pendingChange) {
        isPendingChange = pendingChange;
    }

    public int listIndex() {
        return listIndex;
    }

    public int subIndex() {
        return subIndex;
    }
}
