package login_app.models;

public class User {
    /*
     * TODO:
     * Tambahkan attribute, method, atau constructor
     * yang dibutuhkan di kelas user
     */

    public String username, password;
    public Profile profile;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername(){
        return username;
    }
}
