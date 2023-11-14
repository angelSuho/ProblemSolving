import java.util.*;
import java.time.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] parts = term.split(" ");
            termMap.put(parts[0], Integer.parseInt(parts[1]));
        }

        LocalDate todayDate = LocalDate.parse(today.replace(".", "-"));
        List<Integer> toBeDisposed = new ArrayList<>();

        for (int i = 0; i < privacies.length; i++) {
            String[] privacyParts = privacies[i].split(" ");
            LocalDate collectedDate = LocalDate.parse(privacyParts[0].replace(".", "-"));
            int monthsToAdd = termMap.get(privacyParts[1]);
            LocalDate disposalDate = collectedDate.plusMonths(monthsToAdd);
            if (disposalDate.isBefore(todayDate) || disposalDate.isEqual(todayDate)) {
                toBeDisposed.add(i + 1);
            }
        }

        return toBeDisposed;
    }
}