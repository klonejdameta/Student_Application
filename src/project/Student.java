package project;

public class Student {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private String university;
    private Boolean isWorking;

    public Student(Integer id, String name, String surname, Integer age, String university, Boolean isWorking) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.university = university;
        this.isWorking = isWorking;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getUniversity() {
        return university;
    }

    public Boolean getWorking() {
        return isWorking;
    }

    public static Student createStudent(Integer id, String name, String surname, Integer age, String university, Boolean isworking) {
        return new Student(id, name, surname, age, university, isworking);
    }
}
