
public class Sted {
    private String beskrivelse;
    private Skattekiste kiste;
    private Sted nesteSted;

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
        nesteSted = neste;
    }
    public Sted hentNesteSted(){
        return nesteSted;
    }
 

}