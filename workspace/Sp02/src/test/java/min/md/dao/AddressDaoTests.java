package min.md.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import min.md.domain.Address;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class AddressDaoTests {

	@Autowired
	private AddressDao addressdao;

	@Test
	public void testList() {

		log.info("#AddressMapperTests addressdao : " + addressdao);
		log.info("#AddressMapperTests testList() : " + addressdao.list());

	}

	/*
	 * @Test public void testInsert() { Address address = new Address(-1, "오늘은",
	 * "목요일", null); addressdao.insert(address);
	 * log.info("#AddressMapperTests insert() :"); }
	 */
	
	/*
	 * @Test public void testDelete() { long seq = 18L; addressdao.delete(seq);
	 * log.info("#AddressMapperTests delete() 수행완료"); }
	 */

}
