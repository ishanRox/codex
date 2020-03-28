import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class main {
  public static void main(String[] args) {

    //anagram
    String anagram = "ishan";
    //anagram.chars().forEach(System.out::println);

    //get all combinations https://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
    List<String> collect = IntStream.range(0, (int) Math.pow(2, anagram.length() - 1))
            .boxed()
            .map(e -> (Integer.toBinaryString(e)))
            .collect(Collectors.toList());


    collect.stream().filter(e -> e.matches("\\d{0,3}"))
            .map(e -> {
              return "000".substring(e.length()) + e;
            })
            .forEach(System.out::println);
    ;

    //fill gaps 00ish
    String a = "ish";
    String b = "00000";
    System.out.println(a + b.substring(a.length(), b.length()));

    //  permutation("ishan");

    //programme to find substring of word without selected no
    String word = "ishan";
    for (int i = 0; i < word.length(); i++) {
      System.out.println(word.charAt(i));
      System.out.println(word.substring(0, i) + word.substring(i + 1, word.length()));
    }


    //permutation 1234
    permutation("1234");
  }


  public static void permutation(String str) {
    //a great example for kotlin default arguments
    permutation("", str);
  }

  private static void permutation(String prefix, String str) {
    if (str.length() == 0) System.out.println(prefix);
    else IntStream.range(0,str.length()).forEach(i->{permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, str.length())); });
  }
}
