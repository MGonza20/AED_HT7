/**
 * @reference Alonso, M., 2021. ArbolBinarioBusqueda. [online] GitHub. Available at: <https://github.com/malonso-gt/ArbolBinarioBusqueda>
 *
 * @param <K> llave
 * @param <T> valor
 */

public class BinarySearchTreeee<K, T> implements IBinaryTreeee<K, T> {

    public Nodoooo<K, T> raiz;
    int _count;
    IComparator<K, T> _keyComparator;
    IKeyCalculator<K, T> _keyCalculator;

    /**
     *
     * @param metodoComparar compara las llaves
     * @param metodoCalcularLlave obtiene el valor de la llave
     */
    public BinarySearchTreeee(IComparator<K, T> metodoComparar, IKeyCalculator<K, T> metodoCalcularLlave) {
        _keyComparator = metodoComparar;
        _keyCalculator = metodoCalcularLlave;
        raiz = null;
        _count = 0;
    }

    /**
     * Añade o inserta nuevo nodo a arbol
     * @param key llave
     * @param value valor
     */
    @Override
    public void Insert(K key, T value) {
        Nodoooo<K, T> _new = new Nodoooo<K, T>(key, value);

        if (raiz == null) {
            raiz = _new;
            _count++;
        } else {
            try {
                InsertAux(raiz, _new);
            } catch(Exception e) {
                //Manejo de exception
            }

        }
    }

    /**
     * Maneja los casos que puedan suceder
     *
     * @param _actual nodo actual
     * @param _new nuevo nodo
     * @throws Exception en caso de que suceda algún error
     */
    private void InsertAux(Nodoooo<K, T> _actual, Nodoooo<K, T> _new) throws Exception{
        if (_actual != null) {

            if (_keyComparator.Compare(_actual._key, _new._key) > 0) { //Entra cuando actual > nuevo Inserta en hijo izquierdo
                if (_actual.hijoIzquierdo == null) { //Puedo insertar en hijo izquierdo
                    _actual.hijoIzquierdo = _new;
                    _count++;
                } else { //Entra cuando no puedo insertar en el hijo izquierdo de actual ya que está ocupado
                    InsertAux(_actual.hijoIzquierdo, _new);
                }
            } else if (_keyComparator.Compare(_actual._key, _new._key) < 0) { //Entra cuando actual < nuevo Inserta en hijo derecho

                if (_actual.hijoDerecho == null) { //Puedo insertar en hijo derecho
                    _actual.hijoDerecho = _new;
                    _count++;
                } else { //Entra cuando no puedo insertar en el hijo derecho de actual ya que está ocupado
                    InsertAux(_actual.hijoDerecho, _new);
                }
            } else {
                throw new Exception("Llaves repetidas");
            }

        }
    }

    @Override
    public T Delete(K key) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     *
     * @param key llave
     * @param value valor de llave
     * @return devuelve valor de llave
     */
    @Override
    public T Find(K key, Nodoooo<K,T> value) {
        // TODO Auto-generated method stub
        T temp = null;


        if (value != null) {

            if((value._key).equals(key)){
                temp = value._value;
            }

            if(temp == (null)){
                temp = Find(key, value.hijoIzquierdo);
            }
            if(temp == (null)){
                temp = Find(key, value.hijoDerecho);
            }

        }

        return temp;
    }

    @Override
    public int Count() {
        return _count;
    }

    @Override
    public boolean IsEmpty() {
        return _count == 0;
    }

    /**
     * Ordena el árbol de forma traversal In Orden
     * @param visitNode visita nodo
     * @param actual nodo actual
     */
    @Override
    public void InOrder(IVisitar<K, T> visitNode, Nodoooo<K, T> actual) {
        if (actual != null) {
            InOrder(visitNode, actual.hijoIzquierdo);

            visitNode.VisitarNodo(actual);

            InOrder(visitNode, actual.hijoDerecho);
        }

    }

}