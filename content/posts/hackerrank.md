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

# Data Structures

## Java 1D Array
An array is a simple data structure used to store a collection of data in a contiguous block of memory. Eache element in the collection is accessed using an index, and the elements are easy to find because they're stored sequentially in memory.

Because the collection of elements in an array is stored as a big block of data, we tipically use arrays when we know exactly how many pieces of data we're going to have. For example, you might use an array to store a list of student ID numbers, or the names of state capitals. To create an array of integers named _myArray_ that can hold four integer values, you would write the following code:

```java
int[] myArray = new int[4];
```

This sets aside a block of memory that's capable of storing 4 integers. Each integer storage cell is assigned a unique index ranging from 0 to one less than the size of the array, and each cell initially contains a 0. In the case of myArray, we can store integers at indices 0, 1, 2, and 3. Let's say we wanted the last cell to store the number 12; to do this, we write:

```Java
myArray[3] = 12
```

Similarly, we can print the contents of the last cell with the following code:

```java
System.out.println(myArray[3]);
```

The code above prints the value stored at index 3 of myArray, which is (the value we previously stored there). It's important to note that while Java initializes each cell of an array of integers with a 0, not all languages do this.

### Task
The code in your editor does the following:

1. Reads an integer from stdin and saves it to a variable, n, denoting some number of integers.
2. Reads n integers corresponding to a0, a1,..., an-1  from stdin and saves each integer a to a variable, val.
3. Attempts to print each element of an array of integers named a.

Write the following code in the unlocked portion of your editor:

1. Create an array, , capable of holding n integers.
2. Modify the code in the loop so that it saves each sequential value to its corresponding location in the array. For example, the first value must be stored in a0, the second value must be stored in a1, and so on.

Good luck!

### Input Format
The first line contains a single integer, n, denoting the size of the array. Each line i of the n subsequent lines contains a single integer denoting the value of element ai.

### Output Format
You are not responsible for printing any output to stdout. Locked code in the editor loops through array a and prints each sequential element on a new line.

### Sample input
```terminal
5
10
20
30
40
50
```

### Sample Output
```terminal
10
20
30
40
50
```

### Explanation
When we save each integer to its corresponding index in a, we get a = [10, 20, 30, 40, 50]. The locked code prints each array element on a new line from left to right.

### Code
```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }
        bufferedReader.close();

        int hourglass = Integer.MIN_VALUE;

        for(int i = 0; i < arr.size() - 2 ; i ++){
            for(int j = 0; j < arr.size() - 2 ; j++){

                int dummy =
                    arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2)
                    +arr.get(i+1).get(j+1)
                    +arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);

                hourglass = Math.max(dummy, hourglass);

            }
        }

        System.out.println(hourglass);

    }
}
```

## Java 2D Array
You are given 6 * 6 2D array. An hourglass in a array is a portion shaped like this:
```terminal
a b c
  d
e f g
```

For example, if we create an hourglassusing the number 1 whithin an array full of zeros, it may look like this:
```terminal
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
```

Actually, there are many hourglasses in the array above. The three leftmost hourglasses are the following
```terminal
1 1 1     1 1 0     1 0 0
  1         0         0
1 1 1     1 1 0     1 0 0
```

The sum of an hourglass is the sum of the all numbers within it. The sum for the hourglasses above are 7, 4 and 2, respectively.
In this problem you have to print the largest sum amoung all the hourglasses in the array

### Input Format
There will be exactly 6 lines, each containing 6 integers separated by spaces.
Each integer will be between -9 and 9 inclusive

### Output Format
Print the answer to this problem on a single line.

### Sample Input
```terminal
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0
```

### Sample Output
```terminal
19
```

### Explanation
```terminal
2 4 4
  2
1 2 4
```

### Code
```java
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < 6; i++) {
            String[] arrRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> arrRowItems = new ArrayList<>();

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowTempItems[j]);
                arrRowItems.add(arrItem);
            }

            arr.add(arrRowItems);
        }

        bufferedReader.close();

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < 4 ; i++){
            for(int j = 0; j < 4; j++){

                int sum =
                    arr.get(i).get(j) + arr.get(i).get(j+1) +arr.get(i).get(j+2)
                    +arr.get(i+1).get(j+1)
                    +arr.get(i+2).get(j) + arr.get(i+2).get(j+1) +arr.get(i+2).get(j+2);

                maxSum = Math.max(sum, maxSum);

            }
        }
        System.out.println(maxSum);
    }
}
```

## Java Subarray
* A subarray of an n-element array is an array composed from a contiguous block of the original array's elements. For example, if array = [1,2,3], then the subarrays are [1], [2], [3], [1,2], [2,3], and [1,2,3]. Something like [1,3] would not be a subarray as it's not a contiguous subsection of the original array.
* The sum of an array is the total sum of its elements.
    * An array's sum is negative if the total sum of its elements is negative.
    * An array's sum is positive if the total sum of its elements is positive.

Given an array of n integers, find and prints its number of negative subarrays on a new line

### Input Format
The first line contains a single integer, n, detoning the lenght of array A = [a0, a2,...,an-1]. The second line contains n space-separated integer describing each respective element ai. in array A

### Constraints
* 1 <= n <= 100
* -10^4 <= ai <= 10^4

### Output Format
Print the number of subarrays of A having negative sums

### Sample Input
```terminal
5
1 -2 4 -5 1
```

### Sample Output
```terminal
9
```

### Explanation
There are nine negative subarrays of A = [1,-2,4,-5,1]

```terminal
1. [1:1] => -2
2. [3:3] => -5
3. [0:1] => 1 + -2 = -1
4. [2:3] => 4 + -5 = -1
5. [3:4] => -5 + 1 = -4
6. [1:3] => -2 + 4 + -4 = -3
7. [0:3] => 1 + -2 + 4 + -5 = -2
8. [1:4] => -2 + 4 + -5 + 1 = -2
9. [0:4] => 1 + -2 + 4 + -5 + 1 = -1
```

Thus, we print 9 on a new line.

### Code
```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);

        int arraySize = sc.nextInt();

        int[] array = new int[arraySize];

        for(int i = 0; i < arraySize; i++){
            array[i] = sc.nextInt();
        }

        int add;
        int addAcumulada = 0;

        for(int i = 0; i < arraySize; i++){

            add = 0;

            for(int j = i; j < arraySize; j++){
                add += array[j];

                if(add < 0)
                    addAcumulada++;
            }
        }
        System.out.println(addAcumulada);
    }
}
```

## Java ArrayList
Sometimes it's better use dinamic size arrays. Java's Arraylist can provide you this feature. Try to solve this problem using Arraylist.
You are given _n_ lines. In each line there are zero or more integers. You need to answer a few queries where you need to tell the number located in y^th position of x^th line

### Input Format
The first line has a integer _n_. In each of the next _n_ lines there will be an integer _d_ denoting number of integers on that line and then there will be _d_ space-separated integers. In the next line there will be an integer _q_ denoting number of queries. Each query will consist of two integers _x_ and _y_
### Constraints
* 1 <= n <= 2000
* 0 <= d <= 5000
* 1 <= q <= 1000
* 1 <= x <= n

Each number will fit in signed integer
Total number of integers in _n_ lines will not cross 10^5

### Output Format
In each line, Output the number located in y^th  position of x^th line. If there is no such position, just print "ERROR!"

### Sample Input
```terminal
5
5 41 77 74 22 44
1 12
4 37 34 36 52
0
3 20 22 33
5
1 3
3 4
3 1
4 3
5 5
```

### Sample Output
```terminal
74
52
37
ERROR!
ERROR!
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
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);

        int firstSize = sc.nextInt();

        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < firstSize ; i++){

            int firstElement = sc.nextInt();
            List<Integer> partList = new ArrayList<>();

            for(int j = 0; j < firstElement; j ++){
                partList.add(sc.nextInt());
            }
            list.add(partList);
        }

        int secondSize = sc.nextInt();
        for(int i = 0; i < secondSize; i++) {

            try{
                System.out.println(list.get(sc.nextInt()-1).get(sc.nextInt()-1));
            }catch(Exception e){
                System.out.println("ERROR!");
            }

        }
    }
}
```

## Java 1D Array (Part 2)
Let's play a game on an array" You're standing at index 0 of an n-element array named game.

From some index i (where 0 <= i <= n). you can perform one of the following moves:

* Move Backward: if cell i -1 exists and contains a 0, you can walk back to cell i - 1.
* Move Forward:

    * If cell i + 1 contains a zero, you can walk to cell i + 1
    * If cell i + leap contains a zero, you can jump to cell i + leap
    * If you're standing in cell n - 1 or the value of i + leap >= n you can walk or jump off the end of the array and win the game

In other words, you can move from index i to index i + 1, i - 1, or i + leap as long as the destination index is a cell containing a 0. If the destination index is greater than n - 1, you win the game.

### Function Description
Complete the canWin function in the edito below.

canWin has the following parameters:

* int leap: the size of the leap
* int game[n]: the array to traverse

### Returns
* boolean: true if the game can be won, otherwise false

### Input Format
The first contains an integer, q denoting the number of queries (i.e. function calls).
The 2 ° q subsequents lines describe each query over two lines:

1. The first line contains two space-separated integers describing the respective values of n and leap
2. The second line contains n space-separated binary integers (i.e. zeroes and ones) describing the respective values of game0, game1,..., gamen-1

### Constraints
* 1 <= q <= 5000
* 2 <= n <= 100
* 0 <= leap <= 100
* It is guaranteed that the value of game[0] is always 0

### Sample Input
```terminal
STDN            Function
----            --------
4               q = 4 (number of queries)
5 3             game[] size n = 5, leap = 3 (first query)
0 0 0 0 0       game = [0, 0, 0, 0, 0]
6 5             game[] size n = 6, leap = 5 (second query)
0 0 0 1 1 1     . . .
6 3
0 0 1 1 1 0
3 1
0 1 0
```

### Sample Output
```terminal
YES
YES
NO
NO
```

### Code
```java
import java.util.*;

public class Solution {

    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.

        return canWinFrom(0, leap, game);

    }

    static boolean canWinFrom(int i, int leap, int[] game){

        if(i >= game.length){
            return true;
        }

        if(i < 0 || game[i] == 1){
            return false;
        }

        game[i] = 1;

        return canWinFrom(i + leap, leap, game ) ||
            canWinFrom(i + 1, leap, game) ||
            canWinFrom(i - 1, leap, game);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
```

## Java List
The first line constains an integer _N_ (the initial number of elements in _L_) The second line contains an integer, _Q_ (the number of queries).

The _2Q_ subsequent lines describe the queries, and each query is described over two lines:

* If the first lines of a query contains the Spring Insert, then the second line constains two space separated integers _x, y_, and the value _y_ must be inserted into _L_ at index _x_.
* If the first line of a query contains the String _Delete_, then the second line contains index _x_, whose element must be deleted from _L_.

### Constraints
* 1 <= N <= 4000
* 1 <= Q <= 4000
* Each element in is a 32-bit integers

### Output Format
```terminal
5
12 0 1 78 12
2
Insert
5 23
Delete
0
```

### Sample Output
```terminal
0 1 78 12 23
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
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList();
        int sizeArray = sc.nextInt();

        for(int i = 0; i<sizeArray; i++){
            list.add(i, sc.nextInt());
        }

        int cicles = sc.nextInt();

        for(int i = 0; i < cicles; i++){

            sc.nextLine();
            String action = sc.nextLine();

            if(action.equals("Insert")){
                list.add(sc.nextInt(), sc.nextInt());
            }

            if(action.equals("Delete")){
                list.remove(sc.nextInt());
            }

        }

        printList(list);
    }

    static void printList(List<Integer> list){
        for(int number : list){
            System.out.print(number + " ");
        }
    }
}
```
