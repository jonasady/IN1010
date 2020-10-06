import java.util.ArrayList;
import java.util.Random;


public class Skattekiste{
    private ArrayList<Gjenstand> gjenstander;

    Skattekiste( ArrayList<Gjenstand> g){
        gjenstander = g;
    }
    public void leggTilGjenstand(Gjenstand denne){
       gjenstander.add(denne);
    }

    public Gjenstand taUtGjenstand(){

        Random r = new Random();
        int tilfeldigTall = r.nextInt(gjenstander.size());
        Gjenstand denneGjen = gjenstander.get(tilfeldigTall);
        denneGjen.endrePris();
        
        return denneGjen;  
    }

   public int stoerrelse(){
       return gjenstander.size();
   }

    public ArrayList<Gjenstand> hentListe(){
        return gjenstander;
    }

    public void fjern(int index){
        gjenstander.remove(index);
    }
}