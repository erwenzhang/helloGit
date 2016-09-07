import java.util.Iterator;

public class PeekingIterator<E> implements Iterator<E> {
    private final Iterator<E> it;
    private boolean hasPeeked;
    private E peekedElement;

    public PeekingIterator(Iterator<E> iterator){
        it = iterator;
    }

    public E peek(){
        if(!hasPeeked){
            if(it.hasNext()){
                peekedElement = it.next();
                hasPeeked = true;
            }

        }
        return peekedElement;
    }

    public E next(){
        if(hasPeeked){
            hasPeeked = false;
            return peekedElement;
        }else{
            return it.next();
        }
    }

    public boolean hasNext(){
        return hasPeeked||it.hasNext();
    }
}
