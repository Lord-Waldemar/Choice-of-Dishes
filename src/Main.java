import db.JDBCPostgres;
import JSOUP.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("������� ������� �����!");
        while (true) {
            ArrayList ingredients = JDBCPostgres.select("SELECT * FROM ingredients ORDER BY number");
            System.out.println("����� ����������� �� ������ ������������ ��� �������? ����������� ������ ������������ ����� ������.");
            for (int i = 0; i < ingredients.size(); i++) {
                System.out.print((i + 1) + "-" + ingredients.get(i) + " ");
                if (i!=0 & i%9==0) System.out.println();
            }
            System.out.println();

            try {
                String[] s = sc.nextLine().trim().split(" ");
                int[] ing = new int[s.length];
                for (int j = 0; j < s.length; j++) {
                    ing[j] = Integer.parseInt(s[j]);
                }
                ArrayList dishes = JDBCPostgres.select("select * from (\n" +
                        "select array_agg(i.number) as ing, dishes.name  from dishes\n" +
                        "                                     join ingredients_dishes id on dishes.id = id.dishes_id\n" +
                        "                                     join ingredients i on i.number = id.ingredients_id\n" +
                        "group by dishes.name) as de\n" +
                        "where ing <@ ARRAY" + Arrays.toString(ing));

                if (dishes.isEmpty()) {
                    System.out.println("� ��������� �� ������ �� ������ ����������� :(\n������ ����������� �����?");
                    String answer = sc.nextLine();
                    if (answer.equals("���") | answer.equals("���") | answer.equals("-")) break;
                } else {
                    System.out.println("�� ������ ������������ �� ������ �����������: ");
                    for (int i = 0; i < dishes.size(); i++) {
                        System.out.println(dishes.get(i));
                    }
                    if (dishes.size() == 1) break;
                    else {
                        System.out.println("������ ������� 1 ��������� �����?");
                        String answer = sc.nextLine();
                        if (answer.equals("��") | answer.equals("��") | answer.equals("+")) {
                            String randomDish = dishes.get((int) (Math.random() * dishes.size())).toString();
                            System.out.println("���� ����� - " + randomDish + "!");
                            String urlDish = randomDish.replace(' ', '+');
                            JsoupCustom.getURL(urlDish);

                            break;
                        }
                        else if (answer.equals("���")) {
                            System.out.println("����� ������� ������� ?");
                            break;
                        }
                        else System.out.println("� ��� �� �������, �� ��������)");
                        break;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("�� ������� �� �����! ��������� ����.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}