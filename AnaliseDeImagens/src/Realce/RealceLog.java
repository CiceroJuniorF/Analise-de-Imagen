package Realce;

public class RealceLog extends Realce {

	public RealceLog(int high, int low, String salvar) {
		super(high, low, salvar);
	}

	@Override
	public int[] mapaDeCores() {
		double a, b;
		double lHigh = Math.log10(getHigh() + 1.0);
		double lLow = Math.log10(getLow() + 1.0);
		double range = lHigh - lLow;
		a = 255.0 / range;
		b = -a * lLow;
		int intVal;
		int[] colorTable = new int[256];
		
		for (int i = 0; i < 256; ++i) {
			if (i <= getLow())
				colorTable[i] = 0;
			else if (i > getHigh())
				colorTable[i] = 255;
			else {
				intVal = (int) (a * Math.log10(i + 1) + b);
				if (intVal > 255)
					intVal = 255;
				if (intVal < 0)
					intVal = 0;
				colorTable[i] = intVal;
			}
		}
		return colorTable;
	}

}
