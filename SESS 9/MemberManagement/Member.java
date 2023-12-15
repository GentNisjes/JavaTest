import java.time.LocalDate;
import java.util.*;
/**
 * A class representing a member of a club.
 */
public class Member 
{
    private String firstName;
    private String lastName;
    private String email;
    private int month;
    private int year;
    private double paymentDue;
  

    public Member(String firstName, String lastName, String email, int month, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.month = month;
        this.year = year;
    }
    
    public Member(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.month = LocalDate.now().getMonthValue();
        this.year = LocalDate.now().getYear();
    }
    
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }
    
    public double getPaymentDue(){
        return paymentDue;
    }
    
    public void setPaymentDue (double fee){
        paymentDue = fee;
    }
    
    public void pay (double amount){
        if (amount >= paymentDue){
            setPaymentDue(0);
        }
        else{
            setPaymentDue(paymentDue - amount);
        }
    }
    
    public Boolean isEqual(Member toTest) {
        return (toTest.getFirstName().equals(firstName) && toTest.getLastName().equals(lastName));
    }
}   