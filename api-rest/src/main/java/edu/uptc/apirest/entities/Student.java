package edu.uptc.apirest.entities;


import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "students")
@Getter @Setter
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_student")
    private int id_student;

    @Column(nullable = false, length = 20)
    private String lastName;

    @Column(nullable = false, length = 20)
    private String name;

    @Column
    private Date birthday;

    @Column( length = 10)
    private String phone;

    @ManyToMany(mappedBy = "students")
    private List<Matter> matters;

    


    public Student() {
    }

    public Student(String last_name, String name, Date birthday, String phone, Matter matter) {
        this.lastName = last_name;
        this.name =  name;
        this.birthday = birthday;
        this.phone = phone;

    }

    public Integer getId_Student() {
        return id_student;
    }

    public void setId_Student(int id) {
        this.id_student= id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName =  lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name =  name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday =  birthday;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone =  phone;
    }

    public List<Matter> getMatters() {
        return matters;
    }

    
}
