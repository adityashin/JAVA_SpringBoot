package Practice.Student_Enrollment.Contoller;

import Practice.Student_Enrollment.Entity.Student;
import Practice.Student_Enrollment.Services.StudentEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    public StudentEntryService studentEntryService;

    @GetMapping
    public List<Student> getAllStudent(){
        return studentEntryService.getAllStudents();
    }

    @PostMapping
    public boolean createStudentEntry(@RequestBody Student student){
        student.setTime(LocalDate.now());
        studentEntryService.saveStudent(student);
        System.out.println("New Student Saved");
        return true;
    }


    @DeleteMapping("id/{id}")
    public boolean deleteStudentbyid(@PathVariable ObjectId id){
        studentEntryService.deletebyid(id);
        return true;
    }

    @GetMapping("id/{id}")
    public Student getstudentbyid(@PathVariable ObjectId id){
        return studentEntryService.getStudentbyid(id).orElse(null);
    }



}
