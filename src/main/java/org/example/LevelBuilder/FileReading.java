package org.example.LevelBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReading {
    public static int[] readEnemyFile(String path)
    {
        List<String> list = new ArrayList<>();
        try {
            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine;

            while ((readLine = b.readLine()) != null) {
                list.add(readLine);
            }

            b.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return parseLineInputToIntList(list);
    }

    public static int[][] readMapFile(String path)
    {
        int rows = 20;
        int colums = 20;
        int[][] matrix = new int[rows][colums];

        List<String> list = new ArrayList<>();
        try {
            File f = new File(path);
            BufferedReader b = new BufferedReader(new FileReader(f));
            String readLine;
            int i = 0;
            while ((readLine = b.readLine()) != null) {
                list.add(readLine);
                matrix[i] = FileReading.parseLineInputToIntList(list);
                list.clear();
                i++;
            }

            b.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return matrix;
    }

    public static int[] parseLineInputToIntList(List<String> input)
    {
        List<Integer> list = new ArrayList<>();
        for (String line: input)
        {
            String[] numbers = line.split(" ");
            for (String number : numbers) {
                if (!number.isEmpty()) {
                    list.add(Integer.parseInt(number));
                }
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
