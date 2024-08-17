package satoripop.string.my_cool_app.rest;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {
    @GetMapping("/")
    public String sayHi(){
        return "Hello World" ;
    }

    @GetMapping("/code")
    public String code(){
        return "Understand Spring";
    }

    @GetMapping("/football")
    public String football(){
        return "Football Manager is the best ";
    }

    //Inject properties :
    @Value("${student.name}")
    private String studentName;

    @Value("${student.university}")
    private String studentUniversity;

    @GetMapping("/student")
    public String student(){
        return studentName + " " + studentUniversity;
    }




}
