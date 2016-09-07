class PeekingIterator implements Iterator<Integer>{
    int next;
    Iterator<Integer> iterator;
    boolean hasNext;
    public PeekingIterator(Iterator<Integer> iterator){
        // initialize any member here.
        this.iterator = iterator;
        if(this.iterator.hasNext()){
            next = this.iterator.next();
            hasNext = true;
        }else{
            hasNext = false;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek(){
        if(hasNext){
            return next;
        }else{
            return null;
        }
    }

    // hasNext() and next() should behave the same as in the Iterator interface. Override them as needed.
    @Override
    public boolean hasNext(){
        return hasNext;
    }
    @Override
    public Integer next(){
        Integer result = next;
        if(iterator.hasNext()){
            next = iterator.next();
            hasNext = true;
        }else{
            hasNext = false;
        }
        return result;
    }
  }
