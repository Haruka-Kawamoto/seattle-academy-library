package jp.co.seattle.library.commonutil;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.*;

import java.util.List;

import org.junit.Test;

import jp.co.seattle.library.dto.BookDetailsInfo;

public class BookUtilTest {
	private static final String REQUIRED_ERROR = "未入力の必須項目があります";
	private static final String ISBN_ERROR = "ISBNの桁数または半角数字が正しくありません";
	private static final String PUBLISHDATE_ERROR = "出版日は半角数字のYYYYMMDD形式で入力してください";

	private BookUtil bookUtil = new BookUtil();

	@Test
	public void test() {

		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("1234567890");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList.isEmpty(), is(true));

	}

	@Test
	public void test1() {

		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("123456789");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(ISBN_ERROR));

	}

	@Test
	public void test2() {

		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("111");
		bookInfo.setIsbn("1234567890");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(PUBLISHDATE_ERROR));

	}

	@Test
	public void test3() {

		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("");
		bookInfo.setDescription("");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList.isEmpty(), is(true));

	}

	@Test
	public void test4() {

		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("");
		bookInfo.setDescription("");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(REQUIRED_ERROR));

	}

	@Test
	public void test5() {

		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("");
		bookInfo.setDescription("");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(REQUIRED_ERROR));

	}

	@Test
	public void test6() {

		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("");
		bookInfo.setPublishDate("11111111");
		bookInfo.setIsbn("");
		bookInfo.setDescription("");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(REQUIRED_ERROR));

	}

	@Test
	public void test7() {

		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("20220229");
		bookInfo.setIsbn("");
		bookInfo.setDescription("");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(PUBLISHDATE_ERROR));

	}

	@Test
	public void test8() {

		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("");
		bookInfo.setIsbn("");
		bookInfo.setDescription("");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(REQUIRED_ERROR, PUBLISHDATE_ERROR));

	}

	@Test
	public void test9() {

		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("2021124");
		bookInfo.setIsbn("");
		bookInfo.setDescription("");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(PUBLISHDATE_ERROR));

	}

	@Test
	public void test10() {

		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("20211204");
		bookInfo.setIsbn("1234567890123");
		bookInfo.setDescription("description");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList.isEmpty(), is(true));

	}

	@Test
	public void test11() {

		BookDetailsInfo bookInfo = new BookDetailsInfo();
		bookInfo.setTitle("title");
		bookInfo.setAuthor("author");
		bookInfo.setPublisher("publisher");
		bookInfo.setPublishDate("20211204");
		bookInfo.setIsbn("123456789a");
		bookInfo.setDescription("");

		List<String> errorList = bookUtil.checkBookInfo(bookInfo);
		assertThat(errorList, hasItems(ISBN_ERROR));

	}

}
