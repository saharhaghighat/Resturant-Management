package Utill;

import java.util.Scanner;

public class Util {
    public static String StringInput(String message){
        System.out.println(message);
        Scanner scanner=new Scanner(System.in);
        return scanner.next();
    }
    public static int IntInput(String message){
        System.out.println(message);
        Scanner scanner=new Scanner(System.in);
        return scanner.nextInt();

    }
    public static boolean InputBoolean(String message){
        System.out.println(message);
        Scanner scanner=new Scanner(System.in);
        return scanner.hasNextBoolean();
    }
    public static double IntDouble(String message){
        System.out.println(message);
        Scanner scanner=new Scanner(System.in);
        return scanner.nextDouble();

    }
}
