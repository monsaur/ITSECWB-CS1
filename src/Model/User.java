package Model;

public class User {
    private int id;
    private String username;
    private String password;
    private int role = 2;
    private int locked = 0;
    private String salt;
    private int loginAttempts = 0;
    private String lastAttemptTime;
    private String passwordChangeTime;

    // Keep existing constructors
    public User(String username, String password, String salt){
        this.username = username;
        this.password = password;
        this.salt = salt;
    }
    
    public User(int id, String username, String password, String salt, int role, int locked){
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.role = role;
        this.locked = locked;
    }
    
    // Add the new constructor - make sure it has a different signature
    public User(int id, String username, String password, int role, int locked, 
                String salt, int loginAttempts, String lastAttemptTime, String passwordChangeTime){
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.locked = locked;
        this.salt = salt;
        this.loginAttempts = loginAttempts;
        this.lastAttemptTime = lastAttemptTime;
        this.passwordChangeTime = passwordChangeTime;
    }
    
    // Keep existing getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public int getLocked() {
        return locked;
    }

    public void setLocked(int locked) {
        this.locked = locked;
    }
    
    // Add getters and setters for new fields
    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public String getLastAttemptTime() {
        return lastAttemptTime;
    }

    public void setLastAttemptTime(String lastAttemptTime) {
        this.lastAttemptTime = lastAttemptTime;
    }

    public String getPasswordChangeTime() {
        return passwordChangeTime;
    }

    public void setPasswordChangeTime(String passwordChangeTime) {
        this.passwordChangeTime = passwordChangeTime;
    }
}