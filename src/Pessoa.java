import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Pessoa {
    private String nome;
    private String sobrenome;
    private GregorianCalendar dataNasc;
    private Long numCPF;
    private Float peso;
    private Float altura;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static int CONTADOR;

    public Pessoa(String nome, String sobrenome, int dia, int mes, int ano) {
        if (nome.matches("^[a-zA-Z á]*$") && sobrenome.matches("^[a-zA-Z ]*$")){
            this.nome = nome;
            this.sobrenome = sobrenome;
        }
        else{
            throw new IllegalArgumentException("Um nome não pode possuir digitos ou caracteres especiais.");
        }
        if (ValidaData.isDia(dia) && ValidaData.isMes(mes) && ValidaData.isAno(ano) && ValidaData.isDataValida(dia, mes, ano)){
            dataNasc = new GregorianCalendar(ano, mes, dia);
        }
        else{
            throw new IllegalArgumentException("Data invalida");
        }
        CONTADOR += 1;
    }
    public Pessoa(String nome, String sobrenome, int dia, String mes, int ano) {
        if (nome.matches("^[a-zA-Z á]*$") && sobrenome.matches("^[a-zA-Z ]*$")){
            this.nome = nome;
            this.sobrenome = sobrenome;
        }
        else{
            throw new IllegalArgumentException("Um nome não pode possuir digitos ou caracteres especiais.");
        }
        if (ValidaData.isDia(dia) && ValidaData.isMes(mes) && ValidaData.isAno(ano) && ValidaData.isDataValida(dia, mes, ano)){
            int mesInt = ValidaData.Meses.checaNome(mes).VALOR;
            dataNasc = new GregorianCalendar(ano, mesInt-1, dia);
        }
        else{
            throw new IllegalArgumentException("Data invalida");
        }
        CONTADOR += 1;
    }
    public Pessoa(String nome, String sobrenome, int dia, int mes, int ano, long numCPF, float peso, float altura){
        if (nome.matches("^[a-zA-Z á]*$") && sobrenome.matches("^[a-zA-Z ]*$")){
            this.nome = nome;
            this.sobrenome = sobrenome;
        }
        else{
            throw new IllegalArgumentException("Um nome não pode possuir digitos ou caracteres especiais.");
        }
        if (ValidaData.isDia(dia) && ValidaData.isMes(mes) && ValidaData.isAno(ano) && ValidaData.isDataValida(dia, mes, ano)){
            dataNasc = new GregorianCalendar(ano, mes, dia);
        }
        else{
            throw new IllegalArgumentException("Data invalida");
        }
        this.numCPF = numCPF;
        this.peso = peso;
        this.altura = altura;
        CONTADOR += 1;
    }
    public Pessoa(String nome, String sobrenome, int dia, String mes, int ano, long numCPF, float peso, float altura) {
        if (nome.matches("^[a-zA-Z á]*$") && sobrenome.matches("^[a-zA-Z ]*$")){
            this.nome = nome;
            this.sobrenome = sobrenome;
        }
        else{
            throw new IllegalArgumentException("Um nome não pode possuir digitos ou caracteres especiais.");
        }
        if (ValidaData.isDia(dia) && ValidaData.isMes(mes) && ValidaData.isAno(ano) && ValidaData.isDataValida(dia, mes, ano)){
            int mesInt = ValidaData.Meses.checaNome(mes).VALOR;
            dataNasc = new GregorianCalendar(ano, mesInt-1, dia);
        }
        else{
            throw new IllegalArgumentException("Data invalida");
        }
        this.numCPF = numCPF;
        this.peso = peso;
        this.altura = altura;
        CONTADOR += 1;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDataNasc() {
        return sdf.format(dataNasc.getTime());
    }
    protected int idade(){
        Calendar c = new GregorianCalendar();
        int anoAtual = c.get(Calendar.YEAR);
        int anoNasc = dataNasc.get(Calendar.YEAR);
        return anoAtual - anoNasc;
    }
    public long getNumCPF() {
        return numCPF;
    }
    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Nome: "+nome+" "+sobrenome+"\n");
        sb.append("Data de Nascimento: "+sdf.format(dataNasc.getTime())+"\n");
        if (numCPF != null && peso != null && altura != null){
            sb.append("CPF: "+numCPF+"\n");
            sb.append("Peso: "+peso+"KG\n");
            sb.append("Altura: "+altura+"m\n");
        }
        return sb.toString();
    }
    public static int numPessoas(){
        return CONTADOR;
    }
}
