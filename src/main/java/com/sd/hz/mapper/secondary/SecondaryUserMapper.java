package com.sd.hz.mapper.secondary;

import com.sd.hz.po.User;

import java.util.List;

public interface SecondaryUserMapper {
   List<User> findAllUsers();
}
