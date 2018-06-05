package br.com.unigranrio.bioestudo;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ExerciciosFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ExerciciosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExerciciosFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private List<Questao> questoes = new ArrayList<>();

    private OnFragmentInteractionListener mListener;

    public ExerciciosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExerciciosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExerciciosFragment newInstance(String param1, String param2) {
        ExerciciosFragment fragment = new ExerciciosFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_exercicios, container, false);

        inicializarQuestoes();

        ListView listView = (ListView)rootView.findViewById(R.id.listaQuestoes);

        QuestaoListItemAdapter adapter = new QuestaoListItemAdapter(rootView.getContext(), R.layout.questao_item, questoes);

        listView.setAdapter(adapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Questao questao = (Questao) parent.getItemAtPosition(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("Resposta correta");
                builder.setMessage(questao.getAlternativaCorreta());
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // You don't have to do anything here if you just
                        // want it dismissed when clicked
                    }
                });

                builder.create().show();

                return false;
            }
        });

        return rootView;
    }

    private void inicializarQuestoes() {
        Questao q1 = new Questao();
        q1.setTexto("A membrana plasmática permite que algumas substâncias entrem e saiam da célula. " +
                "Algumas vezes essa entrada e saída ocorrem sem gasto de energia (transporte passivo); " +
                "outras vezes, no entanto, a célula apresenta algum gasto energético (transporte ativo). " +
                "Marque a alternativa que indica corretamente o nome do transporte caracterizado pela " +
                "passagem de moléculas do meio mais concentrado para o meio menos concentrado por " +
                "uma membrana permeável e sem ajuda de nenhum composto presente na membrana.");
        q1.adicionarAlternativa("a","fagocitose");
        q1.adicionarAlternativa("b","difusão");
        q1.adicionarAlternativa("c","osmose");
        q1.adicionarAlternativa("d","bomba de sódio e potássio");
        q1.adicionarAlternativa("e","difusão facilitada");

        q1.setAlternativaCorreta("Alternativa “b”. A difusão é um tipo de transporte pela membrana " +
                "que ocorre sem gasto de energia e caracteriza-se pela passagem de moléculas do " +
                "meio mais concentrado para o meio menos concentrado através de uma membrana " +
                "permeável.");

        Questao q2 = new Questao();
        q2.setTexto("A osmose pode ser observada facilmente em nosso dia a dia, como quando " +
                "temperamos uma salada. Após colocar sal no alface, com o tempo, observa-se que as " +
                "folhas se tornam murchas. Isso ocorre porque");

        q2.adicionarAlternativa("a","a água presente no alface evapora com o tempo");
        q2.adicionarAlternativa("b","a água presente no vegetal move-se para o meio hipertônico");
        q2.adicionarAlternativa("c","a água presente no vegetal move-se para o meio hipotônico");
        q2.adicionarAlternativa("d","o sal colocado na salada move-se para o interior do alface, causando perda de água");
        q2.adicionarAlternativa("e","o sal move-se do meio hipotônico para o meio hipertônico");

        q2.setAlternativaCorreta("Alternativa “b”. A água presente no vegetal move-se para o meio " +
                "hipertônico, ou seja, o meio com maior quantidade de soluto (meio externo rico em " +
                "sal).");

        Questao q3 = new Questao();
        q3.setTexto("A membrana plasmática é um envoltório encontrado em todas as células que regula " +
                "o que entra e o que sai dessa estrutura. O transporte de substâncias pode ocorrer de " +
                "várias maneiras e utilizar, ou não, energia da célula. Analise as alternativas a seguir e " +
                "marque a única que não corresponde a um tipo de transporte passivo.");

        q3.adicionarAlternativa("a","difusão simples");
        q3.adicionarAlternativa("b","difusão facilitada");
        q3.adicionarAlternativa("c","osmose");
        q3.adicionarAlternativa("d","bomba de sódio e potássio");

        q3.setAlternativaCorreta("Alternativa “d”. A bomba de sódio e potássio é um tipo de " +
                "transporte ativo. Nesse tipo de transporte de substâncias, o processo ocorre contra " +
                "o gradiente de concentração e, por isso, necessita de energia por parte da célula.");

        Questao q4 = new Questao();
        q4.setTexto("A glicose é uma substância que não consegue penetrar livremente a membrana " +
                "plasmática. Para que seu transporte ocorra para o interior da célula, é fundamental a " +
                "ajuda de proteínas chamadas de permeases. Esse tipo de transporte recebe o nome de:");

        q4.adicionarAlternativa("a","difusão simples");
        q4.adicionarAlternativa("b","difusão facilitada");
        q4.adicionarAlternativa("c","osmose");
        q4.adicionarAlternativa("d","bomba de sódio e potássio");

        q4.setAlternativaCorreta("Alternativa “d”. Na difusão facilitada, as substâncias acoplam-se " +
                "às proteínas da membrana para que ocorra o transporte.");

        Questao q5 = new Questao();
        q5.setTexto("Quando a concentração de solutos em uma região é menor quando comparada à " +
                "outra, dizemos que esse é um meio:");

        q5.adicionarAlternativa("a","hipotônico");
        q5.adicionarAlternativa("b","hipertônico");
        q5.adicionarAlternativa("c","mesotônico");
        q5.adicionarAlternativa("d","isotônico");

        q5.setAlternativaCorreta("Alternativa “a”. Um meio que apresenta uma concentração de " +
                "solutos inferior à de outro meio é chamado de hipotônico. Quando um meio " +
                "apresenta maior concentração de soluto que outro, é chamado de hipertônico. Por " +
                "fim, quando as concentrações são iguais, a denominação é isotônico.");

        Questao q6 = new Questao();
        q6.setTexto("A membrana plasmática é constituída, basicamente, por uma bicamada de " +
                "fosfolipídios associados a moléculas de proteína. Essa estrutura delimita a célula, " +
                "separa o conteúdo celular do meio externo e possibilita o trânsito de substâncias entre " +
                "os meios intra e extracelular.");

        q6.adicionarAlternativa("a","A passagem de substâncias através da membrana plasmática, utilizando proteínas " +
                "transportadoras é denominada difusão simples.");
        q6.adicionarAlternativa("b","A difusão facilitada é o transporte de substâncias pela membrana com o auxílio de " +
                "proteínas transportadoras e gasto de energia.");
        q6.adicionarAlternativa("c","A osmose é a passagem de substâncias através da membrana plasmática em direção " +
                "à menor concentração de solutos.");
        q6.adicionarAlternativa("d","Uma membrana permeável à substância A possibilitará o transporte dessa " +
                "substância para fora da célula, desde que exista ATP disponível.");
        q6.adicionarAlternativa("e","No transporte ativo, ocorre a passagem de substâncias por proteínas de membrana " +
                "com gasto de energia.");

        q6.setAlternativaCorreta("E - O transporte ativo é todo transporte pela membrana, em que " +
                "a substância flui do meio de menor concentração para o meio de maior " +
                "concentração, com gasto de ATP pela célula.");

        Questao q7 = new Questao();
        q7.setTexto("O oxigênio e o gás carbônico são moléculas que atravessam a membrana plasmática " +
                "da célula do local onde ocorrem em maior concentração para o local com menor " +
                "concentração. Esse movimento é um tipo de transporte conhecido como:");

        q7.adicionarAlternativa("a","osmose");
        q7.adicionarAlternativa("b","difusão facilitada");
        q7.adicionarAlternativa("c","difusão simples");
        q7.adicionarAlternativa("d","bomba de sódio e potássio");
        q7.adicionarAlternativa("e","transporte ativo");

        q7.setAlternativaCorreta("Alternativa “c”. A difusão simples é um tipo de transporte passivo " +
                "em que as moléculas e íons são transportados de forma natural, sem gasto de " +
                "energia e a favor do gradiente de concentração.");

        Questao q8 = new Questao();
        q8.setTexto("A membrana plasmática delimita a célula, permitindo a passagem seletiva de " +
                "substâncias do meio externo para o interno e vice-versa. Se essas substâncias são " +
                "transportadas com gasto de energia, então, o mecanismo envolvido é a(o)");

        q8.adicionarAlternativa("a","troca gasosa");
        q8.adicionarAlternativa("b","transporte ativo");
        q7.adicionarAlternativa("c","difusão simples");
        q8.adicionarAlternativa("d","difusão facilitada");

        q8.setAlternativaCorreta("B - Quando há gasto de energia o transporte é sempre ativo.");

        Questao q9 = new Questao();
        q9.setTexto("Sabe-se que o transporte ativo utiliza proteínas e há gasto de energia. Avalie as " +
                "seguintes afirmativas e assinale a alternativa correta:");

        q9.adicionarAlternativa("a","O transporte ativo é uma forma que a célula possui apara promover a síntese do " +
                "impulso nervoso.");
        q9.adicionarAlternativa("b","Observa-se no transporte ativo, o auxílio de proteínas conhecidas como bombas, " +
                "que por meio da relação de íons, promove a transmissão do impulso nervoso.");
        q9.adicionarAlternativa("c","Ocorre através do glicocálix que tem uma parte proteica muito útil nesse tipo de " +
                "transporte.");
        q9.adicionarAlternativa("d","Tem relação com a glicose, a qual insere-se no meio intracelular por transporte " +
                "ativo.");
        q9.adicionarAlternativa("e","Nenhuma das alternativas anteriores.");

        q9.setAlternativaCorreta("B - Observa-se no transporte ativo, o auxílio de proteínas " +
                "conhecidas como bombas, que por meio da relação de íons, promove a transmissão " +
                "do impulso nervoso.");

        Questao q10 = new Questao();
        q10.setTexto("Com base na definição sobre transporte passivo, responda a alternativa correta:");

        q10.adicionarAlternativa("a","É um tipo e transporte biológico que a célula realiza para obter nutrientes com " +
                "agilidade, evitando sua apopitose, por isso há gasto de energia.");
        q10.adicionarAlternativa("b","É realizado, devido a necessidade do gradiente passar do meio mais " +
                "concentrado, para o menos concentrado, com função de nutrir e abastecer a célula.");
        q10.adicionarAlternativa("c","Realiza-se contra um gradiente de concentração, há gasto energético e é " +
                "utilizado no sistema nervoso e contração muscular.");
        q10.adicionarAlternativa("d","Consiste no transporte, onde proteínas integrais, carream (carregam) glicose para " +
                "o meio intracelular e depois secreta por exocitose, depois de metabolizada.");
        q10.adicionarAlternativa("e","Há gasto de energia, é realizado do meio mais concentrado para o menos " +
                "concentrado, como a bomba de Na+ e K+");

        q10.setAlternativaCorreta("B -  É realizado, devido a necessidade do gradiente passar do meio " +
                "mais concentrado, para o menos concentrado, com função de nutrir e abastecer a " +
                "célula.");

        questoes.add(q1);
        questoes.add(q2);
        questoes.add(q3);
        questoes.add(q4);
        questoes.add(q5);
        questoes.add(q6);
        questoes.add(q7);
        questoes.add(q8);
        questoes.add(q9);
        questoes.add(q10);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
