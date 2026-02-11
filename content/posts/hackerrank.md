---
title: "Hackerrank"
date: 2026-02-10T16:15:24-06:00
draft: false
---

# Hackerrank

## Java Loops II
We use the integers a,b and n to create the following series:
(a + 2^0 * b),(a + 2^0 * b + 2^1 * b),...,(a + 2^0 * b + 2^1 * b + ... + 2^n-1 * b)
You are given q queries in the form of a, b and n. For each query, print the series corresponding to the given a,b and n values as a single line of n space-separated integers

### Input format
The first line contains an integer q, detoning the number of queries.
Each line i of the q subsequents lines contains three space-separated integers describing the respective ai, bi, and ni values for that query.

### Constraints
0 <= q <= 500
0 <= a,b <= 50
1 <= n <= 15

### Output format
For each query, print the corresponding series on a new linem Each series must be printed in order as a single line of n space-separated integers.

### Sample Input
```terminal
2
0 2 10
5 3 5
```

### Sample Output
```terminal
2 6 14 30 62 126 254 510 1022 2046
8 14 26 50 98
```

### Code
```java
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<=t;i++) {

            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int result = a;
            int power = 1;

            for(int j = 0; j < n ; j++) {
                result += b * power;
                System.out.print(result + " ");
                power *= 2;
            }
            System.out.println();
        }
        in.close();
    }
}
```

## Java Datatypes
Java has 8 primitive date types: char, boolean, byte, shot, int, long, float and double. For this exercise, we'll work with the primitives used to hold integer values (byte, short, int and long):

* A byte is an 8-bit signed integer.
* A short is a 16-bit signed integer.
* An int is a 32-bit signed integer.
* A long is a 64-bit signed integer.

Given a input integer, you most determine which primitive data types are capable of property storing that input.
To get you started, a portion of the solution is provided for you in the editor.

### Reference
https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html

### Input format
The first line contains an integer _T_. denoting the number of test cases. Each test case, _T_, is comprised of a single line with an integer, _n_, which can be arbitrarily large or small

### Output format
For each input variable _n_ and appropriate primitive _dataType_. you must determine if the given primitives are capable of storing it, if yes, then print:

```terminal
n can be fitted in:
* datatype
```

If there is more than one appropriate data type, print each one on its own line and order them by size (i.e.: _byte_ < _short_ < _int_ < _long_)
If the number cannot be stored in one of the four aforementioned primitives, print the line:

```terminal
n can't be fitted anywhere.
```

### Sample Input
```terminal
5
-150
150000
1500000000
213333333333333333333333333333333333
-100000000000000
```

### Sample Output
```terminal
-150 can be fitted in:
* short
* int
* long
150000 can be fitted in:
* int
* long
1500000000 can be fitted in:
* int
* long
213333333333333333333333333333333333 can't be fitted anywhere.
-100000000000000 can be fitted in:
* long
```

### Code
```java
import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {
            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                if(x>=-128 && x<=127)System.out.println("* byte");
                if(x>=-32768 && x<=32767)System.out.println("* short");
                if(x>= Integer.MIN_VALUE && x<=Integer.MAX_VALUE)System.out.println("* int");
                if(x>= Long.MIN_VALUE && x<=Long.MAX_VALUE)System.out.println("* long");
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }
        }
    }
}
```

## Java End-of-file
"In computing, End Of Line (commonly abbreviated EOF) is a condition in a computer operation system where no more data can be read from a data source"
The challenge here is to read _n_ lines of input until you reach EOF, the number and print all _n_ lines of content.

*Hint:* Java's Scanner.hasNext() method is helpful for this problem.

### Input Format
Read some unknown _n_ lines of input from stdin(System.in) until you reach EOF: each line of input contains a non-empty String.

### Output Format
For each line, print the line number, followed by a single space, and then the line content received as input

### Sample Input
```terminal
Hello world
I am a file
Read me until end-of-file.
```

### Sample Output
```terminal
1 Hello world
2 I am a file
3 Read me until end-of-file.
```

### Code
```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int lineNumber = 1;

        while(sc.hasNext()){
            System.out.println(lineNumber + " " + sc.nextLine());
            lineNumber++;
        }
    }
}
```

## Java Static Initializer Block
Static Initialization blocks are executed when the class is loaded, and you can initialize static variables in those blocks
It's time to test you knowledge of Static Initialization blocks.
You are given a class Solution with a main method. Complete the given code so that it outputs the are of a parallelogram with breath _B_ and height _H_. You should read the variables from the standard Input
If _B_ <= 0 or _H_ <= 0, the output should be "java.lang.Exception: Breagth and height must be positive" whithout quotes

### Input Format
There are two lines of input. The first line contains _B_: the breadth of the parallelogram. The next, line contains _H_: the height of the parallelogram

### Constraints

* -100 <= _B_ <= 100
* -100 <= _H_ <= 100

### Output Format

If both values are greater than zero, then the main method must output the area of the parallelogram. Otherwise, print "java.lang.Exception: Breadth and height must be positive" whithout quotes

### Sample Input 1
```terminal
1
3
```

### Sample Output
```terminal
e
```

### Sample Input 2
```terminal
-1
2
```

### Sample Output 2
```terminal
java.lang.Exception: Breadth and height must be positive
```

### Code
```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int B;
    static int H;
    static boolean flag = true;

    static{

        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        H = sc.nextInt();
        if(B < 0 || H < 0){
            flag = false;
            System.out.println("java.lang.Exception: Breadth and height must be positive");
        }
    }

public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}//end of class
```

## Java int to String
You given an integer _n_, you have to convert it into a string.
Please complete the partially completed code in the editor. If your code succefully converts _n_ into a string _s_ the code will print "Good job". Otherwise it will print "Wrong answer"

_n_ can range between -100 to 100 inclusive.

### Code
```java
import java.util.*;
import java.security.*;
public class Solution {
    public static void main(String[] args) {

        DoNotTerminate.forbidExit();

        try {
            Scanner in = new Scanner(System.in);
            int n = in .nextInt();
            in.close();

            String s = String.valueOf(n);

            if (n == Integer.parseInt(s)) {
                System.out.println("Good job");
            } else {
                System.out.println("Wrong answer.");
            }
        } catch (DoNotTerminate.ExitTrappedException e) {
            System.out.println("Unsuccessful Termination!!");
        }
    }
}

//The following class will prevent you from terminating the code using exit(0)!
class DoNotTerminate {

    public static class ExitTrappedException extends SecurityException {

        private static final long serialVersionUID = 1;
    }

    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
                public void checkPermission(Permission permission) {
                    if (permission.getName().contains("exitVM")) {
                        throw new ExitTrappedException();
                    }
                }
        };
        System.setSecurityManager(securityManager);
    }
}
```

## Java Date and Time
The Calendar class is an abstract class that provided methods for converting between a specific instant in time and a set of calendar fields such as YEAR, MONTHm DAY_OF_MONTH, HOUR, and so on, and for manipulating the calendar fields, such as getting the date of the next week.

You are given a date, You just need to write the method, _getDay_, witch returns the day on that date. To simplify your task, we have rpovided a portion of the code in the editor.

### Example
month = 8
day = 14
year = 2017

The method should return _MONDAY_ as the day on that date

### Function description
Complete the findDay function in the editor below
findDay has the following parameters:

* int: month
* int: day
* int: year

### Returns
* string: the day of the week in capital letters

### Input Format
A single line of input containing the space separated month, day and year, respectively, in _MM DD YYYY_ format

### Constraints
2000 < year < 3000

### Sample Input
08 05 2015

### Sample Output
WEDNESDAY

### Explanation
The day on August 5th 2015 was WEDNESDAY

### Code
```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();

        System.out.println("month " + month);
        System.out.println("day" + day);
        System.out.println("year" + year);

        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        calendar.set(Calendar.YEAR, year);

        int deamonDay = calendar.get(Calendar.DAY_OF_WEEK);

        System.out.println(deamonDay);

        return dayOfweek(deamonDay);
    }

    private static String dayOfweek(int day){
        switch(day){
            case Calendar.SUNDAY: return "SUNDAY";
            case Calendar.MONDAY: return "MONDAY";
            case Calendar.TUESDAY: return "TUESDAY";
            case Calendar.WEDNESDAY: return "WEDNESDAY";
            case Calendar.THURSDAY: return "THURSDAY";
            case Calendar.FRIDAY: return "FRIDAY";
            case Calendar.SATURDAY: return "SATURDAY";
            default: return "UNKNOW";
        }
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
```

## Java Currency Formatter
Given a doble-precision number, _payment_, denoting an amount of money, use the NumberFormat class getCurrencyInstance method to convert _payment_ into the US, Indian, Chinese and French currency formatas. Then print the formatted values as follows:

```terminal
US: formattedPayment
India: formattedPayment
China: formattedPayment
France: formattedPayment
```

where _formattedPayment_ is _payment_ formatted according to the appropriate Locale's currency
_Note:_ India does not have built-in Locale, so you must construct one where the lenguage is en (i.e.. English)

### Input Format
A single double-precision number denoting _payment_

### Constraints
```terminal
0 <= payment <= 10^9
```

### Output Format
On the first line, print US: u where u is payment formatted for US currency.
On the second line, print India: i where _i_ is payment formatted for Indian currency.
On the third line, print China: c where _c_  is payment formatted for Chinese currency.
On the fourth line, print France: f, where _f_ is payment formatted for French currency.

### Sample Input
```terminal
12324.134
```

### Sample Output
```terminal
US: $12,324.13
India: Rs.12,324.13
China: ￥12,324.13
France: 12 324,13 €
```

### Explanation
Each line contains the value of payment formatted according to the four countries respective currencies.

### Code
```java
import java.util.*;
import java.text.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        Locale us = Locale.US;
        Locale india = new Locale("en", "IN");
        Locale china = Locale.CHINA;
        Locale france = Locale.FRANCE;

        NumberFormat usFormat = NumberFormat.getCurrencyInstance(us);
        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(india);
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(china);
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(france);


        System.out.println("US: " + usFormat.format(payment));
        System.out.println("India: " + indiaFormat.format(payment));
        System.out.println("China: " + chinaFormat.format(payment));
        System.out.println("France: " + franceFormat.format(payment));
    }
}
```
