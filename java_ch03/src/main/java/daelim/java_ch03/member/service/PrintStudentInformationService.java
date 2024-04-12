package daelim.java_ch03.member.service;

import daelim.java_ch03.member.Student;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PrintStudentInformationService {
    StudentService studentService;

    public PrintStudentInformationService(StudentService studentService) {
        this.studentService = studentService;
    }

    public void printStudentInfo() {
        Map<String, Student> studentMap = studentService.allSelect();
        Set<String> keys = studentMap.keySet();
        Iterator<String> iterator = keys.iterator();
        System.out.println("STUDENT LIST START ==================>");
        while (iterator.hasNext()) {
            String key = iterator.next();
            Student student = studentMap.get(key);
            System.out.println("sNum : " + student.getsNum());
            System.out.println("sId : " + student.getsId());
            System.out.println("sPw : " + student.getsPw());
            System.out.println("sName : " + student.getsName());
            System.out.println("----------------------------------");
        }
        System.out.println("END =================================>");
    }
}
