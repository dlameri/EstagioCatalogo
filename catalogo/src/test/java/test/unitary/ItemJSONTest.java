package test.unitary;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ideaiselectronics.catalogo.spring.domain.catalog.Installment;
import com.ideaiselectronics.catalogo.spring.domain.json.ItemJSON;

public class ItemJSONTest {
	ItemJSON itemJSON = new ItemJSON();
	List<Installment> expectedInstallments;

	final BigDecimal priceFrom = new BigDecimal(1000.00);
	final BigDecimal priceFor = new BigDecimal(100.00);

	@Test
	public void testDiscountCalculator() {
		int expectedReturn = 90;
		int actualReturn = itemJSON.calculateDiscount(priceFrom, priceFor);

		assertEquals(expectedReturn, actualReturn);

	}

	@Test
	public void seeIfInstallmentsListAreCorrectWhitInstallmentsBelow12() {
		List<Installment> expectedInstallments = installmentsExampleBelow12();
		List<Installment> actualInstallments = itemJSON
				.calculateInstallments(priceFor);

		assertEquals(expectedInstallments, actualInstallments);

	}

	@Test
	public void seeIfInstallmentsListAreCorrectWhitInstallmentsEquals12() {
		List<Installment> expectedInstallments = installmentsExampleEquals12();
		List<Installment> actualInstallments = itemJSON
				.calculateInstallments(new BigDecimal(120.00));

		assertEquals(expectedInstallments, actualInstallments);

	}

	@Test
	public void testingLastInstallment() {
		itemJSON.setPriceFor(priceFor);
		Installment actualLastInstallment = itemJSON
				.findLastInstallment(expectedInstallments = installmentsExampleBelow12());
		Installment expectedLastInstallment = new Installment(10, "10,00");

		assertEquals(expectedLastInstallment, actualLastInstallment);
	}
	
	@Test
	public void testingPriceForGreaterThanPriceWithLowerValue(){
		itemJSON.setPriceFor(priceFor);
		boolean actual = itemJSON.isPriceForGreaterThan(new BigDecimal(91.00));
		assertEquals(true, actual);
	}
	
	@Test
	public void testingPriceForGreaterThanPriceWithGreaterValue(){
		itemJSON.setPriceFor(priceFor);
		boolean actual = itemJSON.isPriceForGreaterThan(new BigDecimal(111.00));
		assertEquals(false, actual);
	}

	private List<Installment> installmentsExampleBelow12() {
		List<Installment> expectedInstallments = new ArrayList<Installment>();
		expectedInstallments.add(new Installment(1, "100,00"));
		expectedInstallments.add(new Installment(2, "50,00"));
		expectedInstallments.add(new Installment(3, "33,33"));
		expectedInstallments.add(new Installment(4, "25,00"));
		expectedInstallments.add(new Installment(5, "20,00"));
		expectedInstallments.add(new Installment(6, "16,67"));
		expectedInstallments.add(new Installment(7, "14,29"));
		expectedInstallments.add(new Installment(8, "12,50"));
		expectedInstallments.add(new Installment(9, "11,11"));
		expectedInstallments.add(new Installment(10, "10,00"));
		return expectedInstallments;
	}

	private List<Installment> installmentsExampleEquals12() {
		List<Installment> expectedInstallments = new ArrayList<Installment>();
		expectedInstallments.add(new Installment(1, "120,00"));
		expectedInstallments.add(new Installment(2, "60,00"));
		expectedInstallments.add(new Installment(3, "40,00"));
		expectedInstallments.add(new Installment(4, "30,00"));
		expectedInstallments.add(new Installment(5, "24,00"));
		expectedInstallments.add(new Installment(6, "20,00"));
		expectedInstallments.add(new Installment(7, "17,14"));
		expectedInstallments.add(new Installment(8, "15,00"));
		expectedInstallments.add(new Installment(9, "13,33"));
		expectedInstallments.add(new Installment(10, "12,00"));
		expectedInstallments.add(new Installment(11, "10,91"));
		expectedInstallments.add(new Installment(12, "10,00"));
		return expectedInstallments;
	}

}
