package com.webDevelopment.turistar.User.User.Domain;

import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserEmail;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserLastName;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserName;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserPassword;

import java.util.HashMap;
import java.util.Objects;

public class User {

    private UserId userId;
    private UserName userFirstName;
    private UserLastName userLastName;
    private UserEmail userEmail;
    private UserPassword userPassword;

    public User(UserId userId, UserName userFirstName, UserLastName userLastName, UserEmail userEmail, UserPassword userPassword) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    public void updateUser(UserName userFirstName, UserLastName userLastName, UserEmail userNickName)
    {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userEmail = userEmail;
    }

    public boolean equalsById(String otherId)
    {
        return this.userId.equals(new UserId(otherId));
    }

    public HashMap<String, String> data()
    {
        HashMap<String, String> data = new HashMap<String, String>() {{
            put("id", userId.value());
            put("name", userFirstName.value());
            put("lastname", userLastName.value());
            put("email", userEmail.value());
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userFirstName, user.userFirstName) &&
                Objects.equals(userLastName, user.userLastName) &&
                Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(userPassword, user.userPassword);
    }

}
