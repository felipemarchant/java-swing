final class Motor {
	
	private int qtdPist = 0;
	private int potencia = 0;

	public Motor(int qtdPist, int potencia) {
		super();
		this.qtdPist = qtdPist;
		this.potencia = potencia;
	}

	public int getQtdPist() {
		return qtdPist;
	}

	public void setQtdPist(int qtdPist) {
		this.qtdPist = qtdPist;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		String str = "";
		str += "QUANTIDADE DE PISTÕES: " + qtdPist;
		str += "\nPOTENCIA: " + potencia;
		return str;
	}
}
