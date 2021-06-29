package pl.camp.it;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import pl.camp.it.clients.SoapClient;
import pl.camp.it.countries.Country;

public class App {
    public static void main(String[] args) {
        SoapClient soapClient = new SoapClient();
        soapClient.setDefaultUri("http://localhost:8080/ws/");

        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        jaxb2Marshaller.setContextPath("pl.camp.it.countries");

        soapClient.setMarshaller(jaxb2Marshaller);
        soapClient.setUnmarshaller(jaxb2Marshaller);

        Country country = soapClient.getCountry("Polska");
        System.out.println(country.getName());
        System.out.println(country.getCapital());
        System.out.println(country.getPopulation());
        System.out.println(country.getCurrency());
    }
}
