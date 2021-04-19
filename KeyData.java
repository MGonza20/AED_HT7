public class KeyData<K, T> implements IKeyCalculator<K, T> {

    @Override
    public K GetKey(T value) {
        // TODO Auto-generated method stub
        Info datos = (Info)value;
        return (K)datos.getPalabra();
    }

}