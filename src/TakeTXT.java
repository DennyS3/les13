import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Scanner;

public class TakeTXT {
    public void validDoc() {
        Scanner scanner = new Scanner(System.in);
        String tunel = scanner.nextLine();
        try (BufferedReader br = new BufferedReader(new FileReader(tunel))) {
            String read;
            while ((read = br.readLine()) != null) {
                if ((read.startsWith("docnum") || read.startsWith("contract")) && read.length() == 15) {
                    System.out.println(read);
                    valid(read, "документ соответствует параметрам");
                } else if (!(read.startsWith("docnum") || read.startsWith("contract")) && read.length() == 15) {
                    notValid(read, "номер документа не начинается с заданых параметров, но соотвествует длинне");
                }
                else {
                    notValid(read, "документ не соотвествует параметрам длинны и начальных значений");
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void valid(String docText, String message) {
        try {
            File file = new File("D:\\TMS\\les12\\valid.txt");
            if (!file.exists()) {
                file = new File("D:\\TMS\\les12\\valid.txt");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath(), true));
            bw.write(docText
                    + " "
                    + message
                    + "\n");
            bw.close();
        } catch (Exception a) {
            System.out.println(a);
        }
    }
    public void notValid(String docText, String message) {
        try {
            File file = new File("D:\\TMS\\les12\\notValid.txt");
            if (!file.exists()) {
                file = new File("D:\\TMS\\les12\\notValid.txt");
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsolutePath(), true));
            bw.write(docText
                    + " "
                    + message
                    + "\n");
            bw.close();
        } catch (Exception a) {
            System.out.println(a);
        }
    }
}
/*Основное задание
1. Допустим есть txt файл с номерами документов.
                Дополнительное задание
        2. Улучшить предыдущее задание. А именно:
        Валидные номера документов следует записать в один файл-отчет.
        Невалидные номера документов следует записать в другой файл-отчет,
        но после номеров документов следует добавить информацию о том,
        почему этот документ невалиден*/