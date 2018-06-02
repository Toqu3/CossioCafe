package com.scriptgo.cossiocafe.adapters;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.scriptgo.cossiocafe.R;
import com.scriptgo.cossiocafe.models.M_Catalogo;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lbalarezo on 06/10/2017.
 */

public class RecyclerAdapter_Catalogo extends RecyclerView.Adapter<RecyclerAdapter_Catalogo.PendientesViewHolder> {

    List<M_Catalogo> m_catalogos;
    View v;
    PendientesViewHolder viewholder;
    CallBack callback;
    ViewGroup group;
    Context context;
    Bundle arg;

    public RecyclerAdapter_Catalogo(Context context, List<M_Catalogo> data, CallBack call) {
        this.context = context;
        this.callback = call;
        m_catalogos = data;
        arg = new Bundle();
    }

    @Override
    public PendientesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        group = parent;
        context = group.getContext();
        v = LayoutInflater.from(context).inflate(R.layout.item_catalogo, parent, false);
        viewholder = new PendientesViewHolder(v);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(final PendientesViewHolder holder, int position) {
        M_Catalogo m_catalogo = m_catalogos.get(position);

//
//        holder.img_item_catalogo.setText(s_serieguia + " - " + s_correlativo);
//        holder.txt_title_item_catalogo.setText(s_placa);
//        holder.txt_descripcion_item_catalogo.setText(s_nombreapellidochofer);
//        holder.progress_catalog.setText(fecharegistro);

    }

    @Override
    public int getItemCount() {
        return m_catalogos.size();
    }

    public class PendientesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_item_catalogo)
        ImageView img_item_catalogo;
        @BindView(R.id.txt_title_item_catalogo)
        TextView txt_title_item_catalogo;
        @BindView(R.id.txt_descripcion_item_catalogo)
        TextView txt_descripcion_item_catalogo;
        @BindView(R.id.progress_catalog)
        RoundCornerProgressBar progress_catalog;
        View view;
        public PendientesViewHolder(final View itemView) {
            super(itemView);
            view = itemView.getRootView();
            ButterKnife.bind(this, itemView);
        }

//        @OnClick({
//                R.id.imgbtn_subir_registro_pendiente,
//                R.id.crdv_pendiente
//        })
//        void onClick(View v) {
//            int position = getAdapterPosition();
//            arg.putInt(ConstansHelps.POSITION, position);
//            M_Catalogo m_catalogo = m_catalogos.get(getAdapterPosition());
//            switch (v.getId()) {
//                case R.id.imgbtn_subir_registro_pendiente:
//                    callback.onClickButton(m_catalogo, arg);
//                    break;
//                case R.id.crdv_pendiente:
//                    callback.onClickCardView(m_catalogo, arg);
//                    break;
//            }
//        }
//
//        @OnLongClick({
//                R.id.crdv_pendiente
//        })
//        public boolean onLongClick(View v) {
//            int position = getAdapterPosition();
//            arg.putInt(ConstansHelps.POSITION, position);
//            M_Catalogo m_catalogo = m_catalogos.get(getAdapterPosition());
//            callback.onLongClick(m_catalogo, arg);
//
////                    int position = getAdapterPosition();
////                    firstposition = position;
////                    notifyDataSetChanged();
////                    rlv_contenido_pendientes.setVisibility(View.GONE);
////                    rlv_opciones_pendientes.setVisibility(View.VISIBLE);
////                    break;
////            }
//            return true;
//        }
    }

    public interface CallBack {
        void onClickButton(M_Catalogo m_catalogo, Bundle arg);
        void onClickCardView(M_Catalogo m_catalogo, Bundle arg);
        void onLongClick(M_Catalogo m_catalogo, Bundle arg);
    }
}
