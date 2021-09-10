package ee.taltech.iti0202.socialnetwork.group;

import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Group {
    private String name;
    private User owner;
    private Set<User> users = new HashSet<>();
    private List<Message> messages = new ArrayList<>();

    public Group(String name, User owner) {
        this.name = name;
        this.owner = owner;
        this.users.add(owner);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getOwner() {
        return this.owner;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public Set<User> getParticipants() {
        return this.users;
    }

    public void publishMessage(Message message) {
        if (this.users.contains(message.getAuthor())) {
            this.messages.add(message);
            for (User x : users) {
                x.addMessage(message);
            }
        }
    }

    public List<Message> getMessages() {
        return this.messages;
    }

}
