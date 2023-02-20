package ExamPreparation11;

import java.util.*;
import java.util.stream.Collectors;

public class P01FoodFinder {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] words = new String[]{"pear", "flour", "pork", "olive"};
        String[] foundWords = new String[]{"****", "*****", "****", "*****"};

        Queue<Character> vowels = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> vowels.offer(e.charAt(0)));

        Stack<Character> consonants = new Stack<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(e -> consonants.push(e.charAt(0)));

        while (!consonants.isEmpty()) {
            char vowel = vowels.poll();
            char consonant = consonants.pop();

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                int indexVowel = word.indexOf(vowel);
                int indexConsonant = word.indexOf(consonant);
                if (indexVowel >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexVowel) + vowel + foundWords[i].substring(indexVowel + 1);
                }
                if (indexConsonant >= 0) {
                    foundWords[i] = foundWords[i].substring(0, indexConsonant) + consonant + foundWords[i].substring(indexConsonant + 1);
                }
            }
            vowels.offer(vowel);
        }

        List<String> output = Arrays.stream(foundWords).filter(w -> !w.contains("*")).collect(Collectors.toList());

        System.out.printf("Words found: %d%n", output.size());
        output.forEach(System.out::println);
    }
}
