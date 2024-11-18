package raisetech.StudentManagement;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

  private String name = "Enami Kouji";
  private String age = "37";

  private Map<String,String> students=new HashMap<>();

  public static void main(String[] args) {
    SpringApplication.run(StudentManagementApplication.class, args);
  }

  @GetMapping("/studentInfo")
  public String getStudentInfo() {
    return name + " " + age + "歳";
  }

  @PostMapping("/studentInfo")
  public void setStudentInfo(@RequestParam String name, @RequestParam String age) {
    this.name = name;
    this.age = age;
    students.put(name,age);
  }

  @PostMapping("/studentName")
  public void updateStudentName(@RequestParam String name) {
    this.name = name;
  }

  @GetMapping("/allstudents")
  public Map<String,String> getAllStudents(){
    return students;
  }
}
