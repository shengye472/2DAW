package com.fpMislata.persistence.dao;

import com.fpMislata.domain.entity.User;

public interface UserDao {
    User findById(Integer orderId);
}
