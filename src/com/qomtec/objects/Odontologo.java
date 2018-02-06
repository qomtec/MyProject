package com.qomtec.objects;

public class Odontologo {
    private String codigo_odontologo;
    private String nombre_odontologo;
    private String colegiado_odontologo;
    private String correo_odontologo;
    private String clave_odontologo;

    public Odontologo() {
    }

    public Odontologo(String codigo_odontologo, String nombre_odontologo, String colegiado_odontologo, String correo_odontologo, String clave_odontologo) {
        this.codigo_odontologo = codigo_odontologo;
        this.nombre_odontologo = nombre_odontologo;
        this.colegiado_odontologo = colegiado_odontologo;
        this.correo_odontologo = correo_odontologo;
        this.clave_odontologo = clave_odontologo;
    }

    public String getCodigo_odontologo() {
        return codigo_odontologo;
    }

    public void setCodigo_odontologo(String codigo_odontologo) {
        this.codigo_odontologo = codigo_odontologo;
    }

    public String getNombre_odontologo() {
        return nombre_odontologo;
    }

    public void setNombre_odontologo(String nombre_odontologo) {
        this.nombre_odontologo = nombre_odontologo;
    }

    public String getColegiado_odontologo() {
        return colegiado_odontologo;
    }

    public void setColegiado_odontologo(String colegiado_odontologo) {
        this.colegiado_odontologo = colegiado_odontologo;
    }

    public String getCorreo_odontologo() {
        return correo_odontologo;
    }

    public void setCorreo_odontologo(String correo_odontologo) {
        this.correo_odontologo = correo_odontologo;
    }

    public String getClave_odontologo() {
        return clave_odontologo;
    }

    public void setClave_odontologo(String clave_odontologo) {
        this.clave_odontologo = clave_odontologo;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Odontologo{");
        sb.append("codigo_odontologo='").append(codigo_odontologo).append('\'');
        sb.append(", nombre_odontologo='").append(nombre_odontologo).append('\'');
        sb.append(", colegiado_odontologo='").append(colegiado_odontologo).append('\'');
        sb.append(", correo_odontologo='").append(correo_odontologo).append('\'');
        sb.append(", clave_odontologo='").append(clave_odontologo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
