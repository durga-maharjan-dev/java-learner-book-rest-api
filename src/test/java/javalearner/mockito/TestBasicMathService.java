package javalearner.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestBasicMathService {
	
	@Mock
	private BasicMath basicMath;
	
	@InjectMocks
	private BasicMathService basicMathService;
	
	@Before
	public void before() {
		MockitoAnnotations.initMocks(basicMath);
	}
	
	@After
	public void after() {
		System.out.println("test case done.");
	}
	
	@Test(expected = DividerCannotBeZeroException.class)
	public void testDivideWhenDividerIsZero() {
		basicMathService.relyOnDivide(1, 0);
	}
	
	@Test
	public void testDivideWhenDividerIsNonZero() {
		when(basicMath.divide(1, 1)).thenReturn(10);
		int result = basicMathService.relyOnDivide(1, 1);
		assertEquals(12, result);
		
		verify(basicMath, times(1)).divide(1,1);
		verifyNoMoreInteractions(basicMath);
	}

}
