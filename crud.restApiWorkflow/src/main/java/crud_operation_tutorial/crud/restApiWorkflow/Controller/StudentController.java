package crud_operation_tutorial.crud.restApiWorkflow.Controller;

import crud_operation_tutorial.crud.restApiWorkflow.Entities.Student;
import crud_operation_tutorial.crud.restApiWorkflow.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public Student saveStudent(
            @RequestBody Student student){

        return service.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents(){

        return service.getAllStudents();
    }
}