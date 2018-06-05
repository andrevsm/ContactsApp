package up.edu.br.contatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ContatoActivity extends AppCompatActivity {

    Contato contato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contato);

        EditText txtNome = (EditText) findViewById(R.id.txtName);
        EditText txtNumero = (EditText) findViewById(R.id.txtNumero);
        Spinner spinType = (Spinner) findViewById(R.id.spinType);

        Intent it = getIntent();
        if(it != null && it.hasExtra("contato")) {
            contato = (Contato)it.getSerializableExtra("contato");

            txtNome.setText(contato.getNome());
            txtNumero.setText(contato.getNumero());
            spinType.setSelection(
                    ((ArrayAdapter)spinType.getAdapter()).getPosition(contato.getTipo()));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contato, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            EditText txtNome = (EditText) findViewById(R.id.txtName);
            EditText txtNumero = (EditText) findViewById(R.id.txtNumero);
            Spinner spinType = (Spinner) findViewById(R.id.spinType);

            if(contato == null) {
                contato = new Contato();
            }

            contato.setNome(txtNome.getText().toString());
            contato.setTipo(spinType.getSelectedItem().toString());
            contato.setNumero(txtNumero.getText().toString());

            new ContatoDao().salvar(contato);
            contato = null;

            Toast.makeText(getApplicationContext(), "Salvo com sucesso!",
                    Toast.LENGTH_SHORT).show();

            Intent it = new Intent(ContatoActivity.this, MainActivity.class);
            startActivity(it);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
