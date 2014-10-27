package DATA.Perfume;

import DATA.DatasetType;

public class Perfume extends DatasetType {
	double[] attr;
	String nome;
	int id;
	double desiredValue;
	
	@Override
	public double getAttr(int index) {
		return attr[index];
	}
	
	@Override
	public void setAttr(int index, double attr) {
		this.attr[index] = attr;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Perfume(double[] attr, String nome, int id)
	{
		this.attr = attr;
		this.nome = nome;
		this.id = id;
	}
	
	@Override
	public int getNumAttr() {
		return 29;
	}

	@Override
	public double getDesiredValue() {
		return desiredValue;
	}

	@Override
	public double getAttrRange(int index) {
		return 50;
	}

	@Override
	public void setDesiredValue(double d) {
		desiredValue = d;
	}
}
