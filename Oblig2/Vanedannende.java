class Vanedannende extends Legemiddel {
//Subklassen Vanedannende fungerer som legemiddel i tillegg til å ta inn et til parameter- vanestyrke.
//Vanestyrke vil bli returnert i funksjonen hentVaneStyrke, i tillegg til å bli lagt til i en toString()
//metode. 
  protected int vanestyrke;

  public Vanedannende(int v, String navn, double pris, double virkemiddel){
    super(navn, pris, virkemiddel);
    vanestyrke = v;
  }
  public int hentVaneStyrke(){
    return vanestyrke;
  }
  @Override
  public String toString(){
    return super.toString() + "\nVanedannenende styrke: " + vanestyrke;
  }

}
