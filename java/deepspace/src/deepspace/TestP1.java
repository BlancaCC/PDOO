package deepspace;

public class TestP1 {

    public static void main(String[] args) {
	
	//__________  Pruena de los datos enumerados ____________
	CombatResult cr = CombatResult.ENEMYWINS;
	cr = CombatResult.NOCOMBAT;
	cr = CombatResult.STATIONESCAPES;
	cr = CombatResult.STATIONWINS;
	System.out.println( "Combat result " + cr ); 
	// GameCharacter
	GameCharacter gm = GameCharacter.ENEMYSTARSHIP; 
	gm =  GameCharacter.SPACESTATION;
	System.out.println( "Game character " + gm ); 
	// ShotResult
	ShotResult sr = ShotResult.DONOTRESIST;
	sr = ShotResult.RESIST;
	System.out.println( "Shot Result  " + sr ); 
	//Weapon type
	System.out.println( "Probamos el tipo Weapon Type"); 
	WeaponType wt = WeaponType.LASER;
	System.out.println( "El valor de "+  wt +  " es " +  wt.getPower() );
         wt = WeaponType.MISSILE;
	 System.out.println( "El valor de "+  wt +  " es " +  wt.getPower() );
	 wt = WeaponType.PLASMA;
	 System.out.println( "El valor de "+  wt +  " es " +  wt.getPower() );

	 // ========== prueba de las clases =============

	 // _________ Clase Loot _________

	 Loot loot = new Loop( 1,2,3,4,5);
	 System.out.println( "Clase loor consultores \n" +
			     "Supplies: " + getNSupplies() +
			     "\n"
			     );
	 
	 
	 // _________ Clase SuppliesPackage __________
	     
    //constructor por parámetros
    SuppliesPackage sp = new SuppliesPackage (1.1f, 2.2f, 9.3f);
    //constructor por copia
    SuppliesPackage sp2 = new SuppliesPackage( sp);
    // consultores

    System.out.println( "Probamos consultores de SuppliesPackage");
    System.out.println (" ammoPowe: " + sp.getAmmoPower()
			+ "\nfuelUnits: " + sp.getFuelUnits()
			+ "\nshieldPower: " + sp.getShieldPower() ); 


    
    } //main 

} // class TestP1 
