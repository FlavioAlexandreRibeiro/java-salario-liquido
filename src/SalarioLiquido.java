import java.util.Scanner;

public class SalarioLiquido {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("\nNome do funcionario:");
        String nome = scanner.nextLine();

        System.out.print("Salário bruto:");
        double salarioBruto = scanner.nextDouble();

        System.out.print("Valor do desconto do INSS:");
        double descontoInss = scanner.nextDouble();

        System.out.print("Valor do desconto do Imposto de renda:");
        double descontoImpostoRenda = scanner.nextDouble();


        double totalDescontos = calcularDescontos(descontoInss, descontoImpostoRenda);
        double salarioLiquido = calcularSalarioLiquido(salarioBruto, totalDescontos);
        String faixaDeSalario = calcularFaixaSalarial(salarioLiquido);

        double percentual = (totalDescontos / salarioBruto) * 100;
        String descontoPercentual = verificarDesconto(percentual);

        System.out.println("\n====SALÁRIO LÍQUIDO====");
        System.out.println("\nNome: " + nome);
        System.out.printf("Salário Bruto: R$ %.2f%n", salarioBruto);
        System.out.printf("Total de Descontos: R$ %.2f%n", totalDescontos);
        System.out.printf("Salário Líquido: R$ %.2f%n", salarioLiquido);
        System.out.printf("Percentual de Desconto: %.2f%%%n", percentual);
        System.out.println("\nClassificação Salarial: " + faixaDeSalario);
        System.out.println("Classificação do desconto: " + descontoPercentual);


        scanner.close();
    }

    public static double calcularDescontos(double descontoInss, double descontoImpostoRenda) {
        return descontoInss + descontoImpostoRenda;
    }

    public static double calcularSalarioLiquido(double salarioBruto, double totalDescontos) {
        return salarioBruto - totalDescontos;
    }

    public static String calcularFaixaSalarial(double salarioLiquido) {
        if (salarioLiquido <= 2000) {
            return "Baixa renda";
        } else if (salarioLiquido <= 5000) {
            return "Média renda";
        } else {
            return "Alta renda";
        }
    }

    public static String verificarDesconto(double percentual) {
        if (percentual <= 10) {
            return "Desconto Baixo";
        } else if (percentual <= 20) {
            return  "Desconto Médio";
        }else {
            return "Desconto Alto";
        }
    }
}
