package com.ditraacademy.travelagenct.cor;

import com.ditraacademy.travelagenct.utils.ErrorResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Contoller {

    @Autowired
    UserRepository userRepository;

    @PostMapping ("/user")
    public  ResponseEntity<?> createUser(@RequestBody User user) {
        if(user.getName() == null  )
            return new ResponseEntity<>( new ErrorResponseModel(" Name field required"), HttpStatus.BAD_REQUEST);

        if(user.getName().length() <3 )
            return new ResponseEntity<>( new ErrorResponseModel(" invalid Name"), HttpStatus.BAD_REQUEST);

        if(user.getAge() == null  )
            return new ResponseEntity<>( new ErrorResponseModel(" Age field required"), HttpStatus.BAD_REQUEST);

        if(user.getAge()<0)
            return new ResponseEntity<>( new ErrorResponseModel(" invalid Age"), HttpStatus.BAD_REQUEST);
        user = userRepository.save(user);

        return new ResponseEntity<>( user, HttpStatus.OK);


    }
    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userRepository.findAll();

    }
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable int id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.get();
        return user;

    }
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id ) {

        if(userRepository.existsById(id))
          {  userRepository.deleteById(id);
            return new ResponseEntity<>( new ErrorResponseModel(" Deleted"), HttpStatus.OK);
          }

        else
            return new ResponseEntity<>(new ErrorResponseModel(" Error"), HttpStatus.BAD_REQUEST);



    }
    @PutMapping("/user/{id}")
    public ResponseEntity<?>  updateUser(@PathVariable int id,@RequestBody User updatedUser) {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
            return new ResponseEntity<>(new ErrorResponseModel("wrong user id"), HttpStatus.BAD_REQUEST);

        User userlegacy = userOptional.get();

        if (updatedUser.getName() != null)
            if (updatedUser.getName().length() < 3)
                return new ResponseEntity<>(new ErrorResponseModel("Invalid name"), HttpStatus.BAD_REQUEST);
            else
                userlegacy.setName(updatedUser.getName());

        if (updatedUser.getAge()!=null)
            if (updatedUser.getAge()<0)
                return new ResponseEntity<>(new ErrorResponseModel("Invalid Age"), HttpStatus.BAD_REQUEST);
            else
                userlegacy.setAge(updatedUser.getAge());

        userRepository.save(userlegacy);
        return new ResponseEntity<>(userlegacy, HttpStatus.OK);



    }

}
