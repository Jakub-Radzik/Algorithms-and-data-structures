public class ArrayWithQuadraticHash extends ArrayWithHashing{

    public ArrayWithQuadraticHash(int SIZE) {
        super(SIZE);
    }
    public ArrayWithQuadraticHash() {
    }
    public int getOffset(int i, int hash){
        return (((hash + ((-1^(i-1))*(((i+1)/2))^2))%tab.length)+tab.length )%tab.length;
    }

}
