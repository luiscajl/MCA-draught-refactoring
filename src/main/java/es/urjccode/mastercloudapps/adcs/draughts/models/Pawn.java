package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Pawn extends Piece {

    private static final int MAX_DISTANCE_PAWN = 2;

    Pawn(Color color) {
        super(color);
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
			if (board.getPiece(origin.betweenDiagonalPawn(target)) == null) {
				return Error.EATING_EMPTY;
			}
		}
		return null;
    }
    
    boolean isAdvanced(Coordinate origin, Coordinate target) {
		assert origin != null;
		assert target != null;
		int difference = origin.getRow() - target.getRow();
		if (this.color == Color.WHITE) {
			return difference > 0;
		}
		return difference < 0;
	}
}