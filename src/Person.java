public class Person {

    private String name;
    private int age;


    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    public Person(Person person) {

        this.name = person.getName();
        this.age = person.getAge();
    }


    @Override
    public String toString() {
        return  name + ", " + age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
