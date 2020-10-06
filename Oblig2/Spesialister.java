class Spesialister extends Leger implements Godkjenningstiltak{
  //Klassen er en subklasse av leger og tar inn et tilleggsparameter, kontrollID.
  //IDen returneres i en metoden, i tillegg til å legges til i toString
  protected int kontrollID;
  public Spesialister(String n, int k){
    super(n);
    kontrollID = k;
  }
  public int hentKontrollID(){
    return kontrollID;
  }
  @Override
  public String toString(){
    return super.toString() + "\nkontroll-ID: " + kontrollID;
  }
}
