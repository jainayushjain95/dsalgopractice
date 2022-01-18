import java.util.*;

public class LetterTilePossibilities {
    int count;

    public static void main(String[] args) {
        LetterTilePossibilities letterTilePossibilities = new LetterTilePossibilities();
        letterTilePossibilities.numTilePossibilities("AAABBC");
        System.out.println(letterTilePossibilities.count);
    }

    public int numTilePossibilities(String tiles) {
        count = 0;
        Map<Character, Integer> freqMap = getFreqMap(tiles);
        solve(freqMap, 0, tiles.length());
        return count - 1;
    }

    public void solve(Map<Character, Integer> freqMap, int currSize, int n) {
        count++;
        if(currSize == n) {
            return;
        }
        for(Character character : freqMap.keySet()) {
            if(freqMap.get(character) > 0) {
                freqMap.put(character, freqMap.getOrDefault(character, 0) - 1);
                solve(freqMap, currSize + 1, n);
                freqMap.put(character, freqMap.getOrDefault(character, 0) + 1);
            }
        }
    }

    public Map<Character, Integer> getFreqMap(String tiles) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(int i = 0;i < tiles.length(); i++) {
            char c = tiles.charAt(i);
            freqMap.put(c, 1 + freqMap.getOrDefault(c, 0));
        }
        return freqMap;
    }
}
