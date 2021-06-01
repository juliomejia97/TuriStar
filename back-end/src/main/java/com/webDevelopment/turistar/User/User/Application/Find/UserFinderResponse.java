package com.webDevelopment.turistar.User.User.Application.Find;


import com.webDevelopment.turistar.Shared.Application.Response;
import com.webDevelopment.turistar.User.User.Domain.User;

import java.util.HashMap;

public class UserFinderResponse implements Response {

    private User user;

    public UserFinderResponse(User user) {
        this.user = user;
    }

    public HashMap<String, Object> response()
    {
        HashMap response = this.user.data();
        response.remove("id");
        return response;
    }
}