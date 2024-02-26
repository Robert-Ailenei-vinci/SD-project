import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Graph {
    private Map<String, City> correspondanceNomCity;
    private Map<Integer, City> correspondanceIdCity;

    private Map<City, Set<Road>> outputRoads;


    public Graph(File city, File roads) {
        correspondanceNomCity = new HashMap<String, City>();
        correspondanceIdCity = new HashMap<Integer, City>();
        outputRoads = new HashMap<City,Set<Road>>();

        try (Scanner scanner = new Scanner(city)) {

            // Read each line from the file until there are no more lines
            while (scanner.hasNextLine()) {
                // Extract data from the current line
                String line = scanner.nextLine();

                // Split the line into parts based on the comma
                String[] parts = line.split(",");

                // Extract individual data fields
                int id = Integer.parseInt(parts[0]);
                String cityName = parts[1];
                double latitude = Double.parseDouble(parts[2]);
                double longitude = Double.parseDouble(parts[3]);

                // Process the extracted data (you can print it, store it, etc.)
                City toAdd = new City(id, cityName, longitude, latitude);
                correspondanceIdCity.put(id, toAdd);
                correspondanceNomCity.put(cityName, toAdd);
                outputRoads.put(toAdd,new HashSet<>());
            }

            // Close the scanner

        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            // Handle the case where there's an issue parsing numbers
            throw new RuntimeException(e);
        }

        try (Scanner scanner = new Scanner(roads)) {

            // Read each line from the file until there are no more lines
            while (scanner.hasNextLine()) {
                // Extract data from the current line
                String line = scanner.nextLine();

                // Split the line into parts based on the comma
                String[] parts = line.split(",");

                // Extract individual data fields
                City depart = correspondanceIdCity.get(Integer.parseInt(parts[0]));
                City finnish = correspondanceIdCity.get(Integer.parseInt(parts[1]));


                // Process the extracted data (you can print it, store it, etc.)
                outputRoads.get(depart).add(new Road(depart,finnish));
            }

            // Close the scanner

        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            throw new RuntimeException(e);
        } catch (NumberFormatException e) {
            // Handle the case where there's an issue parsing numbers
            throw new RuntimeException(e);
        }

    }


    public String calculerItineraireMinimisantNombreRoutes(String start, String finnish) {

        return null;
    }


    public String calculerItineraireMinimisantKm(String start, String finnish) {

        return null;
    }
}
