package model;

public class Student {
    //_____ATTRIBUTES------------
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    //----------------------------

    //-----CONSTRUCTOR------------
    public Student(String firstName, String lastName, int age, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
    }
    public Student(){}

    //-----STANDARD METHODS-------

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastName;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //----------------------------

    //------CUSTOM METHODS--------
    public String getFullName(){
        return firstName + " " + lastName;
    }

    //----------------------------
}
