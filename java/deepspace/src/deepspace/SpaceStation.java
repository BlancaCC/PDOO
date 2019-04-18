/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author usuario
 */
public class SpaceStation {
    
    private static int MAXFUEL = 100; // Máxima cantidad de unidades de combustible que puede tener una estación
                                      // espacial.
    private static float SHIELDLOSSPERUNITSHOT = 0.1f; //Unidades de escudo que se pierden por cada unidad de
                                                       //potencia de disparo recibido.
    
    private float ammoPower;
    private float fuelUnits;
    private String name;
    private int nMedals;
    private float shieldPower;
    
    private Damage pendingDamage;
    private Hangar hangar;
    private ArrayList<Weapon> weapons;
    private ArrayList<ShieldBooster> shieldBoosters;
    
    
    
    
    private void assignFuelValue(float f) {
        if(f<MAXFUEL)
            fuelUnits = f;
        else
            fuelUnits = MAXFUEL;
    }
    
    private void cleanPendingDamage() {
        if(pendingDamage.hasNoEffect())
            pendingDamage = null;
    }
    
    SpaceStation(String n, SuppliesPackage supplies){
        name = n;
        
        ammoPower = supplies.getAmmoPower();
        fuelUnits = supplies.getFuelUnits();
        shieldPower = supplies.getShieldPower();
        
        nMedals = 0;
        pendingDamage = null;
        hangar = null;
        weapons = null;
        shieldBoosters = null;
    }
    
    public void cleanUpMountedItems() {
        Iterator itr = weapons.iterator();
        while(itr.hasNext()) {
            Weapon w = (Weapon) itr.next();
            if(w.getUses()==0)
                itr.remove();
        }
        
        Iterator it = shieldBoosters.iterator();
        while(it.hasNext()) {
            ShieldBooster s = (ShieldBooster) it.next();
            if(s.getUses()==0)
                it.remove();
        }
    }
    
    public void discardHangar() {
        hangar = null;
    }
    
    public void discardShieldBooster(int i) {
    }
    
    public void discardShieldBoosterinHangar(int i) {
        if(hangar != null) {
            hangar.removeShieldBooster(i);
        }
    }
    
    public void discardWeapon(int i) {
    }
    
    public void discardWeaponInHangar(int i) {
        if(hangar != null) {
            hangar.removeWeapon(i);
        }
    }
    
    public float fire() {
        throw new UnsupportedOperationException();
    }

    public float getAmmoPower() {
        return ammoPower;
    }

    public float getFuelUnits() {
        return fuelUnits;
    }

    public String getName() {
        return name;
    }

    public int getNMedals() {
        return nMedals;
    }

    public float getShieldPower() {
        return shieldPower;
    }

    public Damage getPendingDamage() {
        return pendingDamage;
    }

    public Hangar getHangar() {
        return hangar;
    }

    public ArrayList<Weapon> getWeapons() {
        return weapons;
    }

    public ArrayList<ShieldBooster> getShieldBoosters() {
        return shieldBoosters;
    }
    
    public float getSpeed() {
        return fuelUnits/MAXFUEL;
    }
    
    public SpaceStationToUI getUIversion() {
        return new SpaceStationToUI(this);
    }
    
    public void mountShieldBooster(int i) {
        if(hangar!=null) {
            ShieldBooster s = hangar.removeShieldBooster(i);
            if(s != null) {
                shieldBoosters.add(s);
            }
            
        }
    }
    
    public void mountWeapon(int i) {
        if(hangar != null) {
            Weapon w = hangar.removeWeapon(i);
            if(w != null) {
                weapons.add(w);
            }
        }
    }
    
    public void move() {
        fuelUnits = Math.max(fuelUnits*(1-getSpeed()), 0f);
    }
    
    public float protection() {
        throw new UnsupportedOperationException();
    }
    
    public void receiveHangar(Hangar h) {
        if(hangar == null) {
            hangar = h;
        }
    }
    
    public boolean receiveShieldBooster(ShieldBooster s) {
        if(hangar == null) {
            return false;
        }
        else {
            return hangar.addShieldBooster(s);
        }
    }
    
    public boolean receiveWeapon(Weapon w) {
        if(hangar == null) {
            return false;
        }
        else {
            return hangar.addWeapon(w);
        }
    }
    
    public ShotResult receiveShot(float shot) {
        throw new UnsupportedOperationException();
    }
    
    public void receiveSupplies(SuppliesPackage s) {
      ammoPower += s.getAmmoPower();
      fuelUnits += s.getFuelUnits();
      shieldPower += s.getShieldPower();
    }
    
    public void setLoot(Loot loot) {
        throw new UnsupportedOperationException();
    }
    
    // Se calcula el parámetro ajustado (adjust) a la lista de armas y
    // potenciadores de escudo de la estación y se almacena el resultado en el atributo correspondiente.
    public void setPendingDamage(Damage d) {
        pendingDamage = d.adjust(weapons, shieldBoosters);
    }
    
    public boolean validState() {
        return (pendingDamage == null || pendingDamage.hasNoEffect());
    }
}

