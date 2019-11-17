package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Draught extends Piece {

    Draught(Color color) {
        super(color);
    }

    @Override
    Error isCorrect(Coordinate origin, Coordinate target, Board board) {
        if (!origin.isDiagonal(target)) {
			return Error.NOT_DIAGONAL;
		}
		if (!board.isEmpty(target)) {
			return Error.NOT_EMPTY_TARGET;
		}
		return null;
    }

}