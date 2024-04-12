package daelim.java_ch03.member.DAO;

import daelim.java_ch03.member.Student;

import java.util.HashMap;
import java.util.Map;

public class StudentDAO {
    private Map<String, Student> studentDB = new HashMap<>();

    public void insert(Student student) {
        studentDB.put(student.getsNum(), student);
    }

    public Student select(String sNum) {
        return studentDB.get(sNum);
    }

    public void update(Student student) {
        studentDB.put(student.getsNum(), student);
    }

    public void delete(String sNum) {
        studentDB.remove(sNum);
    }

    public Map<String, Student> getStudentDB() {
        return studentDB;
    }
}
