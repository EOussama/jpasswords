package eoussama.jpasswords;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int count = 10;

        while(count-- > 0)
            System.out.println(jPasswords.Generate(10, null));

    }
}
