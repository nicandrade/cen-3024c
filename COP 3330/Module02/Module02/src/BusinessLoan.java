public class BusinessLoan extends Loan {

    public BusinessLoan(String lastName, double loanAmount, int loanTerm, double interestRate){
        super(lastName, loanAmount, loanTerm);
        super.interestRate = interestRate + 3.2;
        setAmountDue(super.interestRate, loanAmount);
        loanTypeIdentifier = "Business";
    }

    public double setAmountDue(double interestRate, double loanAmount){
        totalAmountDue = ((interestRate/100)*loanAmount)+loanAmount;
        return totalAmountDue;
    }
}