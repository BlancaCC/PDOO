/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;
import java.util.ArrayList; 

/**
 *
 * @author blanca
 */
public class SpaceCity extends SpaceStation {
    
    //en el diagrama no se esoecifica el tipo
    //yo lo he puesto private por intuición
    private SpaceStation base; 
    private ArrayList<SpaceStation> collaborators;
    
    public SpaceCity( SpaceStation base, ArrayList<SpaceStation> rest) {
    super(base);
    this.base=base; 
    collaborators=rest;
    }
    
    
     //la poentecia de las ciudades espaciales
    //es la suma del disparo de sus colaboradores
    @Override
    public float fire() {
            float potencia=super.fire();

            for(SpaceStation resto : collaborators ) {
            potencia+=resto.fire();
           }

            return potencia;
        }

    
     public ArrayList<SpaceStation> getCollaborators () {
        return collaborators;
    }
   
    @Override
    public float protection() {
        float proteccion=super.protection();
        for(SpaceStation resto : collaborators ) 
            proteccion += resto.protection();
        
            return proteccion; 
    }
    
    
    //se debe de redefinir el método  SetLoot
    //para que ya no pueda esperimentar ninguan tranformación más 
    @Override 
    public Transformation setLoot(Loot loot)  {
        super.setLoot(loot);
        System.out.println("No debería de dar le mensaje de que se transforma");
        //como nos encontramos en una estación espacial 
        //ya no puede transformarse
        return Transformation.NOTRANSFORM; 
    }
      
   
    
   
}
