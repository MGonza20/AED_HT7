/**
 * @author Sara Paguaga 20634
 */



import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Info action = new Info();

        // Se crea un nuevo árbol por idioma
        BinarySearchTreeee arbolIngles = new BinarySearchTreeee<String, Info>(new Association<String, Info>(), new KeyData<String, Info>());
        BinarySearchTreeee arbolEsp = new BinarySearchTreeee<String, Info>(new Association<String, Info>(), new KeyData<String, Info>());
        BinarySearchTreeee arbolFrances = new BinarySearchTreeee<String, Info>(new Association<String, Info>(), new KeyData<String, Info>());

        //Archivo .txt diccionario con las palabras correspondientes
        String palabrasTRI = "AsociacionesIdiomas.txt";
        //Archivo .txt de texto a traducir
        String TextoAtraducir = "Texto.txt";

        //Se crea una arraylist
        ArrayList<String> diccionario = action.leerArchivo(palabrasTRI);

        for(String elemento : diccionario) {
            String newString = action.arreglaESPACIOS(elemento);
            String[] lista = newString.split(",");
            arbolIngles.Insert(lista[0], new Info(lista[0], lista[0], lista[1], lista[2]));
            arbolEsp.Insert(lista[1], new Info(lista[1], lista[0], lista[1], lista[2]));
            arbolFrances.Insert(lista[2], new Info(lista[2], lista[0], lista[1], lista[2]));
        }

        ArrayList<String> texto = action.leerArchivo(TextoAtraducir);

        Scanner teclado = new Scanner(System.in);

        System.out.println("BIENVENID@ - WELCOME - BIENVENU\n");
        System.out.println("OPCIONES\n");
        System.out.println("1. Traducir texto\n2. Imprimir árbol en orden");
        String o = teclado.nextLine();

        if(o.equals("1")) {
            //Solicitar idioma origen
            System.out.println("Escoja el idioma origen del texto");
            System.out.println("1. Inglés\n2. Español\n3. Francés");
            String opcion = teclado.nextLine();

            String nuevoTexto = "";

            if(opcion.equals("1")) {
                //Elegir el idioma objetivo
                System.out.println("Escoja el idioma objetivo al que se desea traducir");
                System.out.println("1. Español\n2. Francés");
                String op = teclado.nextLine();

                if(op.equals("1")) {
                    //Se realiza un ciclo for each por cada linea del texto
                    for(String elemento : texto) {
                        String nTexto = "";
                        //Se separan la linea por espacios
                        String[] lista = elemento.split(" ");
                        //Se realiza un ciclo por cada elemento de la lista
                        for(String element : lista) {
                            //Se busca la data en elemento arbol que tiene como raiz elemento inglés
                            String min = action.arreglaESPACIOS(element);
                            Info datosN = (Info)arbolIngles.Find(min, arbolIngles.raiz);
                            //buscar si existe esta raiz en elemento arbol
                            if(datosN != null) {
                                //Se busca en los datos la traducción a español
                                String n = datosN.getEsp();
                                nTexto = nTexto + n + " ";
                            }
                            else {
                                //En caso de no existir se añaden asteriscos para saber que no se puede traducir
                                String n = "*" + element +"*";
                                nTexto = nTexto + n + " ";
                            }

                        }
                        //Se agregar la linea al texto completo
                        nuevoTexto = nuevoTexto + nTexto + "\n";
                    }
                }
                else
                if(op.equals("2")) {
                    //Se realiza un ciclo foreach por cada linea del texto
                    for(String elemento : texto) {
                        String nTexto = "";
                        //Se separa la linea por sus espacios
                        String[] lista = elemento.split(" ");
                        //Se realizaa un ciclo foreach por cada elemento de la lista
                        for(String element : lista) {
                            //Se busca la data en element arbol que tiene como raiz element inglés
                            String min = action.arreglaESPACIOS(element);
                            Info datosN = (Info)arbolIngles.Find(min, arbolIngles.raiz);
                            //Se busca si existe esta raiz en element arbol
                            if(datosN != null) {
                                //Se busca en los datos la traducción a Francés
                                String n = datosN.getFrances();
                                nTexto = nTexto + n + " ";
                            }
                            else {
                                //En caso de no que no este la palabra en el dicconario se añaden asteriscos para saber que no se puede traducir
                                String n = "*" + element +"*";
                                nTexto = nTexto + n + " ";
                            }
                        }
                        //Agregar la linea al texto completo
                        nuevoTexto = nuevoTexto + nTexto + "\n";
                    }
                }
                else {
                    System.out.println("Ingrese correctamente la opción");
                }
            }
            else
            if(opcion.equals("2")) {
                //Se elige el idioma que se desea traducir
                System.out.println("Escoja el idioma que se desea traducir");
                System.out.println("1. Inglés\n2. Francés");
                String op = teclado.nextLine();

                if(op.equals("1")) {
                    //Empezar ciclo for para cada linea del texto
                    for(String elemento : texto) {
                        String nTexto = "";
                        //Separar la linea por sus espacios
                        String[] lista = elemento.split(" ");
                        //Empezar ciclo para cada elemento de la lista
                        for(String element : lista) {
                            //Se busca la data en element arbol que tiene como raiz element Español
                            String min = action.arreglaESPACIOS(element);
                            Info datosN = (Info)arbolEsp.Find(min, arbolEsp.raiz);
                            //buscar si existe esta raiz en element arbol
                            if(datosN != null) {
                                //Buscar en los datos la traducción a inglés
                                String n = datosN.getIngles();
                                nTexto = nTexto + n + " ";
                            }
                            else {
                                //En caso de no existir añadir Asteriscos para saber que no se puede traducir
                                String n = "*" + element +"*";
                                nTexto = nTexto + n + " ";
                            }

                        }
                        //Agregar la linea al texto completo
                        nuevoTexto = nuevoTexto + nTexto + "\n";
                    }
                }
                else
                if(op.equals("2")) {
                    //Empezar ciclo for para cada linea del texto
                    for(String elemento : texto) {
                        String nTexto = "";
                        //Separar la linea por sus espacios
                        String[] lista = elemento.split(" ");
                        //Empezar ciclo para cada elemento de la lista
                        for(String element : lista) {
                            //Se busca la data en element arbol que tiene como raiz element Español
                            String min = action.arreglaESPACIOS(element);
                            Info datosN = (Info)arbolEsp.Find(min, arbolEsp.raiz);
                            //buscar si existe esta raiz en element arbol
                            if(datosN != null) {
                                //Buscar en los datos la traducción a Frances
                                String n = datosN.getFrances();
                                nTexto = nTexto + n + " ";
                            }
                            else {
                                //En caso de no existir añadir Asteriscos para saber que no se puede traducir
                                String n = "*" + element +"*";
                                nTexto = nTexto + n + " ";
                            }

                        }
                        //Agregar la linea al texto completo
                        nuevoTexto = nuevoTexto + nTexto + "\n";
                    }
                }
                else {
                    System.out.println("Digite correctamente la opción");
                }
            }
            else
            if(opcion.equals("3")) {
                //Elegir el idioma objetivo
                System.out.println("Escoja el idioma objetivo al que se desea traducir");
                System.out.println("1. Inglés\n2. Español");
                String op = teclado.nextLine();

                if(op.equals("1")) {
                    //Empezar ciclo for para cada linea del texto
                    for(String elemento : texto) {
                        String nTexto = "";
                        //Separar la linea por sus espacios
                        String[] lista = elemento.split(" ");
                        //Empezar ciclo para cada elemento de la lista
                        for(String element : lista) {
                            //Se busca la data en element arbol que tiene como raiz element francés
                            String min = action.arreglaESPACIOS(element);
                            Info datosN = (Info)arbolFrances.Find(min, arbolFrances.raiz);
                            //buscar si existe esta raiz en element arbol
                            if(datosN != null) {
                                //Buscar en los datos la traducción a ingles
                                String n = datosN.getIngles();
                                nTexto = nTexto + n + " ";
                            }
                            else {
                                //En caso de no existir añadir Asteriscos para saber que no se puede traducir
                                String n = "*" + element +"*";
                                nTexto = nTexto + n + " ";
                            }

                        }
                        //Agregar la linea al texto completo
                        nuevoTexto = nuevoTexto + nTexto + "\n";
                    }
                }
                else
                if(op.equals("2")) {
                    //Empezar ciclo for para cada linea del texto
                    for(String elemento : texto) {
                        String nTexto = "";
                        //Separar la linea por sus espacios
                        String[] lista = elemento.split(" ");
                        //Empezar ciclo para cada elemento de la lista
                        for(String element : lista) {
                            //Se busca la data en element arbol que tiene como raiz element frances
                            String min = action.arreglaESPACIOS(element);
                            Info datosN = (Info)arbolFrances.Find(min, arbolFrances.raiz);
                            //buscar si existe esta raiz en element arbol
                            if(datosN != null) {
                                //Buscar en los datos la traducción a español
                                String n = datosN.getEsp();
                                nTexto = nTexto + n + " ";
                            }
                            else {
                                //En caso de no existir añadir Asteriscos para saber que no se puede traducir
                                String n = "*" + element +"*";
                                nTexto = nTexto + n + " ";
                            }

                        }
                        //Agregar la linea al texto completo
                        nuevoTexto = nuevoTexto + nTexto + "\n";
                    }
                }
                else {
                    System.out.println("Ingrese correctamente la opción");
                }
            }
            else {
                System.out.println("Ingrese la opción correctamente");
            }

            System.out.println("Texto traducido: ");
            System.out.println(nuevoTexto);
        }
        else
        if(o.equals("2")) {
            System.out.println("Escoja el idioma que quiera que sea la base del ordenamiento");
            System.out.println("1. Ingles\n2. Español\n3. Fránces");
            String opcion = teclado.nextLine();
            if(opcion.equals("1")) {
                arbolIngles.InOrder(new Visitar<String, Info>(), arbolIngles.raiz);
            }
            else
            if(opcion.equals("2")) {
                arbolEsp.InOrder(new Visitar<String, Info>(), arbolEsp.raiz);
            }
            else
            if(opcion.equals("3")) {
                arbolFrances.InOrder(new Visitar<String, Info>(), arbolFrances.raiz);
            }
            else {
                System.out.println("Ingrese correctamente la opción");
            }
        }
        else {
            System.out.println("Ingrese correctamente la opción");
        }
    }
}