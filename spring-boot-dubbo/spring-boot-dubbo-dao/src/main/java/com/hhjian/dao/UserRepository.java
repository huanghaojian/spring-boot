package com.hhjian.dao;

import com.hhjian.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>User Repository</p>
 *
 * @author <a href="mailto:hhjian.top@qq.com">hhjian</a>
 * @since 2017.09.18
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
