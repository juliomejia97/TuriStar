package com.webDevelopment.turistar.User.User.Infrastructure;

import com.webDevelopment.turistar.Shared.Domain.User.UserId;
import com.webDevelopment.turistar.User.User.Domain.Ports.UserRepository;
import com.webDevelopment.turistar.User.User.Domain.User;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserEmail;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserLastName;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserName;
import com.webDevelopment.turistar.User.User.Domain.ValueObjects.UserPassword;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    private User user = new User(new UserId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432721"),  new UserName("Pinocho"), new UserLastName("Ni idea"),
            new UserEmail("pinocho@gmail.com"), new UserPassword("MaderiTa1*23"),null,null);
    private User user2 = new User(new UserId("bb5f8ac3-b90d-40ec-b3e2-e0ca3f432735"),  new UserName("Lobo"), new UserLastName("Feroz"),
            new UserEmail("lobo@gmail.com"), new UserPassword("TengoHambre1*23"),null,null);

    private List<User> users = new ArrayList<>() {{
        add(user);
        add(user2);
    }};

    @Override
    public void save(User user) {
        this.users.add(user);
    }

    @Override
    public Optional<User> find(String userId) {
        return users.stream().filter(user -> user.equalsById(userId)).findFirst();
    }

    @Override
    public void update(String userId, User user) {

    }
}
