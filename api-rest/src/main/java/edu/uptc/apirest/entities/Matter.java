package edu.uptc.apirest.entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "matters")
@Getter @Setter
public class Matter {
    @Id
    @Column(name="code", length = 10)
    private String code;

    @Column(nullable = false, length = 45)
    private String description;

    @Column( nullable = false, length = 45)
    private String cedits;

    @JoinTable(
        name="student_has_matter",
        joinColumns = @JoinColumn(name="student_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name="matter_code", nullable = false)
    )
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Student> students;

    public void addStudent(Student student){
        if(this.students == null){
            this.students = new ArrayList<>();
        }
        
        this.students.add(student);
    }

    public Matter() {
        students = new ArrayList<>();
    }

    public Matter(String code, String description, String cedits ) {
        this();
        this.code = code;
        this.description= description;
        this.cedits= cedits;
        //student.addMatter(this)
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCedits() {
        return cedits;
    }

    public void setCedits(String cedits) {
        this.cedits = cedits;
    }


    public List<Student> getStudents() {
        return students;
    } 
}
