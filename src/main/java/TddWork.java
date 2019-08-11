public class TddWork {
    public User judges(User user1, User user2) {
        if (user1.getMyLevel() == user2.getMyLevel()) {
            switch (user1.getMyLevel()) {
                case Common.PAIR_LEVEL:
                    return handleSameLevel(user1, user2);
                case Common.TWO_PAIR_LEVEL:
                    return handleSameLevel(user1, user2);
                case Common.THREE_KIND_LEVEL:
                    return handleSameLevel(user1, user2);
                case Common.STRAIGHT_LEVEL:
                    return handleSameLevel(user1, user2);
                case Common.FLUSH_LEVEL:
                    return handleSameLevel(user1, user2);
            }
            return user1.getMyMaxPoker().compareTo(user2.getMyMaxPoker()).equals(user1.getMyMaxPoker()) ? user1 : user2;
        }
        return user1.getMyLevel() > user2.getMyLevel() ? user1 : user2;
    }

    private User handleSameLevel(User user1, User user2) {
        return user1.getMaxPoker() > user2.getMaxPoker() ? user1 : user2;
    }
}
