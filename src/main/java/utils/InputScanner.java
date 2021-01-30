package utils;

import java.util.Scanner;

public class InputScanner {
  static Scanner scanner = new Scanner(System.in);

  public static int scanInt(){
    boolean validInput = false;
    int ans = 0;
    while (!validInput) {
      try {
        ans = Integer.parseInt(scanner.nextLine());
        validInput = true;
      } catch (Exception e) {
        System.out.println("You need to give integer!\n" +
          "Type another integer!");
      }
    }
    return ans;
  }

  public static String scanString(){
    return scanner.nextLine();
  }
}
