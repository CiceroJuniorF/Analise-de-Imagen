package Realce;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public  abstract class Realce implements RealceInteface{
	public static final String PATH = "C:/Users/resource/Pictures/Realces";
	private int high, low;
	private String nomeImagemSalva;
	
	
	public Realce(int high, int low, String salvar) {
		this.high = high;
		this.low = low;
		this.nomeImagemSalva = salvar;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	//Métodos
	@Override
	public int [] mapaDeCores(){
		
		return null;
	}
	
	@Override
	public BufferedImage realce(BufferedImage bmp) {

		int[] mapaDeCores = mapaDeCores();
		// Nova Imageme
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

	@Override
	public void run() throws IOException {
		BufferedImage bmp = ImageIO.read(new File(PATH, "lena.png"));
		// MÃ©todo Para Equalizar a Imagem
		BufferedImage newImage = realce(bmp);
		// Salvando Imagem Resultante
		ImageIO.write(newImage, "png", new File(PATH, this.nomeImagemSalva+".png"));
	}

}
