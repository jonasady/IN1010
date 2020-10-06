import java.util.Random;

public class Gjenstand{
    private String gjenstand;
    private int pris;

    Gjenstand(String g, int p){
        gjenstand = g;
        pris = p; 
    }

    public int hentPris(){
        return pris;
    }

    public void endrePris(){
        Random random = new Random();

        int plussEllerMinus = random.nextInt(2);
        int nyPris = 0;

        if(pris < 100){
            nyPris = random.nextInt(5);
        }
        else if(pris> 100){
            nyPris = random.nextInt(30);
        }
        if(plussEllerMinus == 0){
            pris = pris - nyPris;
        }
        else{
            pris = pris + nyPris;
        }
    }

    public String hentGjenstand(){
        return gjenstand;
    }
}