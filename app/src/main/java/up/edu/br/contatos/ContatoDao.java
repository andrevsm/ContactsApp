package up.edu.br.contatos;

import java.util.ArrayList;
import java.util.List;

public class ContatoDao {

    static ArrayList<Contato> contatos = new ArrayList<Contato>();
    static Integer id = 0;

    public void salvar(Contato contato) {
        for (Contato c : contatos
             ) {
            if(c.getId() != null && c.getId().equals(contato.getId())) {
                c.setNome(contato.getNome());
                c.setNumero(contato.getNumero());
                c.setTipo(contato.getTipo());
            }
        }

        if(!contatos.contains(contato)){
            contato.setId(id);
            contatos.add(contato);
        }
    }

    public List<Contato> listar() {
        return contatos;
    }

    public void excluir(Contato c) {
        contatos.remove(c);
    }
}
