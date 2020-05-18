/**
 * A
 */
public class A {

    public static void main(String[] args) {
        
        permutations("","fuck");

    }

    private static void permutations(String prefix,String word) {
        if (word.length()==0) {
            System.out.println(prefix);
            return;
        }
        for (int i = 0; i < word.length(); i++) {
            permutations(prefix+word.charAt(i), word.substring(0, i)+word.substring(i+1));
        }
    }
}