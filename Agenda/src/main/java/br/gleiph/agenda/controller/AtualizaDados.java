
package br.gleiph.agenda.controller;

import br.gleiph.agenda.utils.Arquivo;
import br.gleiph.agenda.utils.JSON;
import br.gleiph.agenda.model.Contato;
import br.gleiph.agenda.view.Tela;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author gleip
 */
public class AtualizaDados implements WindowListener{

    private static final String CAMINHO = "dados.json";
    private final Tela tela;

    public AtualizaDados(Tela tela) {
        this.tela = tela;
    }
    
    
    @Override
    public void windowOpened(WindowEvent e) {
        
        try {
            String dados = Arquivo.lerArquivo(CAMINHO);
            List<Contato> contatos = JSON.toContatos(dados);
            
            DefaultListModel<Contato> modelo = new DefaultListModel<>();
            
            for (Contato contato : contatos) {
                modelo.addElement(contato);
            }
            
            tela.getListaContatos().setModel(modelo);
            tela.repaint();
            
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(tela, "Não foi possível carregar os dados da agenda!");
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {
        try {
            ListModel<Contato> modelo = tela.getListaContatos().getModel();
            List<Contato> contatos = new ArrayList<>();
            
            for (int i = 0; i < modelo.getSize(); i++) {
                contatos.add(modelo.getElementAt(i));
            }
            
            String toJSON = JSON.toJSON(contatos);
            System.out.println("toJSON = " + toJSON);
            
            Arquivo.escreverArquivo(CAMINHO, toJSON);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(tela, "Não foi possivel salvar os dados");
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
    }

    @Override
    public void windowIconified(WindowEvent e) {
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("Ativado");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
