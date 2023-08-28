/**
 * @author Pascal
 */
public class Vokabel
{
    private String Fremdwort;
    private String Uebersetzung;

    public Vokabel(String pFremdwort, String pUebersetzung)
    {
        Fremdwort = pFremdwort;
        Uebersetzung = pUebersetzung;
    }

    public String getÜbersetzung(){
        return Uebersetzung;
    }

    public String getFremdwort(){
        return Fremdwort;
    }
}
