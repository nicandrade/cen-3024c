import java.util.Scanner;

public class CreateLoan {
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Scanner userInput = new Scanner(System.in);
        int x, i = 0, inputLoanTerm, counterPersonalLoans = 0, counterBusinessLoans = 0;
        double inputInterestRate, inputLoanAmount, totalPersonalLoansOwed = 0, totalBusinessLoansOwed = 0;
        Loan[] loanArray = new Loan[5];
        Loan createLoan;
        String inputLastName, inputLoanType, inputCache;
        boolean validLoanAmount;

        int numberOfLoansToGenerate = 5;

        // Prompt for current interest rate
        System.out.println("What is the Prime Interest Rate?");
        inputInterestRate = userInput.nextDouble();

        // Complete 5 loan applications
        for (x = 0; x < numberOfLoansToGenerate; x++) {
            // Input cache clear
            inputCache = userInput.nextLine();

            // Select Loan Type
            System.out.println("What kind of loan is this; Personal or Business?");
            inputLoanType = userInput.nextLine();

            // Capture Loan Terms
            System.out.println("How many years do you want this loan to be?");
            inputLoanTerm = userInput.nextInt();

            // Input cache clear
            inputCache = userInput.nextLine();

            // Capture Last Name
            System.out.println("What is your last name?");
            inputLastName = userInput.nextLine();

            // Capture Loan Amount
            do {
                System.out.println("How much are you looking to borrow? (Must be below $50,000)");
                inputLoanAmount = userInput.nextDouble();
                // Checking if over $50k
                validLoanAmount = (inputLoanAmount > 50000) ? true : false;
            } while (validLoanAmount == true);

            // Build Loan
            switch (inputLoanType) {
                case "Business":
                    createLoan = new BusinessLoan(inputLastName, inputLoanAmount, inputLoanTerm,
                            inputInterestRate);
                    loanArray[i] = createLoan;
                    totalBusinessLoansOwed += createLoan.totalAmountDue;
                    counterBusinessLoans++;
                    createLoan.toString();
                    i++;
                    break;
                case "Personal":
                    createLoan = new PersonalLoan(inputLastName, inputLoanAmount, inputLoanTerm,
                            inputInterestRate);
                    loanArray[i] = createLoan;
                    totalPersonalLoansOwed += createLoan.totalAmountDue;
                    counterPersonalLoans++;
                    i++;
                    break;
                default:
            }

        }

        userInput.close(); // Closing User Input

        // reseting i index to 0
        i = 0;

        System.out.println("------------------------------------------");
        System.out.println("            JPL LOAN DETAILS");
        System.out.println("------------------------------------------");

        for (x = 1; x <= numberOfLoansToGenerate; x++) {
            System.out.println("Requested Loan: " + x);
            System.out.println("Borrower's Last Name: " + loanArray[i].lastName);
            System.out.println("Loan Type: " + loanArray[i].loanTypeIdentifier);
            System.out.println("Loan Number: " + loanArray[i].loanNumber);
            System.out.println("Loan Amount: $" + String.format("%.2f", loanArray[i].loanAmount));
            System.out.println("Loan Term Length: " + loanArray[i].loanTerm);
            System.out.println("Loan Interest Rate: " + loanArray[i].interestRate + "%");
            System.out.println("Amount Due to Close: $" + String.format("%.2f", loanArray[i].totalAmountDue));
            System.out.println("------------------------------------------");
            i++;
        }
        System.out.println("\n");

        // Loans by Category
        System.out.println("------------------------------------------");
        System.out.println("            LOANS BY CATEGORY");
        System.out.println("------------------------------------------");
        System.out.println("CATEGORY    # OF LOANS  TOTAL AMOUNT OWED");
        System.out.println(
                "Business\t" + counterBusinessLoans + "\t" + "$" + String.format("%.2f", totalBusinessLoansOwed));
        System.out.println(
                "Personal\t" + counterPersonalLoans + "\t" + "$" + String.format("%.2f", totalPersonalLoansOwed));

    }
}
