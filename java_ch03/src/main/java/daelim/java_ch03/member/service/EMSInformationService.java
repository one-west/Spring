package daelim.java_ch03.member.service;

import daelim.java_ch03.member.DBConnectionInfo;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EMSInformationService {
    private String info;
    private String copyRight;
    private String ver;
    private String sYear;
    private String sMonth;
    private String sDay;
    private int eYear;
    private int eMonth;
    private int eDay;
    private String[] developers;
    private Map<String, String> administrators;
    private Map<String, DBConnectionInfo> dbInfos;

    public void printEMSInformation() {
        System.out.println("EMS INFORMATION START ==========> ");
        String devPeriod = sYear + "/" + sMonth + "/" + sDay +"/" + eYear + "/" + eMonth + "/" + eDay;
        System.out.println(info + "(" + devPeriod + ")");
        System.out.println(copyRight);
        System.out.println(ver);
        System.out.println("Developers : " + developers.toString());
        System.out.println("Administrators : " + administrators);
        System.out.println("END ==============================");
    }

    public void printDBInfo() {
        Set<String> keys = dbInfos.keySet();
        Iterator<String> stringIterator = keys.iterator();
        while (stringIterator.hasNext()) {
            String key = stringIterator.next();
            DBConnectionInfo info = dbInfos.get(key);
            System.out.println("[" + key + "]");
            System.out.println("url : " + info.getUrl());
            System.out.println("userId : " + info.getUserId());
            System.out.println("userPw : " + info.getUserPw());
        }
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCopyRight() {
        return copyRight;
    }

    public void setCopyRight(String copyRight) {
        this.copyRight = copyRight;
    }

    public String getVer() {
        return ver;
    }

    public void setVer(String ver) {
        this.ver = ver;
    }

    public String getsYear() {
        return sYear;
    }

    public void setsYear(String sYear) {
        this.sYear = sYear;
    }

    public String getsMonth() {
        return sMonth;
    }

    public void setsMonth(String sMonth) {
        this.sMonth = sMonth;
    }

    public String getsDay() {
        return sDay;
    }

    public void setsDay(String sDay) {
        this.sDay = sDay;
    }

    public int geteYear() {
        return eYear;
    }

    public void seteYear(int eYear) {
        this.eYear = eYear;
    }

    public int geteMonth() {
        return eMonth;
    }

    public void seteMonth(int eMonth) {
        this.eMonth = eMonth;
    }

    public int geteDay() {
        return eDay;
    }

    public void seteDay(int eDay) {
        this.eDay = eDay;
    }

    public String[] getDevelopers() {
        return developers;
    }

    public void setDevelopers(String[] developers) {
        this.developers = developers;
    }

    public Map<String, String> getAdministrators() {
        return administrators;
    }

    public void setAdministrators(Map<String, String> administrators) {
        this.administrators = administrators;
    }

    public Map<String, DBConnectionInfo> getDbInfos() {
        return dbInfos;
    }

    public void setDbInfos(Map<String, DBConnectionInfo> dbInfos) {
        this.dbInfos = dbInfos;
    }
}
