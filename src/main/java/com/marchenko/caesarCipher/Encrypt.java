package com.marchenko.caesarCipher;

class Encrypt {
    final private String line;
    final private int key;

    Encrypt(String line, int key) {
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
            if (digitSymbol >= 65 && digitSymbol <= 90 || digitSymbol >= 97 && digitSymbol<= 122) {
                digitSymbol = digitSymbol + key;
                if ( digitSymbol > 90 && digitSymbol < (97+key)) {
                    digitSymbol = digitSymbol - (91 - 65);
                } else if (digitSymbol > 122) {
                    digitSymbol = digitSymbol - (123 - 97);
                }
            }
            chars[i] = (char) digitSymbol;
        }
        return String.valueOf(chars) + "/n";
    }
}
