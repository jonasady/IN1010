import java.util.Random;

public class Robot implements Brukergrensesnitt{

    public int beOmKommando(String sporsmaal, String[] alternativer){
        Random r = new Random();
        int tilfeldigValg = r.nextInt(alternativer.length);
        System.out.println(sporsmaal);

        int teller = 1;
        for(String alternativ: alternativer){
            System.out.println(teller + ". " + alternativ);
            teller++;
        }

        return tilfeldigValg + 1;
    }
    public void giStatus(String status){
        System.out.println(status);
    }
}