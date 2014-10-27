package DATA.Perfume;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class PerfumeFactory {
	

	public static Perfume[] getAllPerfume()
	{
		Perfume[] pf = null;
		String csvFile = PerfumeFactory.class.getResource("/Resource/perfume_data.csv").getPath();
		BufferedReader br = null;
		String cvsSplitBy = ";";
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			StringBuffer fileb = new StringBuffer();
			while (br.ready()) {
				fileb.append(br.readLine() + "\n");
			}
			String file = fileb.toString();
			        // use comma as separator
			String[] line = file.split("\n");
			pf = new Perfume[line.length];
			for(int i = 0; i < line.length; i++)
			{
				String[] item = line[i].split(cvsSplitBy);
				
				double[] d = new double[item.length];
				d[0] = 1;
				for(int aux = 1; aux < item.length; aux++)
				{
					d[aux] = Double.parseDouble(item[aux]);
				}
				pf[i] = new Perfume(d, item[0],i);
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		shuffleArray(pf);
		return pf;
	}
	
	static void shuffleArray(Perfume[] ar)
	  {
	    Random rnd = new Random();
	    for (int i = ar.length - 1; i > 0; i--)
	    {
	      int index = rnd.nextInt(i + 1);
	      // Simple swap
	      Perfume a = ar[index];
	      ar[index] = ar[i];
	      ar[i] = a;
	    }
	  }
}
