package Histograma;
import java.awt.Color;
import java.awt.image.BufferedImage;

public class CalculaHistograma {
	
	public static int[] calcula(BufferedImage bmp) {
		int[] histograma = new int[256];
		for (int y = 0; y < bmp.getHeight(); y++) {
			for (int x = 0; x < bmp.getWidth(); x++) {
				Color color = new Color(bmp.getRGB(x, y));
				int gray = (color.getRed() + color.getGreen() + color.getBlue()) / 3;
				histograma[gray] += 1;
			}
		}
		return histograma;
	}
	
}
