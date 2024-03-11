package mhkif.yc.usersservice.services.implementations;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import mhkif.yc.usersservice.dto.requests.UserReq;
import mhkif.yc.usersservice.dto.responses.UserRes;
import mhkif.yc.usersservice.entities.User;
import mhkif.yc.usersservice.enums.Role;
import mhkif.yc.usersservice.exceptions.BadRequestException;
import mhkif.yc.usersservice.exceptions.EntityAlreadyExistsException;
import mhkif.yc.usersservice.exceptions.NotFoundException;
import mhkif.yc.usersservice.repositories.UserRepository;
import mhkif.yc.usersservice.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final ModelMapper mapper;

    @Override
    public UserRes getById(UUID id) {
        Optional<User> userOp = repository.findById(id);
        return userOp.map(
                user -> mapper.map(user, UserRes.class)
        ).orElseThrow(() -> new NotFoundException("User Not Exist with the given Id : " + id)
        );
    }

    @Override
    public Page<UserRes> getAllPages(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return repository.findAll(pageRequest).map(
                user -> mapper.map(user, UserRes.class)
        );
    }

    @Override
    public List<UserRes> getAll() {
        return repository.findAll().stream().map(
                user -> mapper.map(user, UserRes.class)
        ).toList();
    }

    @Override
    public UserRes create(UserReq request) {
        User existingUserEmail = repository.findByEmail(request.getEmail());

        if (Objects.nonNull(existingUserEmail)) {
            throw new EntityAlreadyExistsException("User already exists with the given Email.");
        }

        User user = mapper.map(request, User.class);
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);
        user.setCreatedAt(LocalDateTime.now());
        User savedUser = repository.save(user);

        return mapper.map(savedUser, UserRes.class);
    }

    @Override
    public UserRes getByEmail(Integer id) {
        return null;
    }

    @Override
    public UserRes update(User user) {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public User auth(String email, String password) {
        User user = repository.findByEmail(email);
        if(Objects.isNull(user)){
            throw new NotFoundException("No User Found with this Email");
        }
        else if (!password.equals(user.getPassword())) {
            throw new BadRequestException("Incorrect Password");
        }

        return user;

    }

}
