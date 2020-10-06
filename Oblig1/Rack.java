class Rack{
  //Lager klassen Rack
  private int ant_noder = 0;
  private Node[] noder;
  private int plasser;
  //Lager variabelene ant_noder, arrayen node som har referanse til klassen til Node
  // i tillegg til plasser
  public Rack (int p){
  //Klassen tar inn et parameter, p, som gir plasser verdi.
  //i tillegg gir man noder, som er en Array, lengden sin fra verdien
  //til parameteret.
    plasser = p;
    noder = new Node [plasser];
  }

  public void leggtilNode(Node nyNode){
  //Lager metoden leggtilNode med Node objektet nyNode som parameter
    noder[ant_noder] = nyNode;
    //Den nye noden legges til i noder, hvor plassen bestemmes av ant_noder som
    //plusses på en hver gang metoden brukes
    ant_noder ++;
  }

  public boolean fullRack(){
  //Lager funksjonen fullRack som vil returnere false eller true ettersom
  //ant_noder, som er tallet på hvor mange noder som har fått plass i arrayen, og
  //lengden på arrayen er like. Om de er like er racken full og funksjonen vil returnere
  //true. Ellers vil funksjonen returnere false.
     if (ant_noder == noder.length){
       return true;
     }
     else{
       return false;
     }
  }

  public int hentAntProsessorer(){
  //Lager funksjonen hentAntProsessorer som går så lenge i ikke er større som
  //lengden på arrayen. Løkka går gjennom hver verdi til noder ved å referere noder[i].
  //Om så en verdi ikke er null, altså en plass i arrayen ikke står tom, vil totalt plusses på
  //verdiens ant_prosessorer ved å refere til funksjonen hentAntProsessorer(). Til slutt returnere
  //funksjonen totalt.
    int totalt = 0;
    for(int i = 0; i<noder.length; i++){
      if(noder[i]!= null){
        totalt += noder[i].hentProsessorer();
      }
    }
    return totalt;
  }

  public int sjekkMinnet(int paakrevdMinnet){
  //Metoden går gjennom verdier i arrayen noder, og om verdien ikke er tom eller
  //minnet er mer eller erlik paakrevdMinnet vil noderMedNokMinne plusses på en.
  //Til slutt returneres noderMedNokMinne 
    int noderMedNokMinne = 0;
    for(int i = 0; i<noder.length; i++){
      if(noder[i]!=null && noder[i].hentMinnet()>=paakrevdMinnet){
        noderMedNokMinne++;
      }
    }
    return noderMedNokMinne;
  }
}
