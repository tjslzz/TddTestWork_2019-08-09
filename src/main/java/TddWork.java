public class TddWork {
    public User judges(User user1, User user2) {
        return user1.getMyMaxPoker().compareTo(user2.getMyMaxPoker()).equals(user1.getMyMaxPoker()) ? user1 : user2;
    }
}
