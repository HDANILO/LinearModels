package IA;
import DATA.DatasetType;


public class Perceptron<T extends DatasetType> extends Neuro<T>  {

	boolean log = false;
	public Perceptron(T[] dataset, double ETA,double limiar, boolean log) {
		super(dataset, ETA,limiar);
		this.log = log;
		
		//train
		super.train(super.limiar);

	}

	@Override
	public double predict(T data) {
		if (log)
			System.out.println("Trying to predict: " + data.getNome());
		double result = 0;
		for(int i = 0; i < w.length; i ++)
		{
			if (log)
				System.out.print("w[" + i+ "]=" + w[i] +" ");
			result += w[i]*data.getAttr(i);
		}
		if (log)
		{
			System.out.println();
			for(int i = 0; i < w.length; i ++)
			{
				System.out.print("a[" + i+ "]=" + data.getAttr(i) +" ");
			}
			System.out.println("\nresult = " + result);
		}
		
		//função de ativação
		if (result >= 0)
			return 1;
		else
			return -1;
				
	}

}
