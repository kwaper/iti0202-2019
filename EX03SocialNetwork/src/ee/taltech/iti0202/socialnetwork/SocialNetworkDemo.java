package ee.taltech.iti0202.socialnetwork;

import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.message.Message;
import ee.taltech.iti0202.socialnetwork.user.User;

public class SocialNetworkDemo {

    private static final Integer USER2AGE = 20;

    public static void main(String[] args) {
        User user1 = new User("user1");
        System.out.println(user1.getName()); // user1
        System.out.println(user1.getAge()); // null

        User user2 = new User("user2", 10);
        System.out.println(user2.getName()); // user2
        System.out.println(user2.getAge()); // 10

        User user3 = new User("user2", USER2AGE);

        Group group1 = new Group("group1", user1);
        System.out.println(group1.getName()); // group1
        System.out.println(group1.getOwner()); // user1

        group1.setName("newName");
        System.out.println(group1.getName()); // newName

        Group group2 = new Group("group1", user3);

        group1.addUser(user2);
        System.out.println(group1.getParticipants()); // [user1, user2]

        Message message1 = new Message("title1", "content1", user2);
        System.out.println(message1.getTitle()); // title1
        System.out.println(message1.getMessage()); // content1
        System.out.println(message1.getAuthor()); // user2

        group1.publishMessage(message1);
        System.out.println(group1.getMessages()); // [title1]

        Message message2 = new Message("title2", "content2", user3);
        group2.publishMessage(message2);

        SocialNetwork socialNetwork = new SocialNetwork();
        socialNetwork.registerGroup(group1);
        socialNetwork.registerGroup(group2);
        System.out.println(socialNetwork.getGroups()); // [group1, newGroup]

        System.out.println(socialNetwork.getFeedForUser(user2)); // [title1]
    }

}
