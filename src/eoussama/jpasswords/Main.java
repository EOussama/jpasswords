package eoussama.jpasswords;

public class Main {

    public static void main(String[] args) {
        String password, salt, result;

        password = "password123";
        salt = "fpogjp,";//jPasswords.Generate(128, null);
        result = jPasswords.Hash(password, salt, -1);

        System.out.println("Password: \t" + password);
        System.out.println("Salt: \t\t" + salt);
        System.out.println("Result: \t" + result);
    }
}
