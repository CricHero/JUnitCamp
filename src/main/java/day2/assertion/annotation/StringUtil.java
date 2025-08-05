package day2.assertion.annotation;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StringUtil {

  /**
   * 文字列を逆順にする
   * 
   * @param str 入力文字列
   * @return 逆順になった文字列
   */
  public String reverse(String str) {
    if (str == null) {
      throw new IllegalArgumentException("Input string cannot be null.");
    }
    return new StringBuilder(str).reverse().toString();
  }

  /**
   * 文字列が回文であるか判定する
   * 
   * @param str 入力文字列
   * @return 回文であればtrue、そうでなければfalse
   */
  public boolean isPalindrome(String str) {
    if (str == null) {
      return false; // nullは回文ではないと判断
    }
    String reversedStr = reverse(str);
    return str.equalsIgnoreCase(reversedStr);
  }

  /**
   * 文字列のリストから空文字列を除去する
   * 
   * @param strings 文字列のリスト
   * @return 空文字列が除去された新しいリスト
   */
  public List<String> removeEmptyStrings(List<String> strings) {
    if (strings == null) {
      throw new IllegalArgumentException("Input list cannot be null.");
    }
    return strings.stream().filter(Objects::nonNull) // null要素も除外
        .filter(s -> !s.trim().isEmpty()).collect(Collectors.toList());
  }

  /**
   * 数値文字列を整数に変換する
   * 
   * @param numStr 数値文字列
   * @return 変換された整数
   * @throws NumberFormatException 数値に変換できない場合
   */
  public int convertToInt(String numStr) {
    return Integer.parseInt(numStr);
  }
}
