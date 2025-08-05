package day3.testdouble;

import java.util.Optional;

public class UserService {
  private final UserProvidable userRepository;

  // 依存性注入 (コンストラクタインジェクション)
  public UserService(UserProvidable userRepository) {
    this.userRepository = userRepository;
  }

  /**
   * ユーザーIDに基づいてユーザーを取得する
   * 
   * @param id ユーザーID
   * @return ユーザーオブジェクト（見つからない場合はOptional.empty()）
   */
  public Optional<User> getUserById(String id) {
    if (id == null || id.trim().isEmpty()) {
      throw new IllegalArgumentException("User ID cannot be null or empty.");
    }
    // ここでUserRepositoryのメソッドを呼び出す
    return userRepository.findById(id);
  }

  /**
   * 新しいユーザーを登録する
   * 
   * @param user 登録するユーザーオブジェクト
   * @return 登録が成功した場合はtrue、すでに存在する場合はfalse
   */
  public boolean registerUser(User user) {
    if (user == null || user.getId() == null || user.getId().trim().isEmpty()) {
      throw new IllegalArgumentException("User object or ID cannot be null/empty.");
    }
    // ユーザーが既に存在するか確認
    if (userRepository.findById(user.getId()).isPresent()) {
      return false; // 既に存在する
    }
    userRepository.save(user); // ユーザーを保存
    return true;
  }

  /**
   * 指定されたユーザーIDのユーザーを削除する
   * 
   * @param id ユーザーID
   * @return 削除が成功した場合はtrue、ユーザーが見つからない場合はfalse
   */
  public boolean deleteUser(String id) {
    if (id == null || id.trim().isEmpty()) {
      throw new IllegalArgumentException("User ID cannot be null or empty.");
    }
    if (userRepository.findById(id).isPresent()) {
      userRepository.deleteById(id);
      return true;
    }
    return false;
  }

  /**
   * 現在登録されているユーザーの総数を取得する
   * 
   * @return ユーザーの総数
   */
  public long getTotalUsersCount() {
    return userRepository.countAllUsers();
  }
}
