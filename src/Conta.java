public class Conta {
    private String NumeroDaConta;
    private double saldo;
    private ChequeEspecial chequeEspecial = new ChequeEspecial();
    private double taxa;
    private double verificador;

    public Conta(String numeroConta, double deposito) {
        this.NumeroDaConta = numeroConta;
        if(deposito <= 500.00) {
            chequeEspecial.setLimiteChequeEspecial(50);
        } else {
            chequeEspecial.setLimiteChequeEspecial(deposito / 2);
        }

        this.saldo = deposito + chequeEspecial.getLimiteChequeEspecial();
    }

    public double getSaldo() {
        return saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial.getLimiteChequeEspecial();
    }

    public String depositar(double dinheiro) {
        this.saldo += dinheiro;

        if(taxa > 0) {
            this.verificador = chequeEspecial.getLimiteChequeEspecial() + taxa;
            if(this.saldo >= verificador){
                //o saldo tem que ser maior que taxa tbm, para eu ter certeza que estou tirando do meu saldo e nao do
                // cheque especial de novo.
                this.saldo -= taxa;

                String string = "Saldo depositado R$ " + dinheiro + " e subtraído taxa de 20% do cheque especial: R$ " + taxa;

                this.taxa = 0;

                return string;

            }
        }

        return "Saldo depositado: R$" + dinheiro;
    }

    public String sacar(double dinheiro) {
        if(this.saldo >= dinheiro && this.saldo <= chequeEspecial.getLimiteChequeEspecial()) {

            this.taxa += dinheiro * 0.2;
            this.saldo -= dinheiro;
            return "Saque aprovado: R$" + dinheiro;
        }
        else if(this.saldo >= dinheiro) {
            this.saldo -= dinheiro;

            if(this.saldo < chequeEspecial.getLimiteChequeEspecial()) {
                double diferenca = chequeEspecial.getLimiteChequeEspecial() - this.saldo;
                this.taxa += diferenca * 0.2;
                return "Saque aprovado: R$" + dinheiro;
            }
            return "Saque aprovado: R$" + dinheiro;
        };

        return "Saldo insuficiente!";
    }

    public String verificarChequeEspecial() {
        if(this.saldo < this.chequeEspecial.getLimiteChequeEspecial()) {
            return "Está usando cheque especial!";
        }
        return "Não está usando cheque especial!";
    }

    public String pagarBoleto(Boleto boleto) {
        if(this.saldo >= boleto.getValor()) {
            this.saldo -= boleto.getValor();
            return "Boleto " + boleto.getCodigoDeBarras() + " no valor de R$" + boleto.getValor() + " pago com " +
                    "sucesso!";
        }
        return "Saldo insuficiente para pagar boleto.";
    }

    public double getTaxa() {
        return taxa;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "NumeroDaConta='" + NumeroDaConta + '\'' +
                ", saldo=" + saldo +
                ", chequeEspecial=" + chequeEspecial.getLimiteChequeEspecial() +
                '}';
    }
}
