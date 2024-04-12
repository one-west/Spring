package contact;

import contact.service.ContactRegisterService;
import contact.service.ContactSearchService;
import contact.util.InitSampleData;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("applicationContext.xml");

        InitSampleData initSampleData = ctx.getBean("initSampleData", InitSampleData.class);
        String[] names = initSampleData.getNames();
        String[] phoneNumbers = initSampleData.getPhoneNumbers();

        ContactRegisterService contactRegisterService = ctx.getBean("registerService", ContactRegisterService.class);
        for (int i = 0; i < names.length; i++) {
            ContactSet contactSet = new ContactSet(names[i], phoneNumbers[i]);
            contactRegisterService.register(contactSet);
        }

        ContactSearchService contactSearchService = ctx.getBean("contactSearchService", ContactSearchService.class);
        ContactSet contactSet = contactSearchService.search("류현진");

        System.out.println("name : " + contactSet.getName());
        System.out.println("phone : " + contactSet.getPhoneNumber());
    }
}
