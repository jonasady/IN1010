import java.util.Scanner;

public class Terminal implements Brukergrensesnitt{
    Scanner scanner;
    Terminal(Scanner s){
        scanner = s;      
    }
    public int beOmKommando(String sporsmaal, String[] alternativer){
        System.out.println(sporsmaal);
        System.out.println("Du har " + alterntiver.length + " alternativ(er)");
        
        int valg = parseInt.Integer(scanner.nextLine()); 
        return valg;
    }
    public void giStatus(String status){
        System.out.println(status);
    }
    
}