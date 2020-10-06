class Node{
//Lager klassen Node
  private int minnet;
  private int prosessorer;
  //Lager heltall-variabelene minnet og prosessorer i konstruktøren
  public Node(int m, int p){
  //klassen har to parametere som gir minnet og prosessorer verdier
    minnet = m;
    prosessorer = p;
  }

  public int hentMinnet(){
  //Funksjonen returner minnet
    return minnet;
  }
  public int hentProsessorer(){
    //Funksjonen returner prosessorer 
    return prosessorer;
  }
}
