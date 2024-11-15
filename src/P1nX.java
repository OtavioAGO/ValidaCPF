import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class P1nX {
    public static void main(String[] args) {
        try {
            Pessoa p;
            int dia = Integer.parseInt(args[3]);
            String mes = args[4];
            int mesInt;
            int ano = Integer.parseInt(args[5]);
            long cpf;
            if (ValidaCPF.isCPF(args[6])) {
                cpf = ValidaCPF.toLong(args[6]);
            } else {
                throw new Exception("CPF incorreto. Este CPF não existe.");
            }
            float peso = Float.parseFloat(args[7]);
            float altura = Float.parseFloat(args[8]);
            if ((args[0].equalsIgnoreCase("Masculino") || args[0].charAt(0) == 'm' || args[0].charAt(0) == 'M') && !mes.matches("[a-zA-Z]+")) {
                mesInt = Integer.parseInt(args[4]);
                p = new Homem(args[1], args[2], dia, mesInt, ano, cpf, peso, altura);
            } else if ((args[0].equalsIgnoreCase("Feminino") || args[0].charAt(0) == 'f' || args[0].charAt(0) == 'F') && !mes.matches("[a-zA-Z]+")) {
                mesInt = Integer.parseInt(args[4]);
                p = new Mulher(args[1], args[2], dia, mesInt, ano, cpf, peso, altura);
            } else if (args[0].equalsIgnoreCase("Masculino")) {
                p = new Homem(args[1], args[2], dia, mes, ano, cpf, peso, altura);
            } else if (args[0].equalsIgnoreCase("Feminino")) {
                p = new Mulher(args[1], args[2], dia, mes, ano, cpf, peso, altura);
            } else {
                throw new Exception("Genero Invalido");
            }
            System.out.println(p);
        } catch (Exception e) {
            System.out.println("java P1nX <genero> <nome> <sobre> <dia> <mes> ano> <CPF> <peso> <altura>");
            System.out.println("O genero deve ser m ou f");
            e.printStackTrace();
        }
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            System.out.println("\nQuantas pessoas a mais deseja inserir?");
            n = sc.nextInt();
            sc.nextLine();
            if (n < 0){
                System.out.println("Quantidade inválida! Insira um número positivo.");
            }
            else{
                break;
            }
        }
        Pessoa[] pessoas = new Pessoa[n];
        int i = 0;
        while (i < n){
            try {
                String nome;
                while (true){
                    System.out.println("Insira o nome: ");
                    nome = sc.nextLine();
                    if (nome.matches("^[a-zA-Z ]*$")){
                        break;
                    }else{
                        System.out.println("Nome inválido. O nome não deve conter números.");
                    }
                }
                if (nome.trim().isEmpty()){
                    break;
                }
                String sobrenome;
                while (true){
                    System.out.println("Insira o sobrenome: ");
                    sobrenome = sc.nextLine();
                    if (sobrenome.matches("^[a-zA-Z ]*$")){
                        break;
                    }else{
                        System.out.println("Sobrenome inválido. O sobrenome não deve conter números.");
                    }
                }
                int dia, ano;
                String mes;
                while(true){
                    System.out.println("Dia de Nascimento:");
                    dia = sc.nextInt();
                    sc.nextLine();
                    if (ValidaData.isDia(dia)){
                        break;
                    }
                    else{
                        System.out.println("Dia inválido. Insira um dia existente.");
                    }
                }
                while (true){
                    System.out.println("Mes de nascimento: ");
                    mes = sc.nextLine();

                    if (ValidaData.isMes(mes)){
                        break;
                    }
                    else{
                        System.out.println("Mes inválido. Insira um mes existente.");
                    }
                }
                int mesInt;
                while (true){
                    System.out.println("Ano de nascimento:");
                    ano = sc.nextInt();
                    sc.nextLine();
                    if (ValidaData.isAno(ano)){
                        break;
                    }else {
                        System.out.println("Ano inválido. Insira um ano valido.");
                    }
                }
                String CPF;
                while (true){
                    System.out.println("Insira o CPF: ");
                    CPF = sc.nextLine();
                    if (ValidaCPF.isCPF(CPF)){
                        break;
                    }
                    else {
                        System.out.println("CPF invalido. Insira um CPF válido.");
                    }
                }
                long cpfLong = ValidaCPF.toLong(CPF);
                float peso, altura;
                while (true){
                    System.out.println("Insira o Peso: ");
                    peso = sc.nextFloat();
                    sc.nextLine();
                    if (peso >= 0.21 && peso <= 595) {
                        break;
                    } else {
                        System.out.println("Peso inválido. Insira um peso possível.");
                    }
                }
                while (true){
                    System.out.println("Insira a Altura: ");
                    altura = sc.nextFloat();
                    sc.nextLine();
                    if (altura >= 0.546 && altura <= 3) {
                        break;
                    } else {
                        System.out.println("Altura inválida. Insira uma altura possível.");
                    }
                }
                String genero;
                while (true){
                    System.out.println("Esta pessoa é do gênero feminino ou masculino (f ou m)?");
                    genero = sc.nextLine();
                    if (genero.equalsIgnoreCase("m")||genero.equalsIgnoreCase("f")||genero.equalsIgnoreCase("masculino")||genero.equalsIgnoreCase("feminino")){
                        break;
                    }
                    else{
                        System.out.println("Genero invalido. Insira um dos generos validos (m,f)");
                    }
                }
                if ((genero.equalsIgnoreCase("Masculino") ||genero.equalsIgnoreCase("m")) && !mes.matches("[a-zA-Z]+")) {
                    mesInt = Integer.parseInt(mes);
                    pessoas[i] = new Homem(nome, sobrenome, dia, mesInt, ano, cpfLong, peso, altura);
                } else if ((genero.equalsIgnoreCase("Feminino") || genero.equalsIgnoreCase("f") && !mes.matches("[a-zA-Z]+"))) {
                    mesInt = Integer.parseInt(mes);
                    pessoas[i] = new Mulher(nome, sobrenome, dia, mesInt, ano, cpfLong, peso, altura);
                } else if (genero.equalsIgnoreCase("Masculino") ||genero.equalsIgnoreCase("m")) {
                    pessoas[i] = new Homem(nome, sobrenome, dia, mes, ano, cpfLong, peso, altura);
                } else{
                    pessoas[i] = new Mulher(nome, sobrenome, dia, mes, ano, cpfLong, peso, altura);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            i++;
        }
        int qtdH = 0, qtdM = 0;
        System.out.println("Informações Inseridas:");
        for (i = 0; i < Pessoa.numPessoas() - 1; i++) {
            if (pessoas[i] != null) {
                System.out.println(pessoas[i].toString());
            }
            if (pessoas[i] instanceof Homem) {
                qtdH += 1;
            } else {
                qtdM += 1;
            }
        }
        System.out.println("Quantidade homens:" + qtdH);
        System.out.println("Quantidade mulheres:" + qtdM);
    }

}
