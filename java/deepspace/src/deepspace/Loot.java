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
    
    Loot(int Supplies, int Weapons, int Shields, int Hangars, int Medals) {
        nSupplies = Supplies;
        nWeapons = Weapons;
        nShields = Shields;
        nHangars = Hangars;
        nMedals = Medals;
    }
    
    // consultores 
    public int getNSupplies() { return nSupplies; }
    public int getNWeapons() { return nWeapons; }
    public int getNShields() { return nShields; }
    public int getNHangars() { return nHangars; }
    public int getNMedals() { return nMedals; }
}
