import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static String[][] table;
    static char[] code;
    static int n = 0;
    static int count = 0;
    static List<String> list = new ArrayList<>();
    static char mat = '→';
    static char not = '¬';
    static char and = '∧';
    static char or = '∨';

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        char[] alphabet = new char[n];
        for (int i = 0; i < n; i++) {
            alphabet[i] = (char) ('A' + i);
            list.add(String.valueOf(alphabet[i]));
        }
        for (int i = n; i < 2 * n; i++) list.add(not + list.get(i - n));
        for (int j = 0; j < n; j++) {
            for (int k = 0; k < n; k++) {
                if (j != k) list.add(list.get(j) + mat + list.get(k));
            }
        }
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                list.add(list.get(j) + and + list.get(k));
            }
        }
        for (int j = 0; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                list.add(list.get(j) + or + list.get(k));
            }
        }
        for (String s : list) System.out.print(s + " ");
        System.out.println();
        int pow = pow(n);
        int size = list.size();
        table = new String[pow][size];
        code = new char[n];
        for (int j = 0; j < n; j++) code[j] = '0';
        gray(n, 0);
        set();
        for (String[] strings : table) {
            for (int i = 0; i < strings.length; i++) {
                System.out.print(strings[i]);
                for (int j = 0; j < list.get(i).length() - 1; j++) System.out.print(" ");
                System.out.print(" ");
            }
            System.out.print(" ");
            System.out.println();
        }
    }

    public static void set() {
        for (int i = 0; i < table.length; i++) {
            for (int j = n; j < table[i].length; j++) {
                String expr = list.get(j);
                if (expr.length() == 2) {
                    int l = expr.charAt(1) - 'A';
                    if (table[i][l].equals("T")) table[i][j] = "F";
                    else table[i][j] = "T";
                } else {
                    char s = expr.charAt(1);
                    int l1 = expr.charAt(0) - 'A';
                    int l2 = expr.charAt(2) - 'A';
                    if (s == mat) {
                        if (table[i][l1].equals("T") && table[i][l2].equals("F")) table[i][j] = "F";
                        else table[i][j] = "T";
                    }
                    if (s == and) {
                        if (table[i][l1].equals("T") && table[i][l2].equals("T")) table[i][j] = "T";
                        else table[i][j] = "F";
                    }
                    if (s == or) {
                        if (table[i][l1].equals("T") || table[i][l2].equals("T")) table[i][j] = "T";
                        else table[i][j] = "F";
                    }
                }
            }
        }
    }

    public static void gray(int size, int i) {//calculate the gray code
        if (i == size) {
            init();
            count++;
        } else {
            gray(size, i + 1);
            if (code[i] == '0') code[i] = '1';
            else code[i] = '0';
            gray(size, i + 1);
        }
    }

    public static void init() {
        for (int i = 0; i < code.length; i++) {
            if (code[i] == '1') table[count][i] = "T";
            else table[count][i] = "F";
        }
    }

    public static int com(int n) {//calculate the combinatorial number
        if (n == 1 || n == 2) return 1;
        int num1 = factorial(n);
        int num2 = factorial(n - 2);
        return num1 / num2;
    }

    public static int factorial(int n) {//calculate the factorial
        if (n == 0 || n == 1) return 1;
        return n * factorial(n - 1);
    }

    public static int pow(int n) {//calculate the power of 2
        if (n == 0) return 1;
        return 2 * pow(n - 1);
    }
}