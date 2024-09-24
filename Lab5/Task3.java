package Lab5;

public class Task3 {
    public static char firstSingleLetter(String text, int n) {
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (text.charAt(i) == text.charAt(j)) count++;
            }
            if (count == 1) return text.charAt(i);
        }
        return '\0';
    }

    public static void main(String[] args) {
        String text = "ALGORITHM";
        int n = text.length();
        char result = firstSingleLetter(text, n);
        if (result != '\0') System.out.println("First single letter: " + result);
        else System.out.println("No single letter found");
    }
}
