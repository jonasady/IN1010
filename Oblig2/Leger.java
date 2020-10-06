class Leger{
//Klassen tar inn et legenavn(String) og returnerer dette i metoden hentLegeNavn(), samt legger det til toString
  protected String navn;
  Leger(String n){
    navn = n;
  }
  public String hentLegeNavn(){
    return navn;
  }
@Override
public String toString(){
  return  navn;
}
}
