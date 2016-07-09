import static org.junit.Assert.assertEquals;

import java.util.LinkedHashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ReceiptPrinterTest {
	
	private ReceiptPrinter receiptPrinter;
	
	@Before
	public void setUp(){
		receiptPrinter = new ReceiptPrinter();
	}
	
	private Product createProduct(String name, double price, String unit) {
		return new Product(name,price,unit);
	}

	@Test
	public void getReceiptHead()
	{
		assertEquals("ûǮ׬�̵��嵥",receiptPrinter.getReceiptHead());
	}

	@Test
	public void printOneItemInReceiptItemsSection()
	{
		Assert.assertEquals("���ƣ��ɿڿ��֣�������3ƿ�����ۣ�3.00��Ԫ����С�ƣ�9.00��Ԫ��",receiptPrinter.printOneItemInItemsSection(createProduct("�ɿڿ���", 3.00, "ƿ"),3));
		Assert.assertEquals("���ƣ��ɿڿ��֣�������2ƿ�����ۣ�3.00��Ԫ����С�ƣ�6.00��Ԫ��",receiptPrinter.printOneItemInItemsSection(createProduct("�ɿڿ���", 3.00, "ƿ"),2));
		Assert.assertEquals("���ƣ�ƹ����������1�������ۣ�1.00��Ԫ����С�ƣ�1.00��Ԫ��",
                receiptPrinter.printOneItemInItemsSection(createProduct("ƹ����",1.00,"��"),1));
	}
	@Test
	public void printMutipleItemInReceiptItemsSection()
	{
		LinkedHashMap<Product,Integer> productsWithNumbers = new LinkedHashMap<Product,Integer>();
		productsWithNumbers.put(createProduct("�ɿڿ���", 3.00, "ƿ"),3);
		productsWithNumbers.put(createProduct("ƹ����", 1.00, "��"),1);
		Assert.assertEquals("���ƣ��ɿڿ��֣�������3ƿ�����ۣ�3.00��Ԫ����С�ƣ�9.00��Ԫ��\n���ƣ�ƹ����������1�������ۣ�1.00��Ԫ����С�ƣ�1.00��Ԫ��\n",
							receiptPrinter.printMultipleItemsInItemSection(productsWithNumbers));
	}

	@Test
	public void getReceiptSum()
	{
		assertEquals("�ܼƣ�25.00��Ԫ��",receiptPrinter.getReceiptSum(25.00));
	}
}