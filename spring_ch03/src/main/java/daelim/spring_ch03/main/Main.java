package daelim.spring_ch03.main;

import daelim.spring_ch03.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Assembler assembler = new Assembler();

    public static void main(String[] args) throws IOException {

        //MemberDao memberDao = new MemberDao();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("명령어 입력");
            String command = reader.readLine();
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("종료");
                break;
            }

            if (command.startsWith("new")) {
                // 회원등록
                processNewCommand(command.split(" "));
                continue;
            }
            if (command.startsWith("change")) {
                // 암호변경
                processChangeCommand(command.split(" "));
                continue;
            }
            if (command.startsWith("list")) {
                // 회원 리스트
                assembler.getMemberRegisterService().selectAll();
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

        //MemberRegisterService memberRegisterService = new MemberRegisterService(memberDao);
        MemberRegisterService memberRegisterService = assembler.getMemberRegisterService();
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
        //ChangePasswordService changePasswordService = new ChangePasswordService();
        //changePasswordService.setMemberDao(memberDao);
        ChangePasswordService changePasswordService = assembler.getChangePasswordService();

        try {
            changePasswordService.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("암호가 변경되었습니다.");
        } catch (MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일입니다.");
        } catch (WrongPasswordException e) {
            System.out.println("암호가 일치하지 않습니다.");
        }
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("잘못된 명령입니다. 아래 명러 사용법을 확인하세요");
        System.out.println("new 이메일 이름 암호 암호확인");
        System.out.println("change 이메일 현재암호 변경암호");
        System.out.println();
    }
}
