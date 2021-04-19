public class Visitar<K, T> implements IVisitar<K, T>{

    @Override
    public void VisitarNodo(Nodoooo<K, T> arbol) {

        Info datos = (Info)arbol._value;
        System.out.println("Inglés: " + datos.getIngles() + " Español: " + datos.getEsp() + " Francés: " + datos.getFrances());
    }

}