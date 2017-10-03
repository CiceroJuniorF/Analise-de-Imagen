package Realce;

public class RealceGamma extends Realce {
	private double gamma;

	public RealceGamma(int high, int low, String salvar, double gamma) {
		super(high, low, salvar);
		this.gamma = gamma;
	}

	@Override
	public int[] mapaDeCores() {

		double gamma = this.gamma;
		double a, b;
		a = Math.pow(getLow(), gamma);
		b = Math.pow(getHigh(), gamma);
		double scale = 255.0 / (b - a);
		int intVal;
		int[] colorTable = new int[256];
		
		for (int i = 0; i < 256; ++i) {
			if (i <= getLow())
				colorTable[i] = 0;
			else if (i > getHigh())
				colorTable[i] = 255;
			else {
				intVal = (int) (Math.round(scale * (Math.pow(i, gamma) - a)));
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
