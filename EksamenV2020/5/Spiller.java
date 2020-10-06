import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Object;

public class Spiller {
   
    private String navn;
    protected Brukergrensesnitt objekt;
    private int formue = 0;
    private Skattekiste sekk; 
    protected Sted start;

    Spiller(Brukergrensesnitt obj, Sted s){
        start = s;
        objekt = obj;
        sekk = new Skattekiste(new ArrayList<Gjenstand>());
        
    }

    public void leggTilNavn(String n){
        navn = n;
    } 
    public String hentNavn(){
        return navn;
    }
    public void nyttTrekk(){
            ArrayList<Gjenstand> liste = sekk.hentListe();
            
            objekt.giStatus("\n\n\n\n" + navn + " sin tur \nSted: " + start.hentBeskrivelse()+ "\n");
            Skattekiste denne = start.hentKisteFraSted();
            Gjenstand g = denne.taUtGjenstand();

            int stoerrelse = liste.size();
            String[] a2 = new String[stoerrelse];

            for(int i = 0; i < stoerrelse; i++){
                a2[i] = liste.get(i).hentGjenstand() + " " + liste.get(i).hentPris() + " kr";
            }
            
            if(sekk.stoerrelse() == 0){
                String a[] = { g.hentGjenstand() + ": " + g.hentPris()};
                int valg = objekt.beOmKommando("Sekken din er tom. Bekreft og trykk paa 1 for aa legge objektet i sekken" , a );
                if(valg == 1){
                sekk.leggTilGjenstand(g);
                }
            }
            else if(sekk.stoerrelse() > 20){
                int valg = objekt.beOmKommando("Sekken er full. Velg en gjenstand aa selge", a2);
            }
            
            else{
            String a1[] = { "Legge til i sekken", "La den ligge og selge noe i sekken " };
            int valg1 = objekt.beOmKommando("Hva vil du gjøre med " + g.hentGjenstand() + " til verdien av " + g.hentPris() + " kr", a1);
            objekt.giStatus("\nDu valgte: " + a1[valg1-1]+ "\n");

            if(valg1 == 1){
                sekk.leggTilGjenstand(g);
            }
          
            else if(valg1 == 2){
               
                int valg2 = objekt.beOmKommando("Velg en gjenstand du vil selge i sekken: ", a2);
                objekt.giStatus("\nGjenstand solgt: " + a2[valg2-1] + "\n" );
                Gjenstand gjenstand = liste.get(valg2-1);
                formue += gjenstand.hentPris();
                denne.leggTilGjenstand(gjenstand);
                sekk.fjern(valg2-1);
            
            }
           
            if(sekk.stoerrelse()>0){
                objekt.giStatus("Oversikt over gjenstander og verdier i sekken: ");
                for(int i = 0; i < liste.size(); i++){
                    objekt.giStatus(i+1 + ". " +liste.get(i).hentGjenstand() + ": " + liste.get(i).hentPris() + " kr");    
                }
            }
        }
        objekt.giStatus("\n");    
        start = this.hentNyttSted();  
    }

    public Sted hentNyttSted(){
        return start.hentNesteSted().get(0);
    }

    public int hentFormue(){
        return formue;
    }
    

}