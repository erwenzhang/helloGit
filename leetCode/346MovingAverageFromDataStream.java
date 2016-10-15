public class MovingAverage {

    /** Initialize your data structure here. */
    int p = 0;
    int[] array;
    int sz;
    double sum;
    int fullSz;
    public MovingAverage(int size) {
        array = new int[size];
        fullSz = size;
    }
    
    public double next(int val) {
        int old = array[p%fullSz];
        array[p%fullSz] = val;
        sum = sum - old + val;
        p++;
        sz++;
        if(sz>fullSz) sz = fullSz;
        return sum/sz;
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
