package application.util;

import java.time.LocalDate;
import javax.xml.bind.annotation.adapters.XmlAdapter;


public class LocalDateAdapter {
	
	public LocalDate unmarshal(String v) throws Exception {
		return LocalDate.parse(v);
	}

	public String marshal(LocalDate v) throws Exception {
		return v.toString();
	}
}
