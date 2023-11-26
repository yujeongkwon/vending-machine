package main.view;

import main.domain.Beverage;
import main.domain.CashDenomination;
import main.domain.Options;

import java.util.List;

public class OutputView {

    public static void printException(Exception exception) {
        System.out.println(exception.getMessage());
    }

    public static void printWelcomeMessage() {
        System.out.println("[어서와요! GDSC 음료 자판기]");
        System.out.println();
    }

    public static void printOptionsSelection() {
        System.out.println("음료를 선택 해주세요!");
    }

    public static void printOptions() {
        System.out.println("음료를 선택 해주세요!");
        System.out.println();

        for (Options option : Options.values()) {
            System.out.println("[" + (option.ordinal() + 1) + "] " + option.getOptions());
        }

        System.out.println();
    }

    public void printBeverages(int optionNumber) {
        Options selectedOption = getOptionByNumber(optionNumber);

        List<Beverage> beverages = selectedOption.getBeverages();

        for (int i = 0; i < beverages.size(); i++) {
            Beverage beverage = beverages.get(i);
            System.out.printf("[%d] %s : %d원\n", i + 1, beverage.name(), beverage.price());
        }
    }

    public void printCashDenomination() {

        for (CashDenomination denomination : CashDenomination.values()) {
            System.out.println("[" + denomination.getOption() + "] " + denomination.getValue() + "원");
        }
        System.out.println("[0] 반환");
    }

    private Options getOptionByNumber(int optionNumber) {
        return Options.values()[optionNumber - 1];
    }

    public static void printPaymentOptions() {
        lineClassification();
        System.out.println("[결제 방식 선택]\n");
        System.out.println("[1] 현금");
        System.out.println("[2] 카드 (부가세 10% 적용)");
    }

    public static void lineClassification() {
        System.out.println("------------------------------");
    }
}
