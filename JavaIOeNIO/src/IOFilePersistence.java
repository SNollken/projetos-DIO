

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Stream;

public class IOFilePersistence implements FilePersistence {

    private final String currentDir = System.getProperty("user.dir");

    private final String storedDir = "/managedFiles/IO/";

    private final String fileName;

    public IOFilePersistence(final String fileName) {
        this.fileName = fileName;
        var file = new File(currentDir + storedDir);
        if (!file.exists() && !file.mkdirs()) {
            throw new RuntimeException("Erro ao criar arquivo");
        }

        clearFile();

    }

    @Override
    public String write(final String data) {
        try (var fileWriter = new FileWriter(currentDir + storedDir + fileName, true); var bufferedWrite = new BufferedWriter(fileWriter); var printWriter = new PrintWriter(bufferedWrite);) {
            printWriter.println(data);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return data;
    }

    @Override
    public boolean remove(final String sentence) {
        var contentList = toListString();

        if (contentList.stream().noneMatch(c -> c.contains(sentence))) {
            return false;
        }

        // Limpa o arquivo antes de reescrever
        try (var writer = new PrintWriter(currentDir + storedDir + fileName)) {
            writer.print(""); // limpa o arquivo
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Escreve apenas as linhas que não contêm o 'sentence'
        contentList.stream()
                .filter(c -> !c.contains(sentence) && !c.isBlank())
                .forEach(this::write);

        return true;
    }

    @Override
    public String replace(final String oldContent, final String newContent) {
        var contentList = toListString();

        if (contentList.stream().noneMatch(c -> c.contains(oldContent))) {
            return "";
        }

        clearFile();
        contentList.stream()
                .map(c -> c.contains(oldContent) ? newContent : c)
                .forEach(this::write);
        
        return newContent;
    }



    @Override
    public String findAll() {
        var content = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))) {
            String line;

            do {
                line = reader.readLine();
                if ((line != null)) {
                    content.append(line)
                            .append(System.lineSeparator());
                }
            } while (line != null);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public String findBy(final String sentence) {
        var found = "";

        try (var reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))) {
            String line = reader.readLine();
            while (line != null) {
                System.out.println("Linha lida: [" + line + "]");
                if (line.contains(sentence)) {
                    System.out.println("Encontrado: " + line);
                    found = line;
                    break;
                }
                line = reader.readLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return found;
    }

    private ArrayList<String> toListString() {
        var content = findAll();
        return new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
    }
    private void clearFile() {

        try (OutputStream outputStream = new FileOutputStream(new File(currentDir + storedDir + fileName))) {

            System.out.printf("inicializando recursos (%s) \n", currentDir + storedDir + fileName);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    private void createFile() {

    }

}
