import javafx.geometry.Pos;

public class Queen extends Piece {


    boolean isAlive;

    public Queen() {
        isAlive = true;

    }

    @Override
    public boolean isValidMove(Position position) {

        // first checks if the move is wihtin the board
        if (!super.isValidMove(position))
            return false;

        // now, we gotta check if Queen can move to that place.
        // Queen can move to any place unless there's already a piece on that place
        else{






        }

    }


}
