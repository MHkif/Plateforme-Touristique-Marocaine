package mhkif.yc.usersservice.services;

import mhkif.yc.usersservice.dto.requests.UserReq;
import mhkif.yc.usersservice.dto.responses.UserRes;
import mhkif.yc.usersservice.entities.User;

import java.util.UUID;

public interface UserService extends Service<User, UUID, UserReq, UserRes> {


    UserRes getByEmail(Integer id);
    UserRes update(User user);
    boolean delete(Integer id);
    User auth(String email, String password);
}
