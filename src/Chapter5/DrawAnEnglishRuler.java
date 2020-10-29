package Chapter5;

public class DrawAnEnglishRuler {
	public static void drawRuler(int nInches, int majorLength) {
		//nInches 幾吋，majorLength 有數字的刻度多少個-
		drawLine(majorLength, 0);
		for (int j = 1; j <= nInches; j++) {
			drawInterval(majorLength - 1);
			drawLine(majorLength, j);
		}
	}
	public static void drawInterval(int centralLength) {
		if (centralLength >= 1) {
			drawInterval(centralLength - 1);
			drawLine(centralLength);
			drawInterval(centralLength - 1);
		}
	}
	public static void drawLine(int tickLength, int tickLabel) {
		for (int j = 0; j < tickLength; j++) {
			System.out.print("-");
		}
		if (tickLabel >= 0) {
			System.out.print(" " + tickLabel);
		}
		System.out.print("\n");
	}
	public static void drawLine(int tickLength) {
 		drawLine(tickLength, -1);
	}
	public static void main(String[] args) {
		drawRuler(2, 4);
	}
}

