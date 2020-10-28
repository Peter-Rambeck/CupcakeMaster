package cupcakeMaster.domain.order;

public class Customer {
    private int Customer_id;
    private String email;
    private String username;
    private String password;
    private int saldo;

    public Customer(String email, String username, String password) {

        this.email = email;
        this.password = password;
        this.saldo = saldo;
    }

    public int getCustomer_id() {
        return Customer_id;
    }

    public void setCustomer_id(int customer_id) {
        Customer_id = customer_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Customer_id=" + Customer_id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}