package contact.dao;

import contact.ContactSet;

import java.util.HashMap;
import java.util.Map;

public class ContactDao {
    private Map<String, ContactSet> contactDB = new HashMap<>();

    public void insert(ContactSet contactSet) {
        contactDB.put(contactSet.getName(), contactSet);
    }

    public ContactSet select(String name) {
        return contactDB.get(name);
    }

    public Map getContactDB() {
        return contactDB;
    }
}
