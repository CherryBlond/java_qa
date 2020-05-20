package com.geekbrains.java.files;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AppData {
    private String[] header;
    private int[][] data;

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public int[][] getData() {
        return data;
    }

    public void setData(int[][] data) {
        this.data = data;
    }

    public boolean save(String filePath) {
        try {
            PrintWriter out = new PrintWriter(filePath);

            out.print(String.join(";", header));

            for (int[] line : data) {
                out.print("\n");

                boolean firstNumber = true;
                for (int number : line) {
                    if (!firstNumber) {
                        out.print(";");
                    }
                    firstNumber = false;
                    out.print(number);
                }
            }
            out.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean read(String filePath) {
        try {
            List<String> allLines = Files.readAllLines(Paths.get(filePath));
            if (allLines.size() == 0) {
                header = new String[0];
                data = new int[0][0];
                return true;
            }

            header = allLines.get(0).split(";");
            data = new int[allLines.size()-1][header.length];

            for (int i = 1; i < allLines.size(); i++) {
                String line = allLines.get(i);
                data[i - 1] = new int[header.length];

                String[] lineParts = line.split(";");
                for (int j = 0; j < lineParts.length; j++) {
                    data[i - 1][j] = Integer.parseInt(lineParts[j]);
                }
            }

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
