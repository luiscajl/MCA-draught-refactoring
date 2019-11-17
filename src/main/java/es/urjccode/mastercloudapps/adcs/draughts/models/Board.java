package es.urjccode.mastercloudapps.adcs.draughts.models;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private static final int DIMENSION = 8;

    private Square[][] squares;

    public Board() {
        this.squares = new Square[this.getDimension()][this.getDimension()];
        for (int i = 0; i < this.getDimension(); i++) {
            for (int j = 0; j < this.getDimension(); j++) {
                this.squares[i][j] = new Square();
            }
        }
    }

    public void put(Coordinate coordinate, Piece piece) {
        assert piece != null;
        this.squares[coordinate.getRow()][coordinate.getColumn()].put(piece);
    }

    public Piece remove(Coordinate coordinate) {
        assert this.getPiece(coordinate) != null;
        return this.getSquare(coordinate).remove();
    }

    public void move(Coordinate origin, Coordinate target) {
        this.put(target, this.remove(origin));
    }

    public Piece getPiece(Coordinate coordinate) {
        return this.getSquare(coordinate).getPiece();
    }

    public boolean isEmpty(Coordinate coordinate) {
        return this.getSquare(coordinate).isEmpty();
    }

    public Color getColor(Coordinate coordinate) {
        return this.getSquare(coordinate).getColor();
    }

    public List<Piece> getPieces(Color color) {
        List<Piece> pieces = new ArrayList<Piece>();
        for (Square x[] : squares) {
            for (Square y : x) {
                pieces.add(y.getPiece());
            }
        }
        return pieces;
    }

    public int getDimension() {
        return Board.DIMENSION;
    }

    public Error isValidMovement(Coordinate origin, Coordinate target, Color color) {
        assert origin != null && target != null && color != null;
        if (!origin.isValid() || !target.isValid()) {
            return Error.OUT_COORDINATE;
        }
        if (this.isEmpty(origin)) {
            return Error.EMPTY_ORIGIN;
        }
        if (this.getColor(origin) != color) {
            return Error.OPPOSITE_PIECE;
        }
        Error errorPiece = this.getPiece(origin).isCorrect(origin, target,null);
        if (errorPiece != null) {
            return errorPiece;
        }
        if (!this.isEmpty(target)) {
            return Error.NOT_EMPTY_TARGET;
        }
        if (origin.diagonalDistance(target) == 2) {
            Coordinate between = origin.betweenDiagonal(target);
            if (this.getPiece(between) == null) {
                return Error.EATING_EMPTY;
            }
            this.remove(between);
        }
        return null;
    }

    private String toStringHorizontalNumbers() {
        String string = " ";
        for (int j = 0; j < getDimension(); j++) {
            string += j;
        }
        return string + "\n";
    }

    private String toStringHorizontalPiecesWithNumbers(int row) {
        String string = "" + row;
        for (int j = 0; j < getDimension(); j++) {
            Piece piece = this.getPiece(new Coordinate(row, j));
            if (piece == null) {
                string += " ";
            } else {
                string += piece.getColor().getColorInitial();
            }
        }
        return string + row + "\n";
    }

    private Square getSquare(Coordinate coordinate) {
        assert coordinate != null && coordinate.isValid();
        return this.squares[coordinate.getRow()][coordinate.getColumn()];
    }

    @Override
    public String toString() {
        String string = "";
        string += this.toStringHorizontalNumbers();
        for (int i = 0; i < this.getDimension(); i++) {
            string += this.toStringHorizontalPiecesWithNumbers(i);
        }
        string += this.toStringHorizontalNumbers();
        return string;
    }

}