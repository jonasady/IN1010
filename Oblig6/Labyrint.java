import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException; 
import java.util.ArrayList;

public class Labyrint{
  //Lager en tomdimensjonal array og et objekt knyttet til grensesnittet veier 
    private Monitor monitor = new Monitor();
    private Rute [][]format;
    private Liste<String> utveier; 
    Labyrint(Rute [][] f){
       format = f;
       monitor = new Monitor();

    }

    public Monitor hentMonitor(){
      return monitor;
    }
    
   
    public static Labyrint lesFraFil (File fil) throws FileNotFoundException{
      //Leser inn labyrinten og lager enten aapning, hvitRute eller sortRute etter tegnene og 
      //posisjonen programmet finner for så å returnere et Labyrintobjekt.
        Scanner innlesing  = null;
       
      try { 
        innlesing = new Scanner(fil);
        System.out.println("Fant filen");
      }

      catch (FileNotFoundException e) { 
        System.out.println("Fant ikke filen");
      }
     
        String indexer = innlesing.nextLine();
        
        String liste[] = indexer.split(" ");
        int rader= Integer.parseInt(liste[0]);
        int kolonner = Integer.parseInt(liste[1]);
        
       
      
        Rute [][] todim = new Rute[rader][kolonner];
      
    
        int index1 = 0;
        while(innlesing.hasNextLine()){
            
            String linje[]= innlesing.nextLine().split("");
               int index2 = 0;
                for(String l: linje){  
                
                  if(l.equals(".")){
                  if(index1 == 0 || index2 == 0 || rader-1  == index1 || kolonner-1 == index2 ){
                  todim[index1][index2] = new Aapning(index1, index2);
                  }
                  else{
                    todim[index1][index2]= new HvitRute(index1, index2);
                  }
                }
                  else if(l.equals("#")){
                    todim[index1][index2] = new SortRute(index1, index2);
                  }
                  
                  index2++;
                }
              
            index1++;
            }
            Labyrint labyrinten = new Labyrint(todim);
            for(Rute[] rad: todim){
              for(Rute ruten: rad){
                ruten.finnLabyrint(labyrinten);
              }
            }
            return labyrinten;
        }
   
    public Liste<String> finnUtveiFra(int r, int k){
      //Sier at veier skal være av klasseTypen lenkeliste og kaller på 
      //finnUtvei for så å returnere en utvei fra monitoren.
   
      monitor.reset();
      Rute start = format[r][k];

      Runnable traad = new RuteTraad(null, start);
      Thread traaden = new Thread(traad);
      traaden.start();

      try {
        traaden.join();
      } catch(Exception e) {
      
      }
     
      return monitor.returnerTraader();
      
      
  }
   
    
    public Rute finnRute(int r, int k){
      //Returnerer en bestemt rute i format
      return format[r][k];
    }
    @Override
    public String toString(){
      //ToString metode som returnerer hele labyrinten visuelt.
      String oversikt = "";
      int rader = format.length;
      int kolonner = 0;
      for(Rute[]rad: format){
      
        kolonner = rad.length;
        for(Rute ruten: rad){
          oversikt += Character.toString(ruten.tilTegn());
         
          
        }
        oversikt += "\n";
      }
      oversikt += "\n";
      oversikt+= "Kolonner: " + kolonner + "\nRader: " + rader;
      return oversikt;
      }
       
    }
    
