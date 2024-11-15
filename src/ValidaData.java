import java.util.Calendar;
import java.util.GregorianCalendar;

public class ValidaData {
    enum Meses{
        JANEIRO(1, "Janeiro"), FEVEREIRO(2, "Fevereiro"), MARCO(3, "Marco"), ABRIL(4,"Abril"), MAIO(5,"Maio"), JUNHO(6,"Junho"), JULHO(7,"Julho"), AGOSTO(8,"Agosto"), SETEMBRO(9,"Setembro"), OUTUBRO(10,"Outubro"), NOVEMBRO(11,"Novembro"), DEZEMBRO(12,"Dezembro");
        public final int VALOR;
        private final String NOME;
        Meses(int valor, String nome){
            this.VALOR = valor;
            this.NOME = nome;
        }
        public int getVALOR(){
            return VALOR;
        }
        public static Meses checaValor(int VALOR){
            for (Meses m : values()){
                if (m.VALOR == VALOR){
                    return m;
                }
            }
            return null;
        }
        public static Meses checaNome(String mes){
            for (Meses m : values()){
                if (mes.equalsIgnoreCase(m.NOME)){
                    return m;
                }
            }
            return null;
        }
    }
    public static boolean isDia(int dia){
        String diaStr = String.valueOf(dia);
        if (diaStr.startsWith("0")){
            diaStr = diaStr.replaceFirst("0","");
        }
        dia = Integer.parseInt(diaStr);
        return dia >= 1 && dia <= 31;
    }
    public static boolean isMes(String mes){
        if (mes.startsWith("0")){
            mes = mes.replaceFirst("0","");
        }
        if (Character.isDigit(mes.charAt(0))){
           return Meses.checaValor(Integer.parseInt(mes)) != null;
        }
        else{
            return Meses.checaNome(mes) != null;
        }
    }
    public static boolean isAno(int ano){
        Calendar calendar = new GregorianCalendar();
        int anoAtual = calendar.get(Calendar.YEAR);
        return ano >= (anoAtual-120) && ano <= (anoAtual);
    }
    public static boolean isDataValida(int dia, int mes, int ano){
        Calendar c = new GregorianCalendar();
        c.setLenient(false);
        c.set(ano, mes-1, dia);
        try {
            c.getTime();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public static boolean isDataValida(int dia, String mes, int ano){
        Calendar c = new GregorianCalendar();
        int mesInt = Meses.checaNome(mes).getVALOR();
        c.setLenient(false);
        c.set(ano, mesInt-1, dia);
        try {
            c.getTime();
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
