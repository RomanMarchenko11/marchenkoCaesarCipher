package com.marchenko.readWritesFiles;

import java.util.List;

public class FileService {

    public List<String> read(String path) {
        Input reader = new Input(path);
        return reader.read();
    }

    public void write(String path, List<String> rows) {
        Output writer = new Output(path);
        writer.write(rows);
    }

    public String newFileName(String path, String command) {
        int dotIndex = path.lastIndexOf(".");
        String newNameFile;
        if ("[ENCRYPTED]".equals(path.substring((dotIndex-11), dotIndex))) {
            newNameFile = path.substring(0,dotIndex-11) + "[" + command + "ED]" + path.substring(dotIndex);
        } else {
            newNameFile = path.substring(0, dotIndex) + "[" + command + "ED]" + path.substring(dotIndex);
        }
        return newNameFile;
    }
}
