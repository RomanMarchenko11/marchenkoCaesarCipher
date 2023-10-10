package com.marchenko.caesarCipher;

class Decrypt {
    final private String line;
    final private int key;

    Decrypt(String line, int key) {
        this.line = line;
        while (key > 26) {
            key = key - 26;
        }
        this.key = key;
    }

    String start() {
        char[] chars = line.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int digitSymbol = chars[i];
            if (digitSymbol >= 65 && digitSymbol <= 90) {
                digitSymbol = digitSymbol - key;
                if (digitSymbol < 65) {
                    digitSymbol = digitSymbol + (90 - 64);
                }
            } else if (digitSymbol >= 97 && digitSymbol <= 122) {
                digitSymbol = digitSymbol - key;
                if (digitSymbol < 97) {
                    digitSymbol = digitSymbol + (122 - 96);
                }
            }
            chars[i] = (char) digitSymbol;
        }
        return String.valueOf(chars) + "/n";
    }
}
