/**
 * @reference Alonso, M., 2021. ArbolBinarioBusqueda. [online] GitHub. Available at: <https://github.com/malonso-gt/ArbolBinarioBusqueda>
 * @param <K> llave
 * @param <T> valor de llave
 *
 * Interfaz con método para obtener llave con el valor
 */

public interface IKeyCalculator<K, T> {
    public K GetKey(T value);
}