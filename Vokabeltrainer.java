import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Pascal
 */
public class Vokabeltrainer {

    private Fach[] faecher = new Fach[5];
    private int letzteEingabe;

    private final Scanner scanner;

    public Vokabeltrainer() {
        faecher[0] = new Fach(99999999);
        for (int i = 1; i < 5; i++) {
            faecher[i] = new Fach(i * 20);
        }

        scanner = new Scanner(System.in);

        System.out.println("Willkommen beim Vokabeltrainer!");

        for (int i = 0; i < 5; i++) {
            try {
                File myObj = new File("fächer/fach" + (i + 1) + ".txt");
                if (myObj.createNewFile()) {
                    System.out.println("Datei erstellt: " + myObj.getName());
                }
            } catch (IOException e) {
                System.out.println("Ein Fehler is erstanden:");
                e.printStackTrace();
            }
        }

        laden();

        letzteEingabe = -1;
        while (letzteEingabe != 0) {
            einlesen();
        }
    }

    public void speichern() {
        /* Funktioniert nicht vollständig */
        try {
            for (int i = 0; i < 5; i++) {
                FileWriter fileWriter = new FileWriter("fächer/fach" + (i + 1) + ".txt");
                Queue<Vokabel>.QueueNode current = faecher[i].getFirstNode();
                if (current != null) {
                    do {
                        fileWriter.write(
                                current.getContent().getFremdwort() + "," + current.getContent().getUebersetzung());

                    } while (current.getNext() != null);
                }
                fileWriter.close();
            }
        } catch (Exception e) {
            System.out.println("Speichern fehlgeschlagen");
        }
    }

    public void laden() {
        try {
            for (int i = 0; i < 5; i++) {
                File file = new File("fächer\\fach" + (i + 1) + ".txt");
                Scanner scn = new Scanner(file);
                if (file.length() > 0) {
                    do {
                        String line = scn.nextLine();
                        String[] vokabel = line.split(",");
                        faecher[i].VokabelHinzufuegen(new Vokabel(vokabel[0], vokabel[1]));
                    } while (scn.hasNextLine());
                }
                scn.close();
            }
        } catch (IOException e) {
            System.out.println("Laden fehlgeschlagen");
            e.printStackTrace();
        }
    }

    public void vokabelAnlegen() {
        System.out.println("Fremdwort eingeben");
        String fremdwort = scanner.next();
        System.out.println("Übersetzung eingeben");
        String uebersetzung = scanner.next();
        faecher[0].VokabelHinzufuegen(new Vokabel(fremdwort, uebersetzung));

        speichern();
    }

    public void vokabelnLernen() {
        for (int i = 4; i > 0; i--) {
            if (faecher[i].isLimitExceeded()) {
                fachLernen(i);
            }
        }
        if (!faecher[0].isEmpty()) {
            fachLernen(0);
        }
    }

    public void fachLernen(int i) {
        String antwort;
        System.out.println("Geben sie \"ENDE\" ein um das lernen zu beenden");
        while (faecher[i].getFirst() != null) {
            System.out.println("Übersetze diese Vokabel: " + faecher[i].getFirst().getFremdwort());
            antwort = scanner.next();
            if (antwort.equals(faecher[i].getFirst().getUebersetzung())) {
                System.out.println("Richtig!");
                faecher[i].deleteFirst();
                if (i != 4) {
                    faecher[i + 1].VokabelHinzufuegen(faecher[i].getFirst());
                }
            } else if (antwort.equals("ENDE")) {
                break;
            }
            else {
                System.out.println("Falsch! Die richtige Antwort wäre: " + faecher[i].getFirst().getUebersetzung());
                if (i != 4) {
                    faecher[0].VokabelHinzufuegen(faecher[i].getFirst());
                    faecher[i].deleteFirst();
                }
            }
            speichern();
        }
        speichern();
    }

    public void einlesen() {
        String hauptMenue = "Hauptmenü \n********* \nWas wollen sie tun? \n \n(1) Vokabeln lernen \n(2) Vokabel hinzufügen \n(0) Vokabeltrainer verlassen";
        System.out.println(hauptMenue.replaceAll("[\r]", ""));
        String letzteEingabeString = scanner.next();
        try {
            letzteEingabe = Integer.parseInt(letzteEingabeString);
        } catch (NumberFormatException nfe) {
            letzteEingabe = -1;
        }
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