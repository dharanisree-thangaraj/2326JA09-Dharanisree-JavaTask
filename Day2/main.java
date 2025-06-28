public class StringAnalyzer {
    public static void main(String[] args) {
        String str = "Java is simple and powerful"
        String[] words = str.split("\\s+");
        int wordCount = words.length;
        int charCount = str.replace(" ", "").length();
        String reverse = new StringBuilder(str).reverse().toString();
        String longest = "";
        for (String word : words) {
            if (word.length() > longest.length())
                longest = word;
        }
        System.out.println("Original: " + str);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count: " + charCount);
        System.out.println("Reversed: " + reverse);
        System.out.println("Longest Word: " + longest);
    }
}

