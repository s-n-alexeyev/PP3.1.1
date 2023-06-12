package itm.pp3_1_1.service;

import itm.pp3_1_1.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User readUser(long id);

    void deleteUser(long parseUnsignedInt);

    void createOrUpdateUser(User user);
}
