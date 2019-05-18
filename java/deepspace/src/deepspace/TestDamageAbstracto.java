package deepspace;

import java.util.ArrayList;

public class TestDamageAbstracto {
    public static void main(String[] args) {
	
	NumericDamage nd=new NumericDamage(1,2);
	ArrayList<Weapon> w=new ArrayList();
	Weapon weapon= new Weapon("armilla",WeaponType.LASER,1);
	w.add(weapon);
	
        ArrayList<ShieldBooster> s=new ArrayList<>();
        ShieldBooster  escudo;
        escudo = new ShieldBooster("Escudillo",2.3f,3);
         s.add(escudo);
	NumericDamage d2;
        d2 = nd.adjust(w,s);

	d2.discardWeapon( new Weapon("a",WeaponType.LASER));
	nd.hasNoEffect();
	//int i=nd.getWeapons();

	System.out.println( nd.toString()); 

	
	
    }
}
