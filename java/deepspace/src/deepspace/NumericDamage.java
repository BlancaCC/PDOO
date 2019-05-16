package deepspace;

class NumericDamage extends Damage {
    private int nWeapons;

    //w número de weapons, s: número de shields
    NumericDamage(int w, int s) {
	super.Damage(s);
	nWeapons=w; 
    }
    @Override
    public Damage adjust(ArrayList<Weapon> w, ArrayList<ShieldBooster> s) {
	int newWeapons=Math.min(nWeapons, newNShields);
	
	return new this( newWeapons, adjustShields(s)); 
    }

    //Descarta un arma de esta clase
    @Override
    public void discardWeapon(Weapon w) {
	if(nWeapons >0) nWeapons--; 
    }

    @Override
    public boolean hasNoEffect() {
	return super.hasNoEffect() && nWeapons==0; 
    }

    public getNWeapons() {
	return nWeapons; 
    }

    @Override
    public String toString() {
	String representacion = "\n__Numeric Damage__\n"+
	    super.toString()+"nWeapons= "+nWeapons+"\n";

	return representacion; 
    }
}
