import db.JDBCPostgres;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("�����������! ����� �N��������� �� ������ ������������ ��� �������? ����������� ������������������ ����� ������\n1-���, 2-��������, 3-���, 4-����, 5-������, 6-������, 7-��������");
            String[] s = sc.nextLine().split(" ");

            JDBCPostgres JDBC = new JDBCPostgres();

            int[] ing = new int[s.length];
            for (int j = 0; j < s.length; j++) {
                ing[j] = Integer.parseInt(s[j]);
            }
            ArrayList<String> dishOutput = new ArrayList<>();

            if (isPlovMatched(ing)) dishOutput.add("����");
            if (isSupMatched(ing)) dishOutput.add("���");
            String stringDishOutput = String.join(", ", dishOutput);
            if (dishOutput.isEmpty()) {
                System.out.println("� ��������� �� ������ �� ������ ����������� :(\n������ ����������� �����?");
                String answer = sc.nextLine();
                if (answer.equals("���")) break;
            }
            else {
                System.out.println("�� ������ �����������: " + stringDishOutput + "\n������ ������� 1 ��������� �����?");
                String answer = sc.nextLine();
                if (answer.equals("��")) {
                    System.out.println(dishOutput.get(0+(int) (Math.random() * dishOutput.size())));
                    break;
                }
                if (answer.equals("���")) {
                    System.out.println("����� ����������� ������: " + stringDishOutput);
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