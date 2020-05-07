/**
 * @authors Gabriel Islas, Victor Lavalle, Emilio Lara, Eberth Mezeta
 */
package Aplicacion;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LeerArchivo_MIO {

	public static void read() {
		try (Stream<String> stream = Files.lines(Paths.get("programa.mio"))) {
			stream.forEach(a -> Main.Lista.add(a));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
