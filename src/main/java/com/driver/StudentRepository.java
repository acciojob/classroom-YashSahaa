package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class StudentRepository {
    HashMap<String , Student> studDb;
    HashMap<String , Teacher> teacDb;
    HashMap<String,List<String>> stDb;

    public StudentRepository() {
        this.studDb = new HashMap<>();
        this.teacDb = new HashMap<>();
        this.stDb = new HashMap<>();
    }
    public void addStudent(Student student){
        studDb.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        teacDb.put(teacher.getName(),teacher);
        stDb.put(teacher.getName(),new ArrayList<>());
    }

    public void addStudentTeacherPair(String student, String teacher){
        stDb.get(teacher).add(student);
    }

    public Student getStudentByName(String name){
        return studDb.get(name);
    }

    public Teacher getTeacherByName(String name){
        return teacDb.get(name);
    }

    public List<String> getStudentsByTeacherName(String teacher) {
        return stDb.get(teacher);

    }
    public List<String> getAllStudents(){
        List<String> stud = new ArrayList<>();
        for(String s : studDb.keySet()){
            stud.add(s);
        }
        return stud;
    }

    public void deleteTeacherByName(String teacher){
        teacDb.remove(teacher);
        stDb.remove(teacher);
    }

    public void deleteAllTeachers(){
        teacDb.clear();
        stDb.clear();
    }
}
