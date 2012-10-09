import java.util.Scanner;
import java.io.*;

public class WriteLollipop {
	public static void main(String[] args) throws IOException {
		int frame;
		String fileName;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Write Loillipop LED: ");
		fileName = keyboard.nextLine();
		fileName += ".mlf";

		System.out.print("How many Frame? ");
		frame = Integer.parseInt(keyboard.nextLine());
		
		FileWriter wLolli = new FileWriter(fileName);
		wLolli.write(1);
		wLolli.write(0);
		wLolli.write((char)frame);
		wLolli.write(8211);
		wLolli.write(7);
		wLolli.write(15);
		for(int i=0; i<105; i++){
			wLolli.write(112);
		}
		wLolli.close();
		System.exit(0);
	}
}