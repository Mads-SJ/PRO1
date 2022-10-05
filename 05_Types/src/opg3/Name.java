package opg3;

public class Name {
    private String firstName;
    private String middleName;
    private String lastName;

    public Name(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInit() {
        return "" + firstName.charAt(0) + middleName.charAt(0) + lastName.charAt(0);
    }

    public String getUsername() {
        return "" + firstName.substring(0, 2).toUpperCase()
                  + middleName.length()
                  + lastName.substring(lastName.length() - 2).toLowerCase();
    }
}
