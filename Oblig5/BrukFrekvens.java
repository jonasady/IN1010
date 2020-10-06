import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BrukFrekvens{
public static void main(String[]args){
    Scanner les = null;
    String filnavn = null;
    File fil = null;

    if(args.length > 0){
        filnavn = args[0];
    }

    try{
    fil = new File(filnavn);
    les = new Scanner(fil);
    System.out.println("Fant filen");
    }

    catch(FileNotFoundException e){
        System.out.println("Fant ikke filen");
    }
    int teller = 0;
    String array[] = new String[1000]; 
    String ord;
    while(les.hasNextLine()){
        ord = les.nextLine();
        array[teller] = ord;
        teller++;
    }
    String array2[] = new String[teller];
    for(int i = 0; i < teller; i++){
        array2[i] = array[i];
    }
    Frekvens f = new Frekvens(array2);
    f.finnFlest();
    System.out.println("Ord som er mest nevnt: " + f.hentFlest());
    System.out.println("Antall ganger : " + f.hentAntall());
    }
}