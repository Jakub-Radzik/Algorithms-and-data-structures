public abstract class ArrayWithHashing implements Tab{
    private int tries = 0;
    public int getTries() {
        return tries;
    }
    public void setTries(int tries) {
        this.tries = tries;
    }

    protected static final int SIZE = 30;
    Node[] tab;
    public ArrayWithHashing(int SIZE) {
        this.tab = new Node[SIZE];
    }
    public ArrayWithHashing() {
        tab = new Node[SIZE];
    } //WITH SIZE = 30

    public int hash(int key) {
        return ((key%8)+key/3)%tab.length;
    }
    public int hash2(int key) {
        return (key*5)+2 % tab.length;
    }
    public int put(int k, int v) throws Exception{
        int hash = hash(k);
        int i = 0;
        if (tab[hash] == null) {
            tab[hash] = new Node(k,v);
        } else {
            while (tab[getOffset(i, hash)] != null) {

                if (tab[getOffset(i, hash)].getKey() == k) {
                    int temp = tab[getOffset(i, hash)].getValue();
                    tab[getOffset(i, hash)].setValue(v);
                    setTries(i);
                    return temp;
                }
                if (size() == tab.length)
                    throw new Exception("Array full");
                i++;
            }
            tab[getOffset(i, hash)] = new Node(k,v);
        }
        setTries(i);
        return -1;
    }
    public int get(int k) throws Exception{
        int hash = hash(k);
        int i = 0;

        if(tab[hash]!=null && tab[hash].getKey()==k){
            setTries(i);
            return tab[hash].getValue();
        }

        while (tab[getOffset(i, hash)] != null && tab[getOffset(i, hash)].getKey() != k) {
            if(i>tab.length){
                setTries(i);
                return -1;
            }
            i++;
        }
        setTries(i);

        if(tab[getOffset(i, hash)]!=null){
            return tab[getOffset(i, hash)].getValue();
        }else{
            return -1;
        }

    }
    public int size() {
        int c = 0;
        for (int i = 0; i < tab.length; i++) {
            if(tab[i]!=null){
                c++;
            }
        }
        return c;
    }
    public boolean isEmpty() {
        for(int i = 0; i < tab.length; i++) {
            if(tab[i]!=null){
                return false;
            }
        }
        return true;
    }
    public void resize(int newSize) {
        Node[] newTab = new Node[newSize];
        for (int i = 0; i < tab.length && i<newTab.length; i++) {
            newTab[i] = tab[i];
        }
        tab = newTab;
    }
    public void dump() {
        System.out.print('[');
        for (int i = 0; i < tab.length; i++) {
            if(tab[i]==null){
                System.out.print("[X,X] , ");
            }else{
                System.out.print("["+tab[i].getKey()+":"+tab[i].getValue()+"], ");
            }
        }
        System.out.println("]");
    }
    public int getOffset(int i, int hash){
        return 0;
    }
    @Override
    public boolean containsKey(int key) {
        int hash = hash(key);
        for (int i = hash; i < tab.length; i++) {
            if(tab[i]!=null && tab[i].getKey()==key){
                return true;
            }
        }
        return false;
    }
}
