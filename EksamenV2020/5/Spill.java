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
      
       
        System.out.println("Hvor mange spillere ønsker aa spille?");
        int ant_spillere = Integer.parseInt(les.nextLine());

        Spiller [] spillere = new Spiller[ant_spillere];

        for(int i = 0; i < ant_spillere; i++){
            System.out.println("Vil du spille eller la roboten spille?\n1. Robot\n2. Deg selv");
            int valg = Integer.parseInt(les.nextLine());

            System.out.println("Oensker du flere steder aa velge mellom flere steder eller ett sted?\n1.Ett sted\n2.Flere steder");
            int stedValg = Integer.parseInt(les.nextLine());

            if(valg == 1){
                grensesnitt = new Robot();
            }
            else if(valg == 2){
                grensesnitt = new Terminal(les);
            }
            if(stedValg == 1){
                terreng = new Terreng();
                terreng.leggTilSteder();
                terreng.leggTilNeste();
                terreng.LagKister("gjenstander.txt");
                spiller = new Spiller(grensesnitt, terreng.hentStart());
                spillere[i] = spiller;
            }
            else if(stedValg == 2){
                terreng = new VeiValgTerreng();
                terreng.leggTilSteder();
                terreng.leggTilNeste();
                terreng.LagKister("gjenstander.txt");
                spiller = new VeiValgSpiller(grensesnitt, terreng.hentStart());
                spillere[i] = spiller;
            }
            

            System.out.println("Spillernavn: ");
            String navn = les.nextLine();
            spiller.leggTilNavn(navn);
        }
            
        for(int i = 0; i < terreng.hentStoerrelse(); i++){
            for(Spiller spilleren: spillere){
            spilleren.nyttTrekk();
            }
        }
        for(Spiller spilleren: spillere){
        System.out.println("\nSpillet er ferdig!\n" + spilleren.hentNavn() + " sin Formue: " + spilleren.hentFormue()+ " kr \n");
        }
    }
}