import java.util.Scanner;

public class Terminal implements Brukergrensesnitt{
    private Scanner scanner;
    
    Terminal(Scanner s){
        scanner = s;      
    }
    public int beOmKommando(String sporsmaal, String[] alternativer){
        System.out.println(sporsmaal);
        for(int i = 0; i < alternativer.length; i++){
            System.out.println(i+1+ ". " + alternativer[i]);
        }
        
        int valg = Integer.parseInt(scanner.nextLine()); 
        return valg;
    }
    public void giStatus(String status){
        System.out.println(status);
    }
    
}