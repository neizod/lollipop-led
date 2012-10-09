import java.util.Scanner;
import java.io.*;

public class MergeHeadLollipop {
	public static void main(String[] args) throws IOException {
		boolean tfBreak;
		int frame, cFrame, nFrame, rawData;
		String fileMergeHead, fileOriginal, data;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Merge Head Loillipop LED: ");
		fileMergeHead = keyboard.nextLine();
		fileMergeHead += ".mlf";
		
		FileWriter wLolli = new FileWriter(fileMergeHead);
		
		System.out.print("How many Frame? ");
		frame = Integer.parseInt(keyboard.nextLine());
		
		wLolli.write(5);
		wLolli.write(0);
		wLolli.write((char)frame);
		wLolli.write(8211);
		wLolli.write(7);
		wLolli.write(15);

		try {
			cFrame = 0;
			while(cFrame < frame) {
				System.out.print("Loillipop LED Filename that you want to Merge: ");
				for( ; ; ) {
					data = keyboard.nextLine();
					data += ".mlf";
					File file = new File(data);
					tfBreak = file.exists();
					if (tfBreak) { break; }		
					System.out.print("File does not Exist. Re-enter Filename: ");
				}
				fileOriginal = data;
				
				FileReader rLolli = new FileReader(fileOriginal);
				
				rawData = rLolli.read();
				rawData = rLolli.read();
				nFrame = rLolli.read();
				cFrame += nFrame;
				if(cFrame > frame) {
					System.out.println("\nNote: Some Frame were missing!");

					rawData = rLolli.read();
					rawData = rLolli.read();
					rawData = rLolli.read();
				
					rawData = rLolli.read();
					for(int i=0; i<105*(frame+nFrame-cFrame); i++) {
						wLolli.write(rawData);
						rawData = rLolli.read();
					}
				} else {
					rawData = rLolli.read();
					rawData = rLolli.read();
					rawData = rLolli.read();
				
					rawData = rLolli.read();
					while (rawData != -1) {
						wLolli.write(rawData);
						rawData = rLolli.read();
					}
				}
			}
			wLolli.close();
			System.exit(0);
		} catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}