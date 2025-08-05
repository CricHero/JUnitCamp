package day3.testdouble;

import java.util.Optional;

public interface UserProvidable {
  Optional<User> findById(String id);

  void save(User user);

  void deleteById(String id);

  long countAllUsers(); // 新しいメソッドを追加
}
