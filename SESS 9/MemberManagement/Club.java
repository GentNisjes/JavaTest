import java.io.File;
import java.util.Scanner;
import java.util.*;

/**
 * A class representing a club with members
 */
public class Club{
    private ArrayList<Member> members;
    private ArrayList<Member> removedMembers;
    private String name;
    private double membershipFee;
    
    public Club(String name, double membershipFee){
        this.name = name;
        this.membershipFee = membershipFee;
        
        members = new ArrayList<Member>();
    }
    
    public int getNrOfMembers (){
        return members.size();
    }
    /**
    public void addMember (Member newMember){

        for (int num = 0; num < members.size(); num ++){
            if (members.size() == 0) {
                members.add(newMember);
                num = 0;
            }
            else if (members.get(num).isEqual(newMember) == false) {
                members.add(newMember);
            }
        }
    }
    */
    
    public void addMember (Member newMember){
    
    
        boolean check = false;
        Member m;
        for(int i = 0; i < members.size(); i++)
        {
            m = members.get(i);
            if(newMember.getFirstName() == members.get(i).getFirstName() && newMember.getLastName() == members.get(i).getLastName())
            {
                check = true;
            }
        }
        if(check == false)
        {
            members.add(newMember);
            System.out.println(newMember.getFirstName());
        }
        else
        {
            System.out.println("Member already exist");
        }
    }
    
    
    public String getClubName (){
        return name;
    }
    
    public void showOverview (){
        System.out.println("Overview of all members of club The Red Devils");
        //we have the getters from the Members class so use them!
        for(int i = 0; i < members.size(); i++){
            System.out.println("Member: firstName=" + members.get(i).getFirstName() + ", lastName=" + members.get(i).getLastName() + ", eMail=" + members.get(i).getEmail() + " joined the club in " + members.get(i).getMonth() + "/" + members.get(i).getYear());
        }

    }
    
    public int joinedInYear (int year){
        int count = 0;
        for (Member m : members) {
            if (m.getYear() == year) {
                count++;
            }
        }
        return count;
    }
    
    public boolean isMember (String name){
        for (Member m : members) {
            if (m.getLastName().equals(name)) {
                return true;
            }
        }
        return false;
    }
    /** FOLLOWING DOES NOT WORK FOR ISMEMBER
     * for(int i = 0; i < members.size(); i++){
            if (members.get(i).getLastName().equals(name)){
                return true;
            }
        }
        return false;
     */
    
    public ArrayList<Member> removeMembersFromYear(int year){
        removedMembers= new ArrayList<Member>();
        
        for (int i = 0; i < members.size(); i++)
        {
            if (members.get(i).getYear() == year)
            {
                removedMembers.add(members.get(i));
            }
            for (int j = 0; j < removedMembers.size(); j ++)
            {
                members.remove(removedMembers.get(j));
            }
        }
        return removedMembers;
    }
    
    public ArrayList<String> getSortedNames()
    {
        ArrayList<String> sorted = new ArrayList();
        for (Member m : members) {
            sorted.add(m.getLastName());
        }
        Collections.sort(sorted);
        return sorted;
    }
    
    public void showOverviewFull(){
        String [] months = {"January", "February", "March", "April",
                        "May", "June", "July", "August", "September",
                        "October", "November", "December"};
                        
        for (Member m : members)
        {
            System.out.println("Overview of all members of club The Ded Revils");
            System.out.println("Member: firstName=" + m.getFirstName() + 
            ", lastName=" + m.getLastName() + 
            ", eMail=" + m.getEmail() + 
            " joined the club in " + months[m.getMonth()-1] + " " 
            + m.getYear());
        }
    }
    
    public void populateFromFile (String filename)
    {
        String data;
        String [] mem = new String [7];
        try{
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext()) {
                //next() and next() reads just one string or int and stops reading at a space or a line-break / enter
                String firstName = sc.next();
                String lastName = sc.next();
                String email = sc.next();
                int year = sc.nextInt();
                int month = sc.nextInt();
                if (sc.hasNextLine()) {
                    sc.nextLine();
                }
                addMember(new Member(firstName, lastName, email, month, year));
            }
            sc.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException(e);
        };
    }
    
    public void assignPaymentsDue (int percentDiscount){
        for (Member m : members){
            if (m.getPaymentDue() != 0){
                double stillToPay = m.getPaymentDue();
                m.setPaymentDue( 2*stillToPay + membershipFee);
            }
            else{
                m.setPaymentDue(membershipFee - membershipFee * ((double)percentDiscount)/((double)100));
            }
        }
    }
    
    public void processPaymentsFromFile (String filename){
        try
        {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext())
            {
                String firstName = sc.next();
                String lastName = sc.next();
                String date = sc.next();
                int amount = sc.nextInt();
                for(Member m: members){
                    if (m.getFirstName().equals(firstName) &&
                        m.getLastName().equals(lastName)) {
                        m.pay(amount);
                    }
                }
                if (sc.hasNextLine()){
                    sc.nextLine();
                }
            }
            sc.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        };
    }
    
    public ArrayList<Member> longLifeMembers(){
        
        ArrayList<Member> longlife = new ArrayList();
        
        if (members.isEmpty()) {
            return null;
        }
        
        int month = members.get(0).getMonth();
        int year = members.get(0).getYear();
        for (Member m : members) {
            if (m.getYear() < year) {
                year = m.getYear();
                month = m.getMonth();
            } else if (m.getMonth() < month && m.getYear() == year) {
                year = m.getYear();
                month = m.getMonth();
            }
        }
        for (Member m : members) {
            if (m.getYear() == year && m.getMonth() == month) {
                longlife.add(m);
            }
        }
        return longlife;
    }
}

//USE THIS CODE TO READ FROM A FILE
        /*
        try
        {
            Scanner sc = new Scanner(new File(filename));
            while (sc.hasNext())
            {
                // READ FROM FILE
            }
            sc.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        };
        */
 