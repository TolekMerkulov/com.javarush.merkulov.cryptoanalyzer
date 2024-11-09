package CaesarCipher;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BruteForce {
    private static final char[] ALPHABET = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з',
            'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ',
            'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»', '"', '\'', ':', '!', '?', ' '};

    public void bruteForce() throws IOException {
        FileManager fileManager = new FileManager();
        String content = fileManager.fileInput();
        boolean lie = false;
        StringBuilder stringBuilder = new StringBuilder();
        String nameFile;
        while (!lie) {
            for (int key = 0; key <= ALPHABET.length; key++) {
                stringBuilder.setLength(0);
                char[] chars = content.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (int j = 0; j < ALPHABET.length; j++) {
                        int count = (j - key + ALPHABET.length) % ALPHABET.length;
                        if (chars[i] == ALPHABET[j] || chars[i] == Character.toUpperCase(ALPHABET[j])) {
                            if (Character.isUpperCase(chars[i])) {
                                chars[i] = Character.toUpperCase(ALPHABET[count]);
                            } else {
                                chars[i] = ALPHABET[count];
                            }
                            stringBuilder.append(chars[i]);
                            break;
                        }
                    }
                }
                lie = true;
                nameFile = "result" + key + ".txt";
                fileOutput(nameFile, stringBuilder.toString());
            }

        }

    }

    public void fileOutput(String nameFile, String content) throws IOException {
        Scanner input = new Scanner(System.in);
        String way;
        System.out.println("Введите путь к папке для сохранения файла");
        while (true) {
            way = input.nextLine();
            if (Files.isDirectory(Path.of(way))) {
                break;
            } else System.out.println("Неверно введен путь к папке");
        }
        Path file = Paths.get(way);
        Path name = file.resolve(nameFile);
        if (!Files.exists(name)) {
            Files.createFile(name);
        }
        try (BufferedWriter bufOutput = new BufferedWriter(new FileWriter(name.toString()))) { // создаем буфер
            bufOutput.write(content); // запись строк в файл
        }
    }
}
