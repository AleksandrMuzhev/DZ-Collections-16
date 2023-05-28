package ru.netology;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    HashMap<String, Integer> players = new HashMap<>();

    public void register(Player player) {
        players.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {
        Integer player1 = players.get(playerName1);
        Integer player2 = players.get(playerName2);
        if (player1 == null) {
            throw new NotRegisteredException("Element with name: " + player1 + " not registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Element with name: " + player2 + " not registered");
        }
        if (player1 > player2) {
            return 1;
        }
        if (player1 < player2) {
            return 2;
        }
        return 0;
    }

}
//
//    public Player findByName(String name) {
//        for (String player : players.keySet()) {
//            if (player. () == name){
//                return player;
//            }
//        }
//        return null;
//    }
//}