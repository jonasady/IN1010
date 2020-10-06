
class Hovedprogram{
public static void main(String[] args){
//Jeg har også tatt inn bruk() metoden for å sjekke om resepten er gydlig, i og med at oppgaven ba om relevant informasjon tenkte jeg dette var
//hensiktsmessig å "bruke" resepten en gang, i tillegg vite om resepten er gyldig eller ikke.

//I tillegg til å kalle på den opprinnlige prisen i toString() har jeg lagt til prisen med rabatt som følger om resepten er av subklasse
//Militaerresepter, HviteResepter, BlaaResept eller Presepter.

    BlaaResept resept1 = new BlaaResept(new Narkotisk(3, "Amfetamin", 1000.99, 2.2), new Spesialister("Johan Hansen", 23), 3 , 5);
    System.out.println("\n" + resept1.toString());
    System.out.println(resept1.farge()+"resept");
    System.out.println("Pris m/rabatt: " +resept1.prisAaBetale());
    System.out.println("Gyldig: " + resept1.bruk()+ "\n");

    Militaerresepter resept2 = new Militaerresepter(new Vanedannende(2 , "Morfin" , 559.99 , 5.4), new Leger("Heidi Nilsen"), 2, 4);
    System.out.println(resept2.toString());
    System.out.println(resept2.farge()+"resept");
    System.out.println("Pris m/rabatt: " +resept2.prisAaBetale());
    System.out.println("Gyldig: " + resept2.bruk()+ "\n");

    Presepter resept3 = new Presepter(new Vanlig("Paracetamol", 200, 10.5), new Leger("Anne-Karin Nordmann"), 5);
    System.out.println(resept3.toString());
    System.out.println(resept3.farge()+"resept");
    System.out.println("Pris m/rabatt: " +resept3.prisAaBetale());
    System.out.println("Gyldig: " + resept3.bruk()+ "\n");


  }
}
