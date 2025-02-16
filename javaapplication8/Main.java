/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication8;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Willian
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //3.1
        List<Funcionario> funcionarios = new ArrayList<>(Arrays.asList(
                new Funcionario("Maria", "18/10/2000", 2009.44, "Operador"),
                new Funcionario("João", "12/05/1990", 2284.38, "Operador"),
                new Funcionario("Caio", "02/05/1961", 9836.14, "Coordenador"),
                new Funcionario("Miguel", "14/10/1988", 19119.88, "Diretor"),
                new Funcionario("Alice", "05/01/1995", 2234.68, "Recepcionista"),
                new Funcionario("Heitor", "19/11/1999", 1582.72, "Operador"),
                new Funcionario("Arthur", "31/03/1993", 4071.84, "Contador"),
                new Funcionario("Laura", "08/07/1994", 3017.45, "Gerente"),
                new Funcionario("Heloísa", "24/05/2003", 1606.85, "Eletricista"),
                new Funcionario("Helena", "02/09/1996", 2799.93, "Gerente")
        ));

        //3.2
        funcionarios.removeIf(f -> f.getNome().equals("João"));

        //3.3
        System.out.println("Funcionarios:");
        funcionarios.forEach(f -> System.out.println(f.toString()));

        //3.4
        funcionarios.forEach(f -> f.aumentarSalario(10));

        //3.5
        Map<String, List<Funcionario>> funcionariosPorFuncao = funcionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));

        //3.6
        System.out.println("Funcionarios por função: ");
        funcionariosPorFuncao.forEach((funcao, lista) -> {
            System.out.println("\nFunção: " + funcao);
            lista.forEach(System.out::println);
        });

        //3.8
        System.out.println("\nFuncionários nascidos em outubro ou dezembro:");
        funcionarios.stream()
                .filter(f -> f.getDataNascimento().getMonthValue() == 10 || f.getDataNascimento().getMonthValue() == 12)
                .forEach(System.out::println);

        //3.9
        Funcionario funcionarioMaisVelho = funcionarios.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .get();
        System.out.printf("\nFuncionário mais velho: %s, Idade: %d anos.%n",
                funcionarioMaisVelho.getNome(), Period.between(funcionarioMaisVelho.getDataNascimento(), LocalDate.now()).getYears());

        //3.10
        funcionarios.sort(Comparator.comparing(f -> f.getNome()));
        System.out.println("\nFuncionários ordenados por nome:");
        funcionarios.forEach(System.out::println);

        //3.11
        BigDecimal totalSalarios = BigDecimal.ZERO;
        for (Funcionario f : funcionarios) {
            totalSalarios = totalSalarios.add(f.getSalario());
        }
        System.out.println("\nTotal dos salários: " + NumberFormat.getInstance(new Locale("pt", "BR")).format(totalSalarios));

        //3.12
        System.out.println("\nQuantidade de salários mínimos por funcionário:");
        funcionarios.forEach(f -> {
            BigDecimal qtdSalariosMinimos = f.getSalario().divide(BigDecimal.valueOf(1212), 2, RoundingMode.HALF_UP);
            System.out.println(f.getNome() + " ganha " + qtdSalariosMinimos + " salários mínimos.");
        });
    }

}
