package src;

public class Professor {
    // required
    private String firstName;
    private String lastName;
    private String id;

    // optional
    private String email;
    private String gender;
    private String website;

    public static class Builder{
        // required
        private String firstName;
        private String lastName;
        private String id;

        // optional
        private String email;
        private String gender;
        private String website;

        public Builder(String firstName, String lastName, String id) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setWebsite(String website) {
            this.website = website;
            return this;
        }

        public Professor build() {
            return new Professor(
                this.firstName, 
                this.lastName, 
                this.id, 
                this.email, 
                this.gender, 
                this.website);
        }
    }

    public Professor(String firstName, String lastName, String id, String email, String gender, String website) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.email = email;
        this.gender = gender;
        this.website = website;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
    public String getWebsite() {
        return website;
    }
    
}
