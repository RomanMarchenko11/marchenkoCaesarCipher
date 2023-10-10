package com.marchenko;

import com.marchenko.caesarCipher.CaesarCipher;
import java.util.Scanner;

public class CLI {
    final private Scanner scanner = new Scanner(System.in);
    private boolean isWork = true;
    public void menu() {


        System.out.println("Программа шифрування та дешифрування вітає вас.");

        while (isWork) {
            CaesarCipher caesarCipher;
            System.out.println("Вкажіть шлях до файлу:");
            String path = scanner.nextLine();

            System.out.println("Задайте ключ шифрування (0 - default key):");
            int key = scanner.nextInt();

            System.out.println("Choose command:");
            System.out.println("1 - encrypt");
            System.out.println("2 - decrypt");
            System.out.println("3 - exit");

            int number = scanner.nextInt();
            switch (number) {
                case 1: {
                    caesarCipher = new CaesarCipher("ENCRYPT", path, key);
                    caesarCipher.code();
                    break;
                }
                case 2: {
                    caesarCipher = new CaesarCipher("DECRYPT", path, key);
                    caesarCipher.decode();
                    break;
                }
                case 3: {
                    isWork = false;
                    break;
                }
                default: {
                    System.out.println("Введено невірне значення.");
                }
            }
            scanner.nextLine();
        }
        scanner.close();
    }
}
