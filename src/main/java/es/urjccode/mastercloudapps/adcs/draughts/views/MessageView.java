package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

public enum MessageView {
    LOSE("Derrota!!! No puedes mover tus fichas!!!"), TITTLE("Draughts");

    private Console console;
    private String message;

    private MessageView(String message) {
        this.message = message;
        this.console = new Console();
    }

    void write() {
        this.console.write(this.message);
    }

    void writeln() {
        this.console.writeln(this.message);
    }
}