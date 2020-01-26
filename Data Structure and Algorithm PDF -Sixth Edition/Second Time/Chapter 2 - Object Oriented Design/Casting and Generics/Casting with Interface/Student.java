public class Student implements Person {
    private String id;
    private String name;
    private int age;

    public Student(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public boolean equals(Person other) {
        if (!(other instanceof Student)) return false;
        Student s = (Student) other;
        return id.equals(s.id);
    }

    protected int studyHours() {
        return age/2;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}