package Realce;
import java.awt.image.BufferedImage;
import java.io.IOException;

public interface RealceInteface {
	int [] mapaDeCores();
	
	BufferedImage realce(BufferedImage bmp);
	
	void run() throws IOException;
	
	
}
