import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VeiValgTerreng extends Terreng{
 
    @Override
    public void leggTilSteder() {
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
            Sted detteStedet = new VeiValgSted(beskrivelse);
            steder.add(detteStedet);
        }
    
    }
  
    
    @Override
    public void leggTilNeste(){
    

        for(int i = 0; i < steder.size(); i++){
            Sted detteStedet = steder.get(i);
            Sted nabo = null;
            
            for(int j = 1; j <4 && i < steder.size(); j++){
                
                Random r = new Random();
                int tilfeldig = r.nextInt(steder.size());
              
                nabo = steder.get(tilfeldig);
            
                detteStedet.leggtilSted(nabo);
                
            }
           
        }
    }

}