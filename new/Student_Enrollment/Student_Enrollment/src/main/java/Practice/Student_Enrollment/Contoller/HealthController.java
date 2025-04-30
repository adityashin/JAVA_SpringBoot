package Practice.Student_Enrollment.Contoller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("health")
public class HealthController {
    @GetMapping
    public String healthcheck(){
        System.out.println("Everything OK");
        return "Everything OK";
    }
}
