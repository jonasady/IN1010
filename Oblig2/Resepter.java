abstract class Resepter{
//Klassen tar inn 4 parametere, i tillegg til å ha en IDteller i konstruktøren som er statisk. Dette er fordi denne variabelen skal
//telle oppover og om man så ikke hadde gjort den statisk hadde den begynt på null hver gang klassen kalles. Derfor må man gjøre den
//statisk, slik at programmet "husker" variabelens verdi fra gang til gang og verdien plusses på en, uansett hvilket nytt objekt,
//varianter og subklasser som lages av resepter.

//I tillegg er klassen abstract fordi man skal kunne endre metoder i klassen etter hvilke
//subklasser som lages og endrer på klassen. Samt er også funksjonen farge() og prisAaBetale() abstract
//siden hele "innmaten" av metoden defineres i subklassene.

//I tillegg til metoder som returnerer verdier av reit, legemiddel(funksjonskall) og lege(funksjonskall) sjekker klassen om
//reit erlik eller mindre enn null for å se om resepten er gyldig, om ikke vil metoden returnere false.

//Til slutt legges verdiene i konstruktøren til i toString.
  protected int ID = 0;
  protected Legemiddel legemiddel;
  protected Leger lege;
  protected int reit;
  protected int pasientID;
  protected static int IDTeller;
  public Resepter(Legemiddel l, Leger le, int pasient, int r){
    legemiddel = l;
    lege = le;
    reit = r;
    pasientID = pasient;
    IDTeller ++;
    ID+= IDTeller;
  }

  public int hentId(){
    return ID;
  }

  public String hentLegemiddeliResept(){
    return legemiddel.hentNavn();
  }

  public String hentLege(){
    return lege.hentLegeNavn();
  }


  public int hentReit(){
    return reit;
  }


  public boolean bruk(){
    if (reit>0){
      reit--;
      return true;

    }
    else{
      return false;
    }

  }

  abstract public String farge();

  abstract public double prisAaBetale();

  @Override
  public String toString(){
    return "Resept-ID:" + ID + "\nLege: " + lege + "\nLegemiddel: " + legemiddel + "\nReit: " + reit + "\nPasientID: " + pasientID;
  }

}
