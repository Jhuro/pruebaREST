/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.ws.pruebarest.services;

import co.edu.unipiloto.ws.pruebarest.entidad.Person;
import co.edu.unipiloto.ws.pruebarest.entidad.Salario;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author jupbc
 */
@Path("service")
public class Service {

    private static Salario salario = new Salario();
    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();

    static {
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("My wonderfull Person " + id);
            person.setAge(new Random().nextInt(40) + 1);
            person.setSalario(person.getAge() * 1000000 / 3);
            persons.put(id, person);

            salario.setSalarioTotal(calcularSalarioTotal());
            salario.setSalarioPromedio(calacularSalarioPromedio());
        }
    }

    public static int calcularSalarioTotal() {
        
        int salarioTotal = 0;
        for (Person person : persons.values()) {

            salarioTotal += person.getSalario();
        }
        return salarioTotal;
    }
    
    public static int calacularSalarioPromedio() {
        return calcularSalarioTotal() / persons.size();
    }

    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id") int id) {
        return persons.get(id);
    }

    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id) {
        return persons.get(id);
    }

    @GET
    @Path("/getSalarioPromedioInXML")
    @Produces(MediaType.APPLICATION_XML)
    public Salario getSalarioPromedioXML() {

        return salario;
    }

    @GET
    @Path("/getSumaSalariosInJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public Salario getSumaSalariosInJSON() {

        return salario;
    }

    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML() {
        return new ArrayList<Person>(persons.values());
    }

    @GET
    @Path("/getAllPersonsInJSON")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson() {
        return new ArrayList<Person>(persons.values());
    }

    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person) {
        System.out.println(person.getId());
        persons.put(new Integer(person.getId()), person);
        return person;
    }
}