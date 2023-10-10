package com.marchenko.caesarCipher;

import com.marchenko.readWritesFiles.FileService;

import java.util.ArrayList;
import java.util.List;

public class CaesarCipher {
    final private String command;
    final private String path;
    final private int key;
    final private FileService fileService = new FileService();

    public CaesarCipher(String command, String path, int key) {
        this.command = command;
        this.path = path;
        this.key = key;
    }

    public void code() {
        List<String> rows = fileService.read(path);
        List<String> rowsTowrite = new ArrayList<>();
        for (String row : rows) {
            Encrypt encrypt = new Encrypt(row, key);
            rowsTowrite.add(encrypt.start());
        }
        String newPath = fileService.newFileName(path, command.toUpperCase());
        fileService.write(newPath, rowsTowrite);
    }

    public void decode() {
        List<String> rows = fileService.read(path);
        List<String> rowsTowrite = new ArrayList<>();
        for (String line : rows) {
            Decrypt decrypt = new Decrypt(line, key);
            rowsTowrite.add(decrypt.start());
        }
        String newPath = fileService.newFileName(path, command.toUpperCase());
        fileService.write(newPath, rowsTowrite);
    }
}