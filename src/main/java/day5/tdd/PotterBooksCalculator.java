package day5.tdd;

import java.util.List;
import java.util.Objects;

public class PotterBooksCalculator {
  // 基本的な書籍の価格（1冊あたり）
  private static final double BOOK_PRICE = 8.0;

  /**
   * 購入するハリー・ポッターの書籍リストに基づいて合計金額を計算する。 <br>
   * リストには書籍の巻数（1, 2, 3, 4, 5）が含まれる。<br>
   *
   * @param books 購入する書籍の巻数リスト (例: [1, 2, 1])
   * @return 計算された合計金額
   */
  public double calculateTotalPrice(List<Integer> books) {
	if (books == null || books.isEmpty()) {
	  throw new IllegalArgumentException("カートに何も入っていません。");
	}
    int firstBookVolume = books.get(0);
    boolean isAllSameVolume =
        books.stream().allMatch(bookVolume -> Objects.equals(bookVolume, firstBookVolume));
    if (isAllSameVolume) {
      return books.size() * BOOK_PRICE;
    }
    if (!isAllSameVolume && books.size() == 2) {
      return books.size() * BOOK_PRICE * 0.95;
    }
    if (!isAllSameVolume && books.size() == 3) {
      return books.size() * BOOK_PRICE * 0.9;
    }
    if (!isAllSameVolume && books.size() == 4) {
      return books.size() * BOOK_PRICE * 0.8;
    }
    if (!isAllSameVolume && books.size() >= 5) {
      return books.size() * BOOK_PRICE * 0.75;
    }
    return 0.0; // とりあえず0を返すようにしておく
  }
}
