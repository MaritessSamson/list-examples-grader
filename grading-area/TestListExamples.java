import static org.junit.Assert.*;
import org.junit.*;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

  @Test(timeout = 500)
  public void testMergeLeftEnd(){
    List<String> left = Arrays.asList("b", "c", "d");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c", "d", "d");
    assertEquals(expected, merged);
  }

  @Test (timeout = 500)
  public void testMergeMiddle(){
    List<String> left = Arrays.asList("a", "c", "e");
    List<String> right = Arrays.asList("b", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "b", "c", "d", "e");
    assertEquals(expected, merged);
  }

  @Test(timeout=500)
  public void testMergeEmpty(){
    List<String> emptyListOne = Arrays.asList();
    List<String> emptyListTwo = Arrays.asList();
    List<String> expected = Arrays.asList();
    List<String> merged = ListExamples.merge(emptyListOne, emptyListTwo);
    assertEquals(merged, expected);
  }

  @Test(timeout = 500)
  public void testMergeRepeated(){
    List<String> leftOne = Arrays.asList("a", "b", "c");
    List<String> rightOne = Arrays.asList("a", "d");
    List<String> leftTwo = ListExamples.merge(leftOne, rightOne);
    List<String> rightTwo = Arrays.asList("a", "b", "c");
    List<String> merged = ListExamples.merge(leftTwo, rightTwo);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }

}
