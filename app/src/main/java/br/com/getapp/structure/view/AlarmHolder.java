package br.com.getapp.structure.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import br.com.getapp.R;

/**
 * Created by User on 23/05/2016.
 */
public class AlarmHolder extends RecyclerView.ViewHolder {
    public AlarmHolder(View itemView) {
        super(itemView);

        TextView tempo = (TextView) itemView.findViewById(R.id.tempo);
        Switch sw = (Switch) itemView.findViewById(R.id.sw);

    }


}
