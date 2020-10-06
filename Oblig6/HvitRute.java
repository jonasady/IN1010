
public class HvitRute extends Rute{
    //Returner char . med metodekallet tilTegn() og returnerer false om metodekall på ute()
    int kolonne;
    int rad;
    public Labyrint l;
    Liste<Thread> traader = new Lenkeliste<Thread>();
    Liste<Rute> naboer = new Lenkeliste<Rute>();
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
  //Gaa sjekker ved hjelp av nabo-hjelpemetodene om en kan gå videre til en rute. Alle naboene blir satt som en tråd bortsett fra den siste, som da
  //vil gaa på normalt vis for at trådene ikke skal gaa for evig tid. 

  //Det som vil skje dersom en gammel traad gaar før man starter nye traader er at det kun vil være den gamle traaden (linje 47) som gaar. De gamle traadene vil 
  //aldri kunne gaa, fordi man kaller gaa og vil dermed starte opp metoden igjen. Dermed blir traadene unreachable. Med mindre den gamle traaden har ekstremt flaks
  //og kun gaar i den retningen som er sist i naboer, hvilket er retning ost, vil man kun faa veldig mange Thread exceptions i terminalen sin:)
        vei += "(" + rad + ", " + kolonne + ")==>";
        sjekkNabo(forrige, denne);

        if(naboer.stoerrelse()> 1){
            for(int i = 0; i < naboer.stoerrelse()-1; i++){
                
                    Runnable traad = new RuteTraad(denne, naboer.hent(i) );
                    Thread traaden = new Thread(traad);
                    traader.leggTil(traaden);
            }
                
            for(int j = 0; j < traader.stoerrelse(); j++){
                traader.hent(j).start();
            }
            
            int sisteIndex = (naboer.stoerrelse() - 1);
            Rute siste = naboer.hent(sisteIndex);
            siste.gaa(denne, siste);

            for(int i = 0; i < traader.stoerrelse(); i++){
                try{
                traader.hent(i).join();
                }
                catch(InterruptedException e){
                    
                }
            }
            
        
    }
        //Gaar om det bare finnes en nabo
        else if(naboer.stoerrelse() == 1){
            Rute siste = naboer.hent(0);
            siste.gaa(denne, siste);
        }
    }
    
    @Override
    public  void sjekkNabo(Rute forrige, Rute denne){
    //Hjelpemetode som legger til naboer i Lenkeliste naboer
        
      
         if(forrige!= denne.settNord() && !(denne.settNord() instanceof SortRute)){
             naboer.leggTil(denne.settNord());
             }
     
         if(forrige!= denne.settSor() && !(denne.settSor() instanceof SortRute)){
             naboer.leggTil(denne.settSor());
             }
 
         if(forrige!= denne.settVest() && !(denne.settVest() instanceof SortRute)){
             naboer.leggTil(denne.settVest());
             } 
 
         if(forrige!= denne.settOst()&& !(denne.settOst() instanceof SortRute)){
             naboer.leggTil(denne.settOst());
             }
    }
}