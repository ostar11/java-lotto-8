# java-lotto-precourse

## 로또
사용자가 금액을 입력하면 로또를 구매하고, 당첨번호와 보너스번호를 입력받아 당첨 및 보상 통계를 알려주는 로또 프로그램

### 프로젝트 규칙
- 로또 번호는 1부터 45 사이의 숫자로, 로또는 총 6개로 구성됩니다.
  - 로또 한장은 1000원입니다.
  - 로또를 구매하면 구매한 로또 목록을 확인할 수 있습니다.
- 당첨 번호는 1부터 45 사이의 숫자로, 총 6개로 구성됩니다.
  - 당첨 번호는 쉼표로 구분하며 공백은 없어야 합니다.
- 보너스 번호는 1부터 45 사이의 숫자로 1개입니다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- 당첨은 1등부터 5등까지 존재합니다.
- 입력값이 규칙에 위배되면 메시지를 확인한 후 올바르게 입력해주세요.
- 수익률은 소수점 둘째자리에서 반올림 합니다.

---

### 기능 목록

| 번호     | 기능명            | 설명                                            | 예외                                                                 |
|--------|----------------|-----------------------------------------------|--------------------------------------------------------------------|
| `F-01` | 프로그램 실행        | 로또 구매, 당첨번호 등록, 보너스번호 등록, 결과 출력 등 메인로직을 진행한다. |                                                                    |
| `F-02` | 전체 모듈 조립       | 각 기능 별로 필요한 요소를 조립한다.                         |                                                                    |
| `F-03` | 로또 구입 금액 입력 받기 | 사용자로부터 구매할 로또 금액을 입력받는다.                      | 로또 금액이 1000 단위가 아닐 때<br>로또 금액이 숫자가 아닐 때<br>                        |
| `F-04` | 로또 번호 개수 검증    | 로또 번호가 6개인지 검증한다.                             |                                                                    |
| `F-05` | 로또 번호 중복 검증    | 로또에 같은 번호가 있는지 확인한다.                          |                                                                    |
| `F-06` | 로또 번호 범위 검증    | 로또 번호가 범위에 속하는지 검증한다                          |                                                                    |
| `F-07` | 당첨 번호 입력 받기    | 사용자로부터 로또 당첨 번호를 입력받는다.                       | 당첨 번호가 6개의 숫자로 이루어지지 않을때<br>각 당첨 번호가 범위안에 속하지 않을 때<br>당첨 번호가 중복될 때 |
| `F-08` | 보너스 번호 입력 받기   | 사용자로부터 보너스 번호를 입력받는다.                         | 보너스 번호가 범위 안에 속하지 않을 때<br>당첨 번호와 중복될 때                             |
| `F-09` | 입력값 검증         | 입력값이 비어있는지 검사한다.                              |                                                                    |
| `F-10` | 구입 금액 검증       | 입력한 금액이 1000원 단위인지 검증한다.                      |                                                                    |
| `F-11` | 당첨 번호 문자열 분리   | 당첨 번호 문자열을 번호 목록으로 변환한다.                      |                                                                    |
| `F-12` | 당첨 번호 범위 검증    | 당첨 번호가 숫자 범위에 속하는지 검증한다.                      |                                                                    |
| `F-13` | 당첨 번호 개수 검증    | 당첨 번호가 6개의 숫자로 이루어져 있는지 검증.                   |                                                                    |
| `F-14` | 당첨 번호 중복 검증    | 당첨 번호 목록에 중복된 번호가 있는지 검증한다.                   |                                                                    |
| `F-15` | 보너스 번호 변환      | 보너스 번호를 숫자로 변환한다.                             |                                                                    |
| `F-16` | 보너스 번호 범위 검증   | 보너스 번호가 숫자 범위에 속하는지 검증한다.                     |                                                                    |
| `F-17` | 보너스 번호 중복 검증   | 보너스 번호가 당첨 번호와 중복되는지 검증한다.                    |                                                                    |
| `F-18` | 로또 생성          | 6개의 숫자로 구성된 로또를 생성한다.                         | 로또 번호 중 중복이 있을 때<br>로또 번호 개수가 6개가 아닐때<br>로또 번호가 범위에 속하지 않을때        |
| `F-19` | 로또와 당첨번호 비교    | 로또와 당첨번호가 번호별로 일치하는지 확인한다.                    |                                                                    |
| `F-20` | 로또와 보너스번호 비교   | 보너스 번호가 로또에 있는지 확인한다.                         |                                                                    |
| `F-21` | 로또 점수 계산       | 당첨 번호와 보너스 번호를 기반으로 점수를 계산한다.                 |                                                                    |
| `F-22` | 로또 등수 계산       | 점수를 기반으로 등수를 계산한다.                            | 점수에 해당하는 등수가 없는 경우                                                 |
| `F-23` | 로또 보상 계산       | 점수를 기반으로 보상을 계산한다.                            |                                                                    |
| `F-24` | 당첨 내역 저장       | 등수 별 당첨 횟수를 저장한다.                             |                                                                    |
| `F-25` | 총 당첨금 계산       | 당첨된 금액을 더한다.                                  |                                                                    |
| `F-26` | 수익률 계산         | 구매 금액과 당첨금을 사용해 수익률을 계산한다.                    |                                                                    |
| `F-27` | 로또 출력          | 구매한 로또 번호를 출력한다.                              |                                                                    |
| `F-28` | 입력 반복          | 올바른 입력일때까지 기능을 반복한다.                          |                                                                    |
| `F-29` | 당첨 통계 출력       | 당첨된 금액순으로 개수를 출력한다.                           |                                                                    |
| `F-30` | 수익률 출력         | 수익률을 출력한다.                                    |                                                                    |
| `F-31` | 에러 문구 출력       | 에러 원인을 출력한다.                                  |                                                                    |

---
### 실행 결과 예시
```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

---
### 프로젝트 구조
```
src/main/java
└── lotto
    ├── Application.java
    ├── application
    │   ├── BonusNumberService.java
    │   ├── LottoApplication.java
    │   ├── LottoShopService.java
    │   └── WinningNumberService.java
    ├── common
    │   ├── Parser.java
    │   ├── RepeatableProcessor.java
    │   └── Validator.java
    ├── config
    │   ├── ApplicationConfig.java
    │   ├── BankConfig.java
    │   ├── BonusConfig.java
    │   ├── IOConfig.java
    │   ├── ShopConfig.java
    │   └── WinningConfig.java
    ├── domain
    │   ├── bank
    │   │   ├── LottoBank.java
    │   │   ├── RewardAggregator.java
    │   │   └── RewardCollector.java
    │   ├── bonusNumber
    │   │   ├── BonusNumber.java
    │   │   ├── BonusNumberFactory.java
    │   │   ├── BonusNumberParser.java
    │   │   ├── BonusNumberRule.java
    │   │   └── BonusNumberValidator.java
    │   ├── lotto
    │   │   ├── Lotto.java
    │   │   ├── LottoFactory.java
    │   │   ├── LottoNumberGenerator.java
    │   │   ├── LottoRank.java
    │   │   ├── LottoResult.java
    │   │   ├── LottoReward.java
    │   │   ├── LottoRule.java
    │   │   ├── LottoScore.java
    │   │   └── LottoWallet.java
    │   ├── shop
    │   │   ├── AmountValidator.java
    │   │   ├── LottoPurchase.java
    │   │   ├── LottoShopStaff.java
    │   │   ├── PurchaseParser.java
    │   │   ├── PurchaseUnitValidator.java
    │   │   └── PurchaseValidator.java
    │   └── winningnumber
    │       ├── WinningNumber.java
    │       ├── WinningNumberFactory.java
    │       ├── WinningNumberParser.java
    │       └── WinningNumberRule.java
    ├── exception
    │   ├── DuplicationException.java
    │   ├── EmptyInputException.java
    │   ├── ErrorCode.java
    │   ├── InvalidCountException.java
    │   ├── InvalidFormatException.java
    │   ├── InvalidRangeException.java
    │   └── InvalidUnitException.java
    └── io
        ├── ErrorWriter.java
        ├── InputReader.java
        ├── OutputWriter.java
        ├── formatter
        │   ├── PurchaseFormatter.java
        │   └── WinningFormatter.java
        ├── mapper
        │   ├── LottoMapper.java
        │   └── RewardMapper.java
        └── validator
            └── InputValidator.java

```

---
### 테스트 구조도
```
src/test/java
└── lotto
    ├── ApplicationTest.java
    ├── common
    │   └── RepeatableProcessorTest.java
    ├── domain
    │   ├── bank
    │   │   ├── LottoBankTest.java
    │   │   ├── RewardAggregatorTest.java
    │   │   └── RewardCollectorTest.java
    │   ├── bonusnumber
    │   │   ├── BonusNumberFactoryTest.java
    │   │   ├── BonusNumberParserTest.java
    │   │   ├── BonusNumberRuleTest.java
    │   │   ├── BonusNumberTest.java
    │   │   └── BonusNumberValidatorTest.java
    │   ├── lotto
    │   │   ├── LottoFactoryTest.java
    │   │   ├── LottoNumberGeneratorTest.java
    │   │   ├── LottoRankTest.java
    │   │   ├── LottoResultTest.java
    │   │   ├── LottoRewardTest.java
    │   │   ├── LottoRuleTest.java
    │   │   ├── LottoTest.java
    │   │   └── LottoWalletTest.java
    │   ├── shop
    │   │   ├── AmountValidatorTest.java
    │   │   ├── LottoShopStaffTest.java
    │   │   ├── PurchaseParserTest.java
    │   │   ├── PurchaseUnitValidatorTest.java
    │   │   └── PurchaseValidatorTest.java
    │   └── winningnumber
    │       ├── WinningNumberFactoryTest.java
    │       ├── WinningNumberParserTest.java
    │       ├── WinningNumberRuleTest.java
    │       └── WinningNumberTest.java
    └── io
        ├── formatter
        │   ├── PurchaseFormatterTest.java
        │   └── WinningFormatterTest.java
        ├── mapper
        │   ├── LottoMapperTest.java
        │   └── RewardMapperTest.java
        └── validator
            └── InputValidatorTest.java

```
