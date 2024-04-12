package daelim.java_ch03.member;

import daelim.java_ch03.member.service.EMSInformationService;
import daelim.java_ch03.member.service.PrintStudentInformationService;
import daelim.java_ch03.member.service.StudentService;
import daelim.java_ch03.utils.InitSampleData;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

        // 1. 샘플데이터 등록
        InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
        String[] sNums = initSampleData.getsNums();
        String[] sIds = initSampleData.getsIds();
        String[] sPws = initSampleData.getsPws();
        String[] sNames = initSampleData.getsNames();
        int[] sAges = initSampleData.getsAges();
        char[] sGenders = initSampleData.getsGenders();
        String[] sMajors = initSampleData.getsMajors();

        // 데이터베이스에 등록
        StudentService studentService = ctx.getBean("studentService", StudentService.class);
        for (int i=0; i<sNums.length; i++) {
            studentService.register(new Student(sNums[i], sIds[i], sPws[i], sNames[i], sAges[i], sGenders[i], sMajors[i]));
        }

        // 2. 학생리스트 출력
        PrintStudentInformationService printStudentInformationService = ctx.getBean("printStudentInformationService", PrintStudentInformationService.class);
        printStudentInformationService.printStudentInfo();

        // 3. EMS 정보
        EMSInformationService emsInformationService = ctx.getBean("emsInformationService", EMSInformationService.class);
        emsInformationService.printEMSInformation();
    }
}
