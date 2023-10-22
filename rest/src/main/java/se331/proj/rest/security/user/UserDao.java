package se331.proj.rest.security.user;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}