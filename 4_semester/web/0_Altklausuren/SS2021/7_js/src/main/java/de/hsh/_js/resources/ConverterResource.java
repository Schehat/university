/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package de.hsh._js.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * REST Web Service
 *
 * @author SAbde
 */
@Path("Converter")
@XmlRootElement
public class ConverterResource {
    @GET
    public Converter getEuro(@QueryParam("dollar") double dollar, @QueryParam("faktor") double faktor) {
        System.out.println("GET arrived");
        Converter converter = new Converter();
        converter.setDollar(dollar);
        converter.setFaktor(faktor);
        converter.setEuro(converter.getDollar() * converter.getFaktor());
        return converter;
    }
}
