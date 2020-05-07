/**
 * @authors Gabriel Islas, Victor Lavalle, Emilio Lara, Eberth Mezeta
 */
package Aplicacion;

import javax.swing.JOptionPane;

public class Analizador {
    
    //Metodo Para el Proceso de Analizar el .lex
    public static void Analizar() {
        
      /* Como usamos Pilas para analizar, empleamos estas funciones:
          Stack.pop (): extrae un elemento de la pila. Aparece desde la parte superior de la pila y se elimina de la misma.
          Stack.empty (): verifica si una pila está vacía o no. Devuelve verdadero si la pila está vacía o falso en caso comtrario.
          Stack.peek (): se utiliza para  recuperar el primer elemento de la Pila o el elemento presente en la parte superior de la Pila. 
                              El elemento recuperado no se elimina ni elimina de la Pila.
        */
       
        while (!Main.CambiarStack.empty()) {
            switch (Main.CambiarStack.peek()) {
                
                
                  ////////////////////////////////////////////////////////////////////////////
	case "SINO":
	if(Main.StackActual.peek().equals("FINSI"))
	Main.CambiarStack.pop();
	else { Main.error("ERROR DE FINSI");
	         return;}
	break;
        
        
	////////////////////////////////////////////////////////////////////////////
	case "SI":
	Main.CambiarStack.pop();
	if(Main.CambiarStack.peek().equals("COMPARA")) {
	compara();
	Main.StackActual.push("FINSI");
	if(Main.CambiarStack.peek().equals("ENTONCES")) {
	Main.CambiarStack.pop();
	} 
        
                  else {Main.error("Falta ENTONCES, despues de SI");
	        return;}				
	} else {Main.error("Compilación Exitosa");
	         return;
        }
	break;
        
	////////////////////////////////////////////////////////////////////////////		
	case "FINSI":
	Main.CambiarStack.pop();
	if(Main.StackActual.peek().equals("FINSI")) {
	   Main.StackActual.pop();
                  } else {
	Main.error("Error de SI-FINSI");
	       return;
	}
	break;
        
	////////////////////////////////////////////////////////////////////////////	
                case "FINREP":
	   if(Main.StackActual.peek().equals("FINREP")) {
	      Main.CambiarStack.pop();
	      Main.StackActual.pop();}
                       else {
	         Main.error("Error al Compilar el Archivo");}
	break;
        
        
                  ////////////////////////////////////////////////////////////////////////////
	case "REPITE":
	Main.CambiarStack.pop();
	if(Main.CambiarStack.peek().equals("ID")) {
	     Main.CambiarStack.pop();
	    if(Main.CambiarStack.peek().equals("VECES")) {
	         Main.CambiarStack.pop();
	          Main.StackActual.push("FINREP");
	} else {
	Main.error("Error al Compilar el Archivo");}}
                  else {
	Main.error("Error al Compilar el Archivo");}
	break;
        
    
                  ////////////////////////////////////////////////////////////////////////////
	case "PROGRAMA":
	if (Main.StackActual.contains("FINPROG")) {
	      Main.error("Error al Compilar el Archivo");
	 return;
	} else {
	Main.CambiarStack.pop();
	if (Main.CambiarStack.peek().equals("ID")) {
                        Main.CambiarStack.pop();
		if (Main.CambiarStack.peek().equals("IGUAL")) {
	                        Main.error("Error al Compilar el Archivo");}
					}
			Main.StackActual.push("FINPROG");}
	break;
        
        
                 ////////////////////////////////////////////////////////////////////////////
	case "IMPRIME":
	Main.CambiarStack.pop();
	if (Main.CambiarStack.peek().equals("ID") || Main.CambiarStack.peek().equals("TEXT")) {
	       Main.CambiarStack.pop();
	}   else {
	       Main.error("Error al Compilar el Archivo");}
                  break;
                  
                  
                  ////////////////////////////////////////////////////////////////////////////
	case "LEE":
	   Main.CambiarStack.pop();
                     if (Main.CambiarStack.peek().equals("ID")) {
	          Main.CambiarStack.pop();} 
                         else {
	        Main.error("Error al Compilar el Archivo");}
	break;
        
        
                  ////////////////////////////////////////////////////////////////////////////
	case "FINPROG":
	Main.CambiarStack.pop();
	if (Main.StackActual.peek().equals("FINPROG")) {
	Main.StackActual.pop();}
	    else {
                   Main.error("Error Se Encontro Final de Programa Antes de Terminar el Codigo");
	  return;}	
                  break;
                  
	////////////////////////////////////////////////////////////////////////////			
	case "$":
	if (Main.StackActual.peek().equalsIgnoreCase("$"))
	javax.swing.JOptionPane.showMessageDialog(null, "Compilacion Exitosa");
	return;
        
                  ////////////////////////////////////////////////////////////////////////////			
	case "ID":
	Main.CambiarStack.pop();
	if (Main.CambiarStack.peek().equals("IGUAL")) {
	Main.CambiarStack.pop();
                 if (Main.CambiarStack.peek().equals("ID")) {
	       Main.CambiarStack.pop();
	       if (Main.CambiarStack.peek().equals("OPARIT")) {
	              Main.CambiarStack.pop();
	              if (Main.CambiarStack.peek().equals("ID")) {
	                     Main.CambiarStack.pop();
		} else {
	Main.error("Error al Compilar el Archivo");}
	} else {}
                 } else
                 {Main.error("Error al Compilar el Archivo");}} 
                  else {
                  Main.error("Error al Compilar el Archivo");}
	break;
		
        
        default:
         Main.error("Error de Sintaxis");
         return;
	    }
	}
          }


    //Metodo Para Comparar la linea de la Pila
    public static void compara() {
      Main.CambiarStack.pop();
  if (Main.CambiarStack.peek().equals("ID")) {
         Main.CambiarStack.pop();
       if (Main.CambiarStack.peek().equals("OPRELAC")) {
              Main.CambiarStack.pop();
             if (Main.CambiarStack.peek().equals("ID")) {
	   Main.CambiarStack.pop();}
             else {
	Main.error("\"Error al Compilar el Archivo\"");}} 
         else {
            Main.error("\"Error al Compilar el Archivo\"");}
} else {
  Main.error("\"Error al Compilar el Archivo\"");
               }
        }
}
