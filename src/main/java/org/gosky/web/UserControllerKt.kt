package org.gosky.web

import org.gosky.domain.User
import org.gosky.domain.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

/**
 * Created by guozhong on 17/3/14.
 */
@RestController
@RequestMapping("/users/kt")
public class UserControllerKt {
    @Autowired
    private lateinit var userRepository: UserRepository

    @RequestMapping(value = "/", method = arrayOf(RequestMethod.GET))
    fun getUserList(): List<User> = userRepository.findAll()

    @RequestMapping(value = "/", method = arrayOf(RequestMethod.POST))
    fun postUser(@ModelAttribute user: User): String {
        userRepository.save(user)
        return "success"
    }
}