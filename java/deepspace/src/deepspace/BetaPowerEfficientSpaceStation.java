/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author blanca
 */
public class BetaPowerEfficientSpaceStation extends PowerEfficientSpaceStation {
    
    private final static float EXTRAEFFICIENCY=1.2f;
    private static Dice dice;
    public BetaPowerEfficientSpaceStation(SpaceStation station) {
        super(station);
        dice=new Dice();
    }
    
    public float fire() {
        float normalFire=super.fire(); 
        if(dice.extraEfficiency()) { //ni idea de cual es este fallo
            normalFire *= EXTRAEFFICIENCY;
                         
        }
        return normalFire;
    }
    
}
