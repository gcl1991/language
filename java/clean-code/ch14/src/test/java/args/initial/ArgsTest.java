package args.initial;

import args.finish.ArgsException;
import args.initial.ArgsBooleanStringInteger;
import junit.framework.TestCase;


public class ArgsTest extends TestCase {
    public void testCreateWithNoSchemaOrArguments() throws Exception {
        ArgsBooleanStringInteger args = new ArgsBooleanStringInteger("", new String[0]);
        assertEquals(0, args.cardinality());
    }

    public void testWithNoSchemaButWithOneArgument() throws Exception {
        try {
            new ArgsBooleanStringInteger("", new String[]{"- x"});
            fail();
        } catch (ArgsException e) {
            assertEquals(ArgsException.ErrorCode.UNEXPECTED_ARGUMENT, e.getErrorCode());
            assertEquals('x', e.getErrorArgumentId());
        }
    }

    public void testWithNoSchemaButWithMultipleArguments() throws Exception {
        try {

            new ArgsBooleanStringInteger("", new String[]{"- x", "- y"});
            fail();
        } catch (ArgsException e) {
            assertEquals(ArgsException.ErrorCode.UNEXPECTED_ARGUMENT, e.getErrorCode());
            assertEquals('x', e.getErrorArgumentId());
        }
    }

    public void testNonLetterSchema() throws Exception {
        try {
            new ArgsBooleanStringInteger("*", new String[]{});
            fail(" Args   constructor   should   have   thrown   exception");
        } catch (ArgsException e) {
            assertEquals(ArgsException.ErrorCode.INVALID_ARGUMENT_NAME, e.getErrorCode());
            assertEquals('*', e.getErrorArgumentId());
        }
    }

    public void testInvalidArgumentFormat() throws Exception {
        try {
            new ArgsBooleanStringInteger(" f~", new String[]{});
            fail(" Args   constructor   should   have   throws   exception");
        } catch (ArgsException e) {
            assertEquals(ArgsException.ErrorCode.INVALID_FORMAT, e.getErrorCode());
            assertEquals('f', e.getErrorArgumentId());
        }
    }

    public void testSimpleBooleanPresent() throws Exception {
        ArgsBooleanStringInteger args = new ArgsBooleanStringInteger(" x", new String[]{"- x"});
        assertEquals(1, args.cardinality());
        assertEquals(true, args.getBoolean('x'));
    }

    public void testSimpleStringPresent() throws Exception {
        ArgsBooleanStringInteger args = new ArgsBooleanStringInteger(" x*", new String[]{"- x", " param"});
        assertEquals(1, args.cardinality());
        assertTrue(args.has('x'));

        assertEquals(" param", args.getString('x'));
    }

    public void testMissingStringArgument() throws Exception {
        try {
            new ArgsBooleanStringInteger(" x*", new String[]{"- x"});
            fail();
        } catch (ArgsException e) {
            assertEquals(ArgsException.ErrorCode.MISSING_STRING, e.getErrorCode());
            assertEquals('x', e.getErrorArgumentId());
        }
    }

    public void testSpacesInFormat() throws Exception {
        ArgsBooleanStringInteger args = new ArgsBooleanStringInteger(" x,   y", new String[]{"- xy"});
        assertEquals(2, args.cardinality());
        assertTrue(args.has('x'));
        assertTrue(args.has('y'));
    }

    public void testSimpleIntPresent() throws Exception {
        ArgsBooleanStringInteger args = new ArgsBooleanStringInteger(" x#", new String[]{"- x", " 42"});
        assertEquals(1, args.cardinality());
        assertTrue(args.has('x'));
        assertEquals(42, args.getInt('x'));
    }

    public void testInvalidInteger() throws Exception {
        try {
            new ArgsBooleanStringInteger(" x#", new String[]{"- x", " Forty   two"});
            fail();
        } catch (ArgsException e) {
            assertEquals(ArgsException.ErrorCode.INVALID_INTEGER, e.getErrorCode());
            assertEquals('x', e.getErrorArgumentId());
            assertEquals(" Forty   two", e.getErrorParameter());
        }
    }

    public void testMissingInteger() throws Exception {
        try {
            new ArgsBooleanStringInteger(" x#", new String[]{"- x"});

            fail();
        } catch (ArgsException e) {
            assertEquals(ArgsException.ErrorCode.MISSING_INTEGER, e.getErrorCode());
            assertEquals('x', e.getErrorArgumentId());
        }
    }

    public void testSimpleDoublePresent() throws Exception {
        ArgsBooleanStringInteger args = new ArgsBooleanStringInteger(" x##", new String[]{"- x", " 42. 3"});
        assertEquals(1, args.cardinality());
        assertTrue(args.has('x'));
        assertEquals(42.3, args.getDouble('x'), .001);
    }

    public void testInvalidDouble() throws Exception {
        try {
            new ArgsBooleanStringInteger(" x##", new String[]{"- x", " Forty   two"});
            fail();
        } catch (ArgsException e) {
            assertEquals(ArgsException.ErrorCode.INVALID_DOUBLE, e.getErrorCode());
            assertEquals('x', e.getErrorArgumentId());
            assertEquals(" Forty   two", e.getErrorParameter());
        }
    }

    public void testMissingDouble() throws Exception {
        try {
            new ArgsBooleanStringInteger(" x##", new String[]{"- x"});
            fail();
        } catch (ArgsException e) {
            assertEquals(ArgsException.ErrorCode.MISSING_DOUBLE, e.getErrorCode());
            assertEquals('x', e.getErrorArgumentId());
        }
    }
}

