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
    //String to be scanned to find the pattern.
    String string = "12341ishanxxyxy";
    String regex = "(\\d*)(.*)";

    //Create a Pattern object
    Pattern r = Pattern.compile(regex);

    //Now create matcher object.
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

    System.out.println();
    //Matching groups with indexes. 0 index is whole match
    String data = "Flight AA JFK.101.KRK[2016-12-06]";
    Pattern flightPattern = Pattern.compile("\\w+" + " "
            + "(..) "
            + "(...)\\." + "(\\d+)\\." + "(...)"
            + "\\[(\\d+-\\d+-\\d+)\\]");
    Matcher flight = flightPattern.matcher(data);
    flight.find();
    System.out.println("Airline: " + flight.group(1));
    System.out.println("Origin: " + flight.group(2));
    System.out.println("Number: " + flight.group(3));
    System.out.println("Destination: " + flight.group(4));
    System.out.println("Departure date: " + flight.group(5));

    System.out.println();
    //improvement matcher with names
    //shift + f6 to rename
    String data1 = "Flight AA JFK.101.KRK[2016-12-06]";
    Pattern flightPattern1 = Pattern.compile("\\w+" + " "
            + "(?<airline>..) "
            + "(?<origin>...)\\." + "(?<number>\\d+)\\." + "(?<destination>...)"
            + "\\[(?<deptDate>\\d+-\\d+-\\d+)\\]");
    Matcher flight1 = flightPattern1.matcher(data1);
    flight1.find();
    System.out.println("Airline: " + flight1.group("airline"));
    System.out.println("Origin: " + flight1.group("origin"));
    System.out.println("Number: " + flight1.group("number"));
    System.out.println("Destination: " + flight1.group("destination"));
    System.out.println("Departure date: " + flight1.group("deptDate"));

    String command = "connect 12.23.3.43:1234 as ishan";
    Pattern regex1 = Pattern.compile("^connect " +
            "(?<ip>((25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))" +
            ":(?<port>\\d{4})" +
            " as " +
            "(?<name>\\w*)$");
    Matcher matches = regex1.matcher(command);

    if (matches.find()){
      System.out.println("ip: " + matches.group("ip"));
      System.out.println("name: " + matches.group("name"));
      System.out.println("port: " + matches.group("port"));
    }else{
      System.out.println("Wronge Command !");
    }

  }
}