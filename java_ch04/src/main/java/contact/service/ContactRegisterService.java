package contact.service;

import contact.ContactSet;
import contact.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class ContactRegisterService {
//    @Resource
    @Autowired
    @Qualifier("useBean")
    private ContactDao contactDao;

//    public ContactRegisterService(ContactDao contactDao) {
//        this.contactDao = contactDao;
//    }

    public void register(ContactSet contactSet) {
        String name = contactSet.getName();
        if(verify(name)) {
            contactDao.insert(contactSet);
        } else {
            System.out.println("The name has already registered.");
        }
    }

    public boolean verify(String name) {
        ContactSet contactSet = contactDao.select(name);
        return contactSet == null ? true : false;
    }

    public void setContactDao(ContactDao contactDao) {
        this.contactDao = contactDao;
    }
}
