package pattern.model;

public class Role {
    private Integer RoleID;
    private String RoleName;
    private String Descr;

    public Role (Integer roleID, String roleName, String descr) {
        RoleID = roleID;
        RoleName = roleName;
        Descr = descr;
    }

    public Role(String roleName, String descr) {
    }

    public Integer getRoleID() {
        return RoleID;
    }

    public void setRoleID(Integer roleID) {
        RoleID = roleID;
    }

    public String getRoleName() {
        return RoleName;
    }

    public void setRoleName(String roleName) {
        RoleName = roleName;
    }

    public String getDescr() {
        return Descr;
    }

    public void setDescr(String descr) {
        Descr = descr;
    }
}
