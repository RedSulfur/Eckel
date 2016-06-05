package com.preparation.io;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextFileTest {

    public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException {

        Employee[] list = new Employee[3];
        list[0] = new Employee("John", 1996, 12, 4);
        list[1] = new Employee("Terry", 2000, 4, 16);
        list[2] = new Employee("Darren", 2004, 7, 21);
        /*
        Класс PrintWriter позволяет выполнять операции записи не однобайтными символами,
        а двухбайтными кодовыми единицами в юникоде
        */
        try {
            PrintWriter out = new PrintWriter("/home/sulfur/IdeaProjects/Preparation/Theory/NIO/src/main/java/com/preparation/io/Employee.txt");
            writeData(out, list);
            out.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Класс Scanner - аналог DataInputStream для считывания данных в текстовом формате
        // FileInputStream - позволяет создать поток ввода и присоединить его к конкретному файлу на диске
        try (Scanner in = new Scanner(new FileInputStream("/home/sulfur/IdeaProjects/Preparation/Theory/NIO/src/main/java/com/preparation/io/Employee.txt"))) {

            Employee[] data = readData(in);
            System.out.println("Data fetched: ");
            for (Employee temp : data) {
                System.out.println(temp.toString());
            }

        }

    }

    public static Employee[] readData(Scanner in) {
        int size = in.nextInt();
        Employee[] list = new Employee[size];
        Employee temp;
        in.nextLine();

        ListIterator<Employee> iterator = readEmployee(in).listIterator();

        int i = 0;
        while (iterator.hasNext()) {
            temp = iterator.next();
            list[i++] = temp;
        }

        return list;
    }



    public static List<Employee> readEmployee(Scanner in) {

        String s,name;
        int year, month, day;
        Employee e;
        List<Employee> list = new ArrayList<>();
        Pattern p = Pattern.compile("(\\w+)\\|(\\d+)\\|(\\d+)\\|(\\d+)");
        Matcher m = p.matcher("");

        while (in.hasNext()) {
            s = in.nextLine();
            m.reset(s);

            while (m.find()) {
                name = m.group(1);
                year = Integer.parseInt(m.group(2));
                month = Integer.parseInt(m.group(3));
                day = Integer.parseInt(m.group(4));
                e = new Employee(name, year, month, day);
                System.out.println(e);
                list.add(e);
            }
        }

        return list;
    }


    public static void writeData(PrintWriter out, Employee[] list) {

        out.println(list.length);

        for (Employee employee : list) {
            writeEmployee(out, employee);
        }
    }

    public static void writeEmployee(PrintWriter out, Employee employee) {

        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(employee.getHireDay());

            /**
             * @method get() - returns the value of the given calendar field
             */

        out.println(employee.getName() + "|" + calendar.get(Calendar.YEAR)
                    + "|" + calendar.get(Calendar.MONTH) + "|" + calendar.get(Calendar.DAY_OF_MONTH));

    }
}
