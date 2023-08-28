import java.util.ArrayList;

public class Fach
{
    private ArrayList<Vokabel> Vokabeln = new ArrayList<Vokabel>();
    private int Limit;

    public Fach(int pLimit){
        Limit = pLimit;
    }

    public void VokabelHinzufügen(Vokabel pVokabel){
        Vokabeln.add(pVokabel);
    }

    public Vokabel getVokabel(int pIndex){
        return Vokabeln.get(pIndex);
    }
}