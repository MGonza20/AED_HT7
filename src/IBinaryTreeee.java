/**
 * @reference Alonso, M., 2021. ArbolBinarioBusqueda. [online] GitHub. Available at: <https://github.com/malonso-gt/ArbolBinarioBusqueda>
 *
 * @param <K> llave
 * @param <T> valor de la llave
 *
 * Interfaz con métodos para insertar, borrar, encontrar, ordenar In Order Traversal y saber si está vacio o no
 */

public interface IBinaryTreeee<K, T> {

    public void Insert(K key, T value);
    public T Delete(K key);
    public T Find(K key, Nodoooo<K,T> value);
    public int Count();
    public boolean IsEmpty();
    public void InOrder(IVisitar<K, T> visitNode, Nodoooo<K, T> actual);


}