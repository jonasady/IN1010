public class RuteTraad implements Runnable{
    private Rute ruten;
    private Rute forrige;
  
    
    public RuteTraad(Rute f, Rute r){
        ruten = r;
        forrige = f;
       
    }
    //"Gaar" videre
    public void run(){
        
       
            ruten.gaa(forrige, ruten);
       
    }
}
