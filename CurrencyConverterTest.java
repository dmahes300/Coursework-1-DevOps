import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CurrencyConverterTest {

    public CurrencyConverterTest() {

    }
        CurrencyConverter currencyConverter;
        @Before
        public void BeforeTest() {
            currencyConverter = new CurrencyConverter(0,0,0,0,"");
        }

        @Test
        public void testDollar() {
            assertEquals(0.74, 0.74, currencyConverter.dollarToPound(1));
            assertEquals(0.88, 0.88, currencyConverter.dollarToEuro(1));
        }

        @Test
        public void testPound() {
            assertEquals(1.36, 1.36, currencyConverter.poundToDollar(1));
            assertEquals(1.19, 1.19, currencyConverter.poundToEuro(1));
        }
        @Test
        public void testEuro() {
            assertEquals(1.13, 1.13, currencyConverter.euroToDollar(1));
            assertEquals(0.84, 0.84, currencyConverter.euroToPound(1));
        }
        @Test
        public void testInputCurrency(){
            assertFalse("Test", currencyConverter.input("fifty", "test"));
            assertEquals("Test", false, currencyConverter.input("50", "bitcoin"));
            assertEquals("Test", true, currencyConverter.input("50", "dollars"));
        }
        @Test
        public void testInputCASEs(){
            assertEquals("Test", true, currencyConverter.input("50", "DOLLARS"));
            assertEquals("Test", true, currencyConverter.input("50", "POunds"));
            assertEquals("Test", true, currencyConverter.input("50", "EUrOs"));
        }

    }



