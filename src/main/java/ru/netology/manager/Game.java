package ru.netology.manager;

import ru.netology.data.Player;
import ru.netology.exception.NotRegisteredException;

import java.util.ArrayList;


public class Game {
    protected ArrayList<Player> players = new ArrayList<>();

    void register(Player player) {
        players.add(player);
    }

    int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;

        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player1 = player;
            }
            if (player.getName().equals(playerName2)) {
                player2 = player;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не был зарегистрирован на турнире");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не был зарегистрирован на турнире");
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }
}
