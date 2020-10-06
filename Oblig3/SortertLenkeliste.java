class SortertLenkeliste <T extends Comparable<T>> extends Lenkeliste<T>{
  //SortertLenkeliste extender Lenkeliste i tillegg til å ta inn interface "Comparable". Klassen legger inn
  //elemter i leggTil(T x) i en linka liste.
  public SortertLenkeliste(){
    super();
  }
  @Override
  public void leggTil(T x){
  //Overrider leggTil i superklassen. Her er det mye av de samme som i metoden man finner i superklassen
  //men man har brukt en compareTo-metode som er integert i Java som importeres i starten av klassen.
  //compareTo sørger for at listen kommer i en sotert rekkefølge.
    if (foerst.neste == null){
      foerst.neste = new Node(x);
    }
    else{
      Node noden = foerst;

      while( noden.neste != null && noden.neste.noder.compareTo(x) < 0){
        noden = noden.neste;
    }
    Node nyNode = new Node(x);
    if(noden.neste != null){
      nyNode.neste = noden.neste;
    }
    noden.neste = nyNode;
  }
}
  @Override
  public T fjern(){
    //Fjern-metoden er lik som i Stabel
    int lengden = stoerrelse();
    return fjern(lengden-1);
  }
  @Override
  public void leggTil(int pos, T x){
  //Vil ikke være mulig å bruke metoden leggTil med posisjon OG T x som parameter,
  //dvs. bare leggTil med T x som parameter.
    throw new UnsupportedOperationException("Ugyldig");
  }
  @Override
  public void sett(int pos, T x){
  //Samme som i leggTil vil det kunn være mulig å bruke sett metoden med et parameter
  //T x. Dersom denne Overrida metoden brukes vil den være ugyldig.
    throw new UnsupportedOperationException("Ugyldig");
  }
}
