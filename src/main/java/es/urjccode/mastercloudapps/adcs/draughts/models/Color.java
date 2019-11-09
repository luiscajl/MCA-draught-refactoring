package es.urjccode.mastercloudapps.adcs.draughts.models;

public enum Color {
    WHITE("blancas"), BLACK("negras");

    private String color;

    private Color(String color) {
        this.color = color;

    }

    public String getName() {
        return this.color;
    }
}