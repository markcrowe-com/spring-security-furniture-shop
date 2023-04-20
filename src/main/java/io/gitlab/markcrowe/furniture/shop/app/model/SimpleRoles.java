package io.gitlab.markcrowe.furniture.shop.app.model;

public class SimpleRoles
{
    public static final String Admin = "Admin";
    public static final String SuperAdmin = "SuperAdmin";
    public static final String User = "User";

    public static String getAllRoles()
    {
        return Admin + "," + SuperAdmin + "," + User;
    }
    public static String getDeleteRoles()
    {
        return Admin + "," + SuperAdmin;
    }

    private SimpleRoles() throws Exception {
        throw new Exception("Cannot create instance of SimpleRoles class");
    }
}