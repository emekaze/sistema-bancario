import java.util.Scanner;

public class SistemaBancario {
    public static void main(String[] args) {
        System.out.print("\033\143"); //Limpar tela

        boolean statusConta = false;
        String titular = "";
        float saldoInicial = 0f;
        float saldoAtual = 0f;
        int qtdDepositos = 0;
        float totalDepositos = 0f;
        float valorDeposito = 0f;
        int qtdSaques = 0;
        float totalSaques = 0f;
        float valorSaque = 0f;
        float totalJuros = 0f;
        float minMaxConta = 0f;
        boolean sair = false;
        boolean valorValidacao = false;
        int[] notas = {11, 13, 17, 19};

        Scanner input = new Scanner(System.in);

        while (sair == false){
        System.out.println("========== Menu ==========");
        System.out.println("1. Abrir Conta");
        System.out.println("2. Realizar deposito");
        System.out.println("3. Realizar saque");
        System.out.println("4. Aplicar juros");
        System.out.println("5. Simular emprestimo");
        System.out.println("6. Extrato");
        System.out.println("7. Integrantes");
        System.out.println("8. Sair\n");
        System.out.println("Digite o numero que deseja:");
        int num = input.nextInt();
        input.nextLine();

        switch (num) {
            case 1: // EFETUAR CADASTRO
                System.out.print("\033\143"); //Limpar tela

                System.out.println("========== Abrir conta ==========");

                if (statusConta == true){
                    System.out.println("Conta ja cadastrada!");
                } else {
                    System.out.println("Digite o nome do titular: ");
                    titular = input.nextLine();

                    System.out.println("Digite o saldo inicial: ");
                    saldoInicial = input.nextFloat();

                    saldoAtual += saldoInicial;
                    input.nextLine();

                    statusConta = true;

                    System.out.print("\033\143"); //Limpar tela

                    System.out.println("==== Conta aberta com sucesso! ====");
                }

                System.out.println("Pressione ENTER para voltar ao menu.");
                input.nextLine();
                System.out.print("\033\143"); //Limpar tela

                break;
            case 2: // REALIZACAO DE DEPOSITOS
                System.out.print("\033\143"); //Limpar tela

                System.out.println("========== Realizar deposito ==========");

                while (valorValidacao == false){
                    if (statusConta == false){
                        System.out.println("Acao negada! Voce precisa realizar a abertura da conta");
                        break;

                    } else {
                        System.out.println("Digite o valor a ser depositado");

                        if(input.hasNextFloat()){ // VERIFICA SE O INPUT EH UM VALOR NUMERICO
                            valorDeposito = input.nextFloat();
                            input.nextLine();
    
                            if (valorDeposito <= 0){
                                System.out.print("\033\143");
                                System.out.println("Impossivel depositar valor menor ou igual a 0!");
                                
                            } else {
                                valorValidacao = true; // REALIZA O DEPOSITO E SAI DO LOOP
                                System.out.print("\033\143");
                                saldoAtual += valorDeposito;
                                qtdDepositos++;
                                totalDepositos += valorDeposito;
                                System.out.format("===== Deposito de R$%.2f efetuado com sucesso! =====\n", valorDeposito);
                                System.out.format("===== Saldo atual: R$%.2f =====\n", saldoAtual);
                            }
                        } else {
                            System.out.print("\033\143");
                            System.out.println("Erro: digite um valor numerico!");
                            input.nextLine();
                        }
    
                    }
                }
                valorValidacao = false; // RECEBE FALSO PARA QUE SEJA POSSIVEL REALIZAR O PROXIMO DEPOSITO / SE CONTINUASSE VERDADEIRO, ELE PULA O LOOP E FECHA O CASE 

                System.out.println("Pressione ENTER para voltar ao menu.");
                input.nextLine();
                System.out.print("\033\143");
                break;

            case 3: // REALIZACAO DE SAQUES
                System.out.print("\033\143"); //Limpar tela

                System.out.println("========== Realizar saque ==========");

                while (valorValidacao == false) {
                    if (statusConta == false){
                        System.out.println("Acao negada! Voce precisa realizar a abertura da conta");
                        break;

                    } else {
                        System.out.println("Digite o valor a ser sacado: ");

                        if (input.hasNextFloat()){
                            valorSaque = input.nextFloat();
                            input.nextLine();

                            if (valorSaque <= 0 ){
                                System.out.print("\033\143");
                                System.out.println("Impossivel sacar valor menor ou igual a zero");

                            } else if (valorSaque > saldoAtual){
                                System.out.print("\033\143");
                                System.out.println("Saldo insuficiente!");

                            } else if (valorSaque % 2 != 0 && valorSaque < 5){
                                System.out.print("\033\143");
                                System.out.println("Valor indisponivel para saque! (notas disponiveis: 100, 50, 20, 10, 5, 2)");

                            } else {
                                System.out.print("\033\143");

                                valorValidacao = true;

                                saldoAtual -= valorSaque;
                                qtdSaques++;
                                totalSaques +=valorSaque;

                                System.out.format("===== Saque de %.2f efetuado com sucesso! =====\n", valorSaque);
                                System.out.format("===== Saldo atual : R$%.2f =====\n", saldoAtual);
                            }
                        } else {
                            System.out.print("\033\143");
                            System.out.println("Erro: digite um valor numerico!");
                            input.nextLine();
                        }
                    }
                }

                valorValidacao = false;

                System.out.println("Pressione ENTER para voltar ao menu.");
                input.nextLine();
                System.out.print("\033\143");
                break;

            case 4: // APLICACAO DE JUROS
            System.out.println("Pressione ENTER para voltar ao menu.");
            input.nextLine();
            System.out.print("\033\143");
                break;

            case 5: // REALIZACAO DE EMPRESTIMOS
            System.out.println("Pressione ENTER para voltar ao menu.");
            input.nextLine();
            System.out.print("\033\143");
                break;

            case 6: // EXTRATO
                System.out.print("\033\143"); //Limpar tela

                System.out.println("========== Extrato ==========");
                System.out.format("Titular: %s\n", titular);
                System.out.format("Saldo inicial: %.2f\n", saldoInicial);
                System.out.format("Saldo atual: %.2f\n", saldoAtual);
                System.out.format("Quantidade total de depositos: %d\n", qtdDepositos);
                System.out.format("Valor total de depositos: %.2f\n", totalDepositos);
                System.out.format("Quantidade total de saques: %d\n", qtdSaques);
                System.out.format("Valor total de saques: %.2f\n", totalSaques);
                System.out.format("Valor total de juros recebidos: %.2f\n", totalJuros);
                System.out.format("Saldo minimo e maximo da conta: %.2f\n", minMaxConta);
                System.out.println("Pressione ENTER para voltar ao menu.");
                input.nextLine();
                System.out.print("\033\143");
                break;

            case 7:
                System.out.print("\033\143");
                System.out.println("Marks Cardoso, Nicolas");
                System.out.println("Pressione ENTER para voltar ao menu.");
                input.nextLine();
                System.out.print("\033\143");
                break;

            case 8: // FECHAR PROGRAMA
                System.out.print("\033\143");
                sair = true;
                System.out.println("Encerrando programa...");
                break;

            default:
                System.out.print("\033\143");
                System.out.println("Digito invalido!");
                System.out.println("Pressione ENTER para voltar ao menu.");
                input.nextLine();
                System.out.print("\033\143");
                break;
            
        }
        }
    }
}
