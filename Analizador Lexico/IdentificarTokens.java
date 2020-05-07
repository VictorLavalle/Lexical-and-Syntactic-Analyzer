/**
 * @authors Gabriel Islas, Victor Lavalle, Emilio Lara, Eberth Mezeta
 */
package Aplicacion;

import java.util.ArrayList;

public class IdentificarTokens {
    
    //Declaramos los nombres de las constantes que emplearemos para los token en un enumerado 
 public enum Tokens{
        ID, TEXT, VAL, IGUAL, OPARIT, OPRELAC;
    }
    
 //Declaramos los Simbolos que va a reconocer  del codigo programa.mio
private static String operadoresAritmeticos[] = {"+", "-", "*", "/"};
private static String operadoresRelacionales[] = {">", "<", "=="};
private static String palabrasReservadas[] = {"PROGRAMA", "FINPROG", "SI", "ENTONCES","SINO", "FINSI", "REPITE", "VECES", "FINREP", "IMPRIME","LEE"};
        
 //Metodo Para Identificar los Tokens del programa.mio e irlos metiendo a los arraylist
public static void Identificar(ArrayList<String> Lista ) {
    
    for(String s: Lista) {//Leemos Linea por Linea del programa.mio
        
        //Buscamos comentarios
        //Si la linea empieza con # y tiene menos de 100 caracteres sin tomar en cuenta el # va a proceder
    if(s.startsWith("#"))
         if(s.length()<102)
	continue;
                  else
                  Main.ListaTokens.add("Comentario Muy Largo. Linea: "+Lista.indexOf(s));
	if(s.contains("\"")) {
	    System.out.println(s);	
	    s=s.substring(0, s.indexOf("\""))+s.substring(s.indexOf("\"")).replaceAll("\\s+","");
	   System.out.println(s);
	}
       //Separamos las cadenas que se van leyendo, identificando que tipo de identificador es
            String[] splited = s.split(" ");	
            outter:for(String cadenaDividida: splited) {
                
                 //-----------------------------------------------------------------------	  
                 for(String ar: operadoresAritmeticos) {
	if(cadenaDividida.equals(ar)) {
	   Main.ListaTokens.add(Tokens.OPARIT.name());
	   continue outter;}
	}
	//-----------------------------------------------------------------------				
	for(String rel: operadoresRelacionales) {
	  if(cadenaDividida.equals(rel)) {
	     Main.ListaTokens.add(Tokens.OPRELAC.name());
	     continue outter;}
                  }
	//-----------------------------------------------------------------------			
	for(String res: palabrasReservadas) {
	    if(cadenaDividida.equals(res)) {
	      Main.ListaTokens.add(res);
	       continue outter;}
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	if(Es_ID(cadenaDividida)) {
                      if(cadenaDividida.length()<17)
                         Main.ListaTokens.add(Tokens.ID.name());
                       else
                           Main.ListaTokens.add("Identificador Muy Largo. Linea: "+Lista.indexOf(s));
                      
                  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                  
	if(!Main.Repetido(Main.IDS, cadenaDividida))
	     Main.IDS.add(cadenaDividida+", ID"+(Main.IDS.size()+1));
	     continue outter;}
        
                  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                  
	if(Es_Literal(cadenaDividida)) {
	    Main.ListaTokens.add(Tokens.TEXT.name());
	    if(!Main.Repetido(Main.TXT, cadenaDividida))
	          Main.TXT.add(cadenaDividida+", TX"+(Main.TXT.size()+1));
	             continue outter;}
        
                  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////      
                  
	if(Es_LitNum(cadenaDividida)) {
                        Main.ListaTokens.add(Tokens.VAL.name());
                       if(!Main.Repetido(Main.VAL, cadenaDividida))
	            Main.VAL.add(cadenaDividida+", "+Integer.parseInt(cadenaDividida.substring(2),16));
		continue outter;}
        
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
                  if(cadenaDividida.equalsIgnoreCase("=")) {
	     Main.ListaTokens.add(Tokens.IGUAL.name());
                          continue outter;}
                  
            Main.ListaTokens.add("Token no identificado: Linea " + Lista.indexOf(s));
			}
            
		}
	}
//---------------------------------------------------------------------------------------------------------------------
//Metodos Para Identificar que tipo de IDentificador es en el código 
public static boolean Es_ID(String s) {
    if(s.matches("[A-Za-z][A-Za-z0-9]+")) { return true;}
     return false;}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public static boolean Es_Literal(String s) {
   if(s.matches("\""+"[A-Za-z0-9]+"+"\"")) {return true;}
       return false;}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public static boolean Es_LitNum(String s) {
    if(s.matches("0x"+"[A-Za-z0-9]+")) {return true;}
       return false;}

}
