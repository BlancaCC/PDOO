/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;

/**
 *
 * @author Profe
 */
public class HangarToUI {
    private int maxElements;
    private ArrayList<WeaponToUI> weapons;
    private ArrayList<ShieldToUI> shieldBoosters;    
    
    HangarToUI(Hangar h) {
        weapons=new ArrayList<>();
        shieldBoosters=new ArrayList<>(); 
        
        maxElements=h.getMaxElements();
        
        for (Weapon w:h.getWeapons()) {
            weapons.add(w.getUIversion());
        }
        
        for(ShieldBooster s:h.getShieldBoosters()) {
            shieldBoosters.add(s.getUIversion());
        }
    }

    public int getMaxElements() {
        return maxElements;
    }

    public ArrayList<WeaponToUI> getWeapons() {
        return weapons;
    }

    public ArrayList<ShieldToUI> getShieldBoosters() {
        return shieldBoosters;
    }
    
    public String toString (){

	String representacion = "\n__Hangar__" +
	    "\nCapacidad: " + maxElements +
	    "\nweapons:\n";
	
	if (weapons != null) for( WeaponToUI weapon :weapons)
	    representacion += weapon.toString();
	representacion +="\nshieldBoster: \n";
	
	if(shieldBoosters != null) for(ShieldToUI shield : shieldBoosters)
	    representacion += shield.toString();
	
	representacion += "\n"; 
	return representacion; 
    }
    
}
