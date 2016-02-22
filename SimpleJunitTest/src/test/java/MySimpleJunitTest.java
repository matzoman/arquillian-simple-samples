import org.junit.Assert;
import org.junit.Test;

import com.example.MySimpleClass;

public class MySimpleJunitTest {

	@Test
	public void mySimpleTest() {
		MySimpleClass example = new MySimpleClass();
		Assert.assertEquals(example.add(1,2), 3);
	}
}
