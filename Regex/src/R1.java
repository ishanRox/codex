import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class R1 {
  public static void main(String[] args) {
    //1st way
    Pattern p = Pattern.compile(".s");//. represents single character
    Matcher m = p.matcher("as");
    boolean b = m.matches();

    //2nd way
    boolean b2 = Pattern.compile(".s").matcher("as").matches();

    //3rd way
    boolean b3 = Pattern.matches(".s", "as");

    System.out.println(b + " " + b2 + " " + b3);

    //Find something
    // String to be scanned to find the pattern.
    String string = "12341ishanxxyxy";
    String regex = "(\\d*)(.*)";

    // Create a Pattern object
    Pattern r = Pattern.compile(regex);

    // Now create matcher object.
    Matcher matcher = r.matcher(string);

    if (matcher.find()) {
      System.out.println("Found value: " + matcher.group(0));
      System.out.println("Found value: " + matcher.group(1));
      System.out.println("Found value: " + matcher.group(2));
    } else {
      System.out.println("NO MATCH");
    }


    //shorthand
    //ctrl+alt+v - get var automatically
    Matcher matcher1 = Pattern.compile("i.*").matcher("ishan");
   if (matcher1.find()) System.out.println(matcher1.group());

  }
}
