import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        while (true) {
            System.out.println("Приветствую! Какие игридиенты вы хотите использовать для готовки? Перечислите номераингридиентов через пробел\n1-лук, 2-морковка, 3-рис, 4-мясо, 5-курица, 6-гречка, 7-макароны");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int[] ing = new int[s.length];
            for (int j = 0; j < s.length; j++) {
                ing[j] = Integer.parseInt(s[j]);
            }
            ArrayList<String> dishOutput = new ArrayList<>();

            if (isPlovMatched(ing)) dishOutput.add("Плов");
            if (isSupMatched(ing)) dishOutput.add("Суп");
            String separator = ", ";
            String stringDishOutput = String.join(separator, dishOutput);
            if (dishOutput.isEmpty()) {
                System.out.println("К сожалению вы ничего не можете приготовить :(\nХотите попробовать снова?");
                String answer = sc.nextLine();
                if (answer.equals("нет")) break;
            }
            else {
                System.out.println("Вы можете приготовить: " + stringDishOutput + "\nХотите выбрать 1 случайное блюдо?");
                String answer = sc.nextLine();
                if (answer.equals("да")) {
                    System.out.println(dishOutput.get(0+(int) (Math.random() * dishOutput.size())));
                    break;
                }
                if (answer.equals("нет")) {
                    System.out.println("Тогда продублирую список: " + stringDishOutput);
                    break;
                }
            }

        }
    }

    public static boolean isPlovMatched(int[] ings) {
        int plovCount = 0;
        int[] plov = new int[] {1, 2, 3, 4};
        for (int i = 0; i < ings.length; i++) {
            int thisIng = ings[i];
            for (int j = 0; j < plov.length; j++) {
                if (thisIng==plov[j]) plovCount++;
            }
        }
        if (plovCount==plov.length) return true;
        else return false;
    }
    public static boolean isSupMatched(int[] ings) {
        int supCount = 0;
        int[] sup = new int[] {1,2,5,6,7};
        for (int i = 0; i < ings.length; i++) {
            int thisIng = ings[i];
            for (int j = 0; j < sup.length; j++) {
                if (thisIng==sup[j]) supCount++;
            }
        }
        if (supCount==sup.length) return true;
        else return false;
    }
}