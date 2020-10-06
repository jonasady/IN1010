import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



public class Spill {

    public static void main(String[] args){
        Brukergrensesnitt grensesnitt = null;
        Scanner les = null;
        Terreng terreng = null;
        Spiller spiller = null;
        try {
            les = new Scanner(System.in);
        } catch (Exception e) {
            System.out.println("Noe gikk galt");
        }
        System.out.println("Oensker du flere steder aa velge mellom flere steder eller ett sted?\n1.Ett sted\n2.Flere steder");
        int stedValg = Integer.parseInt(les.nextLine());
       


        System.out.println("Vil du spille eller la roboten spille?\n1. Robot\n2. Deg selv");
        int valg = Integer.parseInt(les.nextLine());
        if(valg == 1){
            grensesnitt = new Robot();
        }
        else if(valg == 2){
            grensesnitt = new Terminal(les);
        }
      
        if(stedValg==1){
            terreng = new Terreng();
            terreng.leggTilSteder();
            terreng.leggTilNeste();
            terreng.LagKister("gjenstander.txt");
            spiller = new Spiller(grensesnitt, terreng.hentStart());
        }

        else if(stedValg == 2){
            terreng = new VeiValgTerreng();
            terreng.leggTilSteder();
            terreng.leggTilNeste();
            terreng.LagKister("gjenstander.txt");
            spiller = new VeiValgSpiller(grensesnitt, terreng.hentStart());
        }
       
        
        

      
        
        for(int i = 0; i < terreng.hentStoerrelse(); i++){
            spiller.nyttTrekk();
        }
        grensesnitt.giStatus("\nSpillet er ferdig!\nFormue: " + spiller.hentFormue()+ " kr \n");

    }
}