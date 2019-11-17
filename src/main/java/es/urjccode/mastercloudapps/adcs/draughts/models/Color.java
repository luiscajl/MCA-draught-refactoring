package es.urjccode.mastercloudapps.adcs.draughts.models;

public enum Color {
    WHITE("blancas"), WHITE_INITIAL("b"), BLACK("negras"), BLACK_INITAL("n"), WHITE_DRAUGHT_INITAL("B"),
    BLACK_DRAUGHT_INITIAL("N"), NONE(" ");

    private String color;

    private Color(String color) {
        this.color = color;

    }

    public String getName() {
        return this.color;
    }

    public String getColorInitial(boolean isDraught) {
        if (color.equals(WHITE.getName())) {
            return isDraught ? Color.WHITE_DRAUGHT_INITAL.getName() : Color.WHITE_INITIAL.getName();
        }
        if (color.equals(BLACK.getName())) {
            return isDraught ? Color.BLACK_DRAUGHT_INITIAL.getName() : Color.BLACK_INITAL.getName();
        }
        return Color.NONE.getName();

    }

    public Color changeColor() {
        if (color.equals(WHITE.getName())) {
            return Color.BLACK;
        } else
            return Color.WHITE;
    }
}