import java.util.ArrayList;

public class VeiValgSpiller extends Spiller {
    
    
    VeiValgSpiller(Brukergrensesnitt obj, Sted std){
        super(obj, std);
        
    }
   
    @Override
    public Sted hentNyttSted(){

        ArrayList<Sted> steder = start.hentNesteSted();
        start.settRetning();
        String[] beskrivelser = new String[steder.size()];
        for(int i = 0; i < steder.size(); i++){
            beskrivelser[i] = "Gaa " + steder.get(i).hentRetning() + ": " + steder.get(i).hentBeskrivelse();
           
        }

        int valg = objekt.beOmKommando("Hvilket sted vil du gaa til " , beskrivelser);
        start = steder.get(valg-1);
        objekt.giStatus("\nDu valgte aa gaa " + start.hentRetning() + ": " + start.hentBeskrivelse());

        return start;
  
    }
}