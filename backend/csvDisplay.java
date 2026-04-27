package backend;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class reads a csv file and displays it
 * 
 * @author Hayden Ralston
 * @version Spring 2026
 */
public class csvDisplay {
    /**
     * Gets the csv file and returns the data
     * 
     * @param file the csv file
     * @return data returns the data list
     */
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

    /**
     * Displays the csv file athe data point
     * 
     * @param data the list of the csv files
     */
    public static void displayCsv(List<String[]> data) {
        for (String[] row : data) {
            for (String value : row) {
                System.out.print(value + "\t");
            }
            System.out.println();
        }
    }


    /**
     * Reads and displays the given csv file
     * 
     * @param args the csv file
     */
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