class Hovedprogram{
  public static void main(String[]args){
    //Lager en main-metode til Hovedprogram
    Dataklynge nyKlynge = new Dataklynge("dataklynge.txt");
    //Lager en referanse, nyKlynge, til klassen Dataklynge, med "dataklynge.txt" som parameter
    System.out.println("Noder med 32 GB eller mer: " + nyKlynge.noderMedNokMinne(32));
    //Setter sammen klassereferansen med metoden noderMedNokMinne() som sjekker hvor mange noder i
    //arraylisten som har 32 GB minnnet eller mer
    System.out.println("Noder med 64 GB eller mer: "+ nyKlynge.noderMedNokMinne(64));
    //Setter sammen klassereferansen med metoden noderMedNokMinne() som sjekker hvor mange noder i
    //arraylisten som har 64 GB minnnet eller mer
    System.out.println("Noder med 128 GB eller mer: " + nyKlynge.noderMedNokMinne(128)+ "\n");
    //Setter sammen klassereferansen med metoden noderMedNokMinne() som sjekker hvor mange noder i
    //arraylisten som har 128 GB minnnet eller mer
    System.out.println("Totalt antall prosessorer: "+ nyKlynge.antProsessorer());
    //Referer til metoden antProsessorer ut ifra klassereferansen fra Dataklynge- ny-klynge- og printer
    //ut totalt hvor mange prosessorer som finnes
    System.out.println("Totalt antall racks: " + nyKlynge.hentRacks());
    //Returnerer totalt antall racks 
  }
}
