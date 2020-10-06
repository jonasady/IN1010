public class Aapning extends HvitRute{
    //Klassen er lik hvit rute, utennom ute() returnerer true slik at metoden gaa skjønner 
    //når man har truffet en åpning og avsluttet.
    int k;
    int r;
    
    Aapning(int rad, int kolonne){
        super(rad, kolonne);
    }
    @Override
    public char tilTegn(){
        return '.';
    } 
    
    @Override
    //Sier ifra at ruten er funnet og legger til i lenkelista og sier at vei skal være
    //en tom tekststreng for å starte på en ny rute
    public void gaa(Rute forrige, Rute denne){
        String rettVei;
       forrige.leggTilKordinater(); 
       vei += "(" + denne.hentRad() + ", " +  denne.hentKolonne()+ ")";
       rettVei = vei;
       vei = "";
       denne.leggTilRute(rettVei);
       
   }
  
}