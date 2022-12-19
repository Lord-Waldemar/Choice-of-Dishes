import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Приветствую! Какие игридиенты вы хотите использовать для готовки? Перечислите через пробел цифры \n1-лук, 2-морковка, 3-рис, 4-мясо, 5-курица, 6-гречка, 7-макароны");
        int[] plov = new int[] {1, 2, 3, 4};
        int[] sup = new int[] {1,2,5,6,7};
        int plovCount = 0;
        int supCount = 0;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] s = str.split(" ");
        int[] ing = new int[s.length];
        for (int j = 0; j < s.length; j++) {
            ing[j]=Integer.parseInt(s[j]);
        }
        for (int i = 0; i < ing.length; i++) {
            for (int i1 = 0;ing.length >= plov.length & i1 < plov.length; i1++) {
                if (ing[i]==plov[i1]) plovCount++;
            }
            for (int i1 = 0; ing.length >= sup.length & i1 < sup.length; i1++) {
                if (ing[i]==sup[i1]) supCount++;
            }
        }
        if (plovCount==plov.length) System.out.println("Плов");
         if (supCount==sup.length) System.out.println("Суп");
         else System.out.println("К сожалению из данных ингридиентов ничего не приготовить((");
    }


}