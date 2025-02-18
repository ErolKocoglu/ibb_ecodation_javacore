package com.erolkocoglu;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Formatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.Date;

public class Main {

    // 3-) Return lu parametresiz
    public String metotReturluParametresiz() {
        return "metot Returnlu Parametresiz";
    }


    // 4-) Return lu parametreli
    public Integer metotReturluParametreli(int number) {
        return number;
    }

    // Date
    public static void dateMethod() {
        //java.util.Date date= new Date();
        Date now = new Date();
        System.out.println("Şu andaki zaman: " + now);
        System.out.println("1 ocak 1970 yılından şimdi ki zamana kadar geçen sürenin milisaniye cinsinden:" + now.getTime());
        System.out.println("Date:" + now.getDate());
        System.out.println("#######################");
        System.out.println("Day:" + now.getDay());
        System.out.println("Month:" + now.getMonth()); // Saymaya Sıfırdan başlar 0=Ocak 1=Şubat
        System.out.println("Year:" + (1900 + now.getYear()));  // 1900(Ekle veya Çıkar)
        System.out.println("Date yıl:" + (2025 - now.getYear()));
        System.out.println("Hours:" + now.getHours());
        System.out.println("Minutes:" + now.getMinutes());
        System.out.println("Seconds:" + now.getSeconds());
    }

    /*
    ⚠️ Önemli Notlar
    ❌ Eclipse gibi IDE'lerde ANSI renkleri desteklenmez.
    ✅ Terminal, IntelliJ IDEA ve VS Code Terminal'de çalışır.
    ✅ Windows 10+ veya Linux/macOS’ta desteklenir.
    ✅ Windows'ta CMD yerine PowerShell veya Windows Terminal kullanmalısınız.
     */
    public static final String RESET = "\033[0m";  // Renk sıfırlama
    public static final String RED = "\033[31m";   // Kırmızı
    public static final String GREEN = "\033[32m"; // Yeşil
    public static final String YELLOW = "\033[33m";// Sarı
    public static final String BLUE = "\033[34m";  // Mavi
    public static final String PURPLE = "\033[35m";// Mor
    public static final String CYAN = "\033[36m";  // Açık Mavi

    public static String nowFormat1() throws NullPointerException {
        Date now = new Date();
        String specialFormat = "Zaman: "
                .concat(String.valueOf(now.getHours()))
                .concat(":")
                .concat(String.valueOf(now.getMinutes()))
                .concat(":")
                .concat(String.valueOf(now.getSeconds()))
                .toString();
        return specialFormat;
    }

    // 2.YÖNTEM()
    public static String nowFormat2() throws NullPointerException {
        Date now = new Date();
        // %s: String
        // %d: Decimal
        // %f: Float
        return String.format("Şimdiki Zaman: %02d:%02d:%02d", now.getHours(), now.getMinutes(), now.getSeconds());
    }
    // 3.YÖNTEM()
    public static String nowFormat3() throws NullPointerException {
        Date now = new Date();
        Locale locale = new Locale("tr", "TR");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",locale);
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss",locale);
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy HH:mm:ss",locale);
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy hh:mm:ss", locale);
        //SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy HH:mm:ss zzzz",locale);
        String formatedDate = String.format("Şimdiki Zaman: %s", sdf.format(now));
        return new Date().toString() + " - " + formatedDate;
    }

    // Yeni nesil Date
    // LocalDateTime (1)
    public static void localDateFormatMethod1() {
        LocalDateTime now = LocalDateTime.now();
        Locale locale = new Locale("tr", "TR");
        //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",locale);
        //DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss",locale);
        //DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MMM-dd HH:mm:ss",locale);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMMM-dd HH:mm:ss", locale);
        // Normal Çıktı
        System.out.println("Şu andaki zaman: " + now);
        System.out.println("Şu andaki zaman: " + now.format(formatter));
    }


    public static void localDateFormatSetMethod2() {
        Locale locale = new Locale("tr", "TR");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy HH:mm:ss", locale);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime newData= now
                .withDayOfMonth(11) //
                .withMonth(12)  //
                .withYear(2029)
                .withHour(14)
                .withMinute(44)
                .withSecond(23);
        //System.out.println(now);
        System.out.println("Normal Tarih: "+now);
        System.out.println("Değiştirilmiş Tarih: "+newData.format(formatter));
    }

    // formatter1
    public static void formatter1() {
        // Eğer new Formatter yazarsak close() ile manuel kapatmak zorundayız.
        Formatter formatter = new Formatter();
        formatter.format("Merhabalar Adınız: %s, T.C: %d, Fiyat: %f ", "Hamit", 11223344, 44.23);
        System.out.println(formatter);
        formatter.close(); // Belleği serbest bırakma
    }

    // formatter2 (Best Practice)
    public static void formatter2() {
        // Eğer String.format() yazarsak kapatmak zorunda değiliz GC(Garbarage Collector) otomatik çalışır
        String formatterString = String.format("Merhabalar Adınız: %s, T.C: %d, Fiyat: %f ", "Hamit", 11223344, 44.23);
        System.out.println(formatterString);
    }

    // formatter (Best Practice) [String.format()]
    public static void formatter3() {
        String formatterString = String.format("Merhabalar Adınız: %s, T.C: %d, Fiyat: %f ", "Hamit", 11223344, 44.23);
        System.out.println(formatterString);
        System.out.println(YELLOW+formatterString+RESET);
        System.out.println();
    }

    // formatter4
    public static void formatter4() {
        String name = "Hamit";
        int tcNumber = 11223344;
        double price = 44.23;
        System.out.printf("Merhabalar Adınız: %s, T.C: %d, Fiyat: %f ", name, tcNumber, price);
        System.out.println();
        System.out.printf("Merhabalar Adınız: %10s, T.C: %d, Fiyat: %f ", name, tcNumber, price); //%10s: Sağdan 10 karakter genişliğinde
        System.out.println();
        System.out.printf("%-15s %-15d %.3f ", name, tcNumber, price);//%-15s: Sola doğru yasla
    }

    public static void main(String[] args) {
        System.out.println("Starting...");
        //formatter1();
        //formatter2();
        formatter3();
        //formatter4();
        localDateFormatSetMethod2();
        //dateMethod();
        System.out.println(nowFormat1());
        String nowDate2 = nowFormat2();
        System.out.println(nowDate2);
        String nowDate3 = nowFormat3();
        System.out.println(nowDate3);

        localDateFormatMethod1();

        Scanner sc = new Scanner(System.in);
        /*int a, b;

        System.out.println("Enter integer a: ");
        a = sc.nextInt();
        System.out.println("Enter integer b: ");
        b = sc.nextInt();

        System.out.println("Result is: " + ((double) -b / a));*/

        int c;
        System.out.println("Enter celsius value: ");
        c = sc.nextInt();
        System.out.println("Fahrenheit value :" + (c * ((double) 9 / 5) + 32));

        int number;
        System.out.println("Enter number: ");
        number = sc.nextInt();
        if (number % 2 == 0) {
            System.out.println("The number is even");
        } else {
            System.out.println("The number is odd");
        }

        // From zero to the number that user gives

        int input;
        System.out.println("Enter number: ");
        input = sc.nextInt();
        if (input > 100)
            input = 100;
        int total = (input * (input + 1)) / 2;
        if (input >= 47)
            total -= 47;

        System.out.println("Total is: " + total);
        /*
        Solution with loops
        Scanner sc = new Scanner(System.in);
        int input;
        System.out.println("Enter number: ");
        input = sc.nextInt();
        int total=0;
        if(input>100)
            input=100;
        for(int i=1;i<=input;i++){
            if(i==47)
                continue;
            total+=i;
        }
        System.out.println("Total is: "+total);

         */

        String v1="v1";
        String v2="v2";
        System.out.println(v1.hashCode());
        System.out.println(v2.hashCode());

        Main isReturn1 = new Main();

        String result1 = isReturn1.metotReturluParametresiz();
        System.out.println(result1);

        Integer result2 = isReturn1.metotReturluParametreli(123456);
        System.out.println(result2);

        // 1-) Widening Cast - Implicit Cast
        byte cast1Byte = 100; // Küçük olan veriyi
        int cast1Int= cast1Byte; // Büyük olan verinin içine ekledim (Veri kaybı yoktur)
        System.out.println(cast1Int);

        // 2-) Narrowing CAst- Explicit Cast
        int cast2Int=999999999;
        byte cast2Byte= (byte) cast2Int;
        System.out.println(cast2Byte);

        // 3-) char  => Int
        char cast3Char='&';
        int ascii1=cast3Char;
        System.out.println(cast3Char+" harfi ascci olarak karşılığı: "+ascii1);

        int cast3Int=38;
        char ascii2= (char) cast3Int;
        System.out.println(cast3Int+" ascii karşılığı: "+ascii2);

        // 4-)
        // 4-) String => int
        String cast4String="10";
        int cast4Int1=Integer.valueOf(cast4String);
        int cast4Int2=Integer.parseInt(cast4String);
        System.out.println(cast4String+20);
        System.out.println(cast4Int1+20);
        System.out.println(cast4Int2+20);
        // 5-) int => String
        int cast5Int=55;
        String cast5String1=String.valueOf(cast5Int);
        System.out.println(cast5String1);

        int number1, number2;
        System.out.println("Number 1 giriniz");
        number1 = sc.nextInt();

        System.out.println("Number 2 giriniz");
        number2 = sc.nextInt();
        try {
            int result = number1 / number2;
            System.out.println(result);

        } catch (ArithmeticException ai) {
            ai.printStackTrace();
            //ai.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            //ai.getMessage();
        } finally {
            System.out.println("İstisna olsa da olmazsa da mutlaka yapılacak iş");
            sc.close();
        }

        /*
       Exception in thread "main" java.lang.ArithmeticException: / by zero
	   at com.hamitmizrak._2_week._14_1_Exception.main(_14_1_Exception.java:8)
        */
        System.out.println("Son 10.000 satır");

        sc.close();
    }
}