package day3.testdouble;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

// これは実際のDBアクセスを模倣したクラスです。
// 通常、ユニットテストではこの実装は使いません（モックに置き換えるため）。
public class UserProvidableImpl implements UserProvidable {
  private final Map<String, User> users = new HashMap<>();

  @Override
  public Optional<User> findById(String id) {
    System.out.println("[UserRepositoryImpl] findById called for ID: " + id);
    // 実際のDBアクセスを模倣
    try {
      Thread.sleep(50); // 処理の遅延を模倣
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    return Optional.ofNullable(users.get(id));
  }

  @Override
  public void save(User user) {
    System.out.println("[UserRepositoryImpl] save called for User: " + user.getId());
    users.put(user.getId(), user);
  }

  @Override
  public void deleteById(String id) {
    System.out.println("[UserRepositoryImpl] deleteById called for ID: " + id);
    users.remove(id);
  }

  @Override
  public long countAllUsers() {
    System.out.println("[UserRepositoryImpl] countAllUsers called.");
    return users.size();
  }
}
