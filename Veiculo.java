import java.lang.reflect.Method;

abstract class Veiculo {
	
	private String placa;
	private String marca;
	private String modelo;
	private float velocMax;
	private Motor motor;
	private int qtdRodas;
	private String cor;

	public Veiculo(String placa, String marca, String modelo, float velocMax, int qtdRodas, String cor) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.velocMax = velocMax;
		this.cor = cor;
		this.qtdRodas = qtdRodas;
	}
	
	public String getPlaca() {
		return placa;
	}

	public final void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public final void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public final void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getVelocMax() {
		return velocMax;
	}

	public final void setVelocMax(float velocMax) {
		this.velocMax = velocMax;
	}

	public Motor getMotor() {
		return motor;
	}

	public final void setMotor(Motor motor) {
		this.motor = motor;
	}
	
	public final void setMotor(int qtdPist, int potencia) {
		motor = new Motor(qtdPist, potencia);
	}

	protected abstract float calcVel(float velocMax);

	protected abstract float calculaTamanhoCalc(Method method);

	public abstract String getTitle();

	public String getCor() {
		return cor;
	}

	public final void setCor(String cor) {
		this.cor = cor;
	}

	public int getQtdRodas() {
		return qtdRodas;
	}

	public final void setQtdRodas(int qtdRodas) {
		this.qtdRodas = qtdRodas;
	}

	@Override
	public String toString() {
		String str = "";
		str += "PLACA: " + placa;
		str += "\nMARCA: " + marca;
		str += "\nMODELO: " + modelo;
		str += "\nVELOCIDADE MÁXIMA: " + calcVel(velocMax);
		str += motor != null ? "\n"+motor : "";
		return str;
	}


}
