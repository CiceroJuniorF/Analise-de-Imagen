package Realce;
public class RealceLinear extends Realce{
	


	public RealceLinear(int high, int low, String salvar) {
		super(high, low, salvar);
	}

	@Override
	public int[] mapaDeCores() {
		double a, b;
		int range = getHigh() - getLow();
		a = 255.0 / range;
		b = -a * getLow();
		int intVal;
		int[] colorTable = new int[256];

		for (int i = 0; i < 256; i++) {
			if (i <= getLow())
				colorTable[i] = 0;
			else if (i > getHigh())
				colorTable[i] = 255;
			else {
				intVal =  (int) (a * i + b);
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
