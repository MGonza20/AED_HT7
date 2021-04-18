/**
 * @reference: Alonso, M., 2021. ArbolBinarioBusqueda. [online] GitHub. Available at: <https://github.com/malonso-gt/ArbolBinarioBusqueda>
 *
 * @param <K> llave
 * @param <T> Valor de la llave
 *
 */

public class Association<K, T> implements IComparator<K,T> {

    @Override
    public int Compare(K key1, K key2) {

        String uno = (String)key1;
        String dos = (String)key2;
        return uno.compareTo(dos);
    }

}