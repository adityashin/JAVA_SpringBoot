package Practice.Student_Enrollment.Repository;

import Practice.Student_Enrollment.Entity.Student;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentEntryRepository extends MongoRepository<Student, ObjectId> {
}
