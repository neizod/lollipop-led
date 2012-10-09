public class LogicLollipop {
	final int a = 0;	//No light
	final int b = 16;	//Dimmest light
	final int c = 32;
	final int d = 48;
	final int e = 64;
	final int f = 80;
	final int g = 96;
	final int h = 112;	//Brighest light
	int rawData;
	char outSymbol;
	
	public char easyLook(int rawData) {
		this.rawData = rawData;
		switch(rawData) {
			case a: outSymbol = (char)32; break;
			case b: outSymbol = (char)250; break;
			case c: outSymbol = (char)43; break;
			case d: outSymbol = (char)42; break;
			case e: outSymbol = (char)248; break;
			case f: outSymbol = (char)15; break;
			case g: outSymbol = (char)35; break;
			case h: outSymbol = (char)254; break;			
			default: outSymbol = 'E';
		}
		return outSymbol;
	}
}