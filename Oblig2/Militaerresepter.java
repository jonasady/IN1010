class Militaerresepter extends HviteResepter{
//Subklassen gjør om prisen til 0 ved å overskrive prisAaBetale
  Legemiddel legemiddel;
  Militaerresepter(Legemiddel l, Leger le, int p, int r){
    super(l, le, p, r);
    legemiddel = l;
  }
@Override
public double prisAaBetale(){
return 0;
}
}
