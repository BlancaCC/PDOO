package deepspace;

/**
 * @brief Representa a los potenciadores de escudo que pueden tener las estaciones espaciales.
 */
class ShieldBooster {
    
    private String name;
    private float boost;
    private int uses;

    //__constructores
    ShieldBooster(String name, float boost, int uses) {
        this.name = name;
        this.boost = boost;
        this.uses = uses;
    }
    
    ShieldBooster(ShieldBooster otro) {
        name = otro.name;
        boost = otro.boost;
        uses = otro.uses;
    }
    //__ fin constructores 
    
    public float getBoost() { return boost; }
    public int getUses() { return uses; }
    
    public float useIt() {
        if(uses > 0f) {
            uses--;
            return boost;
        }
        return 1.0f;
    }

    /**
       @brief Representación de la clase
       @return Devuelve en un string la representación de la clase 
     */
    public String toString(){

    String representation = "name: " + name + "\n"
	+ "uses: " + uses + "\n"
	+ "boost: " + boost + "\n" ;
    
	return representation; 
    }
    
    ShieldToUI getUIversion(){ return new ShieldToUI(this); }
}
