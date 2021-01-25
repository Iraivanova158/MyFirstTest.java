import model.Course;
import model.Student;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JavaObjectWorkshop {
    @Test
    public void workWithObjects(){
        Student irina = new Student();

        irina.setFirstname("Irina");
        irina.setLastname("Ivanova");
        irina.setAge(35);
        irina.setEmail("irina.kosireva@inbox.lv");

        Student raimonds = new Student("Raimonds", "Geislers", 19, "raimonds.geislers@inbox.lv");

//        raimonds.setFirstname("Raimonds");
//        raimonds.setLastname("Geislers");
//        raimonds.setAge(19);
//        raimonds.setEmail("raimonds.geislers@inbox.lv");

//        System.out.println(irina.getFullName());
//        System.out.println(raimonds.getFullName());

        List<Student> students = new ArrayList<Student>();
        students.add(irina);
        students.add(raimonds);
        students.add(new Student("Alex", "Ivanov", 30,"espoolab@inbox.lv"));

        Course qa2 = new Course("QA2 - Automation", 3, students);
        qa2.addStudent(new Student("Lena", "Kosireva", 34, "irina.ivanova@inbox.lv"));
        qa2.printInfo();

    }

}
