import java.io.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;

public class TakeTXT {
    public void validDoc() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> docPull = new ArrayList<>();
        String docTunel = null;
        while ((docTunel = scanner.nextLine()) != null) {
            if ("0".equals(docPull)) {
                break;
            } else {
                docPull.add(docTunel);
            }
        }
        Set<String> docNum = new HashSet<String>();
        File file = new File("src");
        for (String elem : docPull) {
            try (BufferedReader br = new BufferedReader(new FileReader(elem))) {
                String read;
                while ((read = br.readLine()) != null) {
                    docNum.add(read);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }
        for (String elem :
                docNum) {
            if ((elem.startsWith("docnum") || elem.startsWith("contract")) && elem.length() == 15) {
                System.out.println(read);
                valid(read, "документ соответствует параметрам");
            } else if (!(read.startsWith("docnum") || read.startsWith("contract")) && read.length() == 15) {
                notValid(read, "номер документа не начинается с заданых параметров, но соотвествует длинне");
            } else {
                notValid(read, "документ не соотвествует параметрам длинны и начальных значений");
            }
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
1. Вернемся к домашнему заданию занятия номер 12 и модифицируем его.
Программа должна получать имена файлов с номерами документов с
консоли: каждая новая строка - это путь к файлу и имя файла.
Для завершения ввода списка файлов следует ввести 0.
После получения списка документов программа должна обработать
каждый документ: вычитать из файла номера документов и
провалидировать их.
В конце работы создать один файл отчет с выходной информаций: номер
документа - комментарий(валиден или не валиден и по какой причине).
Пусть каждый файл содержит каждый номер документа с новой строки и
в строке никакой другой информации, только номер документа.
Валидный номер документа должен иметь длину 15 символов и
начинаться с последовательности docnum(далее любая
последовательность букв/цифр) или kontract(далее любая
последовательность букв/цифр).
Учесть, что номера документов могут повторяться в пределах одного
файла и так же разные документы могут содержать одни и те же номера
документов.
Если номера документов повторяются, то повторные номера документов
не проверять, не валидировать.
Немного технических деталей
1) Считать с консоли список документов: раз список - то это коллекции
типа List, никаких других условий нет - значит все имена файлов с
консоли сохраняем в структуру данных ArrayList.
2) Номера документов могут повторяться, но повторные документы
обрабатывать не надо и валидировать не надо,т.е. по сути дубликаты
нам не нужны - значит, надо считать номера документов из файлов и все
номера документов сохранять в коллекцию типа Set. Других условий нет,
значит можно использовать HashSet.
3) В конце должна быть структура номер документа - комментарий - т.е.
эта структура типа ключ-значений,значит это коллекция типа Map.
Других условий нет - значит, можно использовать HashMap. Создать
такую структуру и уже потом сделать цикл по этой структуре и записать
всю информацию из этой мапы в файл-отчет. */