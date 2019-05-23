package deepspace;


/**
 * @brief representa el botín que se obtiene al vencer a una nave enemiga.
 */
class Loot {
    
    private int nSupplies;
    private int nWeapons;
    private int nShields;
    private int nHangars;
    private int nMedals;
    
    private boolean getEfficent; 
    private boolean spaceCity; 
    
    
    
    
    Loot(int Supplies, int Weapons, int Shields, int Hangars, int Medals, boolean ef, boolean city) {
        nSupplies = Supplies;
        nWeapons = Weapons;
        nShields = Shields;
        nHangars = Hangars;
        nMedals = Medals;
        
        getEfficent=ef; 
        spaceCity=city; 
        
    }
    
    Loot(int Supplies, int Weapons, int Shields, int Hangars, int Medals) {
        this(Supplies, Weapons, Shields, Hangars, Medals, false, false); 
        
    }
    
    // consultores 
    public int getNSupplies() { return nSupplies; }
    public int getNWeapons() { return nWeapons; }
    public int getNShields() { return nShields; }
    public int getNHangars() { return nHangars; }
    public int getNMedals() { return nMedals; }
    
    public boolean getEfficient() {return getEfficent;}
    public boolean spaceCity() {return spaceCity;}
    
    LootToUI getUIversion() {
        return new LootToUI(this);
    }
}
