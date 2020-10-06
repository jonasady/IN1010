class Narkotisk extends Legemiddel {
//Subklassen oppfører seg akkurat som legemiddel i tilegg til å ta inn parameteret styrke(s),
//parameteret blir lagt til i funksjonen hentStyrke() i tillegg til å overrides i toString(),
//dersom subklassen blir brukt.
  protected int styrke;

 Narkotisk(int s, String navn, double pris, double virkemiddel){
    super(navn,pris,virkemiddel);
    styrke = s;

  }
  public int hentStyrke(){
    return styrke;
  }
  @Override
  public String toString(){
    return super.toString() + "\nNarkotisk styrke: " + styrke;
  }
}
