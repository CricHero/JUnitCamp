# JUnitとは
JUnitは、Javaのユニットテストを行うためのフレームワークです。<br>
ユニットテストとは、個々のプログラムの部品（メソッドやクラスなど）が期待通りに動作するかどうかを確認するテストのことです。<br>
JUnitを使うことで、開発者は効率的にテストコードを作成、実行、管理でき、テストの自動化もサポートされるため、開発効率と品質向上に役立ちます。<br>
FYI： [【JUnit入門】テストの基本から実践まで理解しよう！](https://be-engineer.jp/programming/java/972/)

# 事前準備
※Eclipseを使用していますが、自分でJUnitを実行できる（カバレッジ取得まで）環境構築ができる場合はVSCodeなどでも構いません。<br>

## 環境構築 
### EclipseのSetUp
[こちらの記事](https://www.techfun.co.jp/services/magazine/java/windows-eclipse-install.html)を参考にEclipseをセットアップしてください。<br>
※最新版でのセットアップをお願いします。 <br>

### Eclipseでのソースの反映＆動確
Eclipseセットアップ完了後、以下の手順でEclipse上でJUnitCampのソースが触れることを確認してください。 <br>
#### 1. 任意のディレクトリでターミナルなどを開いて`git clone https://github.com/murakawa-h-com/JUnitCamp.git` を実行する<br>
※Gitが入っていない場合は[こちらの記事](https://qiita.com/takeru-hirai/items/4fbe6593d42f9a844b1c)など参考にしてGit入れてください。

#### 2. Eclipseを起動し、git cloneした階層（今回の例だとtestフォルダ）をワークスペースに選択する<br>
<img width="842" height="441" alt="image" src="https://github.com/user-attachments/assets/014b0112-eb8f-4273-bbbe-ac690eccf8b1" /><br>

#### 3. パッケージエクスプローラーでプロジェクトのインポートを選択する<br>　　
<img width="481" height="441" alt="スクリーンショット 2025-07-11 091024" src="https://github.com/user-attachments/assets/5b5fa568-f203-4236-8422-f87f5d837a3b" /><br>

#### 4. Gradle > 既存のGradleプロジェクトを選択して「次へ」を押下する<br> 
<img width="846" height="518" alt="image" src="https://github.com/user-attachments/assets/5a347fb6-1840-41ca-8a28-3dd548245ac3" /><br>

#### 5. プロジェクト・ルート・ディレクトリーの「参照」を押下して、git clone した JUnitCampを選択して、「完了」を押下する<br>
<img width="918" height="1025" alt="image" src="https://github.com/user-attachments/assets/c5f313f4-b3cc-405f-9cc6-34a48dc4ee72" /><br>

#### 6. パッケージ・エクスプローラーのJUnitCampを右クリックして「Gradleプロジェクトのリフレッシュ」を実行（※Ctrl + Rでも可）<br>
<img width="1025" height="1145" alt="image" src="https://github.com/user-attachments/assets/4f53cd7a-6490-4a33-bd48-0a2459e1fa59" /><br>

#### 7. 任意のテストクラスを開いて右クリックし、「実行 > JUnitテスト」でJUnitを実行する<br>
<img width="1044" height="978" alt="image" src="https://github.com/user-attachments/assets/4be88d23-82dc-4272-b303-f6da658c7249" /><br>

#### 8. テストが失敗することを確認する<br>
<img width="1166" height="393" alt="image" src="https://github.com/user-attachments/assets/e92a1048-0e82-436e-8551-8542533f60dd" /><br>

これでJUnitを実行するための準備が整いました。<br>


## 動画視聴（JUnitやTDDを知らない人向け）
以下の動画をご視聴ください。<br>
TDDの第一人者であるt-wadaさんのライブコーディングイベントです。<br>
https://www.youtube.com/live/Q-FJ3XmFlT8?feature=shared&t=1145<br>

# 課題
**フォルダの構成(関連ありそうなとこのみ)**
```
└─src
    ├─main
    │  ├─java
    │  │  ├─day1
    │  │  │  └─fizzbuzz
    │  │  ├─day2
    │  │  │  └─assertion
    │  │  │      └─annotation
    │  │  ├─day3
    │  │  │  └─testdouble
    │  │  ├─day4
    │  │  │  └─parametrizedtest
    │  │  └─day5
    │  │      └─tdd
    │  └─webapp
    │      └─WEB-INF
    │          └─view
    └─test
        └─java
            ├─day1
            │  └─fizzbuzz
            ├─day2
            │  └─assertion
            │      └─annotation
            ├─day3
            │  └─testdouble
            ├─day4
            │  └─parametrizedtest
            └─day5
                └─tdd
```
test配下にある各テストクラスに課題の具体的な内容を記載しています。<br>
以下は各課題の概要と課題ごとに学ぶ内容になります。<br>
初心者はday1から始めることを推奨しますが、順番通りに進めないといけないわけではありません。<br>
- day1(難易度：易) ：FizzBuzz問題のユニットテストを書いてみよう<br>
    - t-wadaさんのライブコーディングとほぼ同じ内容になります。<br>
    - JavaやJUnitの初心者、あまり分からないという方は動画見ながら写経などしていただいても構いません。<br>
- day2(難易度：易) ：アサーション、アノテーションを使ってみよう<br>
    - JUnitで基本的に使われるアサーション、アノテーションについては[こちら](https://qiita.com/HarukiFujita/items/724c684fa80788810531)をご覧ください。<br>
- day3(難易度：普) ：テストダブルを理解し、使ってみよう<br>
    - [テストダブルとは](https://qiita.com/maple_syrup/items/545b890268315e273227)<br>
- day4(難易度：普) ：パラメータ化テストを理解し、使ってみよう<br>
    - [パラメータテストとは](https://qiita.com/oohira/items/5030182af29a30166868)<br>
- day5（難易度：やや難）：TDDで開発をしてみよう<br>
    - TDDでは仕様を満たすテストを書いてから、そのテストをパスするように実装していきます。<br>
    - テストを書いてパスさせるだけでなく、リファクタにも挑戦していきましょう。<br>


※DB接続テストについても本当は作成したかったのですが、、、誰か作ってください。。

# 参考文献
本教材は以下の情報を参考にして作成しました。
- [【JUnit入門】テストの基本から実践まで理解しよう！](https://be-engineer.jp/programming/java/972/)
- [Java環境構築(Windows版)Eclipseのインストール](https://www.techfun.co.jp/services/magazine/java/windows-eclipse-install.html)
- [Gitのインストール方法(Windows版)](https://qiita.com/takeru-hirai/items/4fbe6593d42f9a844b1c)
- [Cyber-Dojo で Fizz Buzz の次におすすめするエクササイズ5選](https://kakakakakku.hatenablog.com/entry/2024/01/19/210158)
- [cyber‑dojo](https://cyber-dojo.org/creator/home)
- [JUnitの基本的な注釈とアサーションメソッド一覧](https://qiita.com/HarukiFujita/items/724c684fa80788810531)
- [JUnitで外部ライブラリを使用せずテストダブルを実装する](https://qiita.com/maple_syrup/items/545b890268315e273227)
- [JUnit 5 のパラメーター化テストは超便利](https://qiita.com/oohira/items/5030182af29a30166868)
