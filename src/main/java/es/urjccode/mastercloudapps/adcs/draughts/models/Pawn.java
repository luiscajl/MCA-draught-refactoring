package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Pawn extends Piece {

    Color color;

    private static final int MAX_DISTANCE_PAWN = 2;


    public Pawn(Color color) {
        super(color);
    }

    public Color getColor() {
        return this.color;
    }

    Error isCorrect(Coordinate origin, Coordinate target, Board board) {
        if (!origin.isDiagonal(target)) {
            return Error.NOT_DIAGONAL;
        }
        if (!board.isEmpty(target)) {
            return Error.NOT_EMPTY_TARGET;
        }
        if (!this.isAdvanced(origin, target)) {
            return Error.NOT_ADVANCED;
        }
        int distance = origin.diagonalDistance(target);
        if (distance > MAX_DISTANCE_PAWN) {
            return Error.BAD_DISTANCE;
        }
        if (distance == MAX_DISTANCE_PAWN) {
            if (board.getPiece(origin.betweenDiagonal(target)) == null) {
                return Error.EATING_EMPTY;
            }
        }
        return null;
    }


	public boolean isAdvanced(Coordinate origin, Coordinate target) {
		int difference = origin.getRow() - target.getRow();
		if (color == Color.WHITE) {
			return difference > 0;
		}
		return difference < 0;
    }
    
    public Error canMove(Coordinate origin, Coordinate target) {
		if (!origin.isDiagonal(target)) {
			return Error.NOT_DIAGONAL;
		}
		if (origin.diagonalDistance(target) >= 3) {
			return Error.BAD_DISTANCE;
		}
		if (!this.isAdvanced(origin, target)) {
			return Error.NOT_ADVANCED;
		}
		return null;
	}
}