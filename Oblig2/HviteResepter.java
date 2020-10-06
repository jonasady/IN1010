abstract class HviteResepter extends Resepter{
//Oppfører seg som superklassen Resepter, bare at den tar og overskriver metoden farge og returnerer "hvit".
    HviteResepter(Legemiddel l, Leger le, int p, int r){
      super(l, le,p, r);
    }
    @Override
    public String farge(){
      String hvit = "Hvit";
      return hvit;
    }

}
