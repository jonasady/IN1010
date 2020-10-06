class Legemiddel{
//Klassen tar inn tre parameteret: navn, pris og virkemiddel, i tillegg til å ha ID i konstruktøren, som plusses på
//for hver gang klassen kalles. I tillegg til det har klassen funksjoner som returnerer alle variabelene i konsturktøren,
//i tillegg til en metode kalt settNyPris(double nyPris) som tar inn en pris og gjør instansvariabelen pris om til
//verdien gitt i parameteret til funksjonen. I tillegg overrides alle variablene i konstruktøren uten om ID, inn i toString
//slik at main programmet blir lettere å skrive ut ved å kalle på toString()
protected static int teller_ID = 0;
protected int ID = 0;
protected String navn;
protected double pris;
protected double virkemiddel;
  public Legemiddel(String n, double p, double v){
    navn = n;
    pris = p;
    virkemiddel = v;

    teller_ID ++;
    ID += teller_ID;
  }
  public int hentId(){
    return ID;
  }
  public String hentNavn(){
    return navn;
  }
  public double hentPris(){
    return pris;
  }
  public double hentVirkemiddel(){
    return virkemiddel;
  }
  public void settNyPris(double nyPris){
    pris = nyPris;
  }
  @Override
  public String toString(){
    return navn +  "\npris: " + pris + "\nVirkestoff (mg): " + virkemiddel + "\nLegemiddel ID: "+  ID;
  }
}
