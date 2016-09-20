/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    private char[] buffer = new char[4];
    int bufSize = 0; // the size of characters left in buffer from last time call
    int offSet = 0; // the start of characters in buffer to copy
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n){
        int readBytes = 0;
        boolean eof = false;
        while(!eof&&readBytes<n){
            int sz = (bufSize>0)?bufSize:read4(buffer); 
            if(sz<4&&bufSize==0) eof = true;
            int bytes = Math.min(n-readBytes,sz);
            System.arraycopy(buffer, offSet, buf, readBytes, bytes);
            offSet = (offSet + bytes)%4;
            readBytes += bytes;
            bufSize = sz - bytes;
        }
        return readBytes;
    }
}
