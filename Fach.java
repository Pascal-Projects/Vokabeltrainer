/**
 * @author Pascal
 */
public class Fach
{
    private Node first;
    private Node last;
    private final int Limit;

    public Fach(int pLimit){
        Limit = pLimit;
    }

    public void VokabelHinzufügen(Vokabel pVokabel){
        if(first == null){
            first = new Node(pVokabel);
            last = first;
        } else {
            last.setNext(new Node(pVokabel));
            last = last.getNext();
        }
    }

    public Vokabel getVokabel(int pIndex){
        Node zeiger = first;
        for (int i = 0; i < pIndex - 1; i++) {
            zeiger = zeiger.getNext();
        }
        return zeiger.getVokabel();
    }
}