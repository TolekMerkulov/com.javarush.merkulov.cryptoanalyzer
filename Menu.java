package CaesarCipher;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {
    public static void menu() throws IOException {
        FileManager fileManager = new FileManager();
        Cipher encryption = new Cipher();
        BruteForce bruteForce = new BruteForce();
        Scanner console = new Scanner(System.in);

        System.out.println("Выберите пункт меню:");
        System.out.println("1. Шифрование");
        System.out.println("2. Расшифровка с ключом");
        System.out.println("3. Brute force");
        System.out.println("0. Выход");

        int number = console.nextInt();
        switch (number) {
            case 1: {

                System.out.println("Укажите путь к файлу");
                String m = fileManager.fileInput();
                String file = encryption.encoder(m);
                System.out.println("Шифрование завершено. \nУкажите имя и путь, чтобы сохранить результат.");
                fileManager.fileOutput(file);
                System.out.println("Результат сохранен.\nХотите продолжить?\n1. Да\n2. Нет");
                Scanner s = new Scanner(System.in);
                int l = s.nextInt();
                if (l == 1) {
                    menu();
                } else {
                    System.out.println("Завершение работы");
                    System.exit(0);
                }
            }
            case 2: {
                System.out.println("Укажите путь к файлу");
                String file = encryption.decoder(fileManager.fileInput());
                System.out.println("Расшифровка завершена \n Укажите имя и путь, чтобы сохранить результат.");
                fileManager.fileOutput(file);
                System.out.println("Результат сохранен.\nХотите продолжить?\n1. Да\n2. Нет");
                Scanner s = new Scanner(System.in);
                int l = s.nextInt();
                if (l == 1) {
                    menu();
                } else {
                    System.out.println("Завершение работы");
                    System.exit(0);
                }
            }
            case 3: {
                bruteForce.bruteForce();
                System.out.println("Хотите продолжить?");
                System.out.println("1. Да");
                System.out.println("2. Нет");
                Scanner s = new Scanner(System.in);
                int l = s.nextInt();
                if (l == 1) {
                    menu();
                } else {
                    System.out.println("Завершение работы");
                    System.exit(0);
                }
            }
            case 0: {
                System.out.println("Завершение работы");
                System.exit(0);
            }

        }

    }
}
