package com.scriptgo.cossiocafe.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scriptgo.cossiocafe.R;
import com.scriptgo.cossiocafe.adapters.RecyclerAdapter_Catalogo;
import com.scriptgo.cossiocafe.bases.BaseActivity;
import com.scriptgo.cossiocafe.bases.BaseFragment;
import com.scriptgo.cossiocafe.models.M_Catalogo;
import com.scriptgo.cossiocafe.utils.RealmManager;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class CatalogoFragment extends BaseFragment {

    @BindView(R.id.rclv_catalogo)
    RecyclerView rclv_catalogo;

    RecyclerAdapter_Catalogo recyclerview_adapter;

    public CatalogoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
        RealmManager.open();
        if (context instanceof BaseActivity.FragmentToActivity) {
            fragmentToActivity = (BaseActivity.FragmentToActivity) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_catalogo, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    void setAdapter(List<M_Catalogo> data) {
        layoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        layoutManager.setAutoMeasureEnabled(false);
        rclv_catalogo.setLayoutManager(layoutManager);

        recyclerview_adapter = new RecyclerAdapter_Catalogo(context, data, new RecyclerAdapter_Catalogo.CallBack() {
            @Override
            public void onClickCardView(M_Catalogo m_salida, Bundle bundle) {

//                args.putInt(ConstansHelps.IDREGISTRO, MSalida.id);
//                s_fecharegistro = fechahoraformat.format(MSalida.fecharegistro);
//                args.putString(ConstansHelps.FECHAREGISTRO, s_fecharegistro);
//                args.putString(ConstansHelps.GUIA_SERIE_CORRELATIVO, MSalida.serieguia + " - " + MSalida.correlativoguia);
//                args.putString(ConstansHelps.PLACA, MSalida.placa);
//
//                fechaexpiracionrevisiontecnica = MSalida.fechaexpiracionrvt;
//                if (fechaexpiracionrevisiontecnica != null) {
//                    s_fechaexpiracionrevisiontecnica = fechaformat.format(fechaexpiracionrevisiontecnica);
//                    diasrevisiontecnica = MSalida.diasrevisiontecnica;
//                    s_diasreciosrevisiontecnica = String.valueOf(diasrevisiontecnica);
//                    if (diasrevisiontecnica > 15) {
//                        estadorevisiontecnica = "VIGENTE";
//                    } else if (diasrevisiontecnica < 15 && diasrevisiontecnica > 0) {
//                        estadorevisiontecnica = "POR VENCER";
//                    } else {
//                        estadorevisiontecnica = "VENCIDO";
//                    }
//                } else {
//                    s_diasreciosrevisiontecnica = "Sin Registro";
//                    s_fechaexpiracionrevisiontecnica = "Sin Registro";
//                    estadorevisiontecnica = "Sin Registro";
//                }
//                args.putString(ConstansHelps.FECHAEXPIRACIONREVISIONTECNICA, s_diasreciosrevisiontecnica);
//                args.putString(ConstansHelps.DIASEXPIRACIONREVISIONTECNICA, s_fechaexpiracionrevisiontecnica);
//                args.putString(ConstansHelps.ESTADOREVISIONTECNICA, estadorevisiontecnica);
//
//                /* CHOFER */
//                args.putString(ConstansHelps.NOMBRECHOFER, MSalida.nombreapellidochofer);
//                fechaexpiracioncapacitacionchofer = MSalida.fechaexpiracioncapacitchofer;
//                if (fechaexpiracioncapacitacionchofer != null) {
//                    s_fechacapacitacionchofer = fechaformat.format(fechaexpiracioncapacitacionchofer);
//                    diascapacitacionchofer = MSalida.diascapacitacionchofer;
//                    s_diascapacitacionchofer = String.valueOf(diascapacitacionchofer);
//                    if (diascapacitacionchofer > 15) {
//                        estadocapacitacionchofer = "VIGENTE";
//                    } else if (diascapacitacionchofer < 15 && diascapacitacionchofer > 0) {
//                        estadocapacitacionchofer = "POR VENCER";
//                    } else {
//                        estadocapacitacionchofer = "VENCIDO";
//                    }
//                } else {
//                    s_diascapacitacionchofer = "Sin Registro";
//                    s_fechacapacitacionchofer = "Sin Registro";
//                    estadocapacitacionchofer = "Sin Registro";
//                }
//                args.putString(ConstansHelps.FECHAEXPIRACIONCAPACITACIONCHOFER, s_fechacapacitacionchofer);
//                args.putString(ConstansHelps.DIASEXPIRACIONCAPACITACIONCHOFER, s_diascapacitacionchofer);
//                args.putString(ConstansHelps.ESTADOCAPACITACIONCHOFER, estadocapacitacionchofer);

//                /* AYUDANTE */
//                nombreapellidosayudante = MSalida.nombreapellidoayudante;
//                dniayudante = MSalida.dniayudante;
//                kilometraje = MSalida.kilometraje;
//                rpc = MSalida.celular;
//
//                args.putString(ConstansHelps.NOMBREAYUDANTE, (nombreapellidosayudante != null) ? nombreapellidosayudante : "Sin Ayudante");
//                args.putString(ConstansHelps.DNIAYUDANTE, (dniayudante != null) ? dniayudante : "Sin DNI");
//                args.putInt(ConstansHelps.KILOMETRAJE, kilometraje);
//                args.putInt(ConstansHelps.RPC, rpc);
//
//                fechaexpiracioncapacitacionayudante = MSalida.fechaexpiracioncapacitayudante;
//                if (fechaexpiracioncapacitacionayudante != null) {
//                    s_fechacapacitacionayudante = fechaformat.format(fechaexpiracioncapacitacionayudante);
//                    diascapacitacionayudante = MSalida.diascapacitacionayudante;
//                    s_diascapacitacionayudante = String.valueOf(diascapacitacionayudante);
//                    if (diascapacitacionayudante > 15) {
//                        estadocapacitacionayudante = "VIGENTE";
//                    } else if (diascapacitacionayudante < 15 && diascapacitacionayudante > 0) {
//                        estadocapacitacionayudante = "POR VENCER";
//                    } else {
//                        estadocapacitacionayudante = "VENCIDO";
//                    }
//                } else {
//                    s_diascapacitacionayudante = "Sin Registro";
//                    s_fechacapacitacionayudante = "Sin Registro";
//                    estadocapacitacionayudante = "Sin Registro";
//                }
//                args.putString(ConstansHelps.FECHAEXPIRACIONCAPACITACIONAYUDANTE, s_fechacapacitacionayudante);
//                args.putString(ConstansHelps.DIASEXPIRACIONCAPACITACIONAYUDANTE, s_diascapacitacionayudante);
//                args.putString(ConstansHelps.ESTADOCAPACITACIONAYUDANTE, estadocapacitacionayudante);
//
//                args.putString(ConstansHelps.GPS, MSalida.gps);
//                args.putString(ConstansHelps.NOMBRESUPERVISOR, MSalida.nombresupervisor);
//                args.putString(ConstansHelps.CAPACIDAD, MSalida.capacidad);
//                args.putString(ConstansHelps.RUTA, MSalida.ruta);
//
//                args.putInt(ConstansHelps.B10F, MSalida.b10f);
//                args.putInt(ConstansHelps.B10P, MSalida.b10p);
//                args.putInt(ConstansHelps.B10R, MSalida.b10r);
//                args.putInt(ConstansHelps.B15R, MSalida.b15r);
//                args.putInt(ConstansHelps.B45, MSalida.b45);
//                args.putInt(ConstansHelps.B5R, MSalida.b5r);
//                fragmentToActivity.openDialogFragmentToActivity(ConstansHelps.D_DETALLEREGISTRO,
//                        ConstansHelps.TAGDETALLERREGISTRO_SALIR,
//                        "DETALLE",
//                        null,
//                        null,
//                        "Salir",
//                        args);
            }

            @Override
            public void onClickButton(M_Catalogo m_catalogo, Bundle bundle) {

            }

            @Override
            public void onLongClick(M_Catalogo m_catalogo, Bundle bundle) {

            }
        });
        rclv_catalogo.setAdapter(recyclerview_adapter);
        recyclerview_adapter.notifyDataSetChanged();
    }
}
