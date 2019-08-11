public class TddWork {
    public User judges(User user1, User user2) {
        return user1.getMyLevel() == user2.getMyLevel() ? handleSameLevel(user1, user2) : handleDifferentLevel(user1, user2);
    }

    private User handleDifferentLevel(User user1, User user2) {
        return user1.getMyLevel() > user2.getMyLevel() ? user1 : user2;
    }

    private User handleSameLevel(User user1, User user2) {
        return user1.getMaxPoker() > user2.getMaxPoker() ? user1 : user2;
    }
}
