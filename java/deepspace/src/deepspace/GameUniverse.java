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
    private boolean haveSpaceCity;
    
    
    public GameUniverse() {
        gameState = new GameStateController();
        turns = 0;
        dice = new Dice();
    }
    

    
    public CombatResult combat() {
        GameState state = gameState.getState();
        if(state == GameState.BEFORECOMBAT || state == GameState.INIT) {
            return combat(currentStation,currentEnemy);
        }
        else {
            return CombatResult.NOCOMBAT;
        }
    }
    
    
    CombatResult combat(SpaceStation station, EnemyStarShip enemy) {
        boolean enemyWins;
        float fire;
        ShotResult result;
        CombatResult combatResult;
        
        GameCharacter ch = dice.firstShot();
        
        if(ch == GameCharacter.ENEMYSTARSHIP) {
            fire = enemy.fire();
            result = station.receiveShot(fire);
            if(result == ShotResult.RESIST) {
                fire = station.fire();
                result = enemy.receiveShot(fire);
                enemyWins = (result == ShotResult.RESIST); 
            }
            else {
                enemyWins = true;
            }
        }
        else {
            fire = station.fire();
            result = enemy.receiveShot(fire);
            enemyWins = (result == ShotResult.RESIST);
        }
        
        if(enemyWins) {
            float s = station.getSpeed();
            boolean moves = dice.spaceStationMoves(s);
            if(!moves) {
                Damage damage = enemy.getDamage();
                station.setPendingDamage(damage);
                combatResult = CombatResult.ENEMYWINS;
            }
            else {
                station.move();
                combatResult = CombatResult.STATIONESCAPES;
            }
        }
        else {
            Loot aLoot = enemy.getLoot();
            Transformation t = station.setLoot(aLoot);
            if(t==Transformation.GETEFFICIENT) {
                makeStationEfficient();
                combatResult = CombatResult.STATIONWINSANDCONVERTS;
            }
            else if(t==Transformation.SPACECITY ) {//(aLoot.spaceCity()==true){
                createSpaceCity();
                combatResult = CombatResult.STATIONWINSANDCONVERTS;
            }
            else {
                combatResult = CombatResult.STATIONWINS;
            }
        }
        
        gameState.next(turns, spaceStations.size());
        
        return combatResult;
    }
    
    
    public void discardHangar() {
       if(getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT) {
           currentStation.discardHangar();
       } 
    }
    
    public void discardShieldBooster(int i) {
       if(getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT) {
           currentStation.discardShieldBooster(i);
       } 
    }
    
    public void discardWeapon(int i) {
       if(getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT) {
           currentStation.discardWeapon(i);
       } 
    }
    
    public void discardShieldBoosterInHangar(int i) {
       if(getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT) {
           currentStation.discardShieldBoosterinHangar(i);
       } 
    }
    
    public void discardWeaponInHangar(int i) {
       if(getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT) {
           currentStation.discardWeaponInHangar(i);
       } 
    }
    
    
    
    public GameState getState() {
        return gameState.getState();
    }
    
    public GameUniverseToUI getUIversion() {
        return new GameUniverseToUI(currentStation,currentEnemy);
    }
    
    
    public boolean haveAWinner() {
        return (currentStation.getNMedals() >= 10);
    }
    
    
    public void init(ArrayList<String> names) {
        GameState state = gameState.getState();
        
        if(state == GameState.CANNOTPLAY) {
            spaceStations = new ArrayList<SpaceStation>();
            CardDealer dealer = CardDealer.getInstance();
            
            for(String name : names) {
                SuppliesPackage supplies = dealer.nextSuppliesPackage();
                SpaceStation station = new SpaceStation(name,supplies);
                int nh = dice.initWithNHangars();
                int nw = dice.initWithNWeapons();
                int ns = dice.initWithNShields();
                Loot lo = new Loot(0,nw,ns,nh,0);
                station.setLoot(lo);
                spaceStations.add(station);
            }
            
            currentStationIndex = dice.whoStarts(names.size());
            currentStation = spaceStations.get(currentStationIndex);
            currentEnemy = dealer.nextEnemy();
            
            gameState.next(turns, spaceStations.size());
        }
    }
    
    public void mountShieldBooster(int i) {
       if(getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT) {
           currentStation.mountShieldBooster(i);
       } 
    }
    
    public void mountWeapon(int i) {
       if(getState() == GameState.INIT || getState() == GameState.AFTERCOMBAT) {
           currentStation.mountWeapon(i);
       } 
    }
    
    
    public boolean nextTurn() {
        GameState state = gameState.getState();
        
        if(state == GameState.AFTERCOMBAT) {
            boolean stationState = currentStation.validState();
            if(stationState) {
                currentStationIndex = (currentStationIndex +1)%spaceStations.size();
                turns++;
                currentStation = spaceStations.get(currentStationIndex);
                currentStation.cleanUpMountedItems();
                CardDealer dealer = CardDealer.getInstance();
                currentEnemy = dealer.nextEnemy();
                gameState.next(turns, spaceStations.size());
                
                return true;
            }
            
            return false;
        }
        
        return false;
    }

    public void makeStationEfficient() {
        if(dice.extraEfficiency()) {
            currentStation = new BetaPowerEfficientSpaceStation(currentStation);
        }
        else {
            currentStation = new PowerEfficientSpaceStation(currentStation);
        }
    }
    
    public void createSpaceCity(){
        if(haveSpaceCity == false){
            haveSpaceCity = true;
            ArrayList<SpaceStation> colaboradoras = new ArrayList<>();
            for(SpaceStation s: spaceStations) {
                if(s != currentStation) {
                    colaboradoras.add(s);
                }
            }
            currentStation = new SpaceCity(currentStation,colaboradoras);
            spaceStations.set(currentStationIndex,currentStation);
        }
    }
}
