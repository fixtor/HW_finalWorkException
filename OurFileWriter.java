import java.io.FileWriter;
import java.io.IOException;

public class OurFileWriter {
    String fileName;
    String fileData;

    public OurFileWriter(String fileName, String fileData) {
        this.fileName = fileName;
        this.fileData = fileData;
    }

    public void writeFile() throws FileNotExistException {
        try (FileWriter fw = new FileWriter(fileName)) {
            fw.write(fileData);
            System.out.println("Файл успешно записан!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileNotExistException(
                    "Catched Exception: " + e.getClass().getSimpleName() + "\nЗапись в файл не выполнена!", e);
        }
    }

    public void addToFile() throws FileNotExistException {
        try (FileWriter fw = new FileWriter(fileName, true)) {
            fw.write(fileData);
            System.out.println("Файл успешно записан!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileNotExistException(
                    "Catched Exception: " + e.getClass().getSimpleName() + "\nЗапись в файл не выполнена!", e);
        }
    }
}