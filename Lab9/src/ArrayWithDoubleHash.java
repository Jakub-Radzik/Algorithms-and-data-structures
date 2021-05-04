public class ArrayWithDoubleHash extends ArrayWithHashing{
    private int temporaryKey = 0;
    public ArrayWithDoubleHash(int SIZE) {
        super(SIZE);
    }
    public ArrayWithDoubleHash() {
    }
    public int hash(int i) {
        temporaryKey = i;
        return super.hash(i);
    }
    @Override
    public int hash2(int i){
        return (i%49)+(i/5)+i*5;
    }
    public int getOffset(int i, int hash) {
        return (((hash+(i*hash2(temporaryKey)))%tab.length)+tab.length)%tab.length;
    }

}
