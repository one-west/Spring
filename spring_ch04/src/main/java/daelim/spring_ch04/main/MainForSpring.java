package daelim.spring_ch04.main;

import daelim.spring_ch04.config.AppContext;
import daelim.spring_ch04.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainForSpring {

    private static ApplicationContext ctx;

    public static void main(String[] args) throws IOException {

        ctx = new AnnotationConfigApplicationContext(AppContext.class);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("명령어 입력");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("종료");
                break;
            }

            // 회원등록
            if (command.startsWith("new")) {
                processNewCommand(command.split(" "));
                continue;
            }

            // 암호변경
            if (command.startsWith("change")) {
                processChangeCommand(command.split(" "));
                continue;
            }

            // 전체 회원 리스트
            if (command.startsWith("list")) {
                processListCommand();
                continue;
            }

            // 회원 정보 출력
            if (command.startsWith("info")) {
                processInfoCommand(command.split(" "));
                continue;
            }

            // 버전 정보 출력
            if (command.startsWith("version")) {
                processVersionCommand();
                continue;
            }
            printHelp();
        }
    }

    private static void processNewCommand(String[] arg) {

        if (arg.length != 5) {
            printHelp();
            return;
        }
        // 1. 객체 직접 생성 방식
        //MemberRegisterService memberRegisterService = new MemberRegisterService(memberDao);
        // 2. Assembler 객체를 통한 주입 방식
        //MemberRegisterService memberRegisterService = assembler.getMemberRegisterService();
        // 3. Spring Bean을 통한 주입 방식
        MemberRegisterService memberRegisterService = ctx.getBean("memberRegisterService", MemberRegisterService.class);
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if (!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("암호와 확인이 일치하지 않습니다.");
            return;
        }
        try {
            memberRegisterService.regist(req);
            System.out.println("회원등록이 되었습니다.");
            memberRegisterService.selectAll();
        } catch (DuplicationMemberException e) {
            System.out.println("이미 존재하는 이메일입니다.");
        }

    }

    private static void processChangeCommand(String[] arg) {
        if (arg.length != 4) {
            printHelp();
            return;
        }
        // ChangePasswordService changePasswordService = new ChangePasswordService();
        // changePasswordService.setMemberDao(memberDao);
        // ChangePasswordService changePasswordService = assembler.getChangePasswordService();
        ChangePasswordService changePasswordService = ctx.getBean("changePasswordService", ChangePasswordService.class);

        try {
            changePasswordService.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("암호가 변경되었습니다.");
        } catch (MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일입니다.");
        } catch (WrongPasswordException e) {
            System.out.println("암호가 일치하지 않습니다.");
        }
    }

    private static void processListCommand() {
        MemberList memberList = ctx.getBean("memberList", MemberList.class);
        memberList.printAll();
    }

    private static void processInfoCommand(String[] arg) {
        if (arg.length != 2) {
            printHelp();
            return;
        }
        MemberInfoPrinter memberInfoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
        memberInfoPrinter.printMember(arg[1]);
    }

    private static void processVersionCommand() {
        VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
        versionPrinter.print();
    }
    private static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명러 사용법을 확인하세요");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재암호 변경암호");
        System.out.println("info 이메일");
        System.out.println("list");
        System.out.println();
    }


}
