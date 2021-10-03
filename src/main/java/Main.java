import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        /*HashMap<String, TestSubject> hashMap = new HashMap<>();
        String selectedString = "";
        for (int i = 0; i < 100; i++) {
            TestSubject subject = new TestSubject(i);
            hashMap.put(subject.getId(), subject);
            if (i == 27) {
                selectedString = subject.getId();
            }
        }
        System.out.println(hashMap.get(selectedString).getId());

        if (hashMap.get(selectedString).getId() == selectedString) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        TreeMap<Integer, TestSubject> subjectTreeMap = new TreeMap<>(new TestComparator());

        for (int i = 0; i < 100; i++) {
            TestSubject subject = new TestSubject(i);
            subjectTreeMap.put(subject.getOrdinal(), subject);

        }
        System.out.println(subjectTreeMap.lastEntry());
*/
        Parser parser = new Parser();
        ArrayList<String> list = null;

        File file = new File("voyna.txt");

        try {
            list = parser.parse(file);
        } catch (IOException e) {
            e.printStackTrace();
        }


        int wordCount = getWordCount(list);
        System.out.println("Число вхождение по шаблону 1 способ " + wordCount);
        int wordCountS = getWordCountScanner(file);
        System.out.println("Число вхождение по шаблону 2 способ " + wordCountS);

        ////////////////////////////////////////////////
        System.out.println("Таблица умножения");
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.print(i * j + "_");
            }
            System.out.println("");
        }
        /////////////////////////////////////////////////
    }
        public static int getWordCount(ArrayList<String> list) {
            int wordCount = 0;
            String wordPattern = "страдан";
            Pattern pattern = Pattern.compile(wordPattern, Pattern.CASE_INSENSITIVE);
            for (String s : list) {
                Matcher matcher = pattern.matcher(s);
                while (matcher.find()) {
                    wordCount++;
                }
            }
            return wordCount;
        }

            public static int getWordCountScanner(File file) {
                Scanner scanner = null;
                int wordCountS = 0;
                String wordPattern = "страдан";
                Pattern pattern = Pattern.compile(wordPattern, Pattern.CASE_INSENSITIVE);
                try {
                    scanner = new Scanner(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                while (scanner.hasNextLine())
                {
                    if (scanner.findInLine(pattern) != null)
                    {
                        wordCountS++;
                    }
                    scanner.nextLine();
                }
                return wordCountS;
            //list.forEach(System.out::println);
        }
}
