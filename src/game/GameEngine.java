package game;
import java.io.*;
import java.util.*;

//GameState, GameMap, Objective, Player must be imported

public class GameEngine {
//    public GameState currentState;
//    public GameMap map;
//    public Objective[] objectives;
//    public Player[] players;
//    public int playerTurn; //keeps the index of the players array to decide who's gonna play
//    public int saveSlot;
//    public int turn; //total turn count of the game
//
//    public GameEngine(int saveSlot){
//        //variables will be initialized according to the save file(file parameter?)
//        this.saveSlot = saveSlot;
//    }
//
//    public GameEngine(int saveSlot, Player[] players){
//        this.saveSlot = saveSlot;
//        this.players = new Player[players.length];
//        for (int i = 0; i < players.length; i++) {
//            //"=" operator for the player class should be overriden
//            this.players[i] = players[i];
//        }
//        map = new GameMap();
//        turn = 0;
//        currentState = null;
//        playerTurn = 0; //first player will go first, which is stored in index 0
//    }
//
//    public void switchState( GameState currentState){
//        this.currentState = currentState;
//    }
//
//    //map should have a getTerritories method to return the territories array
//    public boolean isGameOver(){
//        for (int i = 0; i < map.getTerritories(); i++) {
//            if( i+1 < (map.getTerritories()).length && (map.getTerritories())[i] != (map.getTerritories())[i+1]){
//                //map is occupied by at least 2 players
//                return false;
//            }
//        }
//        //map is occupied by 1 player
//        return true;
//    }
//
//    public void removeObjective(String name){
//        int index = 0;
//        Objective[] temp = new Objective[objectives.length - 1];
//        for (int i = 0; i < objectives.length; i++) {
//            if(objectives[i].getName() != name){
//                //"=" operator for objective class should be overriden
//                temp[index++] = objectives[i];
//            }
//        }
//        objectives = temp;
//    }
}
