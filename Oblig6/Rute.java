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
    abstract void sjekkNabo(Rute forrige, Rute denne);
    
    //Fra Labyrint får Rute-objekt en labyrintreferanse slik at man kan finne naboer enklere 
    public void finnLabyrint(Labyrint labyrint){
        l = labyrint;
    }
    public Labyrint returnerLabyrint(){
        return l;
    }
       
 
   
    
   //Metoden endres i de forskjellige subklassene
    abstract void gaa(Rute forrige, Rute denne);
    
   
    //Samme her
    abstract char tilTegn();
    

}
  
