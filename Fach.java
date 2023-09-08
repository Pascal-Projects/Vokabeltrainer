/**
 * @author Pascal
 */
public class Fach {
    private Queue<Vokabel> vokabeln;

    private int limit;
    private int counter;

    public Fach(int pLimit) {
        limit = pLimit;
        vokabeln = new Queue<Vokabel>();
    }

    public void VokabelHinzufügen(Vokabel pVokabel) {
        vokabeln.enqueue(pVokabel);
        counter++;
    }

    public void deleteFirst() {
        vokabeln.dequeue();
        counter--;
    }

    public Vokabel getFirst() {
        return vokabeln.front();
    }

    public boolean isLimitExceeded() {
        if (counter >= limit) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty(){
        if (getFirst() == null){
            return true;
        } else {
            return false;
        }
    }
}