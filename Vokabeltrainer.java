import java.util.Scanner;

/**
 * @author Pascal
 */
public class Vokabeltrainer {

    private Fach[] faecher = new Fach[5];
    private int letzteEingabe;

    private Scanner scanner;

    public Vokabeltrainer() {
        faecher[0] = new Fach(99999999);
        for (int i = 1; i < 5; i++) {
            faecher[i] = new Fach(i * 20);
        }

        scanner = new Scanner(System.in);

        System.out.println("Willkommen beim Vokabeltrainer!");

        letzteEingabe = -1;
        while (letzteEingabe != 0) {
            einlesen();
        }
    }

    public void vokabelAnlegen() {
        System.out.println("Fremdwort eingeben");
        String fremdwort = scanner.next();
        System.out.println("Übersetzung eingeben");
        String uebersetzung = scanner.next();
        faecher[0].VokabelHinzufügen(new Vokabel(fremdwort, uebersetzung));
    }

    public void vokabelnLernen() {
        for (int i= 4; i > 0; i--){
            if (faecher[i].isLimitExceeded()){
                fachLernen(i);  
            }
            System.out.println(i);
        }
        if (!faecher[0].isEmpty()){
            fachLernen(0);
        }
    }

    public void fachLernen(int i) {
        String antwort;
        while (faecher[i].getFirst() != null) {
            System.out.println("Übersetze diese Vokabel: " + faecher[i].getFirst().getFremdwort());
            antwort = scanner.next();
            if (antwort.equals(faecher[i].getFirst().getÜbersetzung())) {
                System.out.println("Richtig!");
                if (i != 4) {
                    faecher[i + 1].VokabelHinzufügen(faecher[i].getFirst());
                    faecher[i].deleteFirst();
                }
            } else {
                System.out.println("Falsch!");
                if (i != 4) {
                    faecher[0].VokabelHinzufügen(faecher[i].getFirst());
                    faecher[i].deleteFirst();
                }
            }
        }
    }

    public void einlesen() {
        System.out.println(
                "Was wollen sie tun? \n \n(1) Vokabeln lernen \n(2) Vokabel hinzufügen \n(0) Vokabeltrainer verlassen");
        letzteEingabe = scanner.nextInt();
        if (letzteEingabe == 1) {
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