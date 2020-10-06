import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Terreng{

    protected ArrayList<Sted> steder = new ArrayList<Sted>(); 
    protected String filnavn = "steder.txt";

    public void leggTilSteder(){
        File fil = new File(filnavn);
        Scanner innlesning = null;

        try{
            innlesning = new Scanner(fil);
        }
        catch(FileNotFoundException e){
            System.out.println("Feil ved innlesning av fil");
        }

        while(innlesning.hasNextLine()){
            String beskrivelse = innlesning.nextLine();
            Sted detteStedet = new Sted(beskrivelse);
            steder.add(detteStedet);
        }
    }
    public void leggTilNeste(){
        for(int i = 0; i < steder.size(); i++){
           
            Sted neste = null;
            Sted stedet = steder.get(i);
            
            if(i != steder.size()-1){
                neste = steder.get(i+1);
                stedet.leggtilSted(neste);
            }
            else{
                neste = steder.get(0);
                stedet.leggtilSted(neste);
            }
        }
    }

    public int hentStoerrelse(){
        return steder.size();
    }

    public Sted hentStart(){
         Random random = new Random();
         int index = random.nextInt(steder.size());
         Sted start = steder.get(index);
        return start;
    }

    public void LagKister(String filnavn){

        File fil = new File(filnavn);
        Scanner innlesning = null;

        try{
        innlesning = new Scanner(fil);
        }
        catch(FileNotFoundException e){
            System.out.println("Feil ved innlesning av fil");
        }
    
        ArrayList<Gjenstand> liste = new ArrayList<Gjenstand>();

        while(innlesning.hasNextLine()){
            String data = innlesning.nextLine();
            String [] gjenstander = data.split(" ");
            String gjenstand = gjenstander[0];
            int pris = Integer.parseInt(gjenstander[1]);

            Gjenstand g = new Gjenstand(gjenstand, pris);
            liste.add(g);
        }
     
        int teller_gjenstand = 0;
        int teller_steder = 0;
        while(steder.size() > teller_steder){

            ArrayList<Gjenstand> g = new ArrayList<Gjenstand>();

            for(int i = 0; i < 4; i++){
                if(teller_gjenstand >= liste.size()-1){
                    teller_gjenstand = 0;
                }
                else{
                    g.add(liste.get(teller_gjenstand));
                    teller_gjenstand ++;
                
                }
            }
            Skattekiste s = new Skattekiste(g);
            steder.get(teller_steder).leggTilKiste(s);;
            teller_steder++;
        }
    }
}
