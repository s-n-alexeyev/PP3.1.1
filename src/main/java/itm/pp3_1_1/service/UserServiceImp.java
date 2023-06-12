package itm.pp3_1_1.service;

import itm.pp3_1_1.model.User;
import itm.pp3_1_1.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void createOrUpdateUser(User user) {
        if (0 == user.getId()) {
            createUser(user);
        } else {
            updateUser(user);
        }
    }

    private void createUser(User user) {
        userRepository.save(user);
    }

    private void updateUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User readUser(long id) {
        User user = null;
        Optional<User> opt = userRepository.findById(id);
        if(opt.isPresent()){
            user = opt.get();
        }
        return user;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
