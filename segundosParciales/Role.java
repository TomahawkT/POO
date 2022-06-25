package segundosParciales;

public enum Role {
    STUDENT(2),
    MAIN_RESPONSIBLE(12),
    PRACTICE_RESPONSIBLE(11),
    ASSISTANT(10);

    private final int loanDays;

    Role(int loanDays) {
        this.loanDays = loanDays;
    }

    public int getLoanDays() {
        return loanDays;
    }

}
