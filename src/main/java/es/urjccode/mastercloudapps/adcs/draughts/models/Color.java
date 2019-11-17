package es.urjccode.mastercloudapps.adcs.draughts.models;

public enum Color {
    WHITE("blancas"), WHITE_INITIAL("b"), BLACK("negras"), BLACK_INITAL("n"), NONE(" ");

    private String color;

    private Color(String color) {
        this.color = color;

    }

    public String getName() {
        return this.color;
    }

    public String getColorInitial() {
        if (color.equals(WHITE.getName())) {
            return Color.WHITE_INITIAL.getName();
        }
        if (color.equals(BLACK.getName())) {
            return Color.BLACK_INITAL.getName();
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