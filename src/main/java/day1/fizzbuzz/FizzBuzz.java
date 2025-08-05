package day1.fizzbuzz;

public class FizzBuzz {
	/**
	   * 一般的なFizzBuzz。<br>
	   * 【仕様】<br>
	   * 3の倍数の時は、数の代わりに「Fizz」に変換する。<br>
	   * 5の倍数の時は、数の代わりに「Buzz」に変換する。<br>
	   * 3と5の倍数の時は、数の代わりに「Fizz Buzz」に変換する。<br>
	   * それ以外の数の時は、数を文字列に変換する。<br>
	   * 
	   * @param num 入力値
	   */
	  public String convertFizzBuzz(int num) {
	    if (num % 3 == 0 && num % 5 == 0) {
	      return "Fizz Buzz";
	    } else if (num % 3 == 0) {
	      return "Fizz";
	    } else if (num % 5 == 0) {
	      return "Buzz";
	    }
	    return String.valueOf(num);
	  }
}
