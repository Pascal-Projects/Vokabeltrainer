import java.util.Scanner;
/**
 * @author Pascal
 */
public class Vokabeltrainer {

    private final Fach[] Fächer = new Fach[5];
    private final int letzteEingabe;

    public Vokabeltrainer() {
        Fächer[0] = new Fach(99999999);
        for (int i = 1; i < 5; i++) {
            Fächer[i] = new Fach(i * 20);
        }
        
        Scanner scanner = new Scanner(System.in);


        letzteEingabe = -1;
        while (letzteEingabe != 0){
            einlesen(scanner);
        }
    }

    public void VokabelAnlegen(Scanner pScanner) {
        System.out.println("Fremdwort eingeben");
        String fremdwort = pScanner.nextLine();
        System.out.println("Übersetzung eingeben");
        String uebersetzung = pScanner.nextLine();
        Fächer[0].VokabelHinzufügen(new Vokabel(fremdwort, uebersetzung));
    }
    
    public void einlesen(Scanner pScanner){
        
    }
}