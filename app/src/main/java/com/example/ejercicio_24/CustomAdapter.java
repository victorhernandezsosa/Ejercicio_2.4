package com.example.ejercicio_24;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private List<signaturess> lista;

    public CustomAdapter(List<signaturess> lista) {
        this.lista = lista;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public signaturess getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_firmas, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.firmaImageView = convertView.findViewById(R.id.firmaImageView);
            viewHolder.descripcionTextView = convertView.findViewById(R.id.descripcionTextView);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        signaturess firma = getItem(position);

        viewHolder.firmaImageView.setImageBitmap(firma.getFirma());
        viewHolder.descripcionTextView.setText(firma.getDescripcion());

        return convertView;
    }

    private static class ViewHolder {
        ImageView firmaImageView;
        TextView descripcionTextView;
    }
}

