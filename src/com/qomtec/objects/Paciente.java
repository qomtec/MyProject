package com.qomtec.objects;

public class Paciente {
    private String codigo_paciente;
    private String nombre_paciente;
    private String apellido_paciente;
    private String telefono_paciente;
    private String correo_paciente;
    private Integer edad_paciente;
    private String fecha_nacimiento_paciente;
    private String genero_paciente;
    private String estado_civil_paciente;
    private String ocupacion_paciente;
    private String alergias_paciente;

    public Paciente() {
    }

    public Paciente(String codigo_paciente, String nombre_paciente, String apellido_paciente, String telefono_paciente, String correo_paciente, Integer edad_paciente, String fecha_nacimiento_paciente, String genero_paciente, String estado_civil_paciente, String ocupacion_paciente, String alergias_paciente) {
        this.codigo_paciente = codigo_paciente;
        this.nombre_paciente = nombre_paciente;
        this.apellido_paciente = apellido_paciente;
        this.telefono_paciente = telefono_paciente;
        this.correo_paciente = correo_paciente;
        this.edad_paciente = edad_paciente;
        this.fecha_nacimiento_paciente = fecha_nacimiento_paciente;
        this.genero_paciente = genero_paciente;
        this.estado_civil_paciente = estado_civil_paciente;
        this.ocupacion_paciente = ocupacion_paciente;
        this.alergias_paciente = alergias_paciente;
    }

    public String getCodigo_paciente() {
        return codigo_paciente;
    }

    public void setCodigo_paciente(String codigo_paciente) {
        this.codigo_paciente = codigo_paciente;
    }

    public String getNombre_paciente() {
        return nombre_paciente;
    }

    public void setNombre_paciente(String nombre_paciente) {
        this.nombre_paciente = nombre_paciente;
    }

    public String getApellido_paciente() {
        return apellido_paciente;
    }

    public void setApellido_paciente(String apellido_paciente) {
        this.apellido_paciente = apellido_paciente;
    }

    public String getTelefono_paciente() {
        return telefono_paciente;
    }

    public void setTelefono_paciente(String telefono_paciente) {
        this.telefono_paciente = telefono_paciente;
    }

    public String getCorreo_paciente() {
        return correo_paciente;
    }

    public void setCorreo_paciente(String correo_paciente) {
        this.correo_paciente = correo_paciente;
    }

    public Integer getEdad_paciente() {
        return edad_paciente;
    }

    public void setEdad_paciente(Integer edad_paciente) {
        this.edad_paciente = edad_paciente;
    }

    public String getFecha_nacimiento_paciente() {
        return fecha_nacimiento_paciente;
    }

    public void setFecha_nacimiento_paciente(String fecha_nacimiento_paciente) {
        this.fecha_nacimiento_paciente = fecha_nacimiento_paciente;
    }

    public String getGenero_paciente() {
        return genero_paciente;
    }

    public void setGenero_paciente(String genero_paciente) {
        this.genero_paciente = genero_paciente;
    }

    public String getEstado_civil_paciente() {
        return estado_civil_paciente;
    }

    public void setEstado_civil_paciente(String estado_civil_paciente) {
        this.estado_civil_paciente = estado_civil_paciente;
    }

    public String getOcupacion_paciente() {
        return ocupacion_paciente;
    }

    public void setOcupacion_paciente(String ocupacion_paciente) {
        this.ocupacion_paciente = ocupacion_paciente;
    }

    public String getAlergias_paciente() {
        return alergias_paciente;
    }

    public void setAlergias_paciente(String alergias_paciente) {
        this.alergias_paciente = alergias_paciente;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Paciente{");
        sb.append("codigo_paciente='").append(codigo_paciente).append('\'');
        sb.append(", nombre_paciente='").append(nombre_paciente).append('\'');
        sb.append(", apellido_paciente='").append(apellido_paciente).append('\'');
        sb.append(", telefono_paciente='").append(telefono_paciente).append('\'');
        sb.append(", correo_paciente='").append(correo_paciente).append('\'');
        sb.append(", edad_paciente=").append(edad_paciente);
        sb.append(", fecha_nacimiento_paciente='").append(fecha_nacimiento_paciente).append('\'');
        sb.append(", genero_paciente='").append(genero_paciente).append('\'');
        sb.append(", estado_civil_paciente='").append(estado_civil_paciente).append('\'');
        sb.append(", ocupacion_paciente='").append(ocupacion_paciente).append('\'');
        sb.append(", alergias_paciente='").append(alergias_paciente).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
