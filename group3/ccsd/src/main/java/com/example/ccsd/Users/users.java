package com.example.ccsd.Users;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class users {
        @Id
        private String id;
        private String FirstName;
        private String LastName;
        private String phoneNumber;
        private String userEmail;
        private String userPassword;
        private String userimage;

        public users( String firstName, String lastName, String phoneNumber, String userEmail, String userPassword, String userImage) {
            this.FirstName=firstName;
            this.LastName=lastName;
            this.phoneNumber=phoneNumber;
            this.userEmail=userEmail;
            this.userPassword=userPassword;
            this.userimage=userImage;
        }
        public String getID() {
            return id;
        }
    
        public void setID(String id) {
            this.id = id;
        }
    
       
        public String getFirstName() {
            return FirstName;
        }
    
        public void setFirstName(String firstName) {
            this.FirstName = firstName;
        }
    
       
        public String getLastName() {
            return LastName;
        }
    
        public void setLastName(String lastName) {
            this.LastName = lastName;
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
            return userimage;
        }
    
        public void setUserImage(String userImage) {
            this.userimage = userImage;
        }
    }


    


