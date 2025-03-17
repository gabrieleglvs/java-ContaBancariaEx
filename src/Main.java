import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String texto = """
                *****BEM VINDO AO BANCO DIO*****
                CONTA DE NÚMERO 1234-5, ABERTA COM SUCESSO!
                > POR FAVOR, DEPOSITE UM VALOR INICIAL:""";

        System.out.println(texto);
        double deposito = scanner.nextDouble();

        Conta conta1 = new Conta("1234-5", deposito);
        System.out.println("\nDEPOSITO REALIZADO COM SUCESSO, ESSA É A SITUAÇÃO ATUAL DA SUA CONTA: ");
        System.out.println(conta1);

        String sair = "null";
        do {
             texto = """
                \n*****REALIZE UMA OPERAÇÃO*****
                1 - Consultar saldo
                2 - Consultar cheque especial
                3 - Depositar dinheiro
                4 - Sacar dinheiro
                5 - Pagar boleto
                6 - Verificar se a conta está usando cheque especial
                7 - Sair
                """;

             int opcao = 0;

            System.out.println(texto);
            opcao = scanner.nextInt();

             switch (opcao) {
                 case 1:
                     System.out.println("\nSALDO ATUAL");
                     System.out.println(conta1.getSaldo());
                     break;
                 case 2:
                     System.out.println("\nCHEQUE ESPECIAL");
                     System.out.println("---------------");
                     System.out.println(conta1.getChequeEspecial());
                     break;
                 case 3:
                     System.out.println("\nDEPOSITAR DINHEIRO");
                     System.out.println("--------------------");
                     System.out.println("Digite um valor para depósito: ");
                     double depositar = scanner.nextDouble();
                     System.out.println(conta1.depositar(depositar));
                     break;
                 case 4:
                     System.out.println("\nSACAR DINHEIRO");
                     System.out.println("-------------");
                     System.out.println("Digite um valor para saque: ");
                     double sacar = scanner.nextDouble();
                     System.out.println(conta1.sacar(sacar));
                     break;
                 case 5:
                     System.out.println("PAGAR BOLETO");
                     System.out.println("------------");
                     System.out.println("Digite o código do boleto: ");
                     String codigo = scanner.next();
                     System.out.println("Digite o valor do boleto: ");
                     double valor = scanner.nextDouble();
                     Boleto boleto = new Boleto(codigo, valor);
                     System.out.println(conta1.pagarBoleto(boleto));
                     break;
                 case 6:
                     System.out.println("\nVERIFICAR SE ESTÁ USANDO CHEQUE ESPECIAL");
                     System.out.println("----------------------------------------");
                     System.out.println(conta1.verificarChequeEspecial());
                     break;
                 case 7:
                     sair = "sair";
                     break;
                 default:
                     System.out.println("Opção inválida!");
                     break;
             }
        }
        while (!sair.equalsIgnoreCase("sair"));

//        System.out.println("\nVERIFICADO SALDO DA CONTA:");
//        System.out.println(conta1.getSaldo());
//
//        System.out.println("\nCONSULTAR CHEQUE ESPECIAL:");
//        System.out.println(conta1.getChequeEspecial());
//
//        System.out.println("\nDEPOSITAR DINHEIRO:");
//        System.out.println(conta1.depositar(10));
//
//        System.out.println("\nNOVO SALDO DA CONTA:");
//        System.out.println(conta1.getSaldo());
//
//        System.out.println("\nSACAR DINHEIRO:");
//        System.out.println(conta1.sacar(20));
//
//        System.out.println("\nNOVO SALDO DA CONTA:");
//        System.out.println(conta1.getSaldo());
//
//        System.out.println("\nVERIFICAR SE ESTÁ USANDO CHEQUE ESPECIAL:");
//        System.out.println(conta1.verificarChequeEspecial());
//
//        Boleto boleto = new Boleto("12345000", 300);
//
//        System.out.println("\nPAGAR BOLETO: ");
//        System.out.println(conta1.pagarBoleto(boleto));
//
//        System.out.println("\nNOVO SALDO DA CONTA:");
//        System.out.println(conta1.getSaldo());
//
//        System.out.println("\nVERIFICAR SE ESTÁ USANDO CHEQUE ESPECIAL:");
//        System.out.println(conta1.verificarChequeEspecial());
//
//        //--------------------------------------------------
//
//        System.out.println("\nSACAR DINHEIRO:");
//        System.out.println(conta1.sacar(800));
//
//        System.out.println("\nNOVO SALDO DA CONTA:");
//        System.out.println(conta1.getSaldo());
//
//        System.out.println("\nTAXA:");
//        System.out.println(conta1.getTaxa());
//
//        System.out.println("\nVERIFICAR SE ESTÁ USANDO CHEQUE ESPECIAL:");
//        System.out.println(conta1.verificarChequeEspecial());
//
//        //---------------------------------------------------
//        System.out.println("\nSACAR DINHEIRO que pega direto do cheque:");
//        System.out.println(conta1.sacar(50));
//
//        System.out.println("\nNOVO SALDO DA CONTA:");
//        System.out.println(conta1.getSaldo());
//
//        System.out.println("\nTAXA:");
//        System.out.println(conta1.getTaxa());
//
//        System.out.println("\nVERIFICAR SE ESTÁ USANDO CHEQUE ESPECIAL:");
//        System.out.println(conta1.verificarChequeEspecial());
//
//        //------------------------------------
//        System.out.println("\nDEPOSITAR");
//        System.out.println(conta1.depositar(160));
//
//        System.out.println("\nNOVO SALDO DA CONTA:");
//        System.out.println(conta1.getSaldo());
//
//        System.out.println("\nTAXA:");
//        System.out.println(conta1.getTaxa());
//
//        System.out.println("\nVERIFICAR SE ESTÁ USANDO CHEQUE ESPECIAL:");
//        System.out.println(conta1.verificarChequeEspecial());
//
//        System.out.println("//------------------------------------");
//
//        System.out.println("\nDEPOSITAR");
//        System.out.println(conta1.depositar(20));
//
//        System.out.println("\nNOVO SALDO DA CONTA:");
//        System.out.println(conta1.getSaldo());
//
//        System.out.println("\nTAXA:");
//        System.out.println(conta1.getTaxa());
//
//        System.out.println("\nVERIFICAR SE ESTÁ USANDO CHEQUE ESPECIAL:");
//        System.out.println(conta1.verificarChequeEspecial());
//
//        System.out.println("\nDEPOSITAR");
//        System.out.println(conta1.depositar(12));
//
//        System.out.println("\nNOVO SALDO DA CONTA:");
//        System.out.println(conta1.getSaldo());
//
//        System.out.println("\nTAXA:");
//        System.out.println(conta1.getTaxa());
//
//        System.out.println("\nVERIFICAR SE ESTÁ USANDO CHEQUE ESPECIAL:");
//        System.out.println(conta1.verificarChequeEspecial());


    }
}