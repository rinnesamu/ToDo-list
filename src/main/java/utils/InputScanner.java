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

  public static int scanIntMin(int min){
    boolean validInput = false;
    int ans = 0;
    while (!validInput){
      ans = scanInt();
      if (ans >= min){
        validInput = true;
      }else{
        System.out.println("Your answer must be greater or equal than " + min);
      }
    }
    return ans;
  }

  public static int scanIntMax(int max){
    boolean validInput = false;
    int ans = 0;
    while (!validInput){
      ans = scanInt();
      if (ans <= max){
        validInput = true;
      }else{
        System.out.println("Your answer must be lesser or equal than " + max);
      }
    }
    return ans;
  }

  public static int scanIntMinMax(int min, int max){
    boolean validInput = false;
    int ans = 0;
    while (!validInput){
      ans = scanInt();
      if (ans <= max && ans >= min){
        validInput = true;
      }else{
        System.out.println("Your answer must be greater or equal than " + min +
          " and lesser or equal than " + max);
      }
    }
    return ans;
  }

  public static String scanString(){
    return scanner.nextLine();
  }
}
