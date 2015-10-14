package uk.gov.hscic.fgm.generate;

import java.util.ArrayList;
import java.util.List;

import ca.uhn.fhir.model.api.ResourceMetadataKeyEnum;
import ca.uhn.fhir.model.base.resource.ResourceMetadataMap;
import ca.uhn.fhir.model.dstu2.composite.CodingDt;
import ca.uhn.fhir.model.dstu2.composite.ContactPointDt;
import ca.uhn.fhir.model.dstu2.composite.HumanNameDt;
import ca.uhn.fhir.model.dstu2.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu2.composite.ResourceReferenceDt;
import ca.uhn.fhir.model.dstu2.resource.Bundle;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Destination;
import ca.uhn.fhir.model.dstu2.resource.MessageHeader.Source;
import ca.uhn.fhir.model.dstu2.resource.Organization;
import ca.uhn.fhir.model.dstu2.resource.Parameters;
import ca.uhn.fhir.model.dstu2.resource.Parameters.Parameter;
import ca.uhn.fhir.model.dstu2.resource.Practitioner;
import ca.uhn.fhir.model.dstu2.resource.Practitioner.PractitionerRole;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointSystemEnum;
import ca.uhn.fhir.model.dstu2.valueset.ContactPointUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.IdentifierUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.NameUseEnum;
import ca.uhn.fhir.model.dstu2.valueset.PractitionerRoleEnum;
import ca.uhn.fhir.model.primitive.InstantDt;

public class CreateXML {

	public static Bundle createBundle(){
		
		final Bundle bndl = new Bundle();
		
		//Base Resource attributes
		bndl.setId("13daadee-26e1-4d6a-9e6a-7f4af9b58877");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:fhir.nhs.uk:profile/NHS-FGM-Bundle-QueryParameters");
		bndl.setResourceMetadata(meta);
		
		return bndl;
	}
	
	public static Organization createOrganization(){
		
		//set the data for the elements here
		Organization org = new Organization();
		org.setId("13daadee-26e1-4d6a-9e6a-7f4af9b58878");
		org.setName("THE WHITTINGTON HOSPITAL NHS TRUST");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:fhir.nhs.uk:profile/NHS-FGM-Organization");
		org.setResourceMetadata(meta);
		
		IdentifierDt rr2 = new IdentifierDt();
		rr2.setSystem("urn:fhir.nhs.uk/id/ODSOrganisationCode").setValue("RKE");
		List<IdentifierDt> idenList = new ArrayList<IdentifierDt>();
		idenList.add(rr2);
		org.setIdentifier(idenList);
		return org;
	}
	
	public static MessageHeader createMessageHeader(){
		
		//set the data for the elements here
		MessageHeader msgH = new MessageHeader();
		msgH.setId("14daadee-26e1-4d6a-9e6a-7f4af9b58877");
		
		InstantDt dt = new InstantDt();
		dt.setValueAsString("2015-06-22T14:04:44+00:00");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.UPDATED, dt);
		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:fhir.nhs.uk:profile/NHS-FGM-MessageHeader-QueryParameters");
		msgH.setResourceMetadata(meta);
		
		msgH.setIdentifier("13daadee-26e1-4d6a-9e6a-7f4af9b58977");
		
		dt.setValueAsString("2015-07-04T09:10:14+00:00");
		msgH.setTimestamp(dt);
		
		CodingDt event = new CodingDt();
		event.setSystem("urn:fhir.nhs.uk:vs/MessageEvent");
		event.setCode("urn:nhs:names:services:fgmquery/FGMQuery_1_0");
		msgH.setEvent(event);
		
		Source src = new Source();
		src.setName("FooBar NHS Trust").setSoftware("FooBar Patient Manager").setEndpoint("urn:system:asid/047192794544");
		src.setContact(new ContactPointDt().setSystem(ContactPointSystemEnum.PHONE).setValue("0207 444777").setUse(ContactPointUseEnum.MOBILE));
		msgH.setSource(src);
		
		msgH.addDestination(new Destination().setName("SPINE 2 MHS").setEndpoint("urn:spinecore:asid/990101234567"));
		msgH.setAuthor(new ResourceReferenceDt().setReference("Practitioner/41fe704c-18e5-11e5-b60b-1697f925ec7b").setDisplay("Dr Town Wood"));
		
		ResourceReferenceDt rr2 = new ResourceReferenceDt();
		rr2.setReference("Parameters/7cb73a48-090d-469a-a2b2-04f1e6b11ea2");
		List<ResourceReferenceDt> rr2list = new ArrayList<ResourceReferenceDt>();
		rr2list.add(rr2);
		
		msgH.setData(rr2list);
		
		return msgH;
		
	}
	
	
	public static Parameters createParameters() {
		
		//set the data for the elements here
		Parameters param = new Parameters();
		param.setId("7cb73a48-090d-469a-a2b2-04f1e6b11ea2");
		
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:fhir.nhs.uk:profile/NHS-FGM-QueryParameters");
		param.setResourceMetadata(meta);
		
		param.addParameter(new Parameter().setName("RiskIndicator")).addParameter(new Parameter().setName("NHSNumber"));
		return param;
		
	}
	
	public static Practitioner createPractitioner(){
		
		//set the data for the elements here
		Practitioner prac = new Practitioner();
		prac.setId("41fe704c-18e5-11e5-b60b-1697f925ec7b");
		ResourceMetadataMap meta = new ResourceMetadataMap();
		meta.put(ResourceMetadataKeyEnum.PROFILES, "urn:fhir.nhs.uk:profile/NHS-FGM-Practitioner");
		prac.setResourceMetadata(meta);
		
		List<IdentifierDt> identifierList = new ArrayList<IdentifierDt>();
		
		identifierList.add(0,new IdentifierDt().setUse(IdentifierUseEnum.OFFICIAL).setSystem("urn:fhir.nhs.uk/id/SDSUserID").setValue("G12345678"));
		identifierList.add(1,new IdentifierDt().setUse(IdentifierUseEnum.OFFICIAL).setSystem("urn:fhir.nhs.uk/id/SDSRoleProfileID").setValue("PT1234"));
		prac.setIdentifier(identifierList);
		
		prac.setName(new HumanNameDt().addFamily("Wood").addGiven("Town").addPrefix("Dr.").setUse(NameUseEnum.OFFICIAL));
		
		List<PractitionerRole> PracRoleList = new ArrayList<PractitionerRole>();
		
		PractitionerRole pr = new PractitionerRole();
		pr.setManagingOrganization(new ResourceReferenceDt().setReference("Organization/41fe704c-18e5-11e5-b60b-1697f925ec7b"));
		
		//Below is commented as the values need to be set as the Practitioner role.
//		CodingDt coding2 = new CodingDt();
//		coding2.setSystem("urn:fhir.nhs.uk:vs/SDSJobRoleName");
//		coding2.setCode("R0090");
//		coding2.setDisplay("Hospital Practitioner");
		
		pr.setRole(PractitionerRoleEnum.DOCTOR);
		
		PracRoleList.add(pr);
		
		prac.setPractitionerRole(PracRoleList);
		
		return prac;
		
	}
		
}
