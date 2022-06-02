package HW5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;

public class AppData extends ArrayList<int[]> {
    private String[] headers;

    public AppData(String[] headers) {
        this.headers = headers;
    }

    public AppData(String path) throws IOException, MyArrayDataException {
        readCsv(path);
    }

    public String[] getHeaders() {
        return headers;
    }

    public void saveCsv(String path) throws FileNotFoundException {
        var file = new File(path);
        try (var writer = new PrintWriter(file)) {
            // Write headers.
            writer.println(String.join(";", headers));
            // Write entries.
            for (var entry : this) {
                for (int i = 0; i < entry.length; i++) {
                    writer.print((i == 0 ? "" : ";") + entry[i]);
                }
                writer.println();
            }
        }
    }

    public void readCsv(String path) throws IOException, MyArrayDataException {
        // Remove all entries before loading.
        clear();
        try (
                var file_reader = new FileReader(path);
                var text_buffer = new BufferedReader(file_reader)
        ) {
            // Read headers.
            var textline = text_buffer.readLine();
            if (textline == null) {
                return;
            }
            headers = textline.split(";");
            // Read entries.
            for (int i = 0; (textline = text_buffer.readLine()) != null; i++) {
                var content = new int[headers.length];
                var columns = textline.split(";");
                if (columns.length != headers.length) {
                    throw new IOException(String.format("File '%s' corrupted.", path));
                }
                for (int k = 0; k < columns.length; k++) {
                    var s = columns[k];
                    try {
                        content[k] = Integer.parseInt(s);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(String.format("Unable to parse string value '%s' in row %d, column %d.", s, i + 1, k + 1), e);
                    }
                }
                this.add(content);
            }
        }
    }
}

