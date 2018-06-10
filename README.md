<h1 align="center">jPasswords</h1>

## Description
A simple Java class to facilitate working with passwords, it provides some of the most basic tools like password and salt generators, password salting, password authentification and more.

---

## Functions

### I. `Generate`

#### 1. Syntax
```java
public static String Generate(int chars, String[] entries)
```
#### 2. Description
Generates a random string with the given parameters, can be used as salt string or password generator.

#### 3. Parameters
| Parameter     | Description   |
| ------------- |:--------------|
| chars         | The number of characters you want the generated string to have |
| entries      | The characters you want the generated string to be formed with      |

#### 4. Usage
Basic example:
```java
String randStr = jPasswords.Generate(30, null);

// This will generate a random string of 30 characters that includes lower case characters, upper case characters, numbers, and symbols.
// Probable output: ehDonRDxkvlTvnnt*8sK@$%gfmXfLM
```

We can also control the characters that we want to be used to generate the random string, there are four constants included with the jPasswords class, `UPPER_CASE`, `LOWER_CASE`, `NUMBERS`, `SYMBOLS`:

```java
String randStrUpperCase = jPasswords.Generate(30, new String[] { jPasswords.UPPER_CASE } );
String randStrLowerCase = jPasswords.Generate(30, new String[] { jPasswords.LOWER_CASE });
String randStrNumbers = jPasswords.Generate(30, new String[] { jPasswords.NUMBERS });
String randStrSymbols = jPasswords.Generate(30, new String[] { jPasswords.SYMBOLS });

System.out.println(randStrUpperCase);
System.out.println(randStrLowerCase);
System.out.println(randStrNumbers);
System.out.println(randStrSymbols);

// Output:
// DUHJXTKUMNFAQEIKYEKVJGRHKOZMMF
// zdhbljnimkjlwwwgdwspvejkwmpwux
// 239566729995459210073134446044
// @ &% ^&$*&@ &&%&@#**#*#^&!$%@&
```

We can also have multiple entries at once:

```java
String randStrUpperCaseNumbers = jPasswords.Generate(30, new String[] { jPasswords.UPPER_CASE, jPasswords.NUMBERS } );
String randStrLowerCaseSymbolsUpperCase = jPasswords.Generate(30, new String[] { jPasswords.LOWER_CASE, jPasswords.SYMBOLS, jPasswords.UPPER_CASE });

System.out.println(randStrUpperCaseNumbers);
System.out.println(randStrLowerCaseSymbolsUpperCase);

// Output:
// 6B0PSZB2N1OX8EMIQTBVY1WWG7R5UK
// bPefIdDG$HJvVCNvFry$Bc#mGEwUJd
```

In addition to all of the above, we can use custom entries all we want:

```java
String custStr1 = jPasswords.Generate(30, new String[] {"ABC123"});
String custStr2 = jPasswords.Generate(30, new String[] {"Morocco", jPasswords.NUMBERS});

System.out.println(custStr1);
System.out.println(custStr2);

// Output:
// A11112CCB22A33B3311B3C332ACBCC
// c41639o3850o08c7M7264oc8ro91o6
```

Just remember, passing `null` or an empty array to the `entries` parameter will generate a string of upper case characters, lower case characters, numbers, and symbols.

### II. `Hash`

#### 1. Syntax
```java
public static String Hash(String password, String salt, int chars)
```
#### 2. Description
Uses a simple hashing algorithm to hash a given password, adding a salt or specifying the output length are optional.

#### 3. Parameters
| Parameter     | Description   |
| ------------- |:--------------|
| password         | The password or string you want to hash |
| salt      | Optional salt that you want to add      |
| chars      | The output length      |

#### 4. Usage
Basic example:
```java
String password = "password123";
String hashed_password = jPasswords.Hash(password, null, -1);

System.out.println("Password: " + password);
System.out.println("Hashed password: " + hashed_password);

// Output:
// Password: password123
// Hashed password: >=<o}zB~~lp
```

Adding some salt:

```java
String password = "password123";
String salt = jPasswords.Generate(128, new String[] { jPasswords.LOWER_CASE, jPasswords.UPPER_CASE, jPasswords.NUMBERS });
String hashed_password = jPasswords.Hash(password, null, -1);
String salted_password = jPasswords.Hash(password, salt, 50);

System.out.println("Password: " + password);
System.out.println("Hashed password: " + hashed_password);
System.out.println("Salt: " + salt);
System.out.println("Salted password: " + salted_password);

// Output:
// Password: password123
// Hashed password: >=<o}zB~~lp
// Salt: 1MVhLQYRcg8avaTBYOlkP5wSoRjukYwaymLrAHFm1iD7bpUT9ftdzl5xM8tQ2zFOMUXw4k3n2oKl0hsajNcAqfXVpDkCc2mR9GeQjUf3hIsCOn5tuAh2mQxWNRWOcN7W
// Salted password: B"9N:B=9Bc<X}S,`_ Y:.^4S~Q@U<P2$=X}N.V/[ACQ\,N9UL^
```

We pass -1 as the last parameter of the `Hash` function to output the full string, otherwise, we can pass any positive value to control the output string's length.

### III. `Authenticate`

#### 1. Syntax
```java
public static boolean Authenticate(String password, String salt, String target)
```
#### 2. Description
Compares two passwords and returns `true` if they match, otherwise, returns `false`.

#### 3. Parameters
| Parameter     | Description   |
| ------------- |:--------------|
| password         | The password or string you want check |
| salt      | Optional salt that you want to add      |
| target      | The targeted password or salted password you want the `password` parameter to compare to      |

#### 4. Usage
Basic example:
```java
String password = "123456789";
String hashed_password = jPasswords.Hash(password, null, -1);

System.out.println("Auth: " + jPasswords.Authenticate("12345678", null, hashed_password));
System.out.println("Auth: " + jPasswords.Authenticate("123456789", null, hashed_password));

// Output:
// Auth: false
// Auth: true
```

Adding some salt:

```java
String password = "123456789";
String salt = jPasswords.Generate(20,null);
String hashed_and_salted_password = jPasswords.Hash(password, salt, -1);

System.out.println("Auth: " + jPasswords.Authenticate("123456789", salt, hashed_and_salted_password));
System.out.println("Auth: " + jPasswords.Authenticate("123456789", null, hashed_and_salted_password));

// Output:
// Auth: false
// Auth: true
```