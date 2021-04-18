/**
 * @author Sara Paguaga
 */

import junit.framework.TestCase;

public class Test extends TestCase{

    BinarySearchTreeee arbolIngles = new BinarySearchTreeee<String, Info>(new Association<String, Info>(), new KeyData<String, Info>());
    BinarySearchTreeee arbolEsp = new BinarySearchTreeee<String, Info>(new Association<String, Info>(), new KeyData<String, Info>());
    BinarySearchTreeee arbolFrances = new BinarySearchTreeee<String, Info>(new Association<String, Info>(), new KeyData<String, Info>());

    String dic1 = "house,casa,loger\ndog,perro,chien\nhomework,tarea,devoirs\nwoman,mujer,femme\ntown,pueblo,ville\nyes,si,Oui";
    String tex = "The dog house in town has homework";

    public void testFind() {
        arbolIngles.Insert("house", new Info("house","house","casa","loger"));
        arbolEsp.Insert("casa", new Info("casa","house","casa","loger"));
        arbolFrances.Insert("loger", new Info("loger","house","casa","loger"));
        Info datos1 = (Info)arbolIngles.Find("house", arbolIngles.raiz);
        Info datos2 = (Info)arbolEsp.Find("casa", arbolEsp.raiz);
        Info datos3 = (Info)arbolFrances.Find("loger", arbolFrances.raiz);
        assertEquals(datos1.getFrances(),"loger");
        assertEquals(datos2.getIngles(),"house");
        assertEquals(datos3.getEsp(),"casa");
    }

    public void testInOrder() {
        arbolIngles.Insert("house", new Info("house","house","casa","loger"));
        arbolIngles.Insert("dog", new Info("dog","dog","perro","chien"));
        arbolIngles.Insert("homework", new Info("homework","homework","tarea","devoirs"));
        arbolIngles.InOrder(new Visitar<String, Info>(), arbolIngles.raiz);
    }


}