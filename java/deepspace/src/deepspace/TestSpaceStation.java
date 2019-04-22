/*
Test de prueba de la práctica 3, 
En particular se pruebará los métodos implementados en la clase SpaceStation
 */
package deepspace;

public class TestSpaceStation{
    public static void main( String[] args){
	//_____ creación spaceStation _______

	//elementos auxiliares creación de una estaciín espacial

	SuppliesPackage paquete = new SuppliesPackage(10.0f, 110.3f, 2f ); 
	SpaceStation ss = new SpaceStation( "Mi-ss", paquete);

	//creacion hangar, armas y ShieldBooster
	Hangar hangar = new Hangar (7);
	hangar.addWeapon( new Weapon( "mi-laser", WeaponType.LASER, 3));
	hangar.addWeapon( new Weapon( "mi-laser2", WeaponType.LASER, 8));

        hangar.addShieldBooster( new ShieldBooster( "Escudo", 10, 10) );

	ss.receiveHangar(hangar);
	System.out.println(ss); 
	ss.mountWeapon(0);
	ss.mountShieldBooster(0);

	System.out.println(ss); 
	ss.setPendingDamage( new Damage(3,8));
	

	//--- fire() -
	float fire = ss.fire();
	System.out.println("El fuego es " + fire);

	// --- protección
	System.out.println("Protección es " + ss.protection());

	//--- resultado
	System.out.println("Resultado tiro 1 es " + ss.receiveShot(1));
	System.out.println("Resultado tiro 100 es " + ss.receiveShot(100));
	System.out.println(""); //espacio intencionadamente en blanca

	// ====== pruebas loot ======

        ss.setLoot( new Loot( 2, 1, 10,2, 2));
	System.out.println("SpaceStation tras recibir botín \n" + ss.toString()); 

	// discarWEapon
	
	//	ss.setPendingDamage( new Damage(2,1));
	ss.discardWeapon(0);
	System.out.println("SpaceStation tras descartararma \n" + ss.toString()); 
	
    }
}
