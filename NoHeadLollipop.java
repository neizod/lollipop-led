import java.util.Scanner;
import java.io.*;

public class NoHeadLollipop {
	public static void main(String[] args) throws IOException {
		int rawData;
		String fileOriginal, fileNoHead;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Original Loillipop LED: ");
		fileOriginal = keyboard.nextLine();
		fileOriginal += ".mlf";
		System.out.print("No Head Loillipop LED: ");
		fileNoHead = keyboard.nextLine();
		fileNoHead += ".txt";
		
		try {
			FileReader rLolli = new FileReader(fileOriginal);
			FileWriter wLolli = new FileWriter(fileNoHead);
			
			//Header Code - no need
			for(int i=1; i<=6; i++) {
				rawData = rLolli.read();
			}

			rawData = rLolli.read();
			while (rawData != -1) {
				wLolli.write(rawData);
				rawData = rLolli.read();
			}
			wLolli.close();
			System.exit(0);
		} catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}