import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaCPF{
    public static boolean isCPF(String CPF){
        String regex = "(\\d{3}\\D\\d{3}\\D\\d{3}\\D\\d{2})";
        String regex2 = "(\\d{11})";
        Matcher matcher = Pattern.compile(regex).matcher(CPF);
        Matcher matcher2 = Pattern.compile(regex2).matcher(CPF);
        if (!matcher.matches() && !matcher2.matches()){
            return false;
        }
        int somaD1 = 0, contador = 0, somaD2 = 0;
        int indiceD10 = 0, indiceD11 = 0;
        for (int i = 0; i < CPF.length(); i++) {
            if (Character.isAlphabetic(CPF.charAt(i))){
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
}