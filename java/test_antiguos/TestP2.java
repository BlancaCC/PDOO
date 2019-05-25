package deepspace;

public class TestP2{

    public static void main( String[] args){

	//###### probamos toString y ClaseToUIVersion ###########

	//__________ 	ShieldBooster __________
	System.out.println( "__________ShieldBooster __________");
	ShieldBooster shield = new ShieldBooster( "Escudillo", 13, 0);
	System.out.println( shield.toString());
	ShieldToUI sui = shield.getUIversion();
	System.out.println( sui.toString() ); 
	
	

	//__________ SuppliesPackage ___________
	System.out.println(" ______________ Supplies package __________ "); 
	SuppliesPackage sp = new SuppliesPackage (1.1f, 2.2f, 9.3f);
	System.out.println( sp.toString());

	//________________ Weapon __________
	System.out.println(" ______________ Weapon __________ "); 
	Weapon arma = new Weapon ( "Abracito de la muerte", WeaponType.PLASMA, 1);
	System.out.println(arma.toString());

	WeaponToUI wui = arma.getUIversion();
	System.out.println( "WeaponType: "+ wui.getType()+ "\n"+
			   "Weapon power "+   wui.getPower()  + "\n"+
	    "Weapon uses: "+ wui.getUses()+ "\n"); 

	//_______________ Dice ____________
	Dice dado = new Dice();
	
    }
}
