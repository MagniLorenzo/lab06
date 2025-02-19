/**
 * 
 */
package it.unibo.collections.social.impl;

import it.unibo.collections.social.api.SocialNetworkUser;
import it.unibo.collections.social.api.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 
 * This will be an implementation of
 * {@link SocialNetworkUser}:
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific {@link User} type
 */
public final class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     *
     * [FIELDS]
     *
     * Define any necessary field
     *
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map: think of what type of keys and values would best suit the
     * requirements
     */
    private static final int DEFAULT_AGE = -1;
    private final Map<String, List<U>> followedGroup;

    /*
     * [CONSTRUCTORS]
     *
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     *
     * - firstName
     * - lastName
     * - username
     * - age and every other necessary field
     */
    /**
     * Builds a user participating in a social network.
     *
     * @param name
     *                the user firstname
     * @param surname
     *                the user lastname
     * @param userAge
     *                user's age
     * @param user
     *                alias of the user, i.e. the way a user is identified on an
     *                application
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user, final int userAge) {
        super(name, surname, user, userAge);
        this.followedGroup = new HashMap<>();
    }

    /*
     * 2) Define a further constructor where the age defaults to -1
     */
    public SocialNetworkUserImpl(final String name, final String surname, final String user) {
        this(name, surname, user, DEFAULT_AGE);
    }

    /*
     * [METHODS]
     *
     * Implements the methods below
     */
    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        Objects.requireNonNull(circle);
        Objects.requireNonNull(user);
        List<U> listOfUsersInCircle = this.followedGroup.get(circle);
        if (listOfUsersInCircle != null && listOfUsersInCircle.contains(user)) {
            return false;
        } else if (listOfUsersInCircle != null) {
            listOfUsersInCircle.add(user);
        } else {
            this.followedGroup.put(circle, new ArrayList<>(Arrays.asList(user)));
        }
        return true;
    }

    /**
     *
     * [NOTE] If no group with groupName exists yet, this implementation must
     * return an empty Collection.
     */
    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        Objects.requireNonNull(groupName);
        final List<U> usersInGroup = new ArrayList<>();
        if (this.followedGroup.get(groupName) == null) {
            return usersInGroup;
        } else {
            usersInGroup.addAll(this.followedGroup.get(groupName));
            return usersInGroup;
        }
    }

    @Override
    public List<U> getFollowedUsers() {
        final List<U> followedUsers = new ArrayList<>();
        for (final List<U> group : this.followedGroup.values()) {
            followedUsers.addAll(group);
        }
        return followedUsers;
    }
}
