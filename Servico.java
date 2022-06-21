package ACMEFinancas;

public class Servico extends Cobravel{
    private String tipo;

    public Servico(int identificador, String nome, double valorBase, String tipo) {
        super(identificador, nome, valorBase);
        this.tipo = tipo;
    }

    @Override
    public double calculaImposto() {
        if(tipo.equals("pessoal")){
            return this.getValorBase() * 15/100;
        } else if (this.getTipo().equals("empresarial")){
            return this.getValorBase() * 30/100;
        }
        return 0;
    }

    @Override
    public String toCsv() {
        return "Serviço;" + identificador + ";" + identificador + ";" + nome + ";" + valorBase + ";" + tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "identificador=" + identificador +
                ", nome='" + nome + '\'' +
                ", valorBase=" + valorBase +
                ", tipo='" + tipo + '\'' +
                "valor de imposto: " + this.calculaImposto() +
                '}';
    }
}
