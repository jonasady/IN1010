import java.util.Random;

public class Robot implements Brukergrensesnitt{
    public int beOmKommando(String sporsmaal, String[] alternativer){
        Random r = new Random();
        int tilfeldigValg = r.nextInt(alternativer.length);
        return tilfeldigValg;
    }
    public void giStatus(String status){
        System.out.println(status);
    }
}