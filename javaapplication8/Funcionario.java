/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication8;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author Willian
 */
public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, String dataNascimento, double salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = BigDecimal.valueOf(salario);
        this.funcao = funcao;
    }
    
    public BigDecimal getSalario(){
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    private String getStringSalario() {
        Locale ptBR = new Locale("pt", "BR");
        NumberFormat nf = NumberFormat.getNumberInstance(ptBR);
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        return nf.format(this.salario);
    }
    
    @Override
    public String toString() {
        return String.format("Nome: %s - Data Nascimento: %s - Salario: %s - Função: %s ",
                this.getNome(), this.getStringDataNascimento(), this.getStringSalario(), this.getFuncao());
    }

    public void aumentarSalario(double percentual) {
        BigDecimal fatorPercentual = BigDecimal.valueOf(percentual).divide(BigDecimal.valueOf(100));
        BigDecimal aumento = this.salario.multiply(fatorPercentual);
        this.salario = this.salario.add(aumento);
    }

}
