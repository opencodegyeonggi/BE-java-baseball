package baseball;

import baseball.service.GameManager;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        gameManager.run();
    }
}