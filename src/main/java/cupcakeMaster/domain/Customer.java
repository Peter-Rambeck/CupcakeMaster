package cupcakeMaster.domain;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Objects;

public class Customer {
    private static final int PASSWORD_ITERATIONS = 65536;
    private static final int PASSWORD_LENGTH = 256; // 32 bytes
    private static final SecretKeyFactory PASSWORD_FACTORY;
    static {
        SecretKeyFactory factory = null;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        PASSWORD_FACTORY = factory;
    }



    private int customerId;
    private String email;
    private int saldo;
    private byte[] salt;
    private byte[] secret;
    private final boolean admin;



    public Customer(int customer_id, String email, int saldo, boolean admin, byte[] salt, byte[] secret) {
        customerId = customer_id;
        this.email = email;
        this.saldo = saldo;
        this.salt = salt;
        this.secret = secret;
        this.admin = admin;
    }
    public Customer( String email, int saldo, boolean admin, byte[] salt, byte[] secret) {
        this.email = email;
        this.saldo = saldo;
        this.salt = salt;
        this.secret = secret;
        this.admin = admin;
    }



    public static byte[] generateSalt() {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public static byte[] calculateSecret(byte[] salt, String password) {
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt,
                PASSWORD_ITERATIONS,
                PASSWORD_LENGTH);
        try {
            return PASSWORD_FACTORY.generateSecret(spec).getEncoded();
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkPassword(String password) {
        return Arrays.equals(this.secret, calculateSecret(salt, password));
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return admin;
    }

    public static int getPasswordIterations() {
        return PASSWORD_ITERATIONS;
    }

    public static int getPasswordLength() {
        return PASSWORD_LENGTH;
    }

    public static SecretKeyFactory getPasswordFactory() {
        return PASSWORD_FACTORY;
    }

    public int getSaldo() {
        return saldo;
    }

    public byte[] getSalt() {
        return salt;
    }

    public byte[] getSecret() {
        return secret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId);
    }




    public static String byteArrayToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for(byte b: a)
            sb.append(String.format("%02x", b));
        return sb.toString();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", email='" + email + '\'' +
                ", saldo=" + saldo +
                ", salt=" + Arrays.toString(salt) +
                ", secret=" + Arrays.toString(secret) +
                ", admin=" + admin +
                '}';
    }
}