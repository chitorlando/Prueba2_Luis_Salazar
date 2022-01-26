package com.Luis_Salazar_2doParcial_prueba_01.apps.Luis_Salazar_2doParcial_01_prueba;

public class LOSR_Cliente {
    private int codigo;
    private String nombre;
    private String apellido;
    private String correo;
    private String usr;
    private String passwd;

    public LOSR_Cliente() {
    }

    public LOSR_Cliente(int codigo, String nombre, String apellido, String correo, String usr, String passwd) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.usr = usr;
        this.passwd = passwd;
    }

    public LOSR_Cliente(String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
