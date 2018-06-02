package com.scriptgo.cossiocafe.models;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by lbalarezo on 28/08/2017.
 */

public class M_Catalogo extends RealmObject {
    @PrimaryKey
    public int id;

    public int idguia;
    public int serieguia;
    public int correlativoguia;
    public String placa;
    public Date fechaexpiracionrvt;
    public int diasrevisiontecnica;

    public RealmList<Ayudante_M> ayudantes;

    public int diascapacitacionayudante;

    public String dnichofer;
    public int idchofer;
    public String nombreapellidochofer;
    public Date fechaexpiracioncapacitchofer;
    public int diascapacitacionchofer;



    public Date fecharegistro;
    public Integer minutostardanza;
    public Integer salidas;
    public Integer idmotivotardanza;
    public Integer idmotivosalida;
    public String nombremotivosalida;
    public String nombremotivotardanza;
    public Integer motivostardanza;
    public String motivotardanza;
    public int kilometraje;
    public int serieboleta;
    public int seriefactura;
    public int idzona;
    public String motivofaltante;
    public String zona;
    public String ruta;
    public String horasalida;
    public String zonal;
    public String distrito;
    public String turno;
    public int idusuario;
    public String nombreusuario;
    public int celular;
    public String modoconsultaguia;
    public String modoconsultaplaca;
    public String modoconsultarpc;
    public String modoconsultaayudante;
    public String gps;
    public String nombresupervisor;
    public String capacidad;

    public int b10f;
    public int b10p;
    public int b45;
    public int b10fu;
    public int b45u;
    public int b10pu;

    public int b10r;
    public int b15r;
    public int b5r;

    public Boolean statustmp;
    public String createdAtLocal;
    public String updatedAtLocal;
    public Date createdAt;
    public String updatedAt;

}
