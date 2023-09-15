/**
 * @author Pascal
 */
public class Vokabel implements java.io.Serializable {
    private String Fremdwort;
    private String Uebersetzung;

    public Vokabel(String pFremdwort, String pUebersetzung) {
        Fremdwort = pFremdwort;
        Uebersetzung = pUebersetzung;
    }

    public String getUebersetzung() {
        return Uebersetzung;
    }

    public String getFremdwort() {
        return Fremdwort;
    }
}
