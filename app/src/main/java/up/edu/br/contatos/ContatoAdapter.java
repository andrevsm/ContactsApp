package up.edu.br.contatos;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContatoAdapter extends BaseAdapter {

    private List<Contato> contatos;
    Activity act;

    public ContatoAdapter (List<Contato> contatos, Activity act) {

        this.contatos = contatos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return this.contatos.size();
    }

    @Override
    public Object getItem(int position) {
        return this.contatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = act.getLayoutInflater().inflate(R.layout.contato_adapter, parent, false);

        TextView textView1 = view.findViewById(R.id.textView);
        TextView textView2 = view.findViewById(R.id.textView2);
        ImageView imageView = view.findViewById(R.id.imageContato);

        Contato c = contatos.get(position);

        textView1.setText(c.getNome());
        textView2.setText(c.getNumero());

        if(c.getTipo().equals("Casa")) {
            imageView.setImageResource(R.drawable.home);
        } else if(c.getTipo().equals("Celular")){
            imageView.setImageResource(R.drawable.celular);
        } else {
            imageView.setImageResource(R.drawable.work);
        }




        return view;
    }

    public void remove(Contato contato) {
        this.contatos.remove(contato);
    }
}
