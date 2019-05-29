package deepspace;
import java.util.Random;

class Dice {
    
    private final float NHANGARSPROB;
    private final float NSHIELDSPROB;
    private final float NWEAPONSPROB;
    private final float FIRSTSHOTPROB;
    
    private Random generator;
    
    private final float EXTRAEFFICIENCYPROB;
    
    Dice() {
        
        NHANGARSPROB = 0.25f;
        NSHIELDSPROB = 0.25f;
        NWEAPONSPROB = 0.33f;
        FIRSTSHOTPROB = 0.5f;
        
        generator = new Random();
        
        EXTRAEFFICIENCYPROB=0.8f;
    }
    
    public boolean extraEfficiency() {
        boolean extra=false;
        //generator.nextFloat \in [0.0,1.0]
        if (generator.nextFloat() <= EXTRAEFFICIENCYPROB)
            extra=true;
        return extra;
    }
    public int initWithNHangars() {
        float p = generator.nextFloat();
        if(p < NHANGARSPROB) {
            return 0;
        }
        return 1;
    }
    
    public int initWithNWeapons() {
        float p = generator.nextFloat();
        if(p < NWEAPONSPROB) {
            return 1;
        }
        if(p < 2*NWEAPONSPROB) {
            return 2;
        }
        return 3;
    }
    
    public int initWithNShields() {
        float p = generator.nextFloat();
        if(p<NSHIELDSPROB) {
            return 0;
        }
        return 1;
    }
    
    public int whoStarts(int nPlayers) {
        return generator.nextInt(nPlayers);
    }
    
    GameCharacter firstShot() {
        float p = generator.nextFloat();
        if(p<FIRSTSHOTPROB) {
            return  GameCharacter.SPACESTATION;
        }
        return GameCharacter.ENEMYSTARSHIP;
    }
    
    boolean spaceStationMoves(float speed) {
        float p = generator.nextFloat();
        if(p<speed) {
            return true;
        }
        return false;
    }
}
