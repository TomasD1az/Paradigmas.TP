package stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class OOStackTest {

  public static String TESTSTRING1 = "String1";
  public static String TESTSTRING2 = "String2";

@Test public void test01StackShouldBeEmptyWhenCreated() {
    assertTrue( new OOStack().isEmpty() );
  }

  @Test public void test02PushAddElementsToTheStack() {
    assertFalse( stackWithString().isEmpty() );
  }

  @Test public void test03PopRemovesElementsFromTheStack() {
    assertTrue( stackWithPoppedString().isEmpty() );
  }

  @Test public void test04PopReturnsLastPushedObject() {
    assertEquals( stackWithString().pop(), TESTSTRING1 );
  }

  @Test public void test05StackBehavesLIFO() {
    OOStack stack = stackWithString().push( TESTSTRING2 );

    assertEquals( stack.pop(), TESTSTRING2 );
    assertEquals( stack.pop(), TESTSTRING1 );
    assertTrue( stack.isEmpty() );
  }

  @Test public void test06TopReturnsLastPushedObject() {
    assertEquals( new OOStack().push( TESTSTRING1 ).top(), 
    		TESTSTRING1 );
  }

  @Test public void test07TopDoesNotRemoveObjectFromStack() {
    OOStack stack = stackWithString();
    assertEquals( stack.size(), 1 );
    stack.top();
    assertEquals( stack.size(), 1 );
  }

  @Test public void test08CanNotPopWhenThereAreNoObjectsInTheStack() {
	throwsLike(OOStack.stackEmptyErrorDescription, () -> new OOStack().pop() );
  }

  @Test public void test09CanNotPopWhenThereAreNoObjectsInTheStackAndTheStackHadObjects() {
    throwsLike( OOStack.stackEmptyErrorDescription, () -> stackWithPoppedString().pop() );
  }

  @Test public void test10CanNotTopWhenThereAreNoObjectsInTheStack() {
    throwsLike(OOStack.stackEmptyErrorDescription, () -> new OOStack().top() );
  }
  
  public void throwsLike(String msg, Executable executable) {
		assertEquals( msg, assertThrows( Error.class, executable ).getMessage() );
	}
  
  private OOStack stackWithString() {
		OOStack stack = new OOStack();
	    stack.push( TESTSTRING1 );
		return stack;
	}
  
  private OOStack stackWithPoppedString() {
		OOStack stack = stackWithString();
	    stack.pop();
		return stack;
	}
}