import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class StreamShortNote {

  public static void main(String ishan[]) {

    System.out.println("Ways to create Streams");
    
    System.out.println("_________________________________________________________________");

    System.out.println("Most common methos in java 8  Streams");
    //map thiyena okkotama map karnawa
    IntStream.range(0, 10).map(e -> e + 2).forEach(System.out::println);
    System.out.println();
    //reduce okkoma sum karanawa
    System.out.println(IntStream.range(0, 10).map(e -> e + 2).reduce(0, (e, t) -> e + t));
    ;
    System.out.println();
    //filter filter karanawa
    System.out.println(IntStream.range(0, 10).filter(e -> e < 6).boxed().collect(Collectors.toList()));
    ;
    System.out.println("_________________________________________________________________");

    //distinct
    Stream.of("A", "B", "C", "D", "A", "B", "C").distinct().forEach(System.out::println);
    System.out.println("_________________________________________________________________");

    //ekak hari ehemada
    System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().anyMatch(e -> e == 9));
    System.out.println();
    //okkoma ehemada
    System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().allMatch(e -> e > 0));
    System.out.println();
    //okkoma ehema newed
    System.out.println(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().noneMatch(e -> e > 20));
    System.out.println("_________________________________________________________________");

    //Map int to double and long
    Arrays.asList(1, 2, 3, 4).stream().mapToLong(e -> e).forEach(System.out::println);
    System.out.println();
    Arrays.asList(1, 2, 3, 4).stream().mapToDouble(e -> e).forEach(System.out::println);
    System.out.println();
    System.out.println("_________________________________________________________________");

    //select randomly from Stream ,also can check if stream is empty
    System.out.println(Stream.of().findAny().isPresent());
    System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0).findAny().get());
    System.out.println();
    System.out.println("_________________________________________________________________");

    //make a random stream
    //size
    new Random().ints(5).forEach(System.out::println);
    //size and range end is exclusive
    new Random().ints(5, 0, 11).forEach(System.out::println);
    //we can use doubles and long tooo  new Random().doubles​(5,0,11); , new Random().longs(5,0,11)
    System.out.println("_________________________________________________________________");

    //forEach and forEachOrdered difference
    System.out.println("Using forEach()");
    String str = "ishan";
    str.chars().forEach(n -> System.out.print((char) n));
    System.out.println("\nUsing parallel() + forEach()");
    str.chars().parallel().forEach(n -> System.out.print((char) n));
    System.out.println("\nUsing parallel() + forEachOrdered()");
    str.chars().parallel().forEachOrdered(n -> System.out.print((char) n));
    System.out.println();
    System.out.println("_________________________________________________________________");

    //Sorting methods Stream
    //numbers
    int[] i = new Random().ints(10, 0, 10).toArray();

    Arrays.stream(i).forEach(i1 -> System.out.println(i1));
    System.out.println();
    Arrays.stream(i).sorted().forEach(System.out::println);
    System.out.println();

    //Strings
    Stream.of("x", "a", "b", "d").sorted().forEach(System.out::println);
    System.out.println();

    //Custom class sort using comparator
    Stream.of(new Student(99, "ishan"), new Student(88, "ishan"), new Student(77, "ishan"), new Student(66, "ishan"))
            .sorted((stu1,stu2)->stu1.score-stu2.score)
            .forEach(System.out::println);
  }
}

class Student {
  int score;
  String name;

  @Override
  public String toString() {
    return "Student{" +
            "score=" + score +
            ", name='" + name + '\'' +
            '}';
  }

  public Student(int score, String name) {
    this.score = score;
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
