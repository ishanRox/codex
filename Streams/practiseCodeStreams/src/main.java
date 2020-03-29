import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

    //fill gaps 00ish
    String a = "ish";
    String b = "00000";
    System.out.println(a + b.substring(a.length()));

    //  permutation("ishan");

    //programme to find substring of word without selected no
    String word = "ishan";
    for (int i = 0; i < word.length(); i++) {
      System.out.println(word.charAt(i));
      System.out.println(word.substring(0, i) + word.substring(i + 1));
    }


    //permutation 1234
    permutation("1234");

    //anagrame


    String anagrame0 = "aa";
    String anagrame1 = "aaaaa";

  //  if (anagrame0.length()!=anagrame1.length())return false;
  if (anagrame0==null|anagrame1==null) System.out.println(false);
  if (anagrame0.length()!=anagrame1.length()) System.out.println(false);


    System.out.println("________________________________________________________________________________");
//(\w+) regex word seperate
    String word1="ishan vimukthi   vihanf dfdf";
    String[] split = word1.split("[ .,?!]+");
    System.out.println(split.length);
    Arrays.stream(split).forEach(System.out::println);

  }


  public static void permutation(String str) {
    //a great example for kotlin default arguments
    permutation("", str);
  }


  static boolean isAnagram(String a, String b) {

    if (b==null|a==null|b.length()!=a.length()) return false;
    b=b.toLowerCase();
    a=a.toLowerCase();
    for (int i = 0; i < b.length(); i++) {
      a = a.replaceFirst(b.charAt(i) + "", "");
    }
    return a.equals("");
  }

  private static void permutation(String prefix, String str) {
    if (str.length() == 0) System.out.println(prefix);
    else IntStream.range(0, str.length()).forEach(i -> {
      permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
    });
  }
}
