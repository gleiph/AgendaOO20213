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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author gleip
 */
public class EditarContato implements ActionListener {

    private Tela tela;

    public EditarContato(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        DefaultListModel<Contato> modelo = (DefaultListModel<Contato>) tela.getListaContatos().getModel();
        Contato contato = modelo.getElementAt(tela.getLastIndex());

        try {
            contato.setNome(tela.getJtNome().getText());
            contato.setTelefone(tela.getJtTelefone().getText());
            contato.setDetalhe(tela.getJtDetalhe().getText());
            contato.setEmail(tela.getJtEmail().getText());
        } catch (EmailException ex) {
            JOptionPane.showMessageDialog(tela, ex.getMessage(), ex.getMessage(), JOptionPane.ERROR_MESSAGE);
        }

        tela.repaint();
    }

}
