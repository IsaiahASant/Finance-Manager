import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class csvDisplay {
    public static List<String[]> getCsv(String file) {
        List<String[]> data = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                data.add(values);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return data;
    }

    public static void displayCsv(List<String[]> data) {
        for (String[] row : data) {
            for (String value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java csvDisplay <csv-file-path>");
            return;
        }

        String file = args[0];

        List<String[]> data = getCsv(file);
        displayCsv(data);
    }
}