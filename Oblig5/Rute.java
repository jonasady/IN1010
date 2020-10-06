public abstract class Rute{
    
    private int rad;
    private int kolonne;
    public Labyrint l = null;
    public static String vei = "";
    Rute(int r, int k){
        rad = r;
        kolonne = k; 
    }
    public Rute settSor(){
        return l.finnRute(rad - 1 , kolonne);
    }
    public Rute settNord(){
        return l.finnRute(rad + 1 , kolonne);
    }
    public Rute settOst(){
        return l.finnRute(rad, kolonne + 1);
    }
    public Rute settVest(){
        return l.finnRute(rad, kolonne - 1);
    }
    
    //Fra Labyrint får Rute-objekt en labyrintreferanse slik at man kan finne naboer enklere 
    public void finnLabyrint(Labyrint labyrint){
        l = labyrint;
    }
       
   public void leggTilRute(String vei){
    l.utveier.leggTil(vei);
   }

   
    
   //Metoden endres i de forskjellige subklassene
    abstract void gaa(Rute forrige, Rute denne);
    
   
    //Samme her
    abstract char tilTegn();
    
    //Starter en gaa med null som forrige verdi, fordi man starter på begynnelsen
    public void finnUtvei(){
        this.gaa(null, this);
    }
    //Legger til kordinatene i Static Strengen vei
   public void leggTilKordinater(){
       vei += "(" + rad + ", " + kolonne + ")==>";
   }
   //Henter static strengen vei
   public String hentKordinater(){
       return vei;
   }
}
  
