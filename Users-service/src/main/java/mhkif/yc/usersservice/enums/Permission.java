package mhkif.yc.usersservice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {
    // SYS_ADMIN Permissions
    SYS_ADMIN_READ("sys_admin:read"),
    SYS_ADMIN_UPDATE("sys_admin:update"),
    SYS_ADMIN_CREATE("sys_admin:create"),
    SYS_ADMIN_DELETE("sys_admin:delete"),

    // ADMIN Permissions
    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),

    // MANAGER Permissions
    MANAGER_READ("manager:read"),
    MANAGER_UPDATE("manager:update"),
    MANAGER_CREATE("manager:create"),
    MANAGER_DELETE("manager:delete"),

    // USER Permissions
    USER_READ("user:read"),
    USER_UPDATE("user:update"),
    USER_CREATE("user:create"),
    USER_DELETE("user:delete");
    
    @Getter
    private final String permission;
}
