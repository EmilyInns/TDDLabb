public class Piece {

    char character;
    boolean isPendingChange;
    int listIndex;
    int subIndex;

    public Piece(char charAt) {
        character = charAt;
        isPendingChange = false;

    }

    public Piece(char charAt, int list, int sub) {
        character = charAt;
        isPendingChange = false;
        int listIndex = list;
        int subIndex = sub;
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
}
