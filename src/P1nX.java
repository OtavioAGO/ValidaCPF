import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class P1nX {
    public static void main(String[] args) {
        while (true) {
            try {
                Pessoa p;
                int dia = Integer.parseInt(args[3]);
                int mes = Integer.parseInt(args[4]);
                int ano = Integer.parseInt(args[5]);
                long cpf;
                if (ValidaCPF.isCPF(args[6])) {
                    cpf = ValidaCPF.toLong(args[6]);
                } else {
                    throw new Exception("CPF invalido");
                }
                float peso = Float.parseFloat(args[7]);
                float altura = Float.parseFloat(args[8]);
                if (args[0].equalsIgnoreCase("Homem")) {
                    p = new Homem(args[1], args[2], dia, mes, ano, cpf, peso, altura);
                } else if (args[0].equalsIgnoreCase("Mulher")) {
                    p = new Mulher(args[1], args[2], dia, mes, ano, cpf, peso, altura);
                } else {
                    throw new Exception("Genero Invalido");
                }
                System.out.println(p.toString());
                break;
            } catch (Exception e) {
                System.out.println("java P1nX <genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>");
                System.out.println("O genero deve ser homem ou mulher");
                e.printStackTrace();
                break;
            }
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("\nQuantos usuarios acrescentar?");
        int n = sc.nextInt();
        sc.nextLine();
        Pessoa[] pessoas = new Pessoa[n];
        for (int i = 0; i < n; i++) {
            try {
                System.out.println("Homem ou mulher?");
                String genero = sc.nextLine();
                System.out.println("Nome: ");
                String nome = sc.nextLine();
                System.out.println("Sobrenome: ");
                String sobrenome = sc.nextLine();
                System.out.println("Dia de Nascimento:");
                int dia = sc.nextInt();
                sc.nextLine();
                System.out.println("Mes de nascimento: ");
                String mes = sc.nextLine();
                int mesInt;
                System.out.println("Ano de nascimento:");
                int ano = sc.nextInt();
                sc.nextLine();
                if ((genero.equalsIgnoreCase("Homem") || genero.charAt(0) == 'h' || genero.charAt(0) == 'H') && !mes.matches("[a-zA-Z]+")){
                    mesInt = Integer.parseInt(mes);
                    pessoas[i] = new Homem(nome, sobrenome, dia, mesInt, ano);
                } else if ((genero.equalsIgnoreCase("Mulher") || genero.charAt(0) == 'm' || genero.charAt(0) == 'M' ) && !mes.matches("[a-zA-Z]+")) {
                    mesInt = Integer.parseInt(mes);
                    pessoas[i] = new Mulher(nome, sobrenome, dia, mesInt, ano);
                }
                else if(genero.equalsIgnoreCase("Homem") || genero.charAt(0) == 'h' || genero.charAt(0) == 'H'){
                    pessoas[i] = new Homem(nome, sobrenome, dia, mes, ano);
                }
                else if(genero.equalsIgnoreCase("Mulher") || genero.charAt(0) == 'm' || genero.charAt(0) == 'M'){
                    pessoas[i] = new Mulher(nome, sobrenome, dia, mes, ano);
                }
                else{
                    i-=1;
                    throw new Exception("Genero invalido");
                }
                if (i<n-1){
                    System.out.println("1-Continuar inserindo\n2- Finalizar aplicação");
                    int opc = sc.nextInt();
                    sc.nextLine();
                    if (opc == 2) {
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        int qtdH = 0, qtdM = 0;
        for (int i = 0; i < Pessoa.numPessoas()-1; i++) {
            if (pessoas[i] != null){
                System.out.println(pessoas[i].toString());
            }
            if (pessoas[i] instanceof Homem){
                qtdH+= 1;
            }
            else{
                qtdM += 1;
            }
        }
        System.out.println("Quantidade homens:"+qtdH);
        System.out.println("Quantidade mulheres:"+qtdM);
    }

}
