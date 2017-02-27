// package runtimepractice;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RunTimePractice {

  public static int findNumsOfRepetitions(String s, char c) {
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == c) {
        sum++;
      }
    }
    return sum;
  }

  public static int[] findNumsOfRepetitionsv1(String s, char[] c) {
    int[] sums = new int[c.length];
    for (int i = 0; i < s.length(); i++) {
      for (int j = 0; j < c.length; j++) {
        if (s.charAt(i) == c[j]) {
          sums[j] = sums[j] + 1;
        }
      }
    }
    return sums;
  }

  public static int[] findNumsOfRepetitionsv2(String s, char[] c) {
    int[] sums = new int[c.length];
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i <s.length(); i++) {
      if (!map.containsKey(s.charAt(i))) {
        map.put(s.charAt(i), 1);
      } else {
        int sum = map.get(s.charAt(i));
        map.put(s.charAt(i), sum + 1);
      }
    }

    for (int j = 0; j < c.length; j++) {
      int sum;
      if (!map.containsKey(c[j])) {
        sums[j] = 0;
      } else {
        sums[j] = map.get(c[j]);
      }
    }
    return sums;
  }

  static String sample = "Related IN Number(s) : 2005-348Background/Justification :(S//NF) Analysts in CIA's Office of Russian and European Analysis (OREA) closely watched the Oct 9th and Oct 16th Socialist primaries and will be closely monitoring the April 22nd and May 6th 2012 Presidential elections. Of particular interest is President Sarkozy, the Socialist Party (PS), and other potential candidate's plans and intentions for these elections. Analysts assess that the Union for a Popular Movement (UMP), the current ruling party, is not assured ofwinning the presidential election and, as a result, analysts are interested in the electoral strategyof the non-ruling parties listed below. Additional information on these topics will help analysts assess, and prepare key US policymakers for, the post-election French political landscape and the potential impact on US-France relations. Guidance for UCS :(C//NF) ██████████ please contact ██████████ CIA/DI Office of Collection Strategies and Analysis (CSAA), IC E-Mail ██████████@cia.ic.gov, NSTS phone 935-████. (S//NF) These requirements are NOFORN due to Friends-on-Friends sensitivities.(S//NF) French political parties and persons of interest include:A. (S//NF) Socialist Party (PS)B. (S//NF) National Front (FN)C. (S//NF) Union for a Popular Movement (UMP)D. (S//NF) Dominique Strauss-Kahn (DSK)E. (S//NF) Nicolas SarkozyF. (S//NF) Martine AubryG. (S//NF) Francois HollandeH. (S//NF) Marine Le Pen";

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println(findNumsOfRepetitions(sample, 'a'));
    long endTime = System.currentTimeMillis();
    long duration = endTime - startTime;
    System.out.println("Test" + duration + "ms");

    char[] a = {'a', 'b'};

    startTime = System.currentTimeMillis();
    System.out.println(findNumsOfRepetitionsv1(sample, a));
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    System.out.println("Test" + duration + "ms");

    startTime = System.currentTimeMillis();
    System.out.println(findNumsOfRepetitionsv2(sample, a));
    endTime = System.currentTimeMillis();
    duration = endTime - startTime;
    System.out.println("Test" + duration + "ms");
  }

}
