package com.marchenko.readWritesFiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class Output {
    final private String path;

    Output(String path) {
        this.path = path;
    }

    void write(List<String> rows) {
        try (FileWriter writer = new FileWriter(path);
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {
            for (String row : rows) {
                bufferedWriter.write(row);
                bufferedWriter.flush();
            }
        } catch (
                IOException e) {
            System.out.println();
        }
    }
}
