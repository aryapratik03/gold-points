package crud_operation_tutorial.crud.restApiWorkflow.Respository;

import crud_operation_tutorial.crud.restApiWorkflow.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import crud_operation_tutorial.crud.restApiWorkflow.Entities.Student;

public interface StudentRepository
        extends JpaRepository<Student, Long> {

}

