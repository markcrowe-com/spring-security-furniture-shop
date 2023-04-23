package io.gitlab.markcrowe.furniture.shop.app.model;

public final class SimpleRoles
{
    public static final String ADMIN = "Admin";
    public static final String SUPER_ADMIN = "SuperAdmin";
    public static final String USER = "User";

    public static String getAllRoles()
    {
        return ADMIN + "," + SUPER_ADMIN + "," + USER;
    }
    public static String getDeleteRoles()
    {
        return ADMIN + "," + SUPER_ADMIN;
    }

    private SimpleRoles() {
        throw new IllegalStateException("Utility class");
    }
}
