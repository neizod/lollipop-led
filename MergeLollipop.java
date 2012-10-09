import java.util.Scanner;
import java.io.*;

public class MergeLollipop {
	public static void main(String[] args) throws IOException {
		boolean tfBreak;
		int frame, cFrame, nFrame, rawData, checkNum;
		char checkChar;
		String data, fileMerged, fileOriginal, drawPoorMan;
		
		drawPoorMan = ""+(char)201; for(int i=0; i<62; i++) { drawPoorMan += (char)205; } drawPoorMan += (char)187;
		System.out.println(drawPoorMan);
		
		drawPoorMan = ""+(char)186; for(int i=0; i<62; i++) { drawPoorMan += ' '; } drawPoorMan += (char)186;
		System.out.println(drawPoorMan);
		
		System.out.println((char)186+"       LG GD580 Lollipop LED Front Light Merger v.1.1.2       "+(char)186);
		System.out.println((char)186+"  This is Freeware CC by neizod, contact me for Source Code.  "+(char)186);
		System.out.println(drawPoorMan);
		
		drawPoorMan = ""+(char)200; for(int i=0; i<62; i++) { drawPoorMan += (char)205; } drawPoorMan += (char)188;
		System.out.println(drawPoorMan+"\n");

		System.out.println("Note: File create by this program will no longer editable by LG PC Suite.\n");
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("New LG Lollipop LED Front Light Filename: ");
		for( ; ; ) {
			data = keyboard.nextLine();
			tfBreak = true;
			for(int i=0; i<data.length(); i++) {
				if(data.charAt(i) == 34 || data.charAt(i) == 42 || data.charAt(i) == 47 || data.charAt(i) == 58 || data.charAt(i) == 60 || data.charAt(i) == 62 || data.charAt(i) == 63 || data.charAt(i) == 92 || data.charAt(i) == 124) {
					tfBreak = false;
				}
			}
			if (tfBreak) { break; }
			System.out.print("\\ / : * ? \" < > | can not exist in filename ");
		}
		if(data.length()>4) {
			if(data.charAt(data.length() - 4) != '.' || data.charAt(data.length() - 3) != 'm' || data.charAt(data.length() - 2) != 'l' || data.charAt(data.length() - 1) != 'f') {
				data += ".mlf";
			}
		} else {
			data += ".mlf";
		}
		fileMerged = data;
		
		FileWriter wLolli = new FileWriter(fileMerged);
		
		System.out.print("How many Frames for an Animation? ");
		for( ; ; ) {
			data = keyboard.nextLine();
			tfBreak = true;
			try{
				Integer.parseInt(data);
			} catch(NumberFormatException ex) {
				tfBreak = false;
			}			
			if(tfBreak) {
				frame = Integer.parseInt(data);
				if(frame > 0) { break; }
			}
			System.out.print("Please input a Positive Number! ");
		}
		System.out.println("");
		
		wLolli.write(1);
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
					if(data.length()>4) {
						if(data.charAt(data.length() - 4) != '.' || data.charAt(data.length() - 3) != 'm' || data.charAt(data.length() - 2) != 'l' || data.charAt(data.length() - 1) != 'f') {
							data += ".mlf";
						}
					} else {
						data += ".mlf";
					}
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
			System.out.println("\nMerge Compleate!\nTransfer \""+fileMerged+"\" to your Phone manualy using LG PC Suite.\n\nHave fun. ^__^");
			System.out.println("\n\n(press enter to exit) ");
			data = keyboard.nextLine();
			System.exit(0);
		} catch(IOException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}