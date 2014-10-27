package IA;
import DATA.DatasetType;


public class ADALINE<T extends DatasetType> extends Neuro<T> {

	public ADALINE(T[] dataset, double ETA, double limiar) {
		super(dataset, ETA, limiar);

	}

	@Override
	public double predict(T data) {
		double result = w[0];
		for(int i = 1; i < w.length; i ++)
		{
			result += w[i]*data.getAttr(i);
		}
		
		return result;
	}

}
