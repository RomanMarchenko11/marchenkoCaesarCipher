package com.marchenko;

import com.marchenko.caesarCipher.CaesarCipher;

public class Runner {
    public static void main(String[] args) {
//         command filepath key
        if (args.length == 2) {
            String command = args[0];
            String path = args[1];
            int key = 3;
            constructor(command, path, key);
        } else if (args.length == 3) {
            String command = args[0];
            String path = args[1];
            int key = Integer.parseInt(args[2]);
            constructor(command, path, key);
        } else if (args.length == 0) {
            CLI printMenu = new CLI();
            printMenu.menu();
        } else {
            throw new IllegalArgumentException("Never arguments - must be 3 commands");
        }
    }
    private static void constructor(String command, String path, int key) {
        CaesarCipher caesarCipher = new CaesarCipher(command, path, key);
        if ("ENCRYPT".equals(command)) {
            caesarCipher.code();
        } else if ("DECRYPT".equals(command)) {
            caesarCipher.decode();
        } else {
            throw new IllegalArgumentException("Unknown command");
        }
    }
}