package top.yang.api;

import java.util.Collection;
import top.yang.domain.User;

public interface UserService {

  boolean save(User user);

  boolean remove(Long userId);

  Collection<User> findAll();
}
