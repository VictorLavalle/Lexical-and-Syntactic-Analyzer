package Aplicacion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import java.util.stream.Stream;

public class LeerArchivo_LEX {
    
    public static void read() {
	try (Stream<String> stream = Files.lines(Paths.get("programa.lex"))) {
	     stream.forEach(a -> Main.StackInicial.push(a));
	} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
		}
	}
}
