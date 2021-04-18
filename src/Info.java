/**
 * @reference Alonso, M., 2021. ArbolBinarioBusqueda. [online] GitHub. Available at: <https://github.com/malonso-gt/ArbolBinarioBusqueda>
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Info {

    private String palabra;
    private String ingles;
    private String esp;
    private String frances;


    public Info(String palabra, String ingles, String esp, String frances) {
        super();
        this.palabra = palabra;
        this.ingles = ingles;
        this.frances = frances;
        this.esp = esp;
    }

    public Info(){

    }

    /**
     * @return the palabra
     */
    public String getPalabra() {
        return palabra;
    }



    /**
     * @param palabra the palabra to set
     */
    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    /**
     * @return the ingles
     */
    public String getIngles() {
        return ingles;
    }

    /**
     * @param ingles the ingles to set
     */
    public void setIngles(String ingles) {
        this.ingles = ingles;
    }

    /**
     * @return the frances
     */
    public String getFrances() {
        return frances;
    }

    /**
     * @param frances the frances to set
     */
    public void setFrances(String frances) {
        this.frances = frances;
    }

    /**
     * @return the esp
     */
    public String getEsp() {
        return esp;
    }

    /**
     * @param esp the esp to set
     */
    public void setEsp(String esp) {
        this.esp = esp;
    }

    public  ArrayList<String> leerArchivo(String nombre) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        ArrayList<String> lista = new ArrayList<String>();

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File (nombre);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null) {
                lista.add(linea);
            }
        }

        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            // En el finally se cierra el fichero, para asegurarse que se cierra tanto si todo va bien
            //  como si salta una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
        return lista;
    }

    public static String arreglaESPACIOS(String string) {
        char[] list = string.toCharArray();
        String nv = "";
        for(char c : list) {
            if(c == ' ') {

            }
            else {
                nv = nv + c;
            }
        }
        //Convertir a minusculas
        nv = nv.toLowerCase();
        return nv;
    }

}