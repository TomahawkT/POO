package TP2;

public class Deletrear {
    public static void main(String args[]){
        for (String arg : args) {
            int j = 0;
            for (; j < arg.length() - 1; j++) {
                System.out.print(arg.charAt(j) + "-");
            }
            System.out.println(arg.charAt(j));

        }
    }
}
