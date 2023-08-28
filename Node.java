/**
 * @author Pascal
 */
public class Node
{

    private Vokabel vokabel;
    private Node next;

    public Node(Vokabel pvokabel)
    {
        vokabel = pvokabel;
        next = null;
    }

    public Vokabel getVokabel() {
        return vokabel;
    }

    public void setVokabel(Vokabel vokabel) {
        this.vokabel = vokabel;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
