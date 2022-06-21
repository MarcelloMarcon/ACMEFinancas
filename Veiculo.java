package ACMEFinancas;

public class Veiculo extends Cobravel{
    private String tipo;

    public Veiculo(int identificador, String nome, double valorBase, String tipo) {
        super(identificador, nome, valorBase);
        this.tipo = tipo;
    }

    @Override
    public double calculaImposto() {
        if(this.getTipo().equals("popular")){
            return this.getValorBase() * 5/100;
        } else if (this.getTipo().equals("basico")){
            return this.getValorBase() * 20/100;
        } else if (this.getTipo().equals("esportivo")) {
            return this.getValorBase() * 50/100;
        }
        return 0;
    }

    @Override
    public String toCsv() {
        return "Veiculo;" + identificador + ";" + nome + ";" + valorBase + ";" + tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "identificador=" + identificador +
                ", nome='" + nome + '\'' +
                ", valorBase=" + valorBase +
                ", tipo='" + tipo + '\'' +
                "valor de imposto: " + this.calculaImposto() +
                '}';
    }
}
