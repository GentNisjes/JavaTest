import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.time.LocalDate;

import java.util.Calendar;

public class ClubTest 
{
    private Club team;
    
    PrintStream defaultSO;  
    ByteArrayOutputStream baos;
    BufferedReader br;
    

    /**
     * Executed before each test. Sets up a club with members, so we don't have to do this in each individual test.
     */
    @BeforeEach
    public void setUp() throws Exception 
    {
        // UNCOMMENT FROM TEST 3 ONWARDS
        
        team = new Club("The Red Devils", 300.0);
        team.addMember(new Member("Jeremy","Doku","countdoku@gmail.com",2,2020));
        team.addMember(new Member("Romelu","Lukaku","globetrotter@reddevils.be",8,2010));
        team.addMember(new Member("Kevin","De Bruyne","kdb@united.uk",8,2010));
        team.addMember(new Member("Youri","Tielemans","rocket@reddevils.be",4,2017));
        team.addMember(new Member("Thibaut","Courtois","therealcaptain@reddevils.be",11,2011));
        team.addMember(new Member("Leandro","Trossard","leandro@trossard.com",9,2020));
        
        defaultSO = System.out;
        
    }

    /**
     * Executed after each test. These operations are needed to make sure BlueJ's terminal keeps functioning in case one of the print tests fails.
     */
    @AfterEach
    public void tearDown() throws Exception 
    {
        try
        {
            if( br != null )
            {
                br.close();
            }
            if( baos != null )
            {
                baos.close();
            }
        }
        catch( Exception e )
        {
            System.out.println("Error while closing buffer");
        }
        System.setOut(defaultSO);
    }

    
    /**
     * check constructor of Club, number of members should be 0
     */
    @Test
    public void test01() 
    {
        Club team = new Club("The Red Devils", 300.0);
        assertEquals(0, team.getNrOfMembers());
        assertEquals("The Red Devils", team.getClubName());
    }

    /**
     * add Members to Club
     */
    @Test
    public void test02() 
    {
        Club team = new Club("The Red Devils", 300.0);
        Member captain = new Member("Leandro", "Trossard", "leandro@trossard.com", 2, 2004);
        team.addMember(captain);
        Member keeper = new Member("Thibaut", "Courtois", "therealcaptain@reddevils.be", 11, 2011);
        team.addMember(keeper);
        assertEquals(2, team.getNrOfMembers());
        Member alias1 = new Member("Leandro", "Trossard", "leandro@trossard.com", 12, 2015);
        team.addMember(alias1); // same sirname and firstname
        Member alias2 = new Member("Leandro", "Van Asch", "eden@kuleuven.be", 10, 2019);
        team.addMember(alias2); // same firstname
        Member alias3 = new Member("Anna", "Trossard", "anna.haz@gmail.com", 1, 2019);
        team.addMember(alias3); // same sirname
        assertEquals(4, team.getNrOfMembers());
    }

    /**
     * check showOverview
     */
    @Test
    public void test03() 
    {
        team.showOverview();
        baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        String result = null;
        try
        {
            team.showOverview();
            br = new BufferedReader(new StringReader(baos.toString()));
            result = br.readLine();
            if( result == null )
            {
                fail();
            }
            assertTrue(result.startsWith("Overview of all members of club The Red Devils"));
            result = br.readLine();
            System.out.println(result);
            assertTrue(result.startsWith("Member: firstName=Jeremy, lastName=Doku, eMail=countdoku@gmail.com joined the club in 2/2020"));
        }
        catch(Exception e)
        {
            System.out.println("Error while redirection System.out");
        }
    }
    /**
     * check joined in year
     */
    @Test
    public void test04() 
    {
        assertEquals(2, team.joinedInYear(2010));
        assertEquals(1, team.joinedInYear(2017));
        assertEquals(0, team.joinedInYear(2012));
    }

    /**
     * check if there is a member with given last name
     */
    @Test
    public void test05() 
    {
        String cour = "Cour";
        String tois = "tois";
        assertEquals(true, team.isMember("Courtois"));
        assertEquals(true, team.isMember(cour + tois)); //Does your test fail on this line? Remember the right way to compare strings!
        assertEquals(false, team.isMember("Leandro"));
        assertEquals(false, team.isMember(""));
    }

    /**
     * remove members who started in a given year
     */
    @Test
    public void test06() 
    {
        ArrayList<Member> gone = team.removeMembersFromYear(2010);
        assertEquals(2, gone.size());
        assertEquals("De Bruyne", gone.get(1).getLastName());
        assertEquals("Lukaku", gone.get(0).getLastName());
        assertEquals(4, team.getNrOfMembers());
        gone = team.removeMembersFromYear(2000);
        assertEquals(0, gone.size());
        assertEquals(4, team.getNrOfMembers());
        gone = team.removeMembersFromYear(2017);
        assertEquals(1, gone.size());
        assertEquals("Youri", gone.get(0).getFirstName());
        assertEquals(3, team.getNrOfMembers());
    }

    /**
     * check alphabetical overview
     */
    @Test
    public void test07() 
    {
        ArrayList<String> sortedNames = team.getSortedNames();
        assertEquals( 6, sortedNames.size() );
        assertEquals( "Courtois", sortedNames.get(0) );
        assertEquals( "De Bruyne", sortedNames.get(1) );
        assertEquals( "Doku", sortedNames.get(2) );
        assertEquals( "Lukaku", sortedNames.get(3) );
        assertEquals( "Tielemans", sortedNames.get(4) );
        assertEquals( "Trossard", sortedNames.get(5) );
    }

    /**
     * check showOverviewFull with month names instead of number
     */
    @Test
    public void test08() 
    {
        Club team = new Club("The Ded Revils", 300.0);
        Member captain = new Member("Leandro", "Trossard", "leandro@trossard.com", 9, 2020);
        team.addMember(captain);
        Member keeper = new Member("Thibaut", "Courtois", "therealcaptain@reddevils.be", 11, 2011);
        team.addMember(keeper);
        team.showOverviewFull();
        PrintStream defaultSO = System.out;  
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        try
        {
            team.showOverviewFull();
            BufferedReader br = new BufferedReader(new StringReader(baos.toString()));
            String result = br.readLine();
            if( result == null )
            {
                fail();
            }
            //use contains to see if name of month is written to screen
            assertTrue(result.startsWith("Overview of all members of club The Ded Revils"));
            result = br.readLine();
            assertTrue(result.startsWith("Member: firstName=Leandro, lastName=Trossard, eMail=leandro@trossard.com joined the club in September 2020"));
        } 
        catch(Exception e)
        {
            System.out.println("Error while redirection System.out");
        }
    }
    /**
     * populate club with info stored in a file
     */
    @Test
    public void test09()
    {
        Club team = new Club("The Red Devils", 300.0);
        assertEquals(0, team.getNrOfMembers());
        team.populateFromFile("members1.txt");
        assertEquals(5, team.getNrOfMembers());
        assertTrue( team.isMember("Doku") );
        assertTrue( team.isMember("Courtois") );
        assertTrue( team.isMember("Trossard") );
        assertFalse( team.isMember("Desmet") );
    }
  
    /**
     * check paymentDue for members
     */
    @Test
    public void test10() 
    {
        Member keeper = new Member("Thibaut", "Courtois", "therealcaptain@reddevils.be", 11, 2020);
        keeper.setPaymentDue( 300 );
        
        assertEquals(300, keeper.getPaymentDue());
        keeper.pay(290);
        assertEquals(10, keeper.getPaymentDue());
        keeper.pay(20.0);
        assertEquals(0, keeper.getPaymentDue());
    }

    /**
     * check calculation of payment due for all members
     */
    @Test
    public void test11() 
    {
        Club team = new Club("The Red Devils", 300.0);
        Member captain = new Member("Leandro", "Trossard", "leandro@trossard.com", 2, 2004);
        team.addMember(captain);
        Member keeper = new Member("Thibaut", "Courtois", "therealcaptain@reddevils.be", 11, 2013);
        team.addMember(keeper);
        Member goalgetter = new Member("Romelu", "Lukaku", "globetrotter@reddevils.be", 8, 2010);
        goalgetter.setPaymentDue( 140 );
        team.addMember(goalgetter);

        team.assignPaymentsDue( 10 );
        
        assertEquals(270f, keeper.getPaymentDue(), 0.1);
        assertEquals(580f, goalgetter.getPaymentDue(), 0.1);
        assertEquals(270f, captain.getPaymentDue(), 0.1);
    }
    /**
     * update membership fees of the members of the club with info stored in a textfile
     */
    @Test
    public void test12()
    {
        Club team = new Club("The Red Devils", 300.0);        
        Member m1 = new Member("Jeremy","Doku","countdoku@gmail.com",2,2020);
        Member m2 = new Member("Romelu","Lukaku","globetrotter@reddevils.be",8,2010);
        Member m3 = new Member("Kevin","De Bruyne","kdb@united.uk",8,2010);
        Member m4 = new Member("Youri","Tielemans","rocket@reddevils.be",4,2017);
        Member m5 = new Member("Thibaut","Courtois","therealcaptain@reddevils.be",11,2011);
        Member m6 = new Member("Leandro","Trossard","leandro@trossard.com",9,2020);       
        team.addMember(m1);
        team.addMember(m2);
        team.addMember(m3);
        team.addMember(m4);
        team.addMember(m5);
        team.addMember(m6);
        
        team.assignPaymentsDue( 0 );        
        team.processPaymentsFromFile("payments1.txt");

        assertEquals(0, m1.getPaymentDue(), 0.1);
        assertEquals(90, m2.getPaymentDue(), 0.1);
        assertEquals(300, m3.getPaymentDue(), 0.1);
        assertEquals(300, m4.getPaymentDue(), 0.1);
        assertEquals(150, m5.getPaymentDue(), 0.1);
        assertEquals(0, m6.getPaymentDue(), 0.1);
    }
    /**
     * overload constructor of Member without month and year, use current date (from java.util.LocalDate)
     */
    @Test
    public void test13()
    {
        Club team = new Club("The Red Devils", 300.0);
        Member latest = new Member("Arthur", "Vermeeren", "tureke@derestisparking.be");
        // old style Calendar is used, so we do not give away the (better) solution with LocalDate
        Calendar today = Calendar.getInstance();  
        assertEquals(today.get(Calendar.YEAR), latest.getYear());
        assertEquals(today.get(Calendar.MONTH) + 1, latest.getMonth());
        team.addMember(latest);
        assertEquals(1, team.getNrOfMembers());
    }

    /**
     * check ArrayList of long life club members
     */
    @Test
    public void test14()
    {
        Club team = new Club("The darts club", 250.0);
        assertNull(team.longLifeMembers());
        team.addMember(new Member("Rob", "Cross", "rob@cross.be", 1, 2000));
        team.addMember(new Member("Michael", "Van Gerwen", "mvg@pdc.com", 1, 2001));
        assertEquals(1, team.longLifeMembers().size());
        assertEquals("Cross", team.longLifeMembers().get(0).getLastName());
        team.addMember(new Member("Dimitri", "Vanden Bergh", "dancingdimi@gmail.com", 5, 1999));
        assertEquals(1, team.longLifeMembers().size());
        assertEquals("Vanden Bergh", team.longLifeMembers().get(0).getLastName());
        team.addMember(new Member("Jeff", "Nobody", "jeff@nobody.be", 1, 1900));
        team.addMember(new Member("Jose", "de Sousa", "jose@portugal.po", 1, 2000));
        assertEquals(1, team.longLifeMembers().size());
        assertEquals("Nobody", team.longLifeMembers().get(0).getLastName());
        team.addMember(new Member("Jeff", "Bobdy", "jeff@bobdy.be", 1, 1900));
        assertEquals(2, team.longLifeMembers().size());
        assertEquals("Nobody", team.longLifeMembers().get(0).getLastName());
        assertEquals("Bobdy", team.longLifeMembers().get(1).getLastName());
        team.addMember(new Member("Jeff", "Nobdy", "jeff@nobdy.be", 1, 1900));
        assertEquals(3, team.longLifeMembers().size());
    }
    
    //You can skip these tests for now. The assignment for them is in the extra exercises.
    
    /**
     * updated version of populateFromFile, we are using a file with semicolon as a delimiter here
     *
    @Test
    public void test15()
    {
        Club team = new Club("The Red Devils", 300.0);
        assertEquals(0, team.getNrOfMembers());
        team.populateFromFileImproved("members2.txt");
        assertEquals(6, team.getNrOfMembers());
        assertTrue( team.isMember("Doku") );
        assertTrue( team.isMember("De Bruyne") );
        assertTrue( team.isMember("Trossard") );
        assertFalse( team.isMember("Desmet") );
    }
*/    
    /**
     * final version of populateFromFile, this time the file contains a header row and members of multiple clubs
     *
    @Test
    public void test16()
    {
        Club team = new Club("The Red Devils", 300.0);
        assertEquals(0, team.getNrOfMembers());
        team.populateFromFileFinal("members3.txt");
        assertEquals(6, team.getNrOfMembers());
        assertTrue( team.isMember("Doku") );
        assertTrue( team.isMember("De Bruyne") );
        assertTrue( team.isMember("Trossard") );
        assertFalse( team.isMember("Desmet") );
    }
*/    
    /**
     * updated version of processPaymentsFromFile, the delimiter is a semicolon and payments are stored as decimal numbers
     *
    @Test
    public void test17()
    {
        Club team = new Club("The Red Devils", 300.0);        
        Member m1 = new Member("Jeremy","Doku","countdoku@gmail.com",2,2020);
        Member m2 = new Member("Romelu","Lukaku","globetrotter@reddevils.be",8,2010);
        Member m3 = new Member("Kevin","De Bruyne","kdb@united.uk",8,2010);
        Member m4 = new Member("Youri","Tielemans","rocket@reddevils.be",4,2017);
        Member m5 = new Member("Thibaut","Courtois","therealcaptain@reddevils.be",11,2011);
        Member m6 = new Member("Leandro","Trossard","leandro@trossard.com",9,2020);       
        team.addMember(m1);
        team.addMember(m2);
        team.addMember(m3);
        team.addMember(m4);
        team.addMember(m5);
        team.addMember(m6);
        
        team.assignPaymentsDue( 0 );        
        team.processPaymentsFromFileImproved("payments2.txt");

        assertEquals(0, m1.getPaymentDue(), 0.1);
        assertEquals(89.5, m2.getPaymentDue(), 0.1);
        assertEquals(46.5, m3.getPaymentDue(), 0.1);
        assertEquals(300, m4.getPaymentDue(), 0.1);
        assertEquals(150, m5.getPaymentDue(), 0.1);
        assertEquals(0, m6.getPaymentDue(), 0.1);
*/
}
