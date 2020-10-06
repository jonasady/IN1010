class Stabel<T> extends Lenkeliste<T> {

public Stabel (){
//Referer til superklassen til Stabel<T> - Lenkeliste <T>
  super();
}
protected void leggPaa(T x){
//Kaller på å legge til x. Her er det bare et parameter så man vil
//bruke leggPaa uten pos som parameter.
  leggTil(x);
}

protected T taAv(){
  //Her referer man til å fjerne det siste objektet, i tillegg til å ha
  //minus 1 for at indeksen skal bli riktig.
  int storrelsen = stoerrelse();
  return fjern(storrelsen - 1);
}

}
