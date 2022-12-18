package EnumType;

public enum TransactionType {
    DEPOSIT(5),   //  0
    WITHDRAW(10), // 1
    TRANSFER(15), // 2
    PAYMENT(20),  // 3
    OTHER(100);  // 4

    private final int transactionCode;

    public int getTransactionCode() {
        return transactionCode;
    }

    private TransactionType(int code) {
        this.transactionCode=code;
    }
}
