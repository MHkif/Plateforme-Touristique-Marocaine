package mhkif.yc.regionsservice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public enum Role {

    ADMIN(Set.of(
            Permission.ADMIN_READ,
            Permission.ADMIN_CREATE,
            Permission.ADMIN_UPDATE,
            Permission.ADMIN_DELETE,
            Permission.USER_READ,
            Permission.USER_CREATE,
            Permission.USER_UPDATE,
            Permission.USER_DELETE

    )),
    USER(Set.of(
            Permission.USER_READ,
            Permission.USER_CREATE,
            Permission.USER_UPDATE,
            Permission.USER_DELETE
    ));
    @Getter
    private final Set<Permission> permissions;

}
