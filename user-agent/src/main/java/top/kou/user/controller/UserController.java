package top.kou.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.kou.biz.common.Response;
import top.kou.biz.sequence.Sequencer;
import top.kou.biz.user.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private Map<String, User> users = new HashMap<>();

    @RequestMapping("/user/register")
    public Response<User> register(String name, String email) {
        Objects.requireNonNull(name);
        Objects.requireNonNull(email);


        logger.info("Request [url={}, name={}, email={}]", "/user/register", name, email);
        User user = newUser(name, email);
        synchronized (users) {
            User old = users.putIfAbsent(email, user);
            if (user == old) {
                return new Response<>(old, Response.CODE_FAILURE, "邮箱重复！");
            }
        }
        logger.info("User Registered [id={}, name={}, email={}]", user.getId(), user.getName(), user.getEmail());
        return new Response<>(user);
    }

    @RequestMapping("/user/lookup")
    public Response<User> lookup(String email) {
        Objects.requireNonNull(email);

        logger.info("Request [url={}, email={}]", "/user/lookup", email);
        User user = users.get(email);
        logger.info("Response [user={}]", user);

        return new Response<>(user);
    }

    private User newUser(String name, String email) {
        User user = new User();
        user.setId(Sequencer.getNextSequence());
        user.setName(name);
        user.setEmail(email);
        return user;
    }
}
