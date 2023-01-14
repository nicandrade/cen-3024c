public class Loan implements LoanConstants {
    // values
    int loanNumber = (int) (Math.random() * (5000 - 1000 + 1) + 1);
    String lastName;
    double loanAmount;
    protected double interestRate;
    protected double totalAmountDue;
    int loanTerm;
    protected String loanTypeIdentifier;

    // Constructor
    public Loan(String lastName, double loanAmount, int loanTerm) {

        setLoanNumber(loanNumber);
        setLastName(lastName);
        setLoanAmount(loanAmount);
        setLoanTerm(loanTerm);

    }

    // Getter
    public boolean equals(Object obj) {
        if (!(obj instanceof Loan)) {
            return false;
        }

        boolean result = false;
        if (this.totalAmountDue == ((Loan) obj).totalAmountDue) {
            result = true;
        }
        return result;
    }

    // Setter
    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public void setLoanTerm(int loanTerm) {
        switch (loanTerm) {
            case 3:
                this.loanTerm = LoanConstants.shortTermLoan;
                break;

            case 7:
                this.loanTerm = LoanConstants.midTermLoan;
                break;

            case 15:
                this.loanTerm = LoanConstants.longTermLoan;
                break;

            default:
                this.loanTerm = LoanConstants.shortTermLoan;
        }
        ;
    }

    // ToString
    public String toString() {
        String result;
        result = "Borrower's Last Name: " + lastName + "\n"
                + "Loan Type: " + loanTypeIdentifier + "\n"
                + "Loan Number: " + loanNumber + "\n"
                + "Loan Amount: $" + loanAmount + "\n"
                + "Loan Term Length: " + loanTerm + "\n"
                + "Loan Interest Rate: " + interestRate + "\n"
                + "Total Loan Amount (with fees): " + totalAmountDue + "\n"
                + "------------------------------------------";
        return result;
    }
}
