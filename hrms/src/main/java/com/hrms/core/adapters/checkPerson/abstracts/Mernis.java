package com.hrms.core.adapters.checkPerson.abstracts;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

public class Mernis implements CheckPersonService {

	private KPSPublicSoapProxy client = new KPSPublicSoapProxy();
	
	 @Override
	public boolean validate(Person person) {
		 try {
	            return client.TCKimlikNoDogrula(
	                    Long.parseLong(person.getNalionalityId()),
	                    person.getFirstName(),
	                    person.getLastName(),
	                    Integer.parseInt(person.getYearOfBirth()));
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	}

}