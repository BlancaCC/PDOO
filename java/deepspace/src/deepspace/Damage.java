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
public abstract class Damage {
    private int nShields;

    //El númeor de escudeos es el invariante de varios daños
    //por tanto es lo único que pantiene de la copia
    //HAYT QUE SOBRECARGAR LOS OTROS 
    Damage(int s) {
	nShields=s; 
    }

   
    //OJO QUE HE COMENTADO DamageToUI
    // abstract DamageToUI getUIversion(); 
    
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t) {
        for(int i=0;i<w.size();i++) {
            if(w.get(i).getType() == t) {
                return i;
            }
        }
        return -1;
    }

    //ajuts el número de escudos
     int adjustShields(ArrayList<ShieldBooster> s) {
	int newNShields = Math.min(nShields,s.size());
	return newNShields; 
    }
    
    
    public abstract void discardWeapon(Weapon w);
    
    public abstract Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s);
    
    public void discardShieldBooster(){
        if(nShields>0) {
            nShields--;
        }
    }
    
    public boolean hasNoEffect() { 
	return nShields==0;    
    }


    public int getNShields() {
        return nShields;
    }



    public String toString(){
	
	String representacion =  "Shields: " + nShields +"\n";
	return representacion;
    }
 
    public abstract  DamageToUI getUIversion();
}
