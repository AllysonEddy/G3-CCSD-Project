package com.example.ccsd.Users;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class users {
        @Id
        private String id;
        private String firstName;
        private String lastName;
        private String userName;
        private String phoneNumber;
        private String userEmail;
        private String userPassword;
        private String userImage;

        public users() {}

        public users(String firstName, String lastName,String userName, String phoneNumber, String userEmail, String userPassword, String userImage) {
            this.firstName=firstName;
            this.lastName=lastName;
            this.phoneNumber=phoneNumber;
            this.userName=userName;
            this.userEmail=userEmail;
            this.userPassword=userPassword;
            this.userImage=userImage;
        }
        public String getID() {
            return id;
        }
    
        public void setID(String id) {
            this.id = id;
        }
    
       
        public String getFirstName() {
            return firstName;
        }
    
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    
        public String getLastName() {
            return lastName;
        }
    
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getuserName(){
            return userName;
        }
        
        public void setuserName(String userName){
            this.userName=userName;
        }
        
        public String getPhoneNumber() {
            return phoneNumber;
        }
    
        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }
    
        
        public String getUserEmail() {
            return userEmail;
        }
    
        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }
    
      
        public String getUserPassword() {
            return userPassword;
        }
    
        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }
    
        
        public String getUserImage() {
            return userImage;
        }
    
        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }
    }


    


