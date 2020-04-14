import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * We are given some website visits: the user with name username[i] visited the website website[i] at time timestamp[i].
 * A 3-sequence is a list of websites of length 3 sorted in ascending order by the time of their visits.
 * (The websites in a 3-sequence are not necessarily distinct.)
 * Find the 3-sequence visited by the largest number of users. If there is more than one solution,
 * return the lexicographically smallest such 3-sequence.
 * <p>
 * Input: username = ["joe","joe","joe","james","james","james","james","mary","mary","mary"],
 * timestamp = [1,2,3,4,5,6,7,8,9,10], website = ["home","about","career","home","cart","maps","home","home","about","career"]
 * <p>
 * Output: ["home","about","career"]
 * <p>
 * Explanation:
 * The tuples in this example are:
 * ["joe", 1, "home"]
 * ["joe", 2, "about"]
 * ["joe", 3, "career"]
 * ["james", 4, "home"]
 * ["james", 5, "cart"]
 * ["james", 6, "maps"]
 * ["james", 7, "home"]
 * ["mary", 8, "home"]
 * ["mary", 9, "about"]
 * ["mary", 10, "career"]
 * The 3-sequence ("home", "about", "career") was visited at least once by 2 users.
 * The 3-sequence ("home", "cart", "maps") was visited at least once by 1 user.
 * The 3-sequence ("home", "cart", "home") was visited at least once by 1 user.
 * The 3-sequence ("home", "maps", "home") was visited at least once by 1 user.
 * The 3-sequence ("cart", "maps", "home") was visited at least once by 1 user.
 */

public class AnalyzeUserWebsiteVisitPattern {

    class Entity {
        String name;
        int timestamp;
        String website;

        Entity(String name, int timestamp, String website) {
            this.name = name;
            this.timestamp = timestamp;
            this.website = website;
        }
    }

    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {

        if (username == null || username.length == 0 || timestamp == null || timestamp.length == 0 || website == null || website.length == 0) {
            return new ArrayList<>();
        }

        Entity[] entities = new Entity[username.length];

        for (int i = 0; i < username.length; i++) {
            entities[i] = new Entity(username[i], timestamp[i], website[i]);
        }

        Arrays.sort(entities, ((Entity a, Entity b) -> a.timestamp - b.timestamp));

        Map<String, List<String>> userHistoryMap = new HashMap<>();

        for (Entity entity : entities) {
            List<String> userHistory = userHistoryMap.getOrDefault(entity.name, new ArrayList<String>());
            userHistory.add(entity.website);
            userHistoryMap.put(entity.name, userHistory);
        }

        Map<String, Integer> threeSequenceCountMap = new HashMap<>();

        Map<String, List<String>> threeSequenceListMap = new HashMap<>();

        for (String key : userHistoryMap.keySet()) {
            Set<List<String>> threeSequenceLists = getThreeSequenceLists(userHistoryMap.get(key));

            for (List<String> threeSequenceList : threeSequenceLists) {
                String threeSequence = threeSequenceList.get(0) + "," + threeSequenceList.get(1) + "," + threeSequenceList.get(2);
                threeSequenceCountMap.put(threeSequence, threeSequenceCountMap.getOrDefault(threeSequence, 0) + 1);
                threeSequenceListMap.put(threeSequence, threeSequenceList);
            }

        }

        int maxCount = -1;
        String maxKey = "";

        for (String key : threeSequenceCountMap.keySet()) {
            int val = threeSequenceCountMap.get(key);

            if (val == maxCount && maxKey.compareTo(key) > 0) {
                maxCount = val;
                maxKey = key;
            } else if (val > maxCount) {
                maxCount = val;
                maxKey = key;
            }
        }

        return threeSequenceListMap.get(maxKey);
    }

    public Set<List<String>> getThreeSequenceLists(List<String> list) {
        Set<List<String>> threeSequenceLists = new HashSet<>();

        for (int i = 0; i < list.size() - 2; i++) {
            for (int j = i + 1; j < list.size() - 1; j++) {
                for (int k = j + 1; k < list.size(); k++) {
                    List<String> temp = new ArrayList<>();

                    if (i < list.size() - 2) {
                        temp.add(list.get(i));
                    }

                    if (j < list.size() - 1) {
                        temp.add(list.get(j));
                    }

                    if (k < list.size()) {
                        temp.add(list.get(k));
                    }

                    if (temp.size() == 3) threeSequenceLists.add(temp);
                }
            }
        }

        return threeSequenceLists;
    }

}
