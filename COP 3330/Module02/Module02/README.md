Assignment Description
The Java Programmers Loan (JPL) Company makes loans of up to $50,000 for software development projects. There are two categories of Loans – those to businesses and those to individual applicants.

Write an application that tracks all new loans. The application also must calculate the total amount owed at the due date (original loan amount + loan fee) as well as the total amount that JPL has loaned out in each category and in total.

The application should contain the following classes:

Loan – a public abstract class that implements the LoanConstants interface. A Loan includes a loan number, customer last name, amount of loan, interest rate, and term. The constructor requires data for each of the fields except interest rate. Do not allow loan amounts greater than $50,000. Force any loan term that is not one of the three defined in the LoanConstants interface to a short-term loan. Create a toString() method that displays all the loan data. Create an equals() method that determines whether two compared loans are equivalent.
LoanConstants – a public interface. LoanConstants includes constant values for short-term (3 years), medium-term (7 years), and long-term (15 years) loans. It also contains constants for the company name and the maximum loan amount.
BusinessLoan – a public class that extends Loan. The BusinessLoan constructor sets the interest rate to 3.2% more than the current prime interest rate.
PersonalLoan – a public class that extends Loan. The PersonalLoan constructor sets the interest rate to 2.7% more than the current prime interest rate.
CreateLoans – an application that creates an array of five Loans. Prompt the user for the current prime interest rate. Then, in a loop, prompt the user for the loan type and all relevant information for that loan. Store the created Loan objects in the array. When data entry is complete, display all the loans.
Learning Outcomes
The student will be able to describe and implement the concept of an interface and recognize when and why to use interfaces along with creating inheritance hierarchies.