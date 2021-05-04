public interface Tab {
    int get(int key) throws Exception;
    int put(int k, int v) throws Exception;
    boolean containsKey(int key);
}
