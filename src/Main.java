import Utils.Funtions;
import javax.swing.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        String continuee = "si";
        List<Double> numsElevate = new ArrayList<>();
        do {
            switch (JOptionPane.showInputDialog("1. Llenar con numeros o letras una lista \n 2. convertir una lista de enteros al cuadrado\n 3. Ver la lista y cual era su forma anterior \n 4. numeros mayores que 30 \n  5. Suma total de la lista  \n nota: Para poder activar correctamente las funciones 3 y 5 primero digita la opción 2")){
                case "1":
                    String caseName = JOptionPane.showInputDialog(" 1. llenar con numeros "+ "\n"+" 2. Con cadenas");
                    switch (caseName){
                        case "1":
                            List<Integer> listNums = Funtions.fillNumbers(()-> new Random().nextInt(10),10);
                            listNums.forEach(System.out::println);
                            break;
                        case "2":
                            List<String> listSentencesRamdom = Funtions.fillSentences(()-> main.fillWithSentences(7),10);
                            listSentencesRamdom.forEach(System.out::println);
                            break;
                        default:
                            break;
                    }
                    break;
                case "2":
                    List<Integer> nums = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));
                    numsElevate = Funtions.elevateNumbers(value -> Double.valueOf(value*value),nums);
                    System.out.println("Numeros del 1 al 10 convertidos al cuadrado: ");
                    numsElevate.forEach(System.out::println);
                    break;
                case "3":
                    Funtions.seeList(value -> System.out.println(" El numero elevado es : "+value+" y su numero base es : "+Math.sqrt(value)),numsElevate);
                    break;
                case "4":
                    List<Double> listNumsMayor= Funtions.filterNums(value-> value>30, numsElevate);
                    System.out.println("Los numeros mayores que 30 son : ");
                    listNumsMayor.forEach(System.out::println);
                    break;
                case "5":
                    Optional<Double> sumTotal = numsElevate.stream().reduce((num1,num2)-> num1+num2);
                    sumTotal.ifPresent(aDouble -> System.out.println("La suma total de la lista es : " + aDouble));
                    break;
                default:
                    System.out.println("Cometiste un Error ");
                    break;
            }
            continuee = JOptionPane.showInputDialog("Desea continuar si o no");
        }while (continuee.equalsIgnoreCase("si"));
    }

    public String fillWithSentences(int longitud) {
        String sentences = "";
        char words;
          for (int i=0;i<longitud;i++){
              words = (char)(new Random().nextInt(26) + 'A');
              sentences += words;
              if (i==longitud-1){
                  break;
              }
          }
          return sentences;
    }

}