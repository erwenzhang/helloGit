public boolean canMeasureWater(int x, int y, int z) {
        if(x+y<z) return false;
        if(x==z||y==z||y+x==z) return true;
        return z%GDC(x,y)==0;
    }
    public int GDC(int x,int y){
        while(y!=0){
            int tmp = y;
            y = x%y;
            x = tmp;
        }
        return x;
    }
