import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubdomainVisitCount {
    public static void main(String[] args) {
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        List<String> list = new SubdomainVisitCount().subdomainVisits(cpdomains);
        System.out.println(list);
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for(String parentDomain : cpdomains) {
            String[] domains = parentDomain.split(" ");
            int freq = Integer.parseInt(domains[0]);
            domains = domains[1].split("\\.");
            String start = domains[domains.length - 1];
            for(int i = domains.length - 1;i >= 0; i--) {
                map.put(start, map.getOrDefault(start, 0) + freq);
                if(i > 0) {
                    start = domains[i - 1] + "." + start;
                }
            }
        }

        for(String entry : map.keySet()) {
            list.add(map.get(entry) + " " + entry);
        }

        return list;
    }
}
