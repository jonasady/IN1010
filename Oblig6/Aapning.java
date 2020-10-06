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
    //en tom tekststreng for så at hele ruta blir lagt til monitoren.
    public void gaa(Rute forrige, Rute denne){
        vei += "(" + rad + ", " + kolonne + ")==> Fant veien ut";
        
        try{
        returnerLabyrint().hentMonitor().leggTilTraad(vei);
        }
        catch(Exception e) {
        }
        vei =" ";
   }
   @Override
   public void sjekkNabo(Rute denne, Rute forrige){

   }
}