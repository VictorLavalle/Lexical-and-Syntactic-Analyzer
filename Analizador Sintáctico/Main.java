package Aplicacion;


import java.util.Stack;
import javax.swing.JOptionPane;

public class Main {
                    
                   /*Stack=Pila: Estructura de datos de tipo LIFO
                  (Last In First Out, último en entrar, primero en salir)
                   permite almacenar y recuperar datos.*/
    
	
	public static Stack<String> StackInicial = new Stack<>();
	public static Stack<String> CambiarStack = new Stack<>();
	public static Stack<String> StackActual = new Stack<>();
        
                 //Metodo Para Mostrar Cuadro de Advertencia al No encontrar los archivos necearios o al compilar
	public static void error(String x) {
           javax.swing.JOptionPane.showMessageDialog(null, x); }

                //Main
	public static void main(String[] args) {
                  /*Stack.push (elemento) insertar un elemento en la pila.
                   El elemento se empuja hacia la parte superior de la pila.*/

                  StackActual.push("$");
                  CambiarStack.push("$");
                  
                  //Cargamos el Archivo .Lex
	LeerArchivo_LEX.read();
        
	while (!StackInicial.empty()) {
	if (StackInicial.peek().equals("VAL"))
	CambiarStack.push("ID");
	   else
	       CambiarStack.push(StackInicial.peek());
	          StackInicial.pop();
	}

	CambiarStack.forEach(System.out::println);
	if (CambiarStack.contains("Error"))
	     error("Error lexico");
                    Analizador.Analizar();
	}
}
