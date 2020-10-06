public class HvitRute extends Rute{
    //Returner char . med metodekallet tilTegn() og returnerer false om metodekall på ute()
    int kolonne;
    int rad;
    Labyrint l;
    HvitRute(int r, int k){
        super(r, k);
        rad = r;
        kolonne = k;
       
       
    }
    @Override
    public char tilTegn(){
        return '.';
    } 
 

   @Override
   public void gaa(Rute forrige, Rute denne){
  //Gaa sjekker ved hjelp av nabo-hjelpemetodene om en kan gå videre til en rute. Siden gaa i SortRute er overrida til å ikke gjøre noe som helst
  //vil man bare Ruten denne og forrige være av typen HvitRute og blir stedfortreder for instanceof.
        if(forrige!= null){
           forrige.leggTilKordinater();   
        }
        if(forrige!= denne.settNord()){
            denne.settNord().gaa(denne, denne.settNord());
            }
        
    
        if(forrige!= denne.settSor()){
            denne.settSor().gaa(denne, denne.settSor());
            }

        if(forrige!= denne.settVest()){
            denne.settVest().gaa(denne, denne.settVest());
            } 

        if(forrige!= denne.settOst()){
            denne.settOst().gaa(denne, denne.settOst());
            } 

     
    }

}