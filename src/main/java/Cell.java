public class Cell {

    char character;
    boolean isPendingChange;
    int listIndex;
    int subIndex;

    //TODO: Refactor getters and setters with different names

    public Cell(char charAt) {
        character = charAt;
        isPendingChange = false;

    }

    public Cell(char charAt, int list, int sub) {
        character = charAt;
        isPendingChange = false;
        listIndex = list;
        subIndex = sub;
    }

    public Cell(int list, int sub) {

        listIndex = list;
        subIndex = sub;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public boolean isPendingChange() {
        return isPendingChange;
    }

    public void setPendingChange(boolean pendingChange) {
        isPendingChange = pendingChange;
    }

    public int getListIndex() {
        return listIndex;
    }

    public int getSubIndex() {
        return subIndex;
    }
}
