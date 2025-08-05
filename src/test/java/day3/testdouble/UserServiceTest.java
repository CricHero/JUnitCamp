package day3.testdouble;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * ★Mockについての課題<br>
 * 課題①-1：Mockを利用してUserService#getUserById()にユーザーIDを渡したらユーザーが見つかる場合のテストを書いてください。<br>
 * 課題①-2：Mockを利用してUserService#getUserById()にユーザーIDでユーザーが見つからない場合のテストを書いてください。<br>
 * ※Mockitoの@Mockアノテーションを使って、UserRepositoryImplのモックオブジェクトを自動生成するようにしてください。<br>
 * 課題①-3：UserRepositoryのモックオブジェクトを使用するメリットについてtimesに書いてみましょう。<br>
 * <br>
 * 課題②と③は後回しでも良いです。①とほぼ同じ内容なので<br>
 * 課題②-1：Mockを利用してUserService#registerUser()に新規ユーザーが正常に登録される場合のテストを書いてください。<br>
 * 課題②-2：Mockを利用してUserService#registerUser()に既存ユーザーの登録は失敗する場合のテストを書いてください。<br>
 * 課題③-1：Mockを利用してUserService#deleteUser()にユーザーが正常に削除される場合場合のテストを書いてください。<br>
 * 課題③-2：Mockを利用してUserService#deleteUser()に削除対象のユーザーが見つからない場合のテストを書いてください。<br>
 * <br>
 * 
 * ★Spyについての課題<br>
 * 課題④-1：Spyを利用してUserService#getTotalUsersCount()に対してテストを書いてください。<br>
 * 課題④-2：Spyを利用してUserRepository#findById()を上書きしてみましょう。そして、findByIdが上書きされたことをverifyを使用して検証してみましょう<br>
 */
class UserServiceTest {

  @Test
  void test() {
    fail("まだ実装されていません");
  }

}
