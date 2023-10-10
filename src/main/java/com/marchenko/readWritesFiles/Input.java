package com.marchenko.readWritesFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Input {
    final private String path;

    Input(String path) {
        this.path = path;
    }

    public List<String> read() {
        List<String> rows = new ArrayList<>();
        try (FileReader reader = new FileReader(path);
             BufferedReader bufferReader = new BufferedReader(reader)) {
            String lineReader;
            while ((lineReader = bufferReader.readLine()) != null) {
                rows.add(lineReader + "/n");
            }
        } catch (IOException e) {
            System.out.println();
        }
        return rows;
    }
}