/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleiph.agenda.controller;

import br.gleiph.agenda.model.Contato;
import br.gleiph.agenda.model.EmailException;
import br.gleiph.agenda.view.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author gleip
 */
public class AdicionarContato implements ActionListener {

    private Tela tela;

    public AdicionarContato(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

        DefaultListModel<Contato> model = (DefaultListModel<Contato>) tela.getListaContatos().getModel();

        try {
            model.addElement(new Contato(tela.getJtNome().getText(),
                    tela.getJtTelefone().getText(),
                    tela.getJtDetalhe().getText(),
                    tela.getJtEmail().getText())
            );
        } catch (EmailException ex) {
            JOptionPane.showMessageDialog(tela, ex.getMessage(), ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        tela.getListaContatos().setModel(model);
        tela.repaint();

    }

}
