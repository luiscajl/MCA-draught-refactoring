package es.urjccode.mastercloudapps.adcs.draughts.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console {

	private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

	public String readString(String title) {
		this.write(title);
		String input = "";
		try {
			input = bufferedReader.readLine();
		} catch (IOException ex) {
			this.writeError("de cadena de caracteres");
		}
		return input;
	}

	public int readInt(String title) {
		this.write(title);
		int input = 0;
		try {
			input = Integer.parseInt(bufferedReader.readLine());
		} catch (NumberFormatException ex) {
			this.writeError("entero");
		} catch (IOException ex) {
			this.writeError("de cadena de caracteres");
		}
		return input;
	}

	public char readChar(String title) {
		this.write(title);
		char c = ' ';
		try {
			c = (char) bufferedReader.read();
		} catch (IOException ex) {
			this.writeError("caracter");
		}
		return c;
	}

	public void writeln() {
		System.out.println();
	}

	public void write(String string) {
		System.out.print(string);
	}

	public void writeln(String string) {
		System.out.println(string);
	}

	private void writeError(String formato) {
		System.out.println("ERROR DE FORMATO! " + "Introduzca un valor con formato " + formato + ".");
	}
}
