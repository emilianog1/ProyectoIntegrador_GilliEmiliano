package com.porfolioeg.eg.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Emiliano
 */
@Getter @Setter
@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    //@Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String nombre;
    
    @NotNull
    //@Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String apellido;
    
    //@Size(min = 1, max = 240, message = "No cumple con la longitud")
    private String descripcion;
    
    //@Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String titulo;
    
    //@Size(min = 1, max = 50, message = "No cumple con la longitud")
    private String img;
    
    
}
