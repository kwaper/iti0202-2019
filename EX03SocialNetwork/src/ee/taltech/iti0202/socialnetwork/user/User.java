package ee.taltech.iti0202.socialnetwork.user;


import ee.taltech.iti0202.socialnetwork.message.Message;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String name;
    private Integer age;
    private Set<Message> messages = new HashSet<>();

    public User(String name) {
        this.name = name;
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public Set<Message> getMessages() {
        return this.messages;
    }
}
