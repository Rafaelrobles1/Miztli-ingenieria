package model;
// Generated 19/04/2016 11:26:41 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





@Entity
@Table(name = "usuario"
       , schema = "public")
public class Usuario  implements java.io.Serializable {


    
     private int idUsuario;
     private String nombre;
     private String apellidoPaterno;
     private String apellidoMaterno;
     private String correo;
     private String telefono;
     private byte[] fotoU;
     private String contrasenya;

    public Usuario() {
    }

	
    public Usuario(int idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono, String contrasenya) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenya = contrasenya;
    }
    public Usuario(int idUsuario, String nombre, String apellidoPaterno, String apellidoMaterno, String correo, String telefono, byte[] fotoU, String contrasenya) {
       this.idUsuario = idUsuario;
       this.nombre = nombre;
       this.apellidoPaterno = apellidoPaterno;
       this.apellidoMaterno = apellidoMaterno;
       this.correo = correo;
       this.telefono = telefono;
       this.fotoU = fotoU;
       this.contrasenya = contrasenya;
    }
    @Id
     @Column(name = "id", unique = true, nullable = false)
    public int getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }
    
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }
    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }
    
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }
    
     @Column(name = "correo")
    public String getCorreo() {
        return this.correo;
    }
    
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public byte[] getFotoU() {
        return this.fotoU;
    }
    
    public void setFotoU(byte[] fotoU) {
        this.fotoU = fotoU;
    }
    public String getContrasenya() {
        return this.contrasenya;
    }
    
    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }




}


