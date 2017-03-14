package org.gosky.web;

import org.gosky.domain.User;
import org.gosky.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * Created by guozhong on 17/3/9.
 */
@RestController
@RequestMapping("/users")
public class UserController {
//    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());
    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "获取用户信息列表", notes = "notes")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        return userRepository.findAll();
    }

    @ApiOperation(value = "修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", value = "用户详情实体user", required = true, dataType = "user")
    })
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@ModelAttribute User user) {
//        User u = users.get(id);
//        u.setAge(user.getAge());
//        u.setName(user.getName());
//        u.setId(user.getId());
//        users.put(id, u);
        userRepository.saveAndFlush(user);
        return "success";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user) {
        System.out.println(user.toString());
        userRepository.save(user);
        return "success";
    }



}
