/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author dobne
 */
public class Funcionario {
    //Atributos
    private int matricula = 0;
    private String nomeCompleto = "";
    private int numeroDeDependentes = 0;
    private float salarioBase = 0;
    private int producao = 0;
    
    //Metodos
    public Funcionario(int matricula, String nomeCompleto, int numeroDeDependentes, float salarioBase, int producao)throws Exception{
        if(matricula <= 0) throw new Exception("Matricula não pode ser <= 0");
        this.matricula = matricula;
        if(nomeCompleto.isEmpty()) throw new Exception("O campo nome completo não pode estra vazio.");
        this.nomeCompleto = nomeCompleto;
        if(matricula < 0) throw new Exception("Matrícula não pode ser negativa");
        this.numeroDeDependentes = numeroDeDependentes;
        if(salarioBase <= 0) throw new Exception("O salário base não pode ser <= 0");
        this.salarioBase = salarioBase;
        if(producao < 0) throw new Exception("A produção não pode ser negativa");
        this.producao = producao;
    }
    public int getMatricula(){
        return matricula;
    }
    public void setMatricula(int matricula) throws Exception {
        if(matricula <= 0) throw new Exception("Matricula não pode ser <= 0");
        this.matricula = matricula;
    }
    public String getNomeCompleto() {
        return nomeCompleto;
    }
    public void setNomeCompleto(String nomeCompleto) throws Exception {
        if(nomeCompleto.isEmpty()) throw new Exception("O campo nome completo não pode estra vazio.");
        this.nomeCompleto = nomeCompleto;
    }
    public int getNumeroDeDependentes() {
        return numeroDeDependentes;
    }
    public void setNumeroDeDependentes(int numeroDeDependentes) throws Exception{
            if(matricula < 0) throw new Exception("O número de dependentes não pode ser <= 0");
        this.numeroDeDependentes = numeroDeDependentes;
    }
    public float getSalarioBase() {
        return salarioBase;
    }
    public void setSalarioBase(float salarioBase) throws Exception{
        if(salarioBase <= 0) throw new Exception("O salário base não pode ser <= 0");
        this.salarioBase = salarioBase;
    }
    public int getProducao() {
        return producao;
    }
    public void setProducao(int producao) throws Exception{
        if(producao < 0) throw new Exception("A produção não pode ser negativa");
        this.producao = producao;
    }
    public float calcularGratificacao() {
        float gratificacao;
        if (producao <= 1000) gratificacao = 500;
        else if(producao <=2000) gratificacao = 1250;
        else {
            gratificacao = 2250; 
        }
        return gratificacao;
    }
    public float calcularSalarioBruto(){
        return salarioBase + calcularGratificacao();
    }
    public float calcularDescontoINSS(){
        float salarioBruto = calcularSalarioBruto();
        if(salarioBruto <= 1302) return (float) (salarioBruto * 0.075);
        else if(salarioBruto <= 2571.29) return (float) (salarioBruto * 0.09);
        else if(salarioBruto <= 3856.94) return (float) (salarioBruto * 0.12);
        else return (float) (salarioBruto * 0.14);
    }
    public float calcularDescontoIRPF(){
        if(calcularSalarioBruto() <= 1903.98) return 0;
        else if(calcularSalarioBruto() <= 2826.65) return (float)Math.max(calcularSalarioBruto() * 0.075, 0);
        else if(calcularSalarioBruto() <= 3751.05) return (float)Math.max(calcularSalarioBruto() * 0.15, 0);
        else if(calcularSalarioBruto() <= 4664.68) return (float)Math.max(calcularSalarioBruto() * 0.225, 0);
        else return (float)Math.max(calcularSalarioBruto() * 0.275 - calcularDescontoFilhos(), 0);
    }
    public float calcularDescontoFilhos(){
        return (numeroDeDependentes * 123);
    }
    public float calcularSalarioLiquido(){
        return calcularSalarioBruto() - (calcularDescontoINSS() + calcularDescontoIRPF());
    }

    @Override
    public String toString() {
        return "Funcionario{" + "matricula=" + matricula + ", nomeCompleto=" + nomeCompleto + ", numeroDeDependentes=" + numeroDeDependentes + ", salarioBase=" + salarioBase + ", producao=" + producao + '}';
    }
    
}
