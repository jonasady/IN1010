
public class Lenkeliste<T> implements Liste<T>{
//Lager klassen Lenkeliste<T> med tilhørende grensesnitt Liste<T> i tillegg til klassen Node som tar inn et T element og definerer dette i
//videre i kontruktøren. Det lages variablene noder(type T, verdi gis som parameter i klassen), neste(type Node, verdi null),
//og foerst(type Node, verdi null) i konstruktøren.
public class Node{
  public T noder;
  public Node neste = null;

public Node(T n){
  noder = n;
  }
}
public Node foerst = new Node(null);


  public void sett(int pos, T x){
  //Setter nodene i riktig posisjon ved hjelp av en for-løkke som
  //kjører så lenge posisjonen tilsier. I for-løkka lagges den første noden i noden.neste.
  //Noden legges til slutt inn i listen og riktig posisjon ved hjelp av noden.neste.noder = x.

    if(pos<0 || pos >=stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    Node noden = foerst;
    for(int i = 0; i < pos; i++){
      noden = noden.neste;
    }
    noden.neste.noder = x;
  }

    public void leggTil(T x){
//Legg til sier først om foerst sin neste erlik null vil foreste sin neste naturlig
//nok bli Noden ny. Om ikke vil programmet gå videre og definere Node noden som
//foerst og deretter gå i en while løkke som stopper opp når node.neste== null.
//På denne måten finner man en plass som er ledig. noden.neste blir derfor ny.
//
    Node ny = new Node(x);
    if(foerst.neste == null){
      foerst.neste = ny;
    }
    else{
      Node noden = foerst;

      while(noden.neste != null){
        noden = noden.neste;
          }

      noden.neste = ny;
      }
    }

  @Override
  public T fjern(){
//Metoden fjern gir ugyldig indeks dersom foerst sin neste erlik null. Om ikke vil Node- objektet
//man finner i foerst.neste være Node n. n sin neste vil være lik foerst sin neste, som fjerner et objekt.
//Deretter returnerer man n sin neste.
    if(foerst.neste == null){
      throw new UgyldigListeIndeks(-1);
    }
    else{
      Node nodeFjern = foerst.neste;
      foerst.neste = nodeFjern.neste;
      return nodeFjern.noder;
    }
  }

  public T fjern(int pos){
    //Samme prinsipp som i fjern uten parameter, bare at man tar en if-sjekk om pos(indeksen) er gyldig.
    //Om det ikke er tilfellet vil en for-løkke finne fram til riktig posisjon og deretter
    if(pos<0 || pos >= stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    Node noden = foerst;
    for (int i = 0; i < pos; i++){
      noden = noden.neste;
    }

    Node nodeFjern = noden.neste;
    noden.neste = nodeFjern.neste;

    return nodeFjern.noder;
  }

  public T hent(int pos){
  //Her finner metoden fram til den riktige noden ved å ta inn et int-parameter, pos, hvor det
  //først sjekkes om denne posisjonen er riktig i forhold til lenkelistens lengde. Deretter
  //stopper en for-løkke gjennomgangen av nodene ved n.neste fram til posisjonen, eller indeksen som
  //er gitt. Denne verdien returneres.
    if(pos<0 || pos >= stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }
    Node n = foerst.neste;
    for (int i = 0; i<pos; i++){
      n = n.neste;
    }
    return n.noder;
  }

  public T hentListe(){
    Node n = foerst;
    for(i = 0; i < stoerrelse(); i++){
      n = n.neste;
      return n;
    }
  }

  public int stoerrelse(){
  //metoden stoerrelse går gjennom nodene, ved hjelp av en while-løkke, ved n = n.neste.
  //Metoden stopper dersom verdien erlik null, for da er lista slutt og ingen noder å hente verdi til.
  //En teller plusses med en for hver gang denne itterasjonen skjer, som da returnerer størrelsen.
    int teller= 0;
    Node n = foerst;

    while(n.neste != null){
    teller++;
    n = n.neste;

    }
    return teller;
  }

  @Override
  public void leggTil(int pos, T x){
//Samme prinsipp som leggTil uten pos som parameter, bare at man kjører en for-løkke
//helt til noden er funnet og pos erlik i. Noden noden blir tatt inn for å finne den riktige
//plassen for deretter at nyNode legges til.
    if(pos<0 || pos > stoerrelse()){
      throw new UgyldigListeIndeks(pos);
    }

    if (pos == 0){
      Node noden = new Node(x);
      noden.neste = foerst.neste;
      foerst.neste = noden;
      }

    else{
      Node noden = foerst;
      for (int i = 0; i < pos; i++){
        noden = noden.neste;
        }

      Node nyNode = new Node(x);
      nyNode.neste = noden.neste;
      noden.neste=  nyNode;
      }
  }
}
