import java.io.*;
import java.util.*;

public class Main {
    static class Person implements Comparable<Person> {
        int age;
        String name;
        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }
        @Override
        public int compareTo(Person o) {
            if (this.age > o.age) {
                return 1;
            }
            else if (this.age < o.age) {
                return -1;
            }
            else {
                return 0;
            }
        } 
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Person[] people = new Person[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            people[i] = new Person(Integer.parseInt(st.nextToken()), st.nextToken());
        }
        Arrays.sort(people);
        for (Person p : people) {
            sb.append(p.age + " " + p.name).append("\n");
        }
        System.out.print(sb);
    }
}
