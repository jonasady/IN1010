import java.util.ArrayList;

public class Sted {
    protected String retning;
    private String beskrivelse;
    private Skattekiste kiste;
    protected ArrayList<Sted> nesteSted = new ArrayList<Sted>();

    Sted(String b){
        beskrivelse = b;
    }

    public void leggTilKiste(Skattekiste k){
        kiste = k;
    }

    public Skattekiste hentKisteFraSted(){
        return kiste;
    }
    
    public String hentBeskrivelse(){
        return beskrivelse;
    }

    public void leggtilSted(Sted neste){
        nesteSted.add(neste);
    }

    public ArrayList<Sted> hentNesteSted(){
        return nesteSted;
    }
    public String hentRetning(){
        return retning;
    }
   
    public void settRetning(){
        retning = "gaa videre";
    }

}