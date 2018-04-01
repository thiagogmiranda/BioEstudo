package br.com.unigranrio.bioestudo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import java.util.Map;

public class QuestaoListItemAdapter extends ArrayAdapter<Questao> {
    public QuestaoListItemAdapter(@NonNull Context context, int resource, @NonNull List<Questao> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Questao questao = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.questao_item, parent, false);
        }

        TextView txtPergunta = (TextView) convertView.findViewById(R.id.pergunta);
        TextView txtRespostas = (TextView) convertView.findViewById(R.id.respostas);

        txtPergunta.setText(questao.getTexto());

        Map<String, String> alternativas = questao.getAlternativas();
        String respostas = "";

        for (Map.Entry<String, String> entry : alternativas.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            respostas += key + ") " + value + "\n";
        }

        txtRespostas.setText(respostas);

        return convertView;
    }
}