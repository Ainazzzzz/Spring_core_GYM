package org.spring_core.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.spring_core.DataInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

@Data
@NoArgsConstructor
@Component
@Scope("prototype")
public class User {
    private long id;
    private String first_name;
    private String last_name;
    private String userName;
    private String password;
    private boolean isActive;
    private DataInitializer dataInitializer;

    public User(String first_name, String last_name) {

        this.isActive = true;
    }

    @Autowired
    public User(DataInitializer dataInitializer) {
        this.dataInitializer = dataInitializer;
    }

    public void setFirstAndLastName(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.userName = generateUsername();
        this.password = generatePassword();
    }

    private String generateUsername() {
        String baseUsername = first_name + "." + last_name;
        String username = baseUsername;
        int serialNumber = 1;

        while (usernameExists(username)) {
            serialNumber++;
            username = baseUsername + "." + serialNumber;
        }

        return username;
    }

    private String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }

        return password.toString();
    }

    private boolean usernameExists(String username) {
        if(dataInitializer.getStorage()==null && dataInitializer.getStorage().getUserMap()==null){
            return false;
        }
        AtomicBoolean exists = new AtomicBoolean(false);
    dataInitializer.getStorage().getUserMap().forEach((k,v)->{
            if(v.getUserName().equals(username)){
                exists.set(true);
            }
        });
        return exists.get();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
