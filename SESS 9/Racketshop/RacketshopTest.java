import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class RacketshopTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class RacketshopTest
{
    /**
     * Default constructor for test class RacketshopTest
     */
    public RacketshopTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    /**
     * Method test01: test for the constructor of a RacketShop
     *
     *
    @Test
    public void test01() {
    Racketshop gt = new Racketshop("Groep T Rackets"); 
    assertEquals("Groep T Rackets", gt.getName());
    assertEquals(0, gt.getNoOfRackets());
    }
     */
    /**
     * Method test02: test for adding rackets to a shop
     *
     *
    @Test
    public void test02() {
    Racket zSlash = new Racket("Yonex Z-slash", 85, 'B');
    Racket wilsonpro = new Racket("Wilson Pro", 299, 'T');
    Racket galactica = new Racket("Dunlop Galactica Control", 365, 'P');
    Racketshop gt = new Racketshop("Groep T Rackets"); 
    gt.addRacket(zSlash);
    gt.addRacket(wilsonpro);
    gt.addRacket(galactica);
    assertEquals(3, gt.getNoOfRackets());
    }
     */   
    /**
     * Method test02bis: test for adding rackets to a shop
     *
     *
    @Test
    public void test02bis() {
    Racket zSlash = new Racket("Yonex Z-slash", 85, 'B');
    Racket squash = new Racket("Squash racket", 299, 'S');
    Racket xyz = new Racket("???", 365, 'X');
    Racketshop gt = new Racketshop("Groep T Rackets"); 
    gt.addRacket(zSlash);
    gt.addRacket(squash);
    gt.addRacket(xyz);
    assertEquals(1, gt.getNoOfRackets());
    }
     */
    /**
     * Method test03: test for counting the number of badmintonrackets of a given sport
     *
     *
    @Test
    public void test03() {
    Racket zSlash = new Racket("Yonex Z-slash", 85, 'B');
    Racket wilsonpro = new Racket("Wilson Pro", 299, 'T');
    Racket galactica = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket armortec = new Racket("armortec 900", 85, 'B');
    Racket arcsaber = new Racket("Arcsaber 7", 93, 'B');
    Racket nanoray = new Racket("Nanoray 800", 80, 'B');
    Racket vertex = new Racket("Bullpadel Vertex 3 21", 380, 'P');
    Racket wilsonsteam = new Racket("Wilson Steam 96", 289, 'T');
    Racketshop gt = new Racketshop("Groep T Rackets"); 
    gt.addRacket(zSlash);
    gt.addRacket(wilsonpro);
    gt.addRacket(galactica);
    gt.addRacket(armortec);
    gt.addRacket(arcsaber);
    gt.addRacket(nanoray);
    gt.addRacket(vertex);
    gt.addRacket(wilsonsteam);
    assertEquals(4, gt.getNoOfRacketsOfASport('B'));
    Racketshop gt2 = new Racketshop("Groep T Rackets B");
    gt2.addRacket(wilsonpro);
    gt2.addRacket(wilsonsteam);
    assertEquals(0, gt2.getNoOfRacketsOfASport('P'));
    assertEquals(2, gt2.getNoOfRacketsOfASport('T'));
    Racketshop gt3 = new Racketshop("Groep T Rackets C");
    assertEquals(0, gt3.getNoOfRacketsOfASport('X'));
    }    
     */
    /**
     * Method test04: test for counting the number of badmintonrackets
     *
     *
    @Test
    public void test04() {
    Racket zSlash = new Racket("Yonex Z-slash", 85, 'B');
    Racket wilsonpro = new Racket("Wilson Pro", 299, 'T');
    Racket galactica = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket armortec = new Racket("armortec 900", 85, 'B');
    Racket arcsaber = new Racket("Arcsaber 7", 93, 'B');
    Racket nanoray = new Racket("Nanoray 800", 80, 'B');
    Racket vertex = new Racket("Bullpadel Vertex 3 21", 380, 'P');
    Racket wilsonsteam = new Racket("Wilson Steam 96", 289, 'T');
    Racketshop gt = new Racketshop("Groep T Rackets"); 
    gt.addRacket(zSlash);
    gt.addRacket(wilsonpro);
    gt.addRacket(galactica);
    gt.addRacket(armortec);
    gt.addRacket(arcsaber);
    gt.addRacket(nanoray);
    gt.addRacket(vertex);
    gt.addRacket(wilsonsteam);
    assertEquals(4, gt.getNoOfBadmintonRackets());
    Racketshop gt2 = new Racketshop("Groep T Rackets B");
    gt2.addRacket(wilsonpro);
    gt2.addRacket(wilsonsteam);
    assertEquals(0, gt2.getNoOfBadmintonRackets());
    Racketshop gt3 = new Racketshop("Groep T Rackets C");
    assertEquals(0, gt3.getNoOfBadmintonRackets());
    }
     */
    /**
     * Method test05: test for smallest weight
     *
    @Test
    public void test05()
    {
    Racket zSlash = new Racket("Yonex Z-slash", 85, 'B');
    Racket wilsonpro = new Racket("Wilson Pro", 299, 'T');
    Racket galactica = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket armortec = new Racket("armortec 900", 85, 'B');
    Racket arcsaber = new Racket("Arcsaber 7", 93, 'B');
    Racket nanoray = new Racket("Nanoray 800", 80, 'B');
    Racket vertex = new Racket("Bullpadel Vertex 3 21", 380, 'P');
    Racket wilsonsteam = new Racket("Wilson Steam 96", 289, 'T');
    Racketshop gt = new Racketshop("Groep T Rackets"); 
    gt.addRacket(zSlash);
    gt.addRacket(wilsonpro);
    gt.addRacket(galactica);
    gt.addRacket(armortec);
    gt.addRacket(arcsaber);
    gt.addRacket(nanoray);
    gt.addRacket(vertex);
    gt.addRacket(wilsonsteam);
    assertEquals(80, gt.getSmallestWeight());
    }
     */
    /**
     * Method test06: test for first occurence of a racket
     *
    @Test
    public void test06()
    {
    Racket zSlash = new Racket("Yonex Z-slash", 85, 'B');
    Racket wilsonpro = new Racket("Wilson Pro", 299, 'T');
    Racket galactica = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket galactica2 = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket armortec = new Racket("armortec 900", 85, 'B');
    Racket arcsaber = new Racket("Arcsaber 7", 93, 'B');
    Racket nanoray = new Racket("Nanoray 800", 80, 'B');
    Racket vertex = new Racket("Bullpadel Vertex 3 21", 380, 'P');
    Racket wilsonsteam = new Racket("Wilson Steam 96", 289, 'T');
    Racketshop gt = new Racketshop("Groep T Rackets"); 
    gt.addRacket(zSlash);
    gt.addRacket(wilsonpro);
    gt.addRacket(galactica);
    gt.addRacket(galactica2);
    gt.addRacket(armortec);
    gt.addRacket(arcsaber);
    gt.addRacket(nanoray);
    gt.addRacket(vertex);
    gt.addRacket(wilsonsteam);
    assertEquals(galactica, gt.searchFirstOnType("Dunlop Galactica Control"));
    assertNull(gt.searchFirstOnType("XYZ"));
    }
     */
    /**
     * Method test07: test for find all rackets of a type
     *
    @Test
    public void test07()
    {
    Racket zSlash = new Racket("Yonex Z-slash", 85, 'B');
    Racket wilsonpro = new Racket("Wilson Pro", 299, 'T');
    Racket galactica = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket galactica2 = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket armortec = new Racket("armortec 900", 85, 'B');
    Racket arcsaber = new Racket("Arcsaber 7", 93, 'B');
    Racket nanoray = new Racket("Nanoray 800", 80, 'B');
    Racket vertex = new Racket("Bullpadel Vertex 3 21", 380, 'P');
    Racket wilsonsteam = new Racket("Wilson Steam 96", 289, 'T');
    Racketshop gt = new Racketshop("Groep T Rackets"); 
    gt.addRacket(zSlash);
    gt.addRacket(wilsonpro);
    gt.addRacket(galactica);
    gt.addRacket(galactica2);
    gt.addRacket(armortec);
    gt.addRacket(arcsaber);
    gt.addRacket(nanoray);
    gt.addRacket(vertex);
    gt.addRacket(wilsonsteam);
    assertEquals(2, gt.findAllOnType("Dunlop Galactica Control").size());
    assertEquals(0, gt.findAllOnType("XYZ").size());
    }
     */
    /**
     * Method test08: test for number rackets lighter than given weight for a particular sport
     *
    @Test
    public void test08()
    {
    Racket zSlash = new Racket("Yonex Z-slash", 85, 'B');
    Racket wilsonpro = new Racket("Wilson Pro", 299, 'T');
    Racket galactica = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket galactica2 = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket armortec = new Racket("armortec 900", 85, 'B');
    Racket arcsaber = new Racket("Arcsaber 7", 93, 'B');
    Racket nanoray = new Racket("Nanoray 800", 80, 'B');
    Racket vertex = new Racket("Bullpadel Vertex 3 21", 380, 'P');
    Racket wilsonsteam = new Racket("Wilson Steam 96", 289, 'T');
    Racketshop gt = new Racketshop("Groep T Rackets"); 
    gt.addRacket(zSlash);
    gt.addRacket(wilsonpro);
    gt.addRacket(galactica);
    gt.addRacket(galactica2);
    gt.addRacket(armortec);
    gt.addRacket(arcsaber);
    gt.addRacket(nanoray);
    gt.addRacket(vertex);
    gt.addRacket(wilsonsteam);
    assertEquals(2, gt.getNoOfRacketsLighterThanForASport(300, 'T'));
    assertEquals(1, gt.getNoOfRacketsLighterThanForASport(85, 'B'));
    assertEquals(0, gt.getNoOfRacketsLighterThanForASport(300, 'P'));
    }
     */
    /**
     * Method test09: test for removing one racket
     *
    @Test
    public void test09()
    {
    Racket zSlash = new Racket("Yonex Z-slash", 85, 'B');
    Racket wilsonpro = new Racket("Wilson Pro", 299, 'T');
    Racket galactica = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket galactica2 = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket armortec = new Racket("armortec 900", 85, 'B');
    Racket arcsaber = new Racket("Arcsaber 7", 93, 'B');
    Racket nanoray = new Racket("Nanoray 800", 80, 'B');
    Racket vertex = new Racket("Bullpadel Vertex 3 21", 380, 'P');
    Racket wilsonsteam = new Racket("Wilson Steam 96", 289, 'T');
    Racketshop gt = new Racketshop("Groep T Rackets"); 
    gt.addRacket(zSlash);
    gt.addRacket(wilsonpro);
    gt.addRacket(galactica);
    gt.addRacket(galactica2);
    gt.addRacket(armortec);
    gt.addRacket(arcsaber);
    gt.addRacket(nanoray);
    gt.addRacket(vertex);
    gt.addRacket(wilsonsteam);
    assertTrue(gt.removeOneRacket("Dunlop Galactica Control"));
    assertFalse(gt.removeOneRacket("XYZ"));
    assertEquals(8, gt.getNoOfRackets());
    assertTrue(gt.removeOneRacket("Dunlop Galactica Control"));
    assertEquals(7, gt.getNoOfRackets());
    assertFalse(gt.removeOneRacket("Dunlop Galactica Control"));
    assertEquals(7, gt.getNoOfRackets());
    }
     */
    /**
     * Method test10: test for removing all rackets of a type
     *
    @Test
    public void test10()
    {
    Racket zSlash = new Racket("Yonex Z-slash", 85, 'B');
    Racket wilsonpro = new Racket("Wilson Pro", 299, 'T');
    Racket galactica = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket galactica2 = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket armortec = new Racket("armortec 900", 85, 'B');
    Racket arcsaber = new Racket("Arcsaber 7", 93, 'B');
    Racket nanoray = new Racket("Nanoray 800", 80, 'B');
    Racket vertex = new Racket("Bullpadel Vertex 3 21", 380, 'P');
    Racket wilsonsteam = new Racket("Wilson Steam 96", 289, 'T');
    Racketshop gt = new Racketshop("Groep T Rackets"); 
    gt.addRacket(zSlash);
    gt.addRacket(wilsonpro);
    gt.addRacket(galactica);
    gt.addRacket(galactica2);
    gt.addRacket(armortec);
    gt.addRacket(arcsaber);
    gt.addRacket(nanoray);
    gt.addRacket(vertex);
    gt.addRacket(wilsonsteam);
    assertEquals(2, gt.removeAllRackets("Dunlop Galactica Control").size());
    assertEquals(7, gt.getNoOfRackets());
    assertEquals(0, gt.removeAllRackets("Dunlop Galactica Control").size());
    assertEquals(7, gt.getNoOfRackets());
    }
     */
    /**
     * Method test11: test for getting a sorted list of unique types
     *
    @Test
    public void test11()
    {
    Racket zSlash = new Racket("Yonex Z-slash", 85, 'B');
    Racket wilsonpro = new Racket("Wilson Pro", 299, 'T');
    Racket galactica = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket galactica2 = new Racket("Dunlop Galactica Control", 365, 'P');
    Racket armortec = new Racket("Armortec 900", 85, 'B');
    Racket arcsaber = new Racket("Arcsaber 7", 93, 'B');
    Racket nanoray = new Racket("Nanoray 800", 80, 'B');
    Racket vertex = new Racket("Bullpadel Vertex 3 21", 380, 'P');
    Racket wilsonsteam = new Racket("Wilson Steam 96", 289, 'T');
    Racketshop gt = new Racketshop("Groep T Rackets"); 
    gt.addRacket(zSlash);
    gt.addRacket(wilsonpro);
    gt.addRacket(galactica);
    gt.addRacket(galactica2);
    gt.addRacket(armortec);
    gt.addRacket(arcsaber);
    gt.addRacket(nanoray);
    gt.addRacket(vertex);
    gt.addRacket(wilsonsteam);
    ArrayList<String> types = gt.getSortedListOfUniqueTypes();
    assertEquals(8, types.size());
    assertEquals("Bullpadel Vertex 3 21", types.get(2));
    assertEquals("Nanoray 800", types.get(4));
    }
     */
    /**
     * Method 12: test for adding cities
     *
    @Test
    public void test12()
    {
    Racketshop gt = new Racketshop("Groep T Rackets");
    assertTrue(gt.addCity("Leuven"));
    assertTrue(gt.addCity("New York"));
    assertFalse(gt.addCity("Leuven"));
    assertTrue(gt.addCity("Berlin"));
    assertFalse(gt.addCity("New York"));
    assertTrue(gt.addCity("Shangai"));
    assertFalse(gt.addCity("Sint-Katelijne-Waver"));

    }
     */   
    /**
     * Method 13: test for list of cities
     *
    @Test
    public void test13()
    {
    Racketshop gt = new Racketshop("Groep T Rackets");
    assertEquals(0, gt.getListOfCities().size());
    gt.addCity("Leuven");
    gt.addCity("New York");
    assertEquals(2, gt.getListOfCities().size());
    gt.addCity("Leuven");
    gt.addCity("Berlin");
    assertEquals(3, gt.getListOfCities().size());
    gt.addCity("New York");
    gt.addCity("Shangai");
    assertEquals(4, gt.getListOfCities().size());
    gt.addCity("Sint-Katelijne-Waver");
    assertEquals(4, gt.getListOfCities().size());
    assertEquals("Shangai", gt.getListOfCities().get(3));
    }
     */
}
