package HW_03.Models;

import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private String path;
    private User user;

    public FileManager(User user) {
        this.user = user;
        this.path = "HW_03/data/" + user.getUserSurname().toString() + ".txt";
    }

    public void write() throws IOException {
        try (FileWriter writer = new FileWriter(this.path, true)) {
            writer.write(this.user.toString());
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            throw new IOException(e.getMessage());
        }

    }
}
