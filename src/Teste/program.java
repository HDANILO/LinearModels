package Teste;

import DATA.IRIS.Iris;
import DATA.IRIS.IrisFactory;
import DATA.Perfume.Perfume;
import DATA.Perfume.PerfumeFactory;
import IA.Perceptron;

public class program {

	public static void main(String args[])
	{
		/*//Trying for perfum
		Perfume[] pf = PerfumeFactory.getAllPerfume();
		//Setting the training desired value for the class
		pf[0].setDesiredValue(1);
		for(int i = 1; i < pf.length; i++)
		{
			pf[i].setDesiredValue(-1);
		}
		Perceptron<Perfume> p = new Perceptron<Perfume>(pf,1,0.05,false);
		System.out.println("Trying to classify each perfum!");
		for(int i = 0; i < pf.length; i++)
		{
			System.out.println("its a " + pf[i].getNome() + "?" + p.predict(pf[i]));
		}
		System.out.println(pf[0].getNome());	
		*/
		//Trying for Iris
		Iris[] irf = IrisFactory.getAllIris();
		
		//Setting the training desired value for the class
		for(int i = 0; i < irf.length; i++)
		{
			if(irf[i].getNome().compareTo(irf[0].getNome()) == 0)
				irf[i].setDesiredValue(1);
			else
				irf[i].setDesiredValue(-1);
		}
		
		Perceptron<Iris> ip = new Perceptron<Iris>(irf,0.05,0.05,false);
		System.out.println("Trying to classify each perfum!");
		for(int i = 0; i < irf.length; i++)
		{
			System.out.println("its a " + irf[i].getNome() + "?" + ip.predict(irf[i]));
		}
		System.out.println(irf[0].getNome());
	}
}
