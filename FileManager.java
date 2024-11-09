package CaesarCipher;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileManager {
    public String fileInput() throws IOException {
        Scanner enteringFile = new Scanner(System.in);
        boolean lie = false;
        List<String> content = List.of();
        String way = null;
        while (!lie) {
            way = enteringFile.nextLine(); // путь к файлу
            Path fileInput = Path.of(way); // Открытие файла
            if (Files.isRegularFile(fileInput) && Files.exists(fileInput)) { // проверка пути к файлу
                content = Files.readAllLines(fileInput); // записывает содержимое в список строк
                lie = true;
            } else {
                System.out.println("Файл не найден");
            }
        }
        return content.toString();
    }

    public void fileOutput(String content) throws IOException {
        Scanner fileOutput = new Scanner(System.in);
        boolean lie = false;
        String createFile = null;
        while (!lie) {

            createFile = fileOutput.nextLine();
            Path file = Path.of(createFile);
            if (!Files.exists(file)) {
                Files.createFile(file);// создание файла и открытие файла
                lie = true;
            } else {
                System.out.println("Удалите или переименуйте файл и начните заново");
            }
        }
        BufferedWriter bufOutput = new BufferedWriter(new FileWriter(createFile));// создаем буфер
        bufOutput.write(content); // запись строк в файл
        bufOutput.close();// закрытие файла

    }
}
