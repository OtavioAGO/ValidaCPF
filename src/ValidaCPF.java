import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaCPF{
    public static boolean isCPF(String CPF){
        String regex = "[0-9]{11}|[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}|[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}|[0-9]{2}";
        Matcher matcher = Pattern.compile(regex).matcher(CPF);
        String numeros = CPF.replaceAll("[^0-9]","");
        if (numeros.matches("^(\\d)\\1*$")){//checa se todos os numeros são iguais
            return false;
        }
        if (!matcher.matches()){//checa se o CPF está em algum dos padrões válidos
            return false;
        }
        int somaD1 = 0, contador = 0, somaD2 = 0;
        int indiceD10 = 0, indiceD11 = 0;
        for (int i = 0; i < CPF.length(); i++) {
            if (Character.isAlphabetic(CPF.charAt(i))){//checa se existe alguma letra no CPF enviado
                return false;
            }
            if (Character.isDigit(CPF.charAt(i))){
                if(contador < 9){
                    somaD1 += ((CPF.charAt(i)-48)*(10-contador));
                }
                if (contador < 10){
                    somaD2 += ((CPF.charAt(i)-48)*(11-contador));
                }
                contador += 1;
                if (contador == 10){
                    indiceD10 = i;
                    somaD1 = (11 - (somaD1 % 11));
                    if (somaD1 == 11 || somaD1 == 10){
                        somaD1 = 0;
                    }
                }
                if (contador == 11){
                    indiceD11 = i;
                    somaD2 = (11 - (somaD2 % 11));
                    if (somaD2 == 11 || somaD2 == 10){
                        somaD2 = 0;
                    }
                }
            }
        }
        if (somaD1 != (int) CPF.charAt(indiceD10)-48 || somaD2 != (int) CPF.charAt(indiceD11)-48){
            return false;
        }
        if (contador < 11){
            return false;
        }
        return true;
    }
    public static long toLong(String CPF){
        String str = CPF;
        if (isCPF(CPF)){
            str = str.replaceAll("[^0-9]","");
        }
        long toLong = Long.parseLong(str);
        return toLong;
    }
    public static String format(String CPF){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < CPF.length(); i++) {
            if (sb.length() == 3 || sb.length() == 7){
                sb.append(".");
            }
            if (sb.length() == 11){
                sb.append("-");
            }
            if (Character.isDigit(CPF.charAt(i))){
                sb.append(CPF.charAt(i));
            }
        }
        return sb.toString();
    }
}