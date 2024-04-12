package contact.service;

import contact.ContactSet;
import contact.dao.ContactDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

public class ContactSearchService {

//    @Resource
    @Autowired
    @Qualifier("useBean")
    private ContactDao contactDao;

//    public ContactSearchService(ContactDao contactDao) {
//        this.contactDao = contactDao;
//    }

    public ContactSet search(String name) {
        ContactSet contactSet = contactDao.select(name);
        if (contactSet == null) {
            System.out.println("Contact information is available.");
        } else {
            return contactSet;
        }
        return null;
    }
}
