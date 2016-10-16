public class Solution {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length;
        int n = image[0].length;
        int left = binarySearch(image, y, 0, false);
        int right = binarySearch(image, y, n-1, false);
        int top = binarySearch(image, x, 0, true);
        int bottom = binarySearch(image, x, m-1, true);
        return (right-left+1)*(bottom-top+1);
    }
    
    private int binarySearch(char[][] image, int lo, int hi, boolean horizontal) {
        int inc = lo <= hi? 1: -1;
        while((hi-lo)/inc >= 0) {
            int mid = lo+(hi-lo)/2;
            if(isBlack(image, mid, horizontal)) {
                lo = mid+inc;
            } else {
                hi = mid-inc;
            }
        }
        return hi;
    }
    
    private boolean isBlack(char[][] image, int i, boolean horizontal) {
        if(horizontal) {
            if(i<0 || i>=image.length) {
                return false;
            }
            for(int j=0; j<image[0].length; j++) {
                if(image[i][j] == '1') {
                    return true;
                }
            }
        } else {
            if(i<0 || i>=image[0].length) {
                return false;
            }
            for(int j=0; j<image.length; j++) {
                if(image[j][i] == '1') {
                    return true;
                }
            }
        }
        return false;
    }
}
