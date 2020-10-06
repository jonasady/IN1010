class Presepter extends HviteResepter{
//Subklassen fungerer som HviteResepter, bare at man legger til en rabatt ved å overskrive prisAaBetale().
//Her kaller man på den opprinnlige prisen i legemiddel.hentPris() og returnerer en ny pris,
//i tillegg til å sette reit til 3, og ikke ta med dette som et parameter, heller sette det som en konstant.
  protected Legemiddel legemiddel;
  Presepter(Legemiddel l, Leger le, int p){
    super(l, le, p,3);
    legemiddel = l;
    }

@Override
public double prisAaBetale(){
  double pris = legemiddel.hentPris() - 108;
  if(pris > 0){
  return pris;
}
else{
  return 0;
}

}

}
