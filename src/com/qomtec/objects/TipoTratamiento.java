package com.qomtec.objects;

public class TipoTratamiento {
    private String codigo_tipo_tratamiento;
    private String nombre_tipo_tratamiento;

    public TipoTratamiento() {
    }

    public TipoTratamiento(String codigo_tipo_tratamiento, String nombre_tipo_tratamiento) {
        this.codigo_tipo_tratamiento = codigo_tipo_tratamiento;
        this.nombre_tipo_tratamiento = nombre_tipo_tratamiento;
    }

    public String getCodigo_tipo_tratamiento() {
        return codigo_tipo_tratamiento;
    }

    public void setCodigo_tipo_tratamiento(String codigo_tipo_tratamiento) {
        this.codigo_tipo_tratamiento = codigo_tipo_tratamiento;
    }

    public String getNombre_tipo_tratamiento() {
        return nombre_tipo_tratamiento;
    }

    public void setNombre_tipo_tratamiento(String nombre_tipo_tratamiento) {
        this.nombre_tipo_tratamiento = nombre_tipo_tratamiento;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoTratamiento{");
        sb.append("codigo_tipo_tratamiento='").append(codigo_tipo_tratamiento).append('\'');
        sb.append(", nombre_tipo_tratamiento='").append(nombre_tipo_tratamiento).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
