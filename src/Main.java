import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {

    System.out.println("Здравствуйте, это программа переворачивает введенную строку.");
    System.out.println("Введите строку(не менее трех символов):");
    String s = "";
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    while (s.length() < 3) {
      s = reader.readLine();
      if (s.length() < 3) {
        System.out.println("Строка меньше трех символов, повторите ввод!");
      } else {
        System.out.println("Оригинал - " + s);
        System.out.println("Развернутая строка - " + reverseString(s));
        measureTime(s, 1000);
        measureTime(s, 10_000);
        measureTime(s, 100_000);
      }
    }


  }

  private static String reverseString(String s) {
    StringBuilder stb = new StringBuilder();
    for (int i = s.length() - 1; i >= 0; i--) {
      stb.append(s.charAt(i));
    }
    return stb.toString();
  }

  private static void measureTime(String s, int count) {

    long start = System.currentTimeMillis();
    for (int i = 0; i < count; i++) {
      reverseString(s);
    }
    long finish = System.currentTimeMillis();
    long timeElapsed = finish - start;

    System.out.println("Время работы за " + count + " повторений - " + timeElapsed + "ms");
  }

}
