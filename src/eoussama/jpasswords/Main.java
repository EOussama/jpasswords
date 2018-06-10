package eoussama.jpasswords;

public class Main {

    public static void main(String[] args) {
        String password = "123456789";
        String salt = jPasswords.Generate(20,null);
        String hashed_and_salted_password = jPasswords.Hash(password, salt, -1);

        System.out.println("Auth: " + jPasswords.Authenticate("123456789", salt, hashed_and_salted_password));
        System.out.println("Auth: " + jPasswords.Authenticate("123456789", null, hashed_and_salted_password));
    }
}
