/**
 * @author Pascal
 */
public class Fach {
    private final Queue<Vokabel> vokabeln;

    private final int limit;
    private int counter;

    public Fach(int pLimit) {
        limit = pLimit;
        vokabeln = new Queue<>();
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
        return counter >= limit;
    }

    public boolean isEmpty(){
        return getFirst() == null;
    }
}