package in.capstone.UserService.service;

import in.capstone.UserService.model.User;
import in.capstone.UserService.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> getAllUsers() {
        return repository.findAll();
    }

    public ResponseEntity<User>  updateUser(int id, User user)
    {
      User u=repository.findById(id).orElse(null);
     u.setAccounttype(user.getAccounttype());
     u.setBasecurrency(user.getBasecurrency());
     u.setPin(user.getPin());
        final User updatedUser = repository.save(u);
        return ResponseEntity.ok(updatedUser);
    }


}
