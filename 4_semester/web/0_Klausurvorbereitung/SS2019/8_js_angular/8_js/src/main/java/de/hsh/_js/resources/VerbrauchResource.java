/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package de.hsh._js.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author SAbde
 */
@Path("verbrauch")
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class VerbrauchResource {
    @GET
    public Verbrauch getVerbrauch(@QueryParam("liter") double liter, @QueryParam("km") double km) {
        System.out.println("REST arrived");
        Verbrauch verbrauch = new Verbrauch();
        verbrauch.setVerbrauch(liter / km * 100);
        return verbrauch;
    }
}
