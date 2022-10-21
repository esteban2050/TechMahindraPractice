package models;

public class UserBuilder {

    private final User user;

    private UserBuilder() {
        this.user = new User();
    }

    public static UserBuilder instanceUserObject() {
        return new UserBuilder();
    }

    public UserBuilder withFirstName(String firstName) {
        this.user.setFirstName(firstName);
        return this;
    }

    public UserBuilder withEmployeeId(String employeeId) {
        this.user.setEmployeeId(employeeId);
        return this;
    }

    public UserBuilder withLastName(String lastName) {
        this.user.setLastName(lastName);
        return this;
    }

    public UserBuilder withUserName(String userName) {
        this.user.setUserName(userName);
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.user.setPassword(password);
        return this;
    }

    public User build() {
        return user;
    }
}