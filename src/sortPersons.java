import java.util.Random;

public class sortPersons {
    private String fullName;
    private int age;

    public sortPersons(String fullName, int age) {
        this.fullName = fullName;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAge() {
        return age;
    }

    public static sortPersons[] sortPersons(sortPersons[] persons) {
        int[] cnt = new int[961];

        for (sortPersons person : persons) {
            cnt[person.getAge()]++;
        }

        for (int i = 1; i < cnt.length; i++) {
            cnt[i] += cnt[i - 1];
        }

        sortPersons[] sortedPersons = new sortPersons[persons.length];

        for (int i = persons.length - 1; i >= 0; i--) {
            sortedPersons[cnt[persons[i].getAge()] - 1] = persons[i];
            cnt[persons[i].getAge()]--;
        }

        return sortedPersons;
    }

    public static void main(String[] args) {
        sortPersons[] persons = new sortPersons[1000];
        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {
            persons[i] = new sortPersons("epoka uni" + i, rand.nextInt(961));
        }

        sortPersons[] sortedPersons = sortPersons(persons);

        for (sortPersons person : sortedPersons) {
            System.out.println("Name: " + person.getFullName() + ", Age: " + person.getAge());
        }
    }
}
