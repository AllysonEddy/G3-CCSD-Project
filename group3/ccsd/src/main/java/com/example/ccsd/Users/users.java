package com.example.ccsd.Users;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Base64;

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
        private byte[] userImage;
        private String userImage64String;
        public users() {}

        public users(String id, String firstName, String lastName,String userName, String phoneNumber, String userEmail, String userPassword, byte[] userImage) {
            this.id=id;
            this.firstName=firstName;
            this.lastName=lastName;
            this.phoneNumber=phoneNumber;
            this.userName=userName;
            this.userEmail=userEmail;
            this.userPassword=userPassword;
            this.userImage = userImage;
        }

        public String getUserImage64() {
            return userImage != null ? Base64.getEncoder().encodeToString(userImage) : null;
        }

        public void setUserImage64String(String userImage64String) {
            this.userImage64String = userImage64String;
        }

        public String getUserImage64String() {
            return userImage64String;
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
    
        
       public byte[] getUserImage() { 
        return userImage;
    }
    public void setUserImage(byte[] userImage){
        this.userImage=userImage;
    }
 }


    


