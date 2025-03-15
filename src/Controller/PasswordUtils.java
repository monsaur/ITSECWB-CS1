package Controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {
    
    // Minimum password length requirement
    private static final int MIN_PASSWORD_LENGTH = 8;
    
    // Password pattern: requires at least one digit, one lowercase, one uppercase, and one special character
    private static final String PASSWORD_PATTERN = 
        "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{" + MIN_PASSWORD_LENGTH + ",}$";
    
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    
    /**
     * Validates password strength
     * @param password The password to validate
     * @return true if password meets requirements, false otherwise
     */
    public static boolean isStrongPassword(String password) {
        if (password == null) {
            return false;
        }
        
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    /**
     * Generates a random salt for password hashing
     * @return The generated salt as a Base64 encoded string
     */
    public static String generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
    
    /**
     * Hashes a password with the provided salt using SHA-256
     * @param password The password to hash
     * @param salt The salt to use in hashing
     * @return The hashed password
     */
    public static String hashPassword(String password, String salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(Base64.getDecoder().decode(salt));
            byte[] hashedPassword = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }
}