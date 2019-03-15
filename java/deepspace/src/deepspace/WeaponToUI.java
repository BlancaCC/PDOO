/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author Profe y Blanca 
 */
public class WeaponToUI {
    private WeaponType type;
    private float power;
    private int uses;  
    
    WeaponToUI(Weapon w) {
        type=w.getType();
        power=w.power();
        uses=w.getUses();
    }  

    public WeaponType getType() {
        return type;
    }

    public float getPower() {
        return power;
    }

    public int getUses() {
        return uses;
    }

     /** 
	@return @brief Representación en cadena de la instancia
     */
    public String toString(){

    String representation = "weapon type: " + type + "\n" +
	"weapon power: " + power+ "\n" +
	"uses: " +  uses + "\n"; 

    return representation; 
    }
    
}
