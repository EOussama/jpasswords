package eoussama.jpasswords;

public class Main {

    public static void main(String[] args) {
        System.out.println(jPasswords.Hash("teamdrd", jPasswords.Generate(128, new String[] { jPasswords.NUMBERS, jPasswords.LOWER_CASE }), 10));
    }
}
