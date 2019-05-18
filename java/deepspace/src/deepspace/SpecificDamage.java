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

    //Incompatibilidad de tipos
    @Override
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s) {
	ArrayList<Weapon> newWeapons=(ArrayList<Weapon>)w.clone(); // Preguntar si esto esta bien 
	for(Weapon wtype : w) {
	    int indice=arrayContainsType(w,wtype.getType());
	    if(indice > 0) {
		newWeapons.remove(indice); 
	    }
	}

	return new SpecificDamage(newWeapons, adjustShields(s));
    }

    //Se quiere descartar un tipo de nuestro daño pendiente
    //Incompatibilidad de tipos
    public void discardWeapon(Weapon w) {
	int indice=arrayContainsType(weapons, w.getType());
	if(indice>0) weapons.remove(indice); 
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
}
