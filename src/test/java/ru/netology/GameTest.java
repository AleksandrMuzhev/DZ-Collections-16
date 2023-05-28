package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    @Test
    public void testWinFirstPlayer() {
        Player player1 = new Player(5, "Роман", 75);
        Player player2 = new Player(7, "Владимир", 50);
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Роман", "Владимир");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWinSecondPlayer() {
        Player player1 = new Player(5, "Роман", 75);
        Player player2 = new Player(7, "Владимир", 50);
        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Владимир", "Роман");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testAllNotWinPlayers() {
        Player player1 = new Player(5, "Роман", 50);
        Player player2 = new Player(7, "Владимир", 50);
        game.register(player1);
        game.register(player2);

        int expected = 0;
        int actual = game.round("Роман", "Владимир");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testWhenFirstPlayerNotExist() {
        Player player1 = new Player(5, "Роман", 50);
        Player player2 = new Player(7, "Владимир", 50);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Дмитрий", "Владимир"));
    }

    @Test
    public void testWhenSecondPlayerNotExist() {
        Player player1 = new Player(5, "Роман", 50);
        Player player2 = new Player(7, "Владимир", 50);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Роман", "Алексей"));
    }

    @Test
    public void testWhenAllPlayersNotExist() {
        Player player1 = new Player(5, "Роман", 50);
        Player player2 = new Player(7, "Владимир", 50);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> game.round("Дмитрий", "Алексей"));
    }
}
