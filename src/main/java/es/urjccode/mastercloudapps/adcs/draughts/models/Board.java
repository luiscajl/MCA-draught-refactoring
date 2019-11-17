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

    void remove(List<Coordinate> coordinates) {
        assert coordinates.size() > 0;
        for (Coordinate coordinate: coordinates) {
            assert this.getPiece(coordinate) != null;
            this.getSquare(coordinate).remove();
        } 
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
                string += piece.getColor().getColorInitial(piece instanceof Draught);
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