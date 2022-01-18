import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithDuration {

    public static void main(String[] args) {
        int[] time = {284,263,416,360};
        System.out.println(new PairsOfSongsWithDuration().numPairsDivisibleBy60(time));
    }
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0;i < time.length; i++) {
            if (time[i] % 60 == 0) {
                count += map.getOrDefault(0, 0);
                map.put(0, 1 + map.getOrDefault(0, 0));
            } else {
                int rem = time[i] % 60;
                count += map.getOrDefault(60 - rem, 0);
                map.put(rem, 1 + map.getOrDefault(rem, 0));
            }
        }

        return count;
    }


}
