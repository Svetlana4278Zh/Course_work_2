package functionalProgrammingTask;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        System.out.println("Enter the text:");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        text = text.replaceAll("\\pP", "");
        String[] arrayText = text.split(" ");
        System.out.println("The text has " + arrayText.length + " words");
        System.out.println("TOP 10:");
        String[] uniqueWords = Arrays.stream(arrayText)
                .distinct()
                .toArray(String[]::new);
        Map<String, Long> wordsAndCount = new HashMap();
        for (String value : uniqueWords) {
            wordsAndCount.put(value, Arrays.stream(arrayText).filter(t -> t.equals(value)).count());
        }
        wordsAndCount.entrySet()
                .stream()
                .sorted((o1, o2) -> {
                    int val = o1.getValue().compareTo(o2.getValue())*(-1);
                    if (val == 0){
                        val = o1.getKey().compareTo(o2.getKey());
                    }
                    return val;})
                .limit(10)
                .forEach(e -> System.out.println(e.getValue() + "- " + e.getKey()));;
    }
}
