package edu.uptc.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.apirest.entities.Student;
import edu.uptc.apirest.repositories.StudentRepository;



@Service
public class StudentService {

    @Autowired
    private StudentRepository stdRepository;



    public StudentService(StudentRepository stdRepository) {
        this.stdRepository = stdRepository;
    }

    public List<Student> getStudents(){

        return stdRepository.findAll();
    }

    public Student save( Student student){
       // student.addMatter(student.getMatters());
        return stdRepository.save(student);
      
    }

    public Student findById(int student){

        Optional<Student> optStd = stdRepository.findById(student);

        return optStd.isPresent() ? optStd.get() : null;
    }

    public Student update(Student std){

        if(std.getId_Student()!=null){
            Optional<Student> e = stdRepository.findById(std.getId_Student());
            if(e.isEmpty()){
                if(std.getLastName()!=null){
                    e.get().setLastName(std.getLastName());
                }
                if(std.getName()!=null){
                    e.get().setName(std.getName());
                }
                if(std.getBirthday()!=null){
                    e.get().setBirthday(std.getBirthday());
                }
                if(std.getPhone()!=null){
                    e.get().setPhone(std.getPhone());
                }
                stdRepository.save(e.get());
                return e.get();
            }else{
                return std;
            }
        }else{
            return std;
        }
    }

   /* public Act update(Act act){

        if( findById( act.getId()) !=  null ){
            return actRepository.save( act );
        }

        return null;
    } */

    public Student delete(int id) {
        Student std = findById( id );
        if( std != null){
            stdRepository.delete( std );
        }

        return std;
    }

    
}
