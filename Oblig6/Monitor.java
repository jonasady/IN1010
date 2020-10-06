import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.*;
import java.util.ArrayList;
public class Monitor{
     
    Liste<String> veier = new Lenkeliste<String>();
    private final Lock laas = new ReentrantLock();
      
    //Legger til utvei
    public void leggTilTraad(String s) throws InterruptedException{
      laas.lock();
      try{
        veier.leggTil(s);
      }
      finally{
        laas.unlock();
        }
      }
    public Liste<String> returnerTraader(){
      return veier;
    }
    public void reset(){
      veier= new Lenkeliste<String>();
    }
   
  }
