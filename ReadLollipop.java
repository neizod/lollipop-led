import java.util.Scanner;
import java.io.*;

public class ReadLollipop {
	public static void main(String[] args) {
		int rawData, cLine, cFrame;
		char printChar;
		String fileName;
		
		LogicLollipop logicLolli = new LogicLollipop();
		Scanner keyboard = new Scanner(System.in);
		System.out.print("View Loillipop LED: ");
		fileName = keyboard.nextLine();
		fileName += ".mlf";
		
		try {
			FileReader rLolli = new FileReader(fileName);
			
			System.out.print("Header Code = ");
			for(int i=1; i<=6; i++) {
				rawData = rLolli.read();
				System.out.print(rawData+" ");
			}
			System.out.println("\n");
			
			cLine = 0;
			cFrame = 0;
			rawData = rLolli.read();
			while (rawData != -1) {
				printChar = logicLolli.easyLook(rawData);
				System.out.print(printChar+" ");
				rawData = rLolli.read();
				cLine++;
				if(cLine == 7) {
					System.out.println("");
					cLine = 0;
					cFrame++;
					if(cFrame == 15) {
						System.out.println("");
						cFrame = 0;
					}
				}
			}
			System.exit(0);
		} catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}