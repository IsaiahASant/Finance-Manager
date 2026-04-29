package backend;

import java.util.HashSet;
import java.util.Set;

/**
 * Generates and tracks unique transaction IDs to prevent repeats.
 *
 * @author Isaiah Santamaria
 * @version Spring 2026
 */
public class TransactionID {
    private static final Set<String> usedIds = new HashSet<>();
    private static int counter = 1;
    
    /**
     *
     * @return a unique transaction ID string
     */
    public static String generateId() {
        String newId;
        do {
            newId = String.format("TXN-%04d", counter);
            counter++;
        } while (usedIds.contains(newId)); // Safety check — skips any pre-registered IDs

        usedIds.add(newId);
        return newId;
    }

    /**
     *
     * @param id the transaction ID to check
     * @return true if the ID is already in use
     */
    public static boolean isIdUsed(String id) {
        return usedIds.contains(id);
    }
}