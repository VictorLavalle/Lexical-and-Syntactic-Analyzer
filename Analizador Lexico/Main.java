/**
 * @authors Gabriel Islas, Victor Lavalle, Emilio Lara, Eberth Mezeta
 */
package Aplicacion;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Main {
    
//Metodo para ver si ha alguna linea de codigo repetida
public static boolean Repetido(ArrayList<String> l, String test) {
   for(String s: l) {
    if(s.startsWith(test))
    return true;}
    return false;}

//En lugar de usar matrices o vectores, usamos arraylist para hacerlo dinámico
//Declaramos cada uno de ellos, donde le pasamos sus respectivos datos
public static ArrayList<String> Lista = new ArrayList<String>();
public static ArrayList<String> ListaTokens = new ArrayList<String>();
public static ArrayList<String> IDS= new ArrayList<String>();
public static ArrayList<String> TXT= new ArrayList<String>();
public static ArrayList<String> VAL= new ArrayList<String>();

//Main
public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    //Declaramos Variables de Instancia para determinar que hacer si hay algun error en el progama.mio
    boolean hayerror = false;
   String error = "";
   
   LeerArchivo_MIO.read();  //Cargamos el Archivo de programa.mio
   System.out.println("INICIAL");//Para identificar el inicio de la compilacion
   Lista.forEach(System.out::println);//Leemos linea por linea del array Lista que contiene el codigo del progama.mio
   IdentificarTokens.Identificar(Lista);//Aplicamos el metodo para identificar los tokens
   System.out.println("\n___________________________________________");//Separador
   
   //Checamos si hay algun error en el codigo, si no hay, procede sin problema, sino, no deja generar los archivos lex y sim
   for(int i=0; i<ListaTokens.size(); i++) {
    if(ListaTokens.get(i).length()>13) {
        error = ListaTokens.get(i);
        hayerror = true;
        //JOptionPane.showMessageDialog(null, "Error al Compilar", "Error", JOptionPane.WARNING_MESSAGE);
      break;}
      }

   //Si no hay error se generar los archivos .sim y .lex 
      if(!hayerror) {
       ListaTokens.forEach(System.out::println);
       //Creamos el Archivo con extension .lex y le pasamos sus parametros que es la secuencia tokens
       PrintWriter writer = new PrintWriter("programa.lex", "UTF-8");
       ListaTokens.forEach(writer::println);
        writer.close();
        //----------------------------------------------------------------------------------
        //Creamos el archivo con extension .sim
      PrintWriter writer2 = new PrintWriter("programa.sim", "UTF-8");
      //Separamos para cada identifcador
        writer2.println("IDS");
        IDS.forEach(writer2::println);
        writer2.println("");
        writer2.println("TXT");
        TXT.forEach(writer2::println);
         writer2.println("");
         writer2.println("VAL");
         VAL.forEach(writer2::println);
         writer2.println("");
        writer2.close();
       JOptionPane.showMessageDialog(null, "Compilación Exitosa");
         }
      
//En caso de haber un error mandamos un cuadro de advertencia mostrando el error
     else {
      JOptionPane.showMessageDialog(null, "No se Generaron los Archivos. Se Encontró un Error.\n               "+error, "Error", JOptionPane.WARNING_MESSAGE);
      System.out.println("No se generaron los archivos, se encontro un error");
      System.out.println(error);
		}
		
	}}
