package game.state;

import game.GameEngine;
import game.player.Objective;
import game.player.Player;
import game.player.Territory;
import javafx.event.ActionEvent;

public class ArmyPlacementState implements GameState {
    private static ArmyPlacementState instance;
    private GameEngine engine;
    private int addibleArmyNo;
    private int armyCount; //add amount per territory

    private ArmyPlacementState() {
        engine = GameEngine.getInstance();
        calculateNumberOfArmies(engine.getCurrentPlayer());
    }

    public static ArmyPlacementState getInstance() {
        if (instance == null) {
            synchronized (ArmyPlacementState.class) {
                if (instance == null) {
                    instance = new ArmyPlacementState();
                }
            }
        }
        return instance;
    }
    public void setArmyCount(int count){
        this.armyCount = armyCount;
    }
    @Override
    public void mapSelect(int territory) {
        engine.mapScene.getController().setState(0);
        Territory t = engine.getMap().getTerritory(territory);
        if (engine.getCurrentPlayer() == t.getRuler()) {
                //call display troop selection, it will set the army no.
                engine.mapScene.getController().displayTroopSelector(addibleArmyNo);
                t.setNumOfArmies(t.getNumOfArmies() + armyCount);
                addibleArmyNo = addibleArmyNo - armyCount;
            }
        if (addibleArmyNo <= 0) {
            engine.switchState(AttackingState.getInstance());
        }
    }

    @Override
    public void start() {
        engine.mapScene.getController().setState(0);
    }

    public void calculateNumberOfArmies(Player p) {
        if (p.getNumOfTerritory() <= 9) {
            addibleArmyNo = 3;
        } else {
            addibleArmyNo = p.getNumOfTerritory() / 3;
        }
        if( p.equals(engine.getMap().getAreas()[0].getRuler())){ //east campus area = +3
            addibleArmyNo += 3;
        }
        if( p.equals(engine.getMap().getAreas()[1].getRuler())){ //island area = +2
            addibleArmyNo += 2;
        }
        if( p.equals(engine.getMap().getAreas()[2].getRuler())){ //upper main campus area = +5
            addibleArmyNo += 5;
        }
        if( p.equals(engine.getMap().getAreas()[3].getRuler())){ //lower main campus area = +5
            addibleArmyNo += 5;
        }
        int objectiveResult = p.getObjective().isDone();
        if(objectiveResult == -1){
            p.setObjective(Objective.generateObjective(p));
        } else if (objectiveResult == 1) {
            addibleArmyNo += p.getObjective().getBonus(); //bonus army for a completed objective
            p.setObjective(Objective.generateObjective(p));
        }
    }

    public int getAddibleArmyNo(){
        return addibleArmyNo;
    }
}
