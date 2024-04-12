package daelim.java_ch03.member.service;

import daelim.java_ch03.member.DAO.StudentDAO;
import daelim.java_ch03.member.Student;

import java.util.Map;

public class StudentService {
    private StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public boolean exist(String sNum) {
        Student student = studentDAO.select(sNum);
        return student != null;
    }
    public void register(Student student) {
        if (!exist(student.getsNum())) {
            studentDAO.insert(student);
        } else {
            System.out.println("The Student has already registered.");
        }
    }
    public Student select(String sNum) {
        if (!exist(sNum)) {
            studentDAO.select(sNum);
        } else {
            System.out.println("Student Information nis available.");
        }
        return null;
    }
    public Map<String, Student> allSelect() {
        return studentDAO.getStudentDB();
    }

    public void modify(Student student) {
        if (exist(student.getsNum())) {
            studentDAO.update(student);
        } else {
            System.out.println("Student information nis available");
        }
    }
    public void delete(String sNum) {
        if (exist(sNum)) {
            studentDAO.delete(sNum);
        } else {
            System.out.println("Student information nis available");
        }
    }
}
