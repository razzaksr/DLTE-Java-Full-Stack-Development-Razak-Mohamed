package crud.hibernate.jpa.dltehibernatejpa;

import crud.hibernate.jpa.dltehibernatejpa.model.KnowYourCustomer;
import crud.hibernate.jpa.dltehibernatejpa.remote.KycRepository;
import crud.hibernate.jpa.dltehibernatejpa.services.KycService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class DlteHibernateJpaApplicationTests {

	@MockBean
	KycRepository kycRepository;

	@Autowired
	KycService kycService;

	@Test
	public void testRetrieve(){
		List<KnowYourCustomer> testData= Stream.of(
				new KnowYourCustomer(876567834,"Razak Mohamed","razzaksr@gmail.com","ABCDE8765D",87654567845L,876545678767876L,"Salem",1200.4,"razak",new Date("12/30/2020")),
				new KnowYourCustomer(121352121,"Richard","richard@gmail.com","IUYUR3454I",98767676343L,1111112132323L,"Hampi",98.4,"richard",new Date("5/3/2023"))
		).collect(Collectors.toList());

		when(kycRepository.findAll()).thenReturn(testData);

		assertEquals(876545678767876L,kycService.implementOfFindAll().get(0).getAadhaar());

	}

}
