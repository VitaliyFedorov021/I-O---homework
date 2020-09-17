package ua.com.alevel.iotasks.task1;

import java.io.*;
import java.util.Scanner;

public class Run {
    File file = new File("file.txt");

    public void action() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            Scanner sc = new Scanner(reader);
            String strForCheck;
            int counterForLines = 0, counterForWords = 0;
            while(sc.hasNextLine()) {
                strForCheck = sc.nextLine();
                if (isLineContainsSmth(strForCheck)) {
                    counterForLines++;
                }
                counterForWords = countWordsInLine(strForCheck);
                System.out.println("Line number " + counterForLines + " has " + counterForWords + " words in line");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isLineContainsSmth(String line) {
        if (!line.isBlank()) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isWord(String word) {
        char[] wordArray = word.toCharArray();
        int counter = 0;
        if (wordArray.length == 0) {
            return false;
        }
        for (int i = 0; i < wordArray.length; ++i) {
            if (Character.isLetter(wordArray[i])) {
                counter++;
            }
        }
        boolean res = counter == wordArray.length ? true : false;
        return res;
    }

    private int countWordsInLine(String line) {
        String[] array = line.split(" ");
        int count = 0;
        for (int i = 0; i < array.length; ++i) {
            if (isWord(array[i]) && array[i] != " ") {
                count++;
            }

        }
        return count;
    }
}
