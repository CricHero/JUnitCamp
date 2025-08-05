package day5.tdd;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

// ★最終的なゴール
// 以下の仕様を満たすテストを書いてTDDでPotterBooksCalculator#calculateTotalPriceを実装してください。
// PotterBooksCalculator#calculateTotalPriceは購入数ごとに合計金額を算出するメソッドです。

// 【仕様】
// 購入数によって以下の通り合計金額が異なる。
// 1冊購入: 定価 (8ユーロ)
// 同じ巻を複数購入: それぞれ定価
// 異なる巻を2冊購入: 5% オフ
// 異なる巻を3冊購入: 10% オフ
// 異なる巻を4冊購入: 20% オフ
// 異なる巻を5冊以上購入: 25% オフ
// 0冊の場合は購入できず、「カートに何も入っていません。」のメッセージを表示する。
// また、巻数は5巻までとする。

// TDDではRed（失敗するテストを書く）⇒ Green（テストを成功させる最低限のコードを書く）⇒ Refactor（コードをリファクタリングしてきれいにする）
// というサイクルを細かく繰り返していくことで実装を進めます。
// まずは書籍がない場合のテストから書いていきましょう。

@DisplayName("ハリー・ポッター書籍割引計算")
class PotterBooksCalculatorTest {

  private PotterBooksCalculator calculator;
  private static final double BOOK_PRICE = 8.0; // 定価

  @BeforeEach
  void setUp() {
    calculator = new PotterBooksCalculator();
  }

  @Nested
  @DisplayName("パターン1：同一巻だけを購入した場合のテスト")
  class PurchaseSameBooksTest {

    @DisplayName("1冊だけ購入したら8ユーロ")
    @ParameterizedTest(name = "ケース{index} {0}巻を1冊だけ購入したら8ユーロになること")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void purchaseOnlyOneBooktest(int volume) {
      List<Integer> books = List.of(volume);
      double actual = calculator.calculateTotalPrice(books);
      assertThat(actual, is(BOOK_PRICE));
    }
  }

}
