public class Boleto {
    private String codigoDeBarras;
    private double valor;

    public Boleto(String codigoDeBarras, double valor) {
        this.codigoDeBarras = codigoDeBarras;
        this.valor = valor;
    }

    public String getCodigoDeBarras() {
        return codigoDeBarras;
    }

    public double getValor() {
        return valor;
    }
}
