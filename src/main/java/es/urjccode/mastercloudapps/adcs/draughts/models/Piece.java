package es.urjccode.mastercloudapps.adcs.draughts.models;

public abstract class Piece {

	
	protected Color color;

	public Piece(Color color) {
		assert color != null;
		this.color = color;
	}

	public boolean isLimit(Coordinate coordinate){
		return coordinate.getRow()== 0 && this.getColor() == Color.WHITE ||
		coordinate.getRow()== 7 && this.getColor() == Color.BLACK;
	}

	public Color getColor() {
		return this.color;
	}

	abstract Error isCorrect(Coordinate origin, Coordinate target, Board board);


}