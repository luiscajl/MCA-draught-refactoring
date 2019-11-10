package es.urjccode.mastercloudapps.adcs.draughts.models;

public class Square {

    private Piece piece;

    public Square() {
    }

    public  void put(Piece piece) {
        this.piece = piece;
    }

    public Piece remove() {
        Piece piece = this.piece;
        this.piece = null;
        return piece;
    }

    public  Piece getPiece() {
        return this.piece;
    }

	public boolean isEmpty() {
		return this.piece == null;
	}

	public Color getColor() {
        if (piece == null){
            return Color.NONE;
        }
		return this.piece.getColor();
	}

}