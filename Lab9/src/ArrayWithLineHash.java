public class ArrayWithLineHash extends ArrayWithHashing{

    public ArrayWithLineHash(int SIZE) {
        super(SIZE);
    }
    public ArrayWithLineHash() {
    }

    @Override
    public int getOffset(int i, int hash) {
        return (hash+i)%(tab.length);
    }

}
