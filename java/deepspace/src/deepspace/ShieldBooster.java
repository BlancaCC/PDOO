package deepspace;

/**
 * @brief Representa a los potenciadores de escudo que pueden tener las estaciones espaciales.
 */
class ShieldBooster {
    
    private String name;
    private float boost;
    private int uses;
    
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
    
    public float getBoost() { return boost; }
    public int getUses() { return uses; }
    
    public float useIt() {
        if(uses > 0f) {
            uses--;
            return boost;
        }
        return 1.0f;
    }
}
