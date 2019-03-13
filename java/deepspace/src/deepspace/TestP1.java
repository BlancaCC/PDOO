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

	 Loot loot = new Loot( 1,2,3,4,5);
	 System.out.println( "Clase loor consultores \n" +
			     "Supplies: " + loot.getNSupplies() +
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


    // ______ Clase shieldBooster ________

    //constructor por parámetros
    ShieldBooster shield = new ShieldBooster( "Escudillo", 13, 0);
    //constructor por copia
    ShieldBooster shield1 = new ShieldBooster( shield);

    //consultores y función useIt
    System.out.println("\nConsultor de la lanzadera: " + shield.getBoost()
		       + "\nUsos lanzadera: " + shield.getUses()
		       + "\nTras decrementar los usos, boost vale:" + shield.useIt());

    // __________ Clase weapon _______

    //constructor por parámetros
    Weapon arma = new Weapon ( "Abracito de la muerte", WeaponType.PLASMA, 1);

    //constructor por copia
    Weapon armilla = new Weapon(arma);
    //consultores
    System.out.println( "Tipo de arma " + armilla.getType()
			+ "\nUsos restantes " + armilla.getUses()
			);

    // métodos de instancia
    System.out.println( " El poder de mi abracito es " + armilla.power()
			+ "\nUso arma " + armilla.useIt()
			+ "\nOTRO ABRACITO PA TIII " + armilla.useIt()); 
    
    // __________ Clase weapon _______
    Dice dado = new Dice();
    
    int [] frec = new int[] {0,0,0,0};
    
    for(int i=0;i<100;i++) {
        int s = dado.initWithNHangars();
        frec[s]++;
    }
    System.out.println("\nPrueba initWithNHangars");
    System.out.println("Frecuencia 0: " + frec[0]/100f);
    System.out.println("Frecuencia 1: " + frec[1]/100f);
    
    frec[1]=0;
    frec[2]=0;
    frec[3]=0;
    for(int i=0;i<100;i++) {
        int s = dado.initWithNWeapons();
        frec[s]++;
    }
    System.out.println("\nPrueba initWithNWeapons");
    System.out.println("Frecuencia 1: " + frec[1]/100f);
    System.out.println("Frecuencia 2: " + frec[2]/100f);
    System.out.println("Frecuencia 3: " + frec[3]/100f);
    
    frec[0]=0;
    frec[1]=0;
    for(int i=0;i<100;i++) {
        int s = dado.initWithNShields();
        frec[s]++;
    }
    System.out.println("\nPrueba initWithNShields");
    System.out.println("Frecuencia 0: " + frec[0]/100f);
    System.out.println("Frecuencia 1: " + frec[1]/100f);
    
    frec[0]=0;
    frec[1]=0;
    frec[2]=0;
    frec[3]=0;
    for(int i=0;i<100;i++) {
        int s = dado.whoStarts(4);
        frec[s]++;
    }
    System.out.println("\nPrueba whoStarts");
    System.out.println("Frecuencia 0: " + frec[0]/100f);
    System.out.println("Frecuencia 1: " + frec[1]/100f);
    System.out.println("Frecuencia 2: " + frec[2]/100f);
    System.out.println("Frecuencia 3: " + frec[3]/100f);
    
    frec[0]=0;
    frec[1]=0;
    for(int i=0;i<100;i++) {
        GameCharacter s = dado.firstShot();
        if(s==GameCharacter.ENEMYSTARSHIP)  frec[0]++;
        else if(s==GameCharacter.SPACESTATION)  frec[1]++;
    }
    System.out.println("\nPrueba firstShot");
    System.out.println("Frecuencia ENEMYSTARSHIP: " + frec[0]/100f);
    System.out.println("Frecuencia SPACESTATION: " + frec[1]/100f);
    
    frec[0]=0;
    frec[1]=0;
    for(int i=0;i<100;i++) {
        boolean s = dado.spaceStationMoves(0.618f);
        if(s==false)  frec[0]++;
        else if(s==true)  frec[1]++;
    }
    System.out.println("\nPrueba spaceStationMoves");
    System.out.println("Frecuencia false: " + frec[0]/100f);
    System.out.println("Frecuencia true: " + frec[1]/100f);
    
    } //main 

} // class TestP1 
