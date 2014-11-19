package DATA.Machine;

import DATA.DatasetType;

public class Machine extends DatasetType {
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

	public Machine(double[] attr, String nome, int id)
	{
		this.attr = attr;
		this.nome = nome;
		this.id = id;
	}
	
	@Override
	public int getNumAttr() {
		return 8;
	}

	@Override
	public double getDesiredValue() {
		return this.attr[7];
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
