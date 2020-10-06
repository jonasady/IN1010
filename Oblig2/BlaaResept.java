class BlaaResept extends Resepter{
  Legemiddel legemiddel;
  BlaaResept(Legemiddel l, Leger le, int p, int r){
    //Oppfører seg som superklassen Resepter, bare at den tar og overskriver metoden farge og returnerer "Blaa", i tillegg
    //til å sette ned prisen slik at man betaler 25% av den opprinnlige prisen.
    super(l, le, p , r);
    legemiddel = l;
  }
  @Override
  public String farge(){
    String blaa = "Blaa";
    return blaa;
  }
  @Override
  public double prisAaBetale(){
    double pris = legemiddel.hentPris() * 0.25;
    return pris;
  }

}
