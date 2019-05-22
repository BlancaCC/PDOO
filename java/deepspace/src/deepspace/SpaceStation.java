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
        if(pendingDamage != null && pendingDamage.hasNoEffect())
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
        weapons = new ArrayList<Weapon>();
        shieldBoosters = new ArrayList<ShieldBooster>();
    }
    
    SpaceStation (SpaceStation station) {
        name=station.getName();
        ammoPower=station.getAmmoPower();
        fuelUnits=station.getFuelUnits();
        
        nMedals=station.getNMedals();
        pendingDamage=station.getPendingDamage();
        hangar=station.getHangar();
        weapons=station.getWeapons();
        shieldBoosters=station.getShieldBoosters(); 
        
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
    //se intenta descartar arma con ese índice
    public void discardWeapon(int i) {
	
	if( i >= 0 && i< weapons.size()){
	    Weapon weapon = weapons.get(i);
	    weapons.remove(i);
	    System.out.println("comprobación arma" + weapon.toString());
	    if(pendingDamage != null)
		pendingDamage.discardWeapon(weapon);
	    cleanPendingDamage(); 
	}
    }
    
    public void discardWeaponInHangar(int i) {
        if(hangar != null) {
            hangar.removeWeapon(i);
        }
    }

    /**
       realiza un disparo y devuelve la energía o potencia del mismo
     */
    public float fire() {
	float factor = 1;

	if (weapons != null)
	    for( Weapon weapon : weapons ){
		factor *= weapon.useIt(); 
	    }
	
	return ammoPower*factor;
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
		if (shieldBoosters == null)
		    shieldBoosters = new ArrayList<>(); 
                shieldBoosters.add(s);
            }
            
        }
    }
    
    public void mountWeapon(int i) {
	
        if(hangar != null) {
	    
            Weapon w = hangar.removeWeapon(i);
            if(w != null) {
		if (weapons == null)
		    weapons = new ArrayList<>(); 
                weapons.add(w);
            }
        }
    }
    
    public void move() {
        fuelUnits = Math.max(fuelUnits*(1-getSpeed()), 0f);
    }

    //Una el escudo de protección y devuelve la energía del mismo
    public float protection() {

	float factor = 1.0f;
	if (shieldBoosters != null)
	    for(ShieldBooster shieldBooster :  shieldBoosters) {
	    
		factor *= shieldBooster.useIt(); 
	    }
	return shieldPower*factor; 
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

    //operaciones receptión impacto enemigo
    public ShotResult receiveShot(float shot) {

	ShotResult resultado = ShotResult.DONOTRESIST;
	
	if( protection() >= shot){
	    shieldPower -= SHIELDLOSSPERUNITSHOT*shot;
	    shieldPower = Math.max( shieldPower, 0.0f);

	    resultado = ShotResult.RESIST; 
	}
	else{
	    shieldPower = 0.0f;
	    
	    resultado = ShotResult.DONOTRESIST;    
	}

	return resultado; 
    }
    
    public void receiveSupplies(SuppliesPackage s) {
      ammoPower += s.getAmmoPower();
      fuelUnits += s.getFuelUnits();
      shieldPower += s.getShieldPower();
    }

    //recepción de un botín 
    //¿UTILIZAR UNA CLASE PLANTILLA??
    public Transformation setLoot(Loot loot) {

	CardDealer dealer = CardDealer.getInstance();

	// hangar
	for( int i=0; i<loot.getNHangars(); i++ ) {
	    receiveHangar( dealer.nextHangar());  
	}
	
	// supplies
	for( int i=0; i<loot.getNSupplies(); i++){
	    receiveSupplies( dealer.nextSuppliesPackage());
	}

	// weapons
	for( int i=0; i<loot.getNWeapons(); i++){

	    receiveWeapon( dealer.nextWeapon()); 
	}

	// shield
	for(int i=0; i<loot.getNMedals(); i++){
	    receiveShieldBooster( dealer.nextShieldBooster()); 
	}

	//medals
	nMedals += getNMedals(); 
        
        
        //HAY QUE VER QUÉ SE HACE AHORA CON ESTO
        Transformation transformation = Transformation.NOTRANSFORM;
        if( loot.getEfficient() ) 
            transformation=Transformation.GETEFFICIENT; 
        else if (loot.spaceCity())
            transformation=Transformation.SPACECITY;
             return transformation; 
	
    } //setLoot
    
    // Se calcula el parámetro ajustado (adjust) a la lista de armas y
    // potenciadores de escudo de la estación y se almacena el resultado en el atributo correspondiente.
    public void setPendingDamage(Damage d) {
        pendingDamage = d.adjust(weapons, shieldBoosters);
    }
    
    public boolean validState() {
        return (pendingDamage == null || pendingDamage.hasNoEffect());
    }
    
    
    //COSAS QUE SE HAN MODIFICADO EN LA ÚLTIMA VERSIÓN 
    
    public String toString(){
	
	String representacion = "Spacece Station \n"+
	    "ammoPower: " + ammoPower +
	    "\nfuelUnits: " + fuelUnits +
	    "\nname: " + name + 
	    "\nshieldPower :" + shieldPower;
	
	if (pendingDamage != null)
	    representacion += "\npendingDamage :" + pendingDamage.toString();
	representacion += "\n__mounted__\n"; 
	if(hangar != null)
	    representacion += "\nhangar :" + hangar.toString(); 
	representacion += "\nweapons :\n";

	if(weapons != null)for( Weapon weapon :weapons)
	    representacion += weapon.toString();
	representacion +="\nshieldBoster: \n";
	
	if(shieldBoosters != null) for(ShieldBooster shield : shieldBoosters)
	    representacion += shield.toString();
	
	representacion += "\n"; 

	return representacion; 
    }

}

