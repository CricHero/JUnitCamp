package day5.tdd;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
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
    
    @DisplayName("複数冊を同一巻で購入した場合のテスト")
    @ParameterizedTest(name = "ケース{index} {0}巻を{1}冊購入したら{2}ユーロになること")
    @CsvSource({
        "1, 2, 16.0",
        "2, 3, 24.0",
        "5, 4, 32.0"
    })
    void purchaseMultipleSameBooksTest(int volume, int quantity, double expectedPrice) {
        List<Integer> books = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            books.add(volume);
        }
        double actual = calculator.calculateTotalPrice(books);
        assertThat(actual, is(expectedPrice));
    }
  }
  
  @Nested
  @DisplayName("パターン2：異なる巻を購入した場合のテスト")
  class PurchaseDifferentBooksTest {

    @DisplayName("異なる巻の組み合わせと割引率が正しいことを確かめるテスト")
    @ParameterizedTest(name = "ケース{index} {0}巻の組み合わせで購入したら{1}ユーロになること")
    @MethodSource("differenBooksProvider")
    void purchaseDifferentBooksTest(List<Integer> books, double expectedPrice) {
      double actual = calculator.calculateTotalPrice(books);
      assertThat(actual, is(expectedPrice));
    }

    static Stream<Arguments> differenBooksProvider() {
      return Stream.of(
    	// 異なる巻2冊 (5%オフ)
        arguments(Arrays.asList(1, 2), 15.2),
        arguments(Arrays.asList(2, 1), 15.2), // (順序が異なっても結果は同じはず)
        arguments(Arrays.asList(3, 5), 15.2),
        // 異なる巻3冊 (10%オフ)
        arguments(Arrays.asList(1, 2, 3), BOOK_PRICE * 3 * 0.90),
        arguments(Arrays.asList(2, 1, 3), BOOK_PRICE * 3 * 0.90), // (順序が異なっても結果は同じはず)
        arguments(Arrays.asList(3, 5, 4), BOOK_PRICE * 3 * 0.90),
        arguments(Arrays.asList(3, 3, 5), BOOK_PRICE * 3 * 0.90)
      );
    }
  }
}
