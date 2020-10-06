import java.lang.InterruptedException;

import javafx.application.Platform;

public class TraadBehandler implements Runnable {

    public void run(){
      try{
          Thread.sleep(5000);
          Platform.exit();
        }
      catch(InterruptedException e){

        }
    }
}
  

