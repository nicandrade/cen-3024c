public class PersonalLoan extends Loan {
    
    public PersonalLoan(String lastName, double loanAmount, int loanTerm, double interestRate){
        super(lastName, loanAmount, loanTerm);
        super.interestRate = interestRate + 2.7;
        setAmountDue(super.interestRate, loanAmount);
        loanTypeIdentifier = "Personal";
    }

    public double setAmountDue(double interestRate, double loanAmount){
        totalAmountDue = ((interestRate/100)*loanAmount)+loanAmount;
        return totalAmountDue;
    }
}
