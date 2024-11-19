package raisetech.StudentManagement;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

  @Autowired
  private StudentRepository repository;

//  private String name = "Enami Kouji";
//  private String age = "37";

  private Map<String, String> students = new HashMap<>();

  public static void main(String[] args) {
    SpringApplication.run(StudentManagementApplication.class, args);
  }

  @GetMapping("/student")
  public String getStudentInfo(@RequestParam String name) {
    Student student = repository.searchByName(name);
//    Student student = new Student();
//    student.setName("EnamiKouji");
//    String name =student.getName();
    if (student == null) {
      return "Student not found";
    }

    return student.getName() + " " + student.getAge() + "歳";
  }

  @PostMapping("/student")
  public void registerStudent(@RequestParam String name, @RequestParam int age) {
    repository.registerStudent(name,age);
  }

  @PatchMapping("/student")
  public void updateStudentName(String name,@RequestParam int age) {
    repository.updateStudent(name,age);
  }

  @DeleteMapping("/student")
  public void deleteStudent(String name){
    repository.deleteStudent(name);

  }

  @GetMapping("/allstudents")
  public Map<String, String> getAllStudents() {
    return students;
  }
}
