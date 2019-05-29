package deepspace;
import java.util.ArrayList;

public class SpecificDamage extends Damage{

    private ArrayList<WeaponType> weapons;
    
    SpecificDamage(ArrayList<WeaponType> wl, int s) {
	super(s);
	weapons=wl; 
    }

    //dada una lista devuelve el índice del tipo pasado
    //si no se encuntra devuelve -1
    private int arrayContainsType(ArrayList<Weapon> w, WeaponType t) {
	int salida=-1; //valor de salida erronea
	
	for(int i=0;i<w.size() && salida <0;i++) {
            if(w.get(i).getType() == t) {
                salida=i;
            }
        }
        return salida;
        
    }

    
    @Override
    public SpecificDamage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s) {
	ArrayList<WeaponType> newWeapons=new ArrayList<>(); 
        ArrayList<Weapon> auxWeapons = new ArrayList<>(w);
	for(WeaponType wtype : weapons) {
	    int indice=arrayContainsType(auxWeapons,wtype);
	    if(indice >= 0) {
                newWeapons.add(wtype);
		auxWeapons.remove(indice); 
	    }
	}

	return new SpecificDamage(newWeapons, adjustShields(s));
        
    }

    //Se quiere descartar un tipo de nuestro daño pendiente
    //Incompatibilidad de tipos
    @Override
    public void discardWeapon(Weapon w) {
	for(WeaponType wt:weapons) {
            if(wt == w.getType()) {
                weapons.remove(wt);
                return;
            }
        }
    }

    @Override
    public boolean hasNoEffect() {
	return super.hasNoEffect() && weapons.isEmpty(); 
    }

    public ArrayList<WeaponType> getWeapons() {
	return weapons; 
    }

    @Override
    public String toString() {
	String repr="\n__Specific Damage__\n"
	    + super.toString()
	    + "Weapons: \n";

	if(weapons != null) for(WeaponType weapon : weapons)
	    repr += weapon;
	repr += "\n";

	return repr; 
	
    }
    
    @Override
    public SpecificDamageToUI getUIversion(){
        return new SpecificDamageToUI(this);
    }
}
