import java.util.*;

public class GeneralizedAbbr {
    public static void main(String[] args) {
        List<String> abbrs = new GeneralizedAbbr().generateAbbreviations("wa");
        for(String abbr : abbrs) {
            System.out.println(abbr);
        }
    }

    public List<String> generateAbbreviations(String word) {
        List<String> abbrs = new ArrayList<>();
        generateAbbreviationsBacktrack(abbrs, new StringBuilder(), word, 0, 0);
        return abbrs;
    }

    public void generateAbbreviationsBacktrack(List<String> abbrs, StringBuilder builder, String word, int i, int cosecutiveOnesCount) {
        int length = builder.length();
        if(i == word.length()) {
            if(cosecutiveOnesCount != 0) {
                builder.append(cosecutiveOnesCount);
            }
            abbrs.add(builder.toString());
        } else {
            generateAbbreviationsBacktrack(abbrs, builder, word, i + 1, cosecutiveOnesCount + 1);
            if(cosecutiveOnesCount != 0) {
                builder.append(cosecutiveOnesCount);
            }
            builder.append(word.charAt(i));
            generateAbbreviationsBacktrack(abbrs, builder, word, i + 1, 0);
        }
        builder.setLength(length);
    }

    public String generateAbbreviationsBitMaskSolve(String word, int number) {
        StringBuilder abbr = new StringBuilder();
        int n = word.length();
        int cosecutiveOnesCount = 0;

        for(int i = 0;i < word.length(); i++) {
            if(isLastBitSet(number)) {
                cosecutiveOnesCount++;
            } else {
                if(cosecutiveOnesCount != 0) {
                    abbr.append(cosecutiveOnesCount);
                    cosecutiveOnesCount = 0;
                }
                abbr.append(word.charAt(i));
            }
            number = number >> 1;
        }

        if(cosecutiveOnesCount != 0) {
            abbr.append(cosecutiveOnesCount);
        }

        return abbr.toString();
    }

    public boolean isLastBitSet(int bitSet) {
        return (bitSet & 1) > 0;
    }

    public void generateAbbreviationsSolve(String word, int currentIndex, List<String> abbrs) {
        if(currentIndex < 0) {
            return;
        }

        int length = abbrs.size();
        char c = word.charAt(currentIndex);

        abbrs.addAll(abbrs);

        for(int i = 0;i < length; i++) {
            abbrs.set(i, c + abbrs.get(i));
        }

        for(int i = 0;i < length; i++) {
           String curr = abbrs.get(i + length);
            if(isAlphabet(curr.charAt(0))) {
                abbrs.set(i + length, "1" + curr);
            } else {
                int index = 0;
                while(index < curr.length() && !isAlphabet(curr.charAt(index))) {
                    index++;
                }
                String updatedAbbr = "" + (1 + getIntEq(curr.substring(0, index)));
                if(index < curr.length()) {
                    updatedAbbr = updatedAbbr + curr.substring(index);
                }
                abbrs.set(i + length, updatedAbbr);
            }
        }
        generateAbbreviationsSolve(word, currentIndex - 1, abbrs);
    }

    public boolean isAlphabet(char c) {
        int num = (int) c;
        return num >= 97 && num <= 122;
    }

    public int getIntEq(String str) {
        return Integer.parseInt(str);
    }

}
