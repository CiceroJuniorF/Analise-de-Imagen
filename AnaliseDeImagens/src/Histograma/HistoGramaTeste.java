package Histograma;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Cicero Junior
 */
public class HistoGramaTeste {

	private static final String PATH = "C:/Users/resource/Pictures";

	int[] calculoHistogramaAcumulado(int[] histograma) {
		int[] histogramaAcumulado = new int[256];
		histogramaAcumulado[0] = histograma[0];
		for (int i = 1; i < histograma.length; i++) {
			histogramaAcumulado[i] = histograma[i] + histogramaAcumulado[i - 1];
		}
		return histogramaAcumulado;
	}

	int[] calculaMapaDeCores(int[] histograma, float pixels) {

		int[] mapaDeCores = new int[256];
		int[] histogramaAcumulado = calculoHistogramaAcumulado(histograma);
		float gk;
		for (int i = 0; i < histograma.length; i++) {
			gk = histogramaAcumulado[i] / pixels;
			mapaDeCores[i] = Math.round(gk * 255);
		}
		return mapaDeCores;
	}

	BufferedImage equalizacao(BufferedImage bmp) {
		// Chamar Métod que calcula o histograma
		int[] histograma = CalculaHistograma.calcula(bmp);
		// Calcular novo mapa de cores;
		int[] mapaDeCores = calculaMapaDeCores(histograma, bmp.getWidth() * bmp.getHeight());
		// Imagem Processada
		BufferedImage out = new BufferedImage(bmp.getWidth(), bmp.getHeight(), BufferedImage.TYPE_INT_RGB);
		// Atuliza palheta de cores da imagem
		for (int y = 0; y < bmp.getHeight(); y++) {
			for (int x = 0; x < bmp.getWidth(); x++) {
				Color color = new Color(bmp.getRGB(x, y));
				Color newColor = new Color(mapaDeCores[color.getRed()], mapaDeCores[color.getGreen()],
						mapaDeCores[color.getBlue()]);
				out.setRGB(x, y, newColor.getRGB());
			}
		}
		// Retorna imagem processada
		return out;
	}

	void run() throws IOException {
		// Carregando Imagem
		BufferedImage bmp = ImageIO.read(new File(PATH, "ventila.png"));
		// Método Para Equalizar a Imagem
		BufferedImage newImage = equalizacao(bmp);
		// Salvando Imagem Resultante
		ImageIO.write(newImage, "png", new File(PATH, "resultEqua.png"));
	}

	public static void main(String[] args) {
		try {
			new HistoGramaTeste().run();
			System.out.println("Imagem criada em: " + PATH);
		} catch (IOException ex) {
			Logger.getLogger(HistoGramaTeste.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
