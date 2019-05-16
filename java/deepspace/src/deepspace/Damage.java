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
abstract class Damage {
    private int nShields;

    //El númeor de escudeos es el invariante de varios daños
    //por tanto es lo único que pantiene de la copia
    //HAYT QUE SOBRECARGAR LOS OTROS 
    Damage(int s) {
	nShield=s; 
    }

   

    DamageToUI getUIversion() {
        return new DamageToUI(this);
    }
    
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t) {
        for(int i=0;i<w.size();i++) {
            if(w.get(i).getType() == t) {
                return i;
            }
        }
        return -1;
    }

    //ajuts el número de escudos
    private int adjustShields(ArrayList<ShieldBooster> s) {
	int newNShields = Math.min(nShields,s.size());
	return newNShields; 
    }
    
    
    public abstract void discardWeapon(Weapon w);
    
    public void discardShieldBooster(){
        if(nShields>0) {
            nShields--;
        }
    }
    
    public boolean hasNoEffect() { //¿se podría poner como abstracta?
	return nShields==0;    
    }


    public int getNShields() {
        return nShields;
    }

    public int getNWeapons() {
        return nWeapons;
    }

    public ArrayList<WeaponType> getWeapons() {
        return weapons;
    }

    public String toString(){
	
	String representacion = "\n__ damage__\n";
	representacion += "\nShields: " + nShields +
	    "\nnWeapons: " + nWeapons +
	    "\nweapons:\n";
	
	if(weapons != null) for(WeaponType weapon : weapons)
	    representacion += weapon;
	representacion += "\n";

	return representacion; 
	       

    }
    
    
}
