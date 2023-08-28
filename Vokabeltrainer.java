import java.util.Scanner;
/**
 * @author Pascal
 */
public class Vokabeltrainer {

    private Fach[] Fächer = new Fach[5];
    private int letzteEingabe;

    private Scanner scanner;

    public Vokabeltrainer() {
        Fächer[0] = new Fach(99999999);
        for (int i = 1; i < 5; i++) {
            Fächer[i] = new Fach(i * 20);
        }

        scanner = new Scanner(System.in);

        System.out.println("Willkommen beim Vokabeltrainer!");

        letzteEingabe = -1;
        while (true) {
            einlesen();
        }
    }

    public void vokabelAnlegen() {
        System.out.println("Fremdwort eingeben");
        String fremdwort = scanner.next();
        System.out.println("Übersetzung eingeben");
        String uebersetzung = scanner.next();
        Fächer[0].VokabelHinzufügen(new Vokabel(fremdwort, uebersetzung));
    }

    public void vokabelnLernen(){
        Node aktuell = Fächer[0].getFirst();
        String antwort;
        do {
            System.out.println("Übersetze diese Vokabel: " + aktuell.getVokabel().getFremdwort());
            antwort = scanner.next();
            if (antwort.equals(aktuell.getVokabel().getÜbersetzung())){
                System.out.println("Richtig!");
            }
            else {
                System.out.println("Falsch!");
            }
            aktuell = aktuell.getNext();
        } while (aktuell != null);
    }
    
    public void einlesen(){
        System.out.println("Was wollen sie tun? \n \n(1) Vokabeln lernen \n(2) Vokabel hinzufügen \n(0) Vokabeltrainer verlassen");
        letzteEingabe = scanner.nextInt();
        if (letzteEingabe == 1 ){
            vokabelnLernen();
        } else if (letzteEingabe == 2) {
            vokabelAnlegen();
        } else if (letzteEingabe == 0) {
            scanner.close();
            System.exit(0);
        } else {
            System.out.println("Ungültige Eingabe");
        }
    }
}