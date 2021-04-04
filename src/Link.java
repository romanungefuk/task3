public class Link<T> {
    private T content;
    private Link<T> next;

    public Link(T content) {
        this.content = content;
    }

    public Link<T> getNext() {
        return next;
    }

    public void setNext(Link<T> next) {
        this.next = next;
    }

    public T getValue() {
        return content;
    }

}
