public class TddWork {
    public User judges(User user1, User user2) {
        if (user1.getMyLevel() == user2.getMyLevel()) {
            switch (user1.getMyLevel()) {
                case Common.PAIR_LEVEL:
                    return handleLevel2(user1, user2);
            }
            return user1.getMyMaxPoker().compareTo(user2.getMyMaxPoker()).equals(user1.getMyMaxPoker()) ? user1 : user2;
        }
        return user1.getMyLevel() > user2.getMyLevel() ? user1 : user2;
    }

    private User handleLevel2(User user1, User user2) {
        return user1.getMaxPoker() > user2.getMaxPoker() ? user1 : user2;
    }
}
