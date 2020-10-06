class TestLegemiddel{
  public static void main(String[]args){
    Narkotisk nyttLegemiddel1 = new Narkotisk(2, "Cannabis", 134.99, 2.2);
    Vanedannende nyttLegemiddel2 = new Vanedannende(3, "Morfin", 200.99, 2.2);
    Vanlig nyttLegemiddel3 = new Vanlig("Paracetamol", 99.99, 10);
//Tester hver metode i legemiddel med hjelpemetodene testHeltall, testDouble og testString
//som har for hensikt å ta inn to verdier: en returverdi fra metoder fra Resepter og
//verdien som er forventet at metoden kombinert med referanse fra objektet skal returnere.
//På denne måten sjekker man at alle metodene fungerer og returnerer forventet verdi.

    System.out.println("\nSjekker ID (true/false)");

    System.out.println("Legemiddel1: " + testHeltall(nyttLegemiddel1.hentId(), 1));
    System.out.println("Legemiddel2: " + testHeltall(nyttLegemiddel2.hentId(), 2));
    System.out.println("Legemiddel3: " + testHeltall(nyttLegemiddel3.hentId(), 3));


    System.out.println("\nSjekker navn (true/false)");

    System.out.println("Legemiddel1: " + testString(nyttLegemiddel1.hentNavn(), "Cannabis"));
    System.out.println("Legemiddel2: " + testString(nyttLegemiddel2.hentNavn(), "Morfin"));
    System.out.println("Legemiddel3: " + testString(nyttLegemiddel3.hentNavn(), "Paracetamol"));


    System.out.println("\nSjekker pris (true/false)");

    System.out.println("Legemiddel1: " + testDouble(nyttLegemiddel1.hentPris(), 134.99));
    System.out.println("Legemiddel2: " + testDouble(nyttLegemiddel2.hentPris(), 200.99));
    System.out.println("Legemiddel3: " + testDouble(nyttLegemiddel3.hentPris(), 99.99));


    System.out.println("\nSjekker virkemiddel (true/false)");

    System.out.println("Legemiddel1: " + testDouble(nyttLegemiddel1.hentVirkemiddel(), 2.20));
    System.out.println("Legemiddel2: " + testDouble(nyttLegemiddel2.hentVirkemiddel(), 2.20));
    System.out.println("Legemiddel3: " + testDouble(nyttLegemiddel3.hentVirkemiddel(), 10.00));


    nyttLegemiddel1.settNyPris(200.2);
    nyttLegemiddel2.settNyPris(324.6);
    nyttLegemiddel3.settNyPris(50.4);


    System.out.println("\nSjekker pris etter settNyPris(nypris)(true/false)");

    System.out.println("Legemiddel1: " + testDouble(nyttLegemiddel1.hentPris(), 200.2));
    System.out.println("Legemiddel2: " + testDouble(nyttLegemiddel2.hentPris(), 324.6));
    System.out.println("Legemiddel3: " + testDouble(nyttLegemiddel3.hentPris(), 50.4));


    System.out.println("\nSjekker narkotisk styrke(True/false)");

    System.out.println("Legemiddel1: " + testHeltall(nyttLegemiddel1.hentStyrke(), 2));


    System.out.println("\nSjekker vanedannende styrke(True/false)");

    System.out.println("Legemiddel2: " + testHeltall(nyttLegemiddel2.hentVaneStyrke(), 3)+ "\n");



  //Tester at toString() metoden fungerer
    System.out.println(nyttLegemiddel1.toString()+ "\n");
    System.out.println(nyttLegemiddel2.toString()+ "\n");
    System.out.println(nyttLegemiddel3.toString()+ "\n");


  }
//Her har jeg lagd tre metoder som er ment å ta inn en objektverdi og en verdi
//som representerer hva som er den forventetede returverdien, om de er like
//vil metodene returnere true og om ikke vil de returnere false. Siden alle
//metodene i Legemiddel, Narkotisk, Vanedannende og Vanlig er enten av typen
//int, String eller Double tenkte jeg det var hensiktsmessig og lage en boolean
//metode til hver av typene. Metodene er gjort private fordi de BARE brukes inni
//TestLegemiddel og derfor unødvendig å gjøres public.

  private static boolean testHeltall(int ref_objekt, int forventet){
    return ref_objekt == forventet;
}

  private static boolean testString(String ref_objekt, String forventet){
    return ref_objekt == forventet;
}

  private static boolean testDouble(double ref_objekt, double forventet){
  return ref_objekt == forventet;
}
}
