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
public class Damage {
    private int nShields;
    private int nWeapons;
    private ArrayList<WeaponType> weapons;
    
    Damage(int w,int s) {
        nShields = s;
        nWeapons = w;
        weapons = null;
    }
    
    Damage(ArrayList<WeaponType> wl, int s) {
        nShields = s;
        nWeapons = -1;
        weapons = wl;
    }
    
    Damage(Damage d) {
        nShields = d.nShields;
        nWeapons = d.nWeapons;
        weapons = d.weapons;
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
    
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s) {
        int newNShields, newNWeapons;
        ArrayList<WeaponType> newWeapons = new ArrayList<>();
        
        newNShields = Math.min(nShields,s.size());
        
        if(nWeapons == -1) {
            
            int nLaser=0, nMissile=0, nPlasma=0;
            for(WeaponType wi : weapons) {
                if(wi == WeaponType.LASER)
                    nLaser++;
                else if(wi == WeaponType.MISSILE)
                    nMissile++;
                else if(wi == WeaponType.PLASMA)
                    nPlasma++;
            }
            
            int wnLaser=0, wnMissile=0, wnPlasma=0;
            for(Weapon wi : w) {
                if(wi.getType() == WeaponType.LASER)
                    wnLaser++;
                else if(wi.getType() == WeaponType.MISSILE)
                    wnMissile++;
                else if(wi.getType() == WeaponType.PLASMA)
                    wnPlasma++;
            }
            
            for(int i=0;i<Math.min(nLaser, wnLaser);i++) {
                newWeapons.add(WeaponType.LASER);
            }
            for(int i=0;i<Math.min(nMissile, wnMissile);i++) {
                newWeapons.add(WeaponType.MISSILE);
            }
            for(int i=0;i<Math.min(nPlasma, wnPlasma);i++) {
                newWeapons.add(WeaponType.PLASMA);
            }
            
            
            return new Damage(newWeapons,newNShields);                        
        }
        else {
            newNWeapons = Math.min(nWeapons,w.size());
            
            return new Damage(newNWeapons,newNShields);
        }
    }
    
    public void discardWeapon(Weapon w) {
        if(nWeapons == -1) {
          int i=0;
          while(i<weapons.size()){
              if(weapons.get(i) == w.getType()) {
                  weapons.remove(i);
              }
              else {
                  i++;
              }
          }
        }
        else {
            if(nWeapons > 0)
                nWeapons--;
        }
    }
    
    public void discardShieldBooster(){
        if(nShields>0) {
            nShields--;
        }
    }
    
    public boolean hasNoEffect() {
        if(nWeapons == -1) {
            return nShields == 0 && weapons.isEmpty();            
        }
        else {
            return nShields==0 && nWeapons==0;
        }
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
    
    
}
