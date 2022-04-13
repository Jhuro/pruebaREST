/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unipiloto.ws.pruebarest.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author jupbc
 */

@XmlRootElement (name = "salario")
@XmlType(propOrder = {"salarioTotal", "salarioPromedio"})
public class Salario {

    private int salarioTotal;
    private int salarioPromedio;

    public Salario() {

    }
    
    @XmlElement
    public int getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(int salarioTotal) {
        this.salarioTotal = salarioTotal;
    }
    
    @XmlElement
    public int getSalarioPromedio() {
        return salarioPromedio;
    }

    public void setSalarioPromedio(int salarioPromedio) {
        this.salarioPromedio = salarioPromedio;
    }
}