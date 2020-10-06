import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//Importerer Arraylist, File, FileNotFoundException og Scanner
class Dataklynge{
//Lager klassen Dataklynge med variabelene arraylisten racks, filnavn og plasser i konstruktøren.
  private String filnavn;
  private int plasser = 0;
  private ArrayList<Rack>racks = new ArrayList<>();
  public Dataklynge(String f){
  //klassen tar inn et parameter, her representert som f, hvorav filnavn får f sin verdi.
  //Det kalles i tillegg på metoden lesFraFil()
    filnavn = f;
    lesFraFil();
  }
  public Dataklynge(int p){
  //Tar inn et parameter, representert med p som gir verdi til plasser
    plasser = p;
  }
  public void lesFraFil(){
    //funksjonen lager et filabjekt, her representert med variabelnavnet filen,
    //i tillegg til et scanner-objekt som får verdien null, eller ingenting
    File filen = new File(filnavn);
    Scanner les = null;

    try{
    //Lager et helt nytt scannerobjekt med filen som parameter, hvorav objektet lagres i "les"
      les = new Scanner(filen);
    }
    catch(FileNotFoundException e){
      //Om filen ikke åpnes vil programmet skrive ut "fant ikke filen"
      System.out.println("Fant ikke filen");
    }
    //Går gjennom med scanner(les.nextInt) og finner den første verdien i fila som
    //er hvor mange noder det er plass till per rack. Dette skrives ut med System.out.println
    plasser = les.nextInt();
    System.out.println("Det er " + plasser+ " nodeplasser pr rack\n");

    while(les.hasNextLine()){
    //While løkka forsetter så lenge "les" finner verdier
      int index = 0;
      //Lager en ny lokal int-variabel inni while-løkka
      int ant_noder = les.nextInt();
      //gir heltall variabelen ant_noder verdien av det les finner som neste heltall-verdi(nextInt)
      int minnet = les.nextInt();
      //gir heltall variabelen minnet verdien av det les finner som neste heltall-verdi(nextInt)
      int prosessorer = les.nextInt();
      //gir heltall variabelen prosessorer verdien av det les finner som neste heltall-verdi(nextInt)

      while(index<ant_noder){
      //Lager en while-løkke i den oprinnlige while-løkka som vil gå så lenge index er mindre enn ant_noder
      leggtilNoderiRack(new Node(minnet, prosessorer));
      //Legger til minnet og prosessorer i metoden leggtilNoderiRack som parametere
      index++;
      //plusser på index med en, slik at while-løkka skal gå ut når index har passert ant_noder
    }

    }
  }
  public void leggtilNoderiRack (Node nyNode){
  //Lager metoden leggtilNoderiRack som tar inn et node-objekt som parameter
    for( Rack rack : racks){
    //Går gjennom hver listene i arraylisten racks, som representeres som rack
        if(!rack.fullRack()){
        //Om rack ikke er full vil man legge til nyNode i det bestemte racket
        //ved hjelp av metoden leggtilNode() fra klassen rack
          rack.leggtilNode(nyNode);
          return;
    }
  }
    Rack rack = new Rack(plasser);
    //Lager et nytt Rack objekt når for-løkka utspilles, som får navnet rack, men har
    //ingenting med rack variabelen i for-løkka fordi rack variabelen i for-løkka er
    //en lokal variabel
    rack.leggtilNode(nyNode);
    //Bruker metoden leggtilNode med nyNode som parameter
    racks.add(rack);
    //Legger til lista rack i arraylisten racks
}

public int noderMedNokMinne(int paakrevdMinnet) {
//Lager metoden noderMedNokMinne som tar inn et heltall som parameter, her representert med
//paakrevdMinnet. Metoden går gjennom hver liste i arraylisten racks og plusser på nok_minnet
//om racks verdien oppfyller kravene i metoden sjekkMinnet. Til slutt returneres nok_minnet
  int nok_minnet = 0;
  for(int i = 0; i<racks.size(); i++){
      nok_minnet += racks.get(i).sjekkMinnet(paakrevdMinnet);
  }
  return nok_minnet;
}
public int antProsessorer(){
//Funksjonen går gjennom listene i ArrayListen racks og plusser på ant_prosessorer med den bestemte verdien av racks. Den bestemte verdien
// av racks kjøres gjennom metoden hentProsessorer som returner hvor mange prosessorer som finnes i lista. Til slutt returneres ant_prosessorer.
  int ant_prosessorer = 0;
  for (int i = 0; i<racks.size(); i++){
    ant_prosessorer+= racks.get(i).hentAntProsessorer();
  }
  return ant_prosessorer;
}
public int hentRacks(){
//Funksjonen returner lengden/størrelsen på racks
  return racks.size();
}
}
