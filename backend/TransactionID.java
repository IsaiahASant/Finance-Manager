package backend;

import java.util.HashSet;
import java.util.Set;

/**
 * Utility class responsible for generating and tracking unique transaction IDs.
 * Ensures that no duplicate transaction IDs are created during runtime.
 *
 * IDs are generated in the format: ID-0001, ID-0002, etc.
 *
 * @author Isaiah Santamaria
 * @version Spring 2026
 */
public class TransactionID {
    private static final Set<String> usedIds = new HashSet<>();
    private static int counter = 1;
    
    /**
     * return a unique transaction ID string
     *
     * @return a unique transaction ID string
     */
    public static String generateId() {
        String newId;
        do {
            newId = String.format("ID-%04d", counter);
            counter++;
        } while (usedIds.contains(newId)); // Safety check — skips any pre-registered IDs

        usedIds.add(newId);
        return newId;
    }

    /**
     * Checks whether a given transaction ID has already been used.
     *
     * @param id the transaction ID to check
     * @return true if the ID is already in use, false otherwise
     */
    public static boolean isIdUsed(String id) {
        return usedIds.contains(id);
    }
}