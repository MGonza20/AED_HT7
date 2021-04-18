public class Nodoooo<K, T> {
    public T _value;
    public K _key;
    public Nodoooo<K, T> hijoIzquierdo;
    public Nodoooo<K, T> hijoDerecho;

    public Nodoooo() {
        hijoIzquierdo = null;
        hijoDerecho = null;
    }

    public Nodoooo(K key, T value) {
        _key = key;
        _value = value;
        hijoIzquierdo = null;
        hijoDerecho = null;
    }
}