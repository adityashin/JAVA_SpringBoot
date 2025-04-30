package Practice.Student_Enrollment.Services;


import Practice.Student_Enrollment.Entity.Student;
import Practice.Student_Enrollment.Repository.StudentEntryRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentEntryService {

    @Autowired
    private StudentEntryRepository studentEntryRepo;

    public List<Student> getAllStudents(){
        return studentEntryRepo.findAll();
    }

    public void saveStudent(Student student){
        studentEntryRepo.save(student);
    }

    public Optional<Student> getStudentbyid(ObjectId mid){
        return studentEntryRepo.findById(mid);
    }

    public void deletebyid(ObjectId sid){
        studentEntryRepo.deleteById(sid);
    }

}
