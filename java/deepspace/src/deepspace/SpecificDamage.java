package deepspace;
import java.utils.ArrayList;

class SpecificDamage extends Damage{

    private ArrayList<WeaponType> weapons;
    
    SpecificDamage(ArrayList<WeaponType> wl, int s) {
	super(s);
	weapons=wl; 
    }

    //dada una lista devuelve el índice del tipo pasado
    //si no se encuntra devuelve -1
    private int arrayContainsType(ArrayList<Weapon> w, WeaponsType t) {
	int salida=-1; //valor de salida erronea
	
	for(int i=0;i<w.size() && salida <0;i++) {
            if(w.get(i).getType() == t) {
                salida=i;
            }
        }
        return salida;
    }

    @Override
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s) {
	ArrayList<WeaponType> newWeapons=w.clone(); //Mirar a ver si no revienta  
	for(WeaponType wtype : w) {
	    int indice=arrayContainsType(w,wtype);
	    if(indice > 0) {
		newWeapons.remove(indice); 
	    }
	}

	return new this(newWeapons, adjustShields(s));
    }

    //Se quiere descartar un tipo de nuestro daño pendiente
    @Override
    public void discardWeapons(Weapons w) {
	int indice=arrayContainsType(weapons, w.getType());
	if(indice>0) weapons.remove(indice); 
    }

    @Override
    public boolean hasNoEffect() {
	return super.hasNoEffect && weapons.isEmpty(); 
    }
}
