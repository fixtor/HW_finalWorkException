public class User {
    private String firstName;
    private String middleName;
    private String lastName;
    private String dateBirth;
    private String phoneNumber;
    private String gender;

    public User(String firstName, String middleName, String lastName, String dateBirth, String phoneNumber,
            String gender) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateBirth = dateBirth;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public User() {
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "<" + lastName + ">" + "<" + firstName + ">" + "<" + middleName + ">" + "<" + dateBirth + ">" + "<"
                + phoneNumber + ">" + "<" + gender + ">" + "\n";
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

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}