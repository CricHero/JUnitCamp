package day5.tdd;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PotterBooksCalculator {
  // 基本的な書籍の価格（1冊あたり）
  private static final double BOOK_PRICE = 8.0;

  private static final Map<Integer, Double> DISCOUNT_RATE_BY_COUNT = Map.of(
      2, 0.95,
      3, 0.90,
      4, 0.80,
      5, 0.75
  );
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

    int totalBooks = books.size();
    boolean isAllSameVolume = isAllSameVolume(books);

    if (isAllSameVolume) {
      return totalBooks * BOOK_PRICE;
    }

    double discountRate = DISCOUNT_RATE_BY_COUNT.getOrDefault(totalBooks, totalBooks > 5 ? 0.75 : 1.0);
    return totalBooks * BOOK_PRICE * discountRate;
  }

  private boolean isAllSameVolume(List<Integer> books) {
    int firstVolume = books.get(0);
    return books.stream().allMatch(volume -> Objects.equals(volume, firstVolume));
  }
}