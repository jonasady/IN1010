import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Scene;


public class Spill extends Application{
    Pane ramme;
    Text resultat;
    Button knapp;
    Stage teater;
    static int endeligeFormue = 0;
    @Override 
    public void start(Stage t){
        
        knapp = new Button("Avslutt");
        resultat = new Text("Spillet er ferdig! Formue: "+ endeligeFormue + " kr");

        Avslutt a = new Avslutt();
        knapp.setOnAction(a);
        resultat.setFont(Font.font("Helvetia", 20));

        knapp.setLayoutX(200);
        knapp.setLayoutY(210);
        resultat.setLayoutX(75);
        resultat.setLayoutY(200);

        teater = t;
        Pane ramme = new Pane();
        ramme.setPrefSize(400, 400);
        ramme.getChildren().addAll(resultat, knapp);
        Scene scene = new Scene(ramme);
        teater.setScene(scene);
        teater.show();
    }
   

    public class Avslutt implements EventHandler<ActionEvent>{
        @Override
        public void handle(ActionEvent e){
        Platform.exit();
        }
    }

    public static void main(String[] args){
        Brukergrensesnitt grensesnitt = null;
        Scanner les = null;

        try {
            les = new Scanner(System.in);
        } 
        catch (Exception e) {
            System.out.println("Noe gikk galt");
        }
        System.out.println("Vil du spille eller la roboten spille?\n1. Robot\n2. Deg selv");
        int valg = Integer.parseInt(les.nextLine());
        if(valg == 1){
            grensesnitt = new Robot();
        }
        else if(valg == 2){
            grensesnitt = new Terminal(les);
        }
      
        
        Terreng terreng = new Terreng();
        terreng.leggTilSteder();
        terreng.leggTilNeste();
        terreng.LagKister("gjenstander.txt");

        Spiller spiller = new Spiller(grensesnitt, terreng.hentStart());
        int ferdig = 0;
        for(int i = 0; i < terreng.hentStoerrelse(); i++){
            spiller.nyttTrekk();
            ferdig = i;
        }
        
        endeligeFormue = spiller.hentFormue();
        
        TraadBehandler traader = new TraadBehandler();
        Thread traaden = new Thread(traader);
        traaden.start();

        launch(args);
    }

}