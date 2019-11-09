package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

public class CommandView extends SubView {

    private static final String[] COLORS = { "blancas", "negras" };

    public CommandView() {
        super();
    }

    public void interact(PlayController playController) {
        String color = CommandView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();
        do {
            String command = this.console.readString("Mueven las " + color + ": ");
            int origin = Integer.parseInt(command.substring(0, 2));
            int target = Integer.parseInt(command.substring(3, 5));
            error = playController.move(new Coordinate(calculateRow(origin), calculateColumn(origin)),
                    new Coordinate(calculateRow(target), calculateColumn(target)));
            if (error != null) {
                console.writeln("Error!!!" + error.name());
                gameView.write(playController);
            }
        } while (error != null);
        if (playController.isBlocked()) {
            MessageView.LOSE.writeln();
        }
    }

    private int calculateRow(int row) {
        return row / 10 - 1;

    }

    private int calculateColumn(int column) {
        return column % 10 - 1;
    }

}