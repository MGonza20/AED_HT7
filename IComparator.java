public interface IComparator<K, T> {
    /**
     * @reference Alonso, M., 2021. ArbolBinarioBusqueda. [online] GitHub. Available at: <https://github.com/malonso-gt/ArbolBinarioBusqueda>
     * Compara dos llaves
     * @param key1 llave 1
     * @param key2 llave 2
     *
     * @return Devuelve 0 si son iguales, 1 si key1 es mayor que key2 (key1 > key2) y -1 de lo contrario (key1 < key2)
     *
     */
    public int Compare(K key1, K key2);
}