package ee.taltech.iti0202.socialnetwork;

import ee.taltech.iti0202.socialnetwork.feed.Feed;
import ee.taltech.iti0202.socialnetwork.group.Group;
import ee.taltech.iti0202.socialnetwork.user.User;

import java.util.HashSet;
import java.util.Set;


public class SocialNetwork {
    private Set<Group> groups = new HashSet<>();

    public void registerGroup(Group group) {
        this.groups.add(group);
    }

    public Set<Group> getGroups() {
        return this.groups;
    }

    public Feed getFeedForUser(User user) {
        Feed feed = new Feed(user, user.getMessages());
        return feed;
    }

}
