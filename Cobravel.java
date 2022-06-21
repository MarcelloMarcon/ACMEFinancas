package ACMEFinancas;

public abstract class Cobravel {
	protected int identificador;
	protected String nome;
	protected double valorBase;

	public Cobravel(int identificador, String nome, double valorBase) {
		this.identificador = identificador;
		this.nome = nome;
		this.valorBase = valorBase;
	}

	public abstract double calculaImposto();

	public abstract String toCsv();

	public int getIdentificador() {
		return identificador;
	}

	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValorBase() {
		return valorBase;
	}

	public void setValorBase(double valorBase) {
		this.valorBase = valorBase;
	}
}
