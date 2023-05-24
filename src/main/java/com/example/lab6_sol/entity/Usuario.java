package com.example.lab6_sol.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int id;

    @Column(nullable = false)
    @NotBlank(message = "El nombre es un campo obligatorio")
    @Size(min=3,max=100,message = "Debe tener una longitud de entre 3 y 100 caracteres")
    private String nombres;

    @NotBlank(message = "El apellido es un campo obligatorio")
    @Size(min=3,max=100,message = "Debe tener entre 3 y 100 caracteres")
    @Column(nullable = false)
    private String apellidos;

    @Column(name = "dni", nullable = false, length = 8)
    @NotBlank(message = "Es un campo obligatorio")
    @Size(max = 8, message = "Deber se un numero de DNI válido de máximo 8 digitos")
    private String dni;

    @Column(name = "edad", nullable = false)
    @NotNull(message = "Es un campo obligatorio")
    @Digits(integer= 3, fraction= 0, message = "La edad debe ser un numero entero positivo")
    @Max(value = 120,message = "La edad debe ser un numero entero positivo")
    @Min(value = 0, message = "La edad debe ser un numero entero positivo")
    private int edad;

    @Column(nullable = false)
    private String correo;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean activo;

    @Column(nullable = false)
    private int rolid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public int getRolid() {
        return rolid;
    }

    public void setRolid(int rolid) {
        this.rolid = rolid;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}