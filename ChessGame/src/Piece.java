public class Piece extends Game {

    private String colour;
    private Position position;

    public Piece(String colour) {
        this.colour = colour;

    }

    public Piece() {

    }

    // checks if piece is within the board.
    public boolean isValidMove(Position position) {

        if (position.x > 8 || position.x < 0 || position.y > 8 || position.y < 0)
            return false;

        else
            return true;

    }


}
