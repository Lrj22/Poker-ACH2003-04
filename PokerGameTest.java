import org.junit.Rule;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class PokerGameTest {

    Table table;

    String test1;
    String test2;

    String test1Result;
    String test2Result;

    @Before
    public void setup() {

        table = new Table();

        test1 = "14o 13o 12o 11o 10o";
        test2 = "14o 13c 12o 11o 9o";

        test1Result = "14o 13o 12o 11o 10o RoyalFlush";
        test2Result = "14o 13c 12o 11o 9o ";
    }

    @Rule
    public Timeout timeout = new Timeout(5, TimeUnit.SECONDS);

    @Test
    public void test1() {

        assertEquals(test1Result, table.individualTest(test1));
    }

    @Test
    public void test2() {

        assertEquals(test2Result, table.individualTest(test2));
    }
}