package th.co.ais.enterprisecloud.jaxbsample;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import th.co.ais.enterprisecloud.dto.OrganizationType;
import th.co.ais.enterprisecloud.dto.UserType;
import th.co.ais.enterprisecloud.dto.VmType;


public class App {
	
	public static void main(String[] args) throws JAXBException {
		
		OrganizationType org = new OrganizationType();
		UserType user = new UserType();
		VmType vm = new VmType();
		

		
		/* Set user information */
		user.setFullName("John Doe");
		user.setEmail("john.doe@company.com");
		user.setPhone("0900000001");
		
		/* Set VM information */
		vm.setNoOfCpus(2);
		vm.setCoresPerSocket(2);
		vm.setMemorySize(4);
		vm.setOsImageName("CENTOS7");
		vm.setNonMobileNumber("9000000002");
		vm.setStorageSize(200);
		
		org.setCaNumber("CA0000000123");
		org.setName("Company dot com Limited");
		org.setOrderType("TRIAL");
		org.setShortName("COM");
		
		org.getUser().add(user);
		org.getVm().add(vm);
		

		JAXBContext jaxbContext = JAXBContext.newInstance(OrganizationType.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
	    
		// output pretty printed
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.setProperty(Marshaller.JAXB_SCHEMA_LOCATION, "http://enterprisecloud.ais.co.th/bot/bot.xsd");
		
		//jaxbMarshaller.marshal(new JAXBElement<OrganizationType>(new QName("uri","local"), OrganizationType.class, org), file);
		//jaxbMarshaller.marshal(new JAXBElement<OrganizationType>(new QName("organization"), OrganizationType.class, org), System.out);
			
		File file = new File("org.xml");
		
		jaxbMarshaller.marshal(org, file);
		jaxbMarshaller.marshal(org, System.out);
		
	}
}
