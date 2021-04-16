import java.util.Scanner;

public class CalculoImc {

  public static void main(String args[]) {

    Scanner ler = new Scanner(System.in);

    double peso = 0, altura = 0, vlrIMC = 0;
    String nome = null;
    int pessoa = 0;
    
    while(pessoa < 2) {
    pessoa ++;
    System.out.printf("\n=========CALCULO IMC DOS JOGADORES=========\n\n");
    System.out.printf("Informe o nome do paciente: ");
    nome = ler.next(); 

    System.out.printf("Informe o peso do paciente: ");
    peso = ler.nextDouble(); 

    System.out.printf("Informe a Altura do paciente: ");
    altura = ler.nextDouble(); 
    System.out.printf("\n===========================================\n\n");    
    }
   

    System.out.printf("\n========================================\n");
    vlrIMC = IMC(peso, altura);
    System.out.println("Nome do paciente: "+ nome);
    System.out.println("Peso: "+ peso);
    System.out.println("Altura: "+ altura);
    System.out.printf("IMC = %.2f \n", vlrIMC);
    System.out.printf("O paciente se encontra na categoria: \n    %s \n",interpretacaoIMC(vlrIMC));
    System.out.printf("========================================\n");
}

  public static double IMC(double peso, double altura) {
    return(peso / (altura * altura));
  }

  public static String interpretacaoIMC(double vlrIMC) {
    if (vlrIMC <= 18.4) {
         return("Abaixo do peso");
    }else if ((vlrIMC >= 18.5) && (vlrIMC <= 24.9)) {
         return("Peso normal");
    }else if ((vlrIMC >= 25) && (vlrIMC <= 29.9)){
         return("Sobrepeso");
    }else if ((vlrIMC >= 30) && (vlrIMC <= 34.9)){
         return("Obesidade grau I");
    }else if ((vlrIMC >= 35) && (vlrIMC <= 39.9)){
         return("Obesidade grau II");
    }else { 
         return("Obesidade grau III");
    }
  } 
}