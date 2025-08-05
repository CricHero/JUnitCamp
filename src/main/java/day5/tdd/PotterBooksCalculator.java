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
	if (books.size() == 1) {
	  return BOOK_PRICE;
	}
    int firstBookVolume = books.get(0);
    boolean isAllSameVolume =
        books.stream().allMatch(bookVolume -> Objects.equals(bookVolume, firstBookVolume));
    if (isAllSameVolume) {
      return books.size() * BOOK_PRICE;
    }
    return 0.0; // とりあえず0を返すようにしておく
  }
}
