package com.hendisantika.springdocapisample.repository;

import com.hendisantika.springdocapisample.entity.Contact;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : springdoc-api-sample
 * User: powercommerce
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 25/03/22
 * Time: 06.33
 * To change this template use File | Settings | File Templates.
 */
@Service
public class ContactInMemoryRepository implements ContactRepository {

    private static final List<Contact> contacts = new ArrayList<>();

    public ContactInMemoryRepository() {
        // initialize test data
        contacts.add(new Contact(1L, "Uzumaki", "Naruto", "uzumaki_naruto@konohagakure.co.jp", "123-456-789", "address 123, street 1, city 1"));
        contacts.add(new Contact(2L, "Uchiha", "Sasuke", "uchiha_sasuke@konohagakure.co.jp", "123-456-788", "address 456, street 2, city 1"));
        contacts.add(new Contact(3L, "Haruno", "Sakura", "haruno_sakura@konohagakure.co.jp", "123-456-787", "address 789, street 3, city 1"));
        contacts.add(new Contact(4L, "Hatake", "Kakashi", "hatake_kakashi@konohagakure.co.jp", "123-456-786", "address 234, street 4, city 1"));
        contacts.add(new Contact(5L, "Rock", "Lee", "rock_lee@konohagakure.co.jp", "123-456-785", "address 678, street 5, city 1"));
    }

    @Override
    public List<Contact> getAll() {
        return contacts;
    }

    @Override
    public Contact getById(Long id) {
        Contact result = contacts.stream()
                .filter(contact -> contact.getId().equals(id))
                .findAny()
                .orElse(null);
        return result;
    }

    @Override
    public Contact save(Contact newContact) {
        contacts.add(newContact);
        return newContact;
    }
}
