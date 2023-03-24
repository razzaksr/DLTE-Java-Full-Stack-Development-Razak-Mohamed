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
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@Timeout(1L)
@SpringBootTest
class DlteHibernateJpaApplicationTests {

	@MockBean
	KycRepository kycRepository;

	@Autowired
	KycService kycService;

	@Test
	public void testException(){
		assertThrows(NumberFormatException.class,()->{
			long data=Long.parseLong("87654567876");
			kycService.implementOfFindById(data);
		});
	}

	@Test
	public void testDeleteByLocation(){
		List<String> customers1=Stream.of("Razak","Sridhar","Manvith").collect(Collectors.toList());
		List<String> customers2=Stream.of("Saikethan","Aishwarya","Apoorva").collect(Collectors.toList());

		when(kycRepository.findAllByLocation("Bellari")).thenReturn(customers1);

		assertLinesMatch(customers1,kycService.implementDeletionMultiple("Bellari"));
		assertSame(customers1.get(2),kycService.implementDeletionMultiple("Bellari").get(0));
	}

	@Test
	public void testMinimumBalance(){
		KnowYourCustomer knowYourCustomer1=new KnowYourCustomer(876567834,"Razak Mohamed","razzaksr@gmail.com","ABCDE8765D",87654567845L,876545678767876L,"Salem",1200.4,"razak",new Date("12/30/2020"));
		KnowYourCustomer knowYourCustomer2=new KnowYourCustomer(121352121,"Richard","richard@gmail.com","IUYUR3454I",98767676343L,1111112132323L,"Hampi",98.4,"richard",new Date("5/3/2023"));
		KnowYourCustomer knowYourCustomer3=new KnowYourCustomer(12343234,"Arun","arunvr@gmail.com","TYUDC1232E",567894545L,7654567656545L,"Hubli",477.6,"arun",new Date("3/28/2023"));
		KnowYourCustomer knowYourCustomer4=new KnowYourCustomer(87656735,"Karthik","karthik@gmail.com","VHDCB1325V",123454345L,8787678787L,"Ballari",1298.4,"karthik",new Date("11/29/2021"));

		when(kycRepository.findAllByMinimumBalance(1000)).thenReturn(Stream.of(knowYourCustomer1,knowYourCustomer4).collect(Collectors.toList()));

		assertSame(knowYourCustomer4,kycService.implementMinimumBalance(1000).get(1));

	}

	@Test
	public void testPan() {
		Optional<KnowYourCustomer> knowYourCustomer1= Optional.of(new KnowYourCustomer(876567834, "Razak Mohamed", "razzaksr@gmail.com", "ABCDE8765D", 87654567845L, 876545678767876L, "Salem", 1200.4, "razak", new Date("12/30/2020")));
		Optional<KnowYourCustomer> knowYourCustomer2= Optional.of(new KnowYourCustomer(121352121, "Richard", "richard@gmail.com", "IUYUR3454I", 98767676343L, 1111112132323L, "Hampi", 98.4, "richard", new Date("5/3/2023")));
		Optional<KnowYourCustomer> knowYourCustomer3= Optional.of(new KnowYourCustomer(12343234, "Arun", "arunvr@gmail.com", "TYUDC1232E", 567894545L, 7654567656545L, "Hubli", 45677.6, "arun", new Date("3/28/2023")));
		Optional<KnowYourCustomer> knowYourCustomer4= Optional.of(new KnowYourCustomer(87656735, "Karthik", "karthik@gmail.com", "VHDCB1325V", 123454345L, 8787678787L, "Ballari", 1298.4, "karthik", new Date("11/29/2021")));

		//Thread.sleep(10000);

		when(kycRepository.findByPan("IUYUR3454I")).thenReturn(knowYourCustomer2);

		assertNotEquals(knowYourCustomer2,kycService.implementOfPan("ABCDE8765D"));

	}

	@Test
	public void testSave(){
		KnowYourCustomer knowYourCustomer1=new KnowYourCustomer(876567834,"Razak Mohamed","razzaksr@gmail.com","ABCDE8765D",87654567845L,876545678767876L,"Salem",1200.4,"razak",new Date("12/30/2020"));
		KnowYourCustomer knowYourCustomer2=new KnowYourCustomer(121352121,"Richard","richard@gmail.com","IUYUR3454I",98767676343L,1111112132323L,"Hampi",98.4,"richard",new Date("5/3/2023"));
		KnowYourCustomer knowYourCustomer3=new KnowYourCustomer(12343234,"Arun","arunvr@gmail.com","TYUDC1232E",567894545L,7654567656545L,"Hubli",45677.6,"arun",new Date("3/28/2023"));
		KnowYourCustomer knowYourCustomer4=new KnowYourCustomer(87656735,"Karthik","karthik@gmail.com","VHDCB1325V",123454345L,8787678787L,"Ballari",1298.4,"karthik",new Date("11/29/2021"));

		when(kycRepository.save(knowYourCustomer3)).thenReturn(knowYourCustomer3);

		assertNotSame(knowYourCustomer3,kycService.implementationOfSave(knowYourCustomer3));
	}

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
