package Practice.Student_Enrollment.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Document
public class Student {
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getSname() {
        return Sname;
    }

    public void setSname(String sname) {
        Sname = sname;
    }

    public String getSsurname() {
        return Ssurname;
    }

    public void setSsurname(String ssurname) {
        Ssurname = ssurname;
    }

    public String getMobileNumber() {
        return MobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        MobileNumber = mobileNumber;
    }

    public LocalDate getTime() {
        return time;
    }

    public void setTime(LocalDate time) {
        this.time = time;
    }

    @Id
    private ObjectId id;
    private String Sname;
    private String Ssurname;
    private String MobileNumber;
    private LocalDate time;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Sname='" + Sname + '\'' +
                ", Ssurname='" + Ssurname + '\'' +
                ", MobileNumber='" + MobileNumber + '\'' +
                ", time=" + time +
                '}';
    }
}
