/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author usuario
 */
public class GameUniverse {
    
    private static final int WIN = 10;
    
    private int currentStationIndex;
    private int turns;
    private SpaceStation currentStation;
    private ArrayList<SpaceStation> spaceStations;
    private EnemyStarShip currentEnemy;
    private GameStateController gameState;
    private Dice dice;
    
    
    GameUniverse() {
        gameState = new GameStateController();
        turns = 0;
        dice = new Dice();
    }
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy) {
        
    }
    
    public CombatResult() {
        
    }
    
}
