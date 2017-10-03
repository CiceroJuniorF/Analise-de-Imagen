package Realce;

public class RealceExponencial extends Realce {



	public RealceExponencial(int high, int low, String salvar) {
		super(high, low, salvar);
	}

	@Override
	public int[] mapaDeCores() {
		double scale1 = Math.log10(256.0) / 255.0;
		double a, b;
		int[] colorTable = new int[256];
		
		a = Math.exp(scale1 * getLow()) - 1.0;
		b = Math.exp(scale1 * getHigh()) - 1.0;
		double scale2 = 255.0 / (b - a);
		int intVal;
		for (int i = 0; i < 256; ++i) {
			if (i <= getLow())
				colorTable[i] = 0;
			else if (i > getHigh())
				colorTable[i] = 255;
			else {
				intVal = (int) (Math.round(scale2 * (Math.exp(scale1 * i) - 1.0 - a)));
				if (intVal > 255)
					intVal = 255;
				if (intVal < 0)
					intVal = 0;
				colorTable[i] = (byte) intVal;
			}
		}

		return colorTable;
	}

}
