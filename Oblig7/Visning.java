import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.stage.FileChooser;
import javafx.scene.text.Text;
import javafx.event.*;

public class Visning extends Application {
    public Text info = new Text(); 
    Stage teater;
    public Rute labyrint[][];
    public Labyrint lab;
    public GridPane rutenett;
    public Button filknapp;
    public Pane kulisser;

@Override
public void start(Stage t) {
    //Lager ny GridPane
    rutenett = new GridPane();
    //Lar man velge fil
    File fil = new FileChooser().showOpenDialog(teater);
        try{
            lab = Labyrint.lesFraFil(fil);
            labyrint = lab.returnerFormat();
        }
        catch (FileNotFoundException e) {
            System.out.println("Fant ikke filen");
        }
        rutenett = new GridPane();
        //Gaar gjennom rute for rute og adder de i GridPanen. Deler opp i svart/hvit/aapning
        for(Rute rad[]: labyrint){
             for(Rute ruten: rad){
              
               
                
                if(ruten instanceof SortRute){
                        
                    Button labKnapp = new Button("#");
                    labKnapp.setStyle("-fx-background-color: #000000; -fx-text-fill: #000000");
                    Utvei u = new Utvei();
                    labKnapp.setOnAction(u);
                    rutenett.add(labKnapp, ruten.hentKolonne() , ruten.hentRad());
                }

                else{
                    Button labKnapp = new Button(".");
                    labKnapp.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #FFFFFF");
                    Utvei u = new Utvei();
                    labKnapp.setOnAction(u);
                    rutenett.add(labKnapp, ruten.hentKolonne() , ruten.hentRad());
              
                }
               
            }
        }
    //Setter linjer i GridPanen synlig, plasserer GridPane og legger til i kulisser 
    rutenett.setGridLinesVisible(true);
    rutenett.setLayoutX(50);
    rutenett.setLayoutY(80);
    teater = t;
    kulisser = new Pane();
    Scene scene = new Scene(kulisser);
    //Setter rutenettet i kulisser(Scene)
    kulisser.getChildren().add(rutenett);
    teater.setScene(scene);
    teater.show();


 }
 public class Utvei implements EventHandler<ActionEvent>{
     @Override
     public void handle(ActionEvent e){
         //Faar inn knappen som er trykket
        Button b =  (Button)e.getSource();
        //Lager en Boolean[][] losningsvei og sjekker den mot alle verdiene i Ruter [][]lab 
        if(b.getText().contains(".")){
      
        int k = GridPane.getRowIndex(b);
        int r = GridPane.getColumnIndex(b);
        if(k == 0 || r == 0){
            info.setText("Du begynte i en utgang");
            Button veiUt = new Button("  ");
            veiUt.setStyle("-fx-background-color: yellow");
            rutenett.add(veiUt, r , k); 
        }
        else{
        Liste<String> utveier = lab.finnUtveiFra(k, r);
        if(utveier.stoerrelse()==0){
            info.setText("Fant ingen utveier");
            }
        else{
        info.setText("Antall utveier: " + utveier.stoerrelse());
        
        boolean[][] losningsvei = losningStringTilTabell(utveier.hent(0), lab.hentKolonner(), lab.hentRader());
     
        
       //Sjekker om kolonnene i Rute[][]lab returneres som true i Boolean[][]losningsvei
        for(int i = 0; i < lab.hentKolonner(); i++){
            for(int j = 0; j < lab.hentRader(); j++){
                if(losningsvei[j][i]){
                    Button veiUt = new Button("  ");
                    veiUt.setStyle("-fx-background-color: yellow");
                    rutenett.add(veiUt, j , i); 
                        }
                    }
                }
            }
        }
    }
        
       
       else{
        info.setText("Du har trykka paa en svart rute");
        }
    info.setLayoutX(50);
    info.setLayoutY(40);
    kulisser.getChildren().add(info);
    }

}
  /**
 * Konverterer losning-String fra oblig 5 til en boolean[][]-representasjon
 * av losningstien.
 * @param losningString String-representasjon av utveien
 * @param bredde        bredde til labyrinten
 * @param hoyde         hoyde til labyrinten
 * @return              2D-representasjon av rutene der true indikerer at
 *                      ruten er en del av utveien.
 */
static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
    boolean[][] losning = new boolean[hoyde][bredde];
    java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
    java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
    while (m.find()) {
        int x = Integer.parseInt(m.group(1));
        int y = Integer.parseInt(m.group(2));
        losning[y][x] = true;
        }
    return losning;
    }

    public static void main(String[] args) {
    launch(args);
    }
 }
