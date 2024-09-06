package info0202_project.serialization;

/**
 *
 * @author Clément
 */

import java.io.Serializable;

public class GameData implements Serializable {
    private boolean gameStarted;

    public GameData(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }

    public boolean isGameStarted() {
        return gameStarted;
    }

    public void setGameStarted(boolean gameStarted) {
        this.gameStarted = gameStarted;
    }
}
