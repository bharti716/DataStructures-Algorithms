public class readBuffer {

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    int ptr = 0, cap = 1;
    char[] r4 = new char[4];
    public int read(char[] buf, int n) {
        int i = 0;
        while(n > 0){
            if(ptr == 0){
                cap = read4(r4);
                if(cap == 0) return i;
            }
            buf[i++] = r4[ptr++];
            ptr %= cap;
            n--;
        }
        return i;
    }

    private int read4(char[] r4) {
        return 0;
    }
}
