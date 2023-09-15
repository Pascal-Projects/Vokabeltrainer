/**
 * @author Pascal
 */

public class Fach implements java.io.Serializable {
    private Queue<Vokabel> vokabeln;

    private int limit;
    private int counter;

    public Fach(int pLimit) {
        limit = pLimit;
        vokabeln = new Queue<>();
    }

    public void VokabelHinzufuegen(Vokabel pVokabel) {
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

    public Queue<Vokabel>.QueueNode getFirstNode() {
        return vokabeln.first();
    }

    public boolean isLimitExceeded() {
        return counter >= limit;
    }

    public boolean isEmpty(){
        return getFirst() == null;
    }
}