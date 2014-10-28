package IA;
import java.util.Random;

import DATA.DatasetType;

public abstract class Neuro<T extends DatasetType> {

	protected double[] w;
	T[] dataset;
	double ETA;
	protected double limiar;
	
	public Neuro(T[] dataset, double ETA, double limiar)
	{
		this.ETA = ETA;
		this.dataset = dataset;
		this.limiar = limiar;
		
		w = new double[dataset[0].getNumAttr()];
		Random r = new Random();
		for(int i = 0; i < dataset[0].getNumAttr(); i++)
		{
			//initial value of weights
			w[i] = r.nextDouble();
		}
		
		this.normalizeDataset();
	}
	
	private void normalizeDataset()
	{
		//for each attr of the dataset
		for(int i = 0; i < dataset[0].getNumAttr(); i++)
		{
			//gets the min for every entry
			double min = 0;
			for(int j = 0; j < dataset.length; j++)
			{
				min = Math.min(dataset[j].getAttr(i),min);
			}
			
			for(int j = 0; j < dataset.length; j++)
			{
				double normalized = (dataset[j].getAttr(i) - min) / dataset[j].getAttrRange(i);
				dataset[j].setAttr(i, normalized);
			}
		}
	}
	
	public abstract double predict(T data);
	
	//private double emq()
	
	private double erro(int i)
	{
		double err = 0;
		for(int j = 0; j < dataset.length; j++)
		{
			err += (predict(this.dataset[j]) - this.dataset[j].getDesiredValue()) * this.dataset[j].getAttr(i);
		} 
		err /= w.length;
		return err;
	}
	
	protected void train(double limiar)
	{
		double[] err = new double[w.length];
		double t = 9999;
		
		/*while (t > limiar)
		{*/
		for(int k = 0; k < 100000; k++)
		{
			t = 0;
			for(int i = 0; i < w.length; i ++)
			{
				err[i] = erro(i);
				w[i] = w[i] - (ETA*erro(i));
				err[i] = err[i] - erro(i);
			}
			
			for(int i = 0; i < err.length; i++)
			{
				t += err[i]; 
			}
			//System.out.println("t = " + t);
			
		}
		//}
	}
	
}
