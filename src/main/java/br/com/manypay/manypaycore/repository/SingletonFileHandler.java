package br.com.manypay.manypaycore.repository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class SingletonFileHandler {

    private static class SingletonContainer {
        private static final SingletonFileHandler INSTANCE = new SingletonFileHandler();
    }

    private File file;

    private SingletonFileHandler() {}

    public static SingletonFileHandler getInstance() {
        return SingletonContainer.INSTANCE;
    }

    public void createFile(String filename) throws IOException {
       try {
             if (!(file = new File(filename)).exists()) {
                file.createNewFile();
                System.out.println("File created: " + file.getAbsolutePath());
            } else {
                System.out.println("File already exists!");
                System.out.println(file.getAbsolutePath());
            }
       } catch (Exception e) {
           System.out.println("An error occurred while creating file: " + file.getAbsolutePath());
           e.printStackTrace();
       }
    }

    public void writeToFile(List<String> content, String filename) throws IOException {
        try (FileWriter fileWriter = new FileWriter(filename, true);) {
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(content.toString());
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred while writing to file: " + file.getAbsoluteFile());
            e.printStackTrace();
        }
    }

    public void readFromFile(String filename) throws IOException {
        int linesToRead = 10;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            List<String> lines = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
                if (lines.size() == linesToRead) {
                    processLines(lines);
                    lines.clear();
                }
            }
            if (!lines.isEmpty()) {
                processLines(lines);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading from file: " + this.file.getAbsoluteFile());
        }
    }

    private void processLines(List<String> lines) throws IOException {
        System.out.println("Processing lines...");
        lines.forEach(System.out::println);
    }
}
