/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deepspace;

/**
 *
 * @author Profe y Blanca
 */
public class ShieldToUI {
    private float boost;
    private int uses;

    ShieldToUI (ShieldBooster s) {
        boost=s.getBoost();
        uses=s.getUses();
    }    

    public float getBoost() {
        return boost;
    }

    public int getUses() {
        return uses;
    }

    /**
       @brief Representación de la clase
       @return Devuelve en un string la representación de la clase 
    */
    public String toString(){

	String representation = "uses: " + uses + "\n"
	    + "boost: " + boost + "\n" ;
    
	return representation; 
    }
    
    
}
