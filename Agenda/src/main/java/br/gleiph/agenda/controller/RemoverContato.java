/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleiph.agenda.controller;

import br.gleiph.agenda.model.Contato;
import br.gleiph.agenda.view.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author gleip
 */
public class RemoverContato implements ActionListener {

    private Tela tela;

    public RemoverContato(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int selectedIndex = tela.getListaContatos().getSelectedIndex();

        if (selectedIndex == -1) {
            JOptionPane.showMessageDialog(tela, "Selecione um contato para ser excluído!");
        } else {
            DefaultListModel<Contato> modelo = (DefaultListModel<Contato>) tela.getListaContatos().getModel();

            modelo.removeElementAt(selectedIndex);
            tela.getListaContatos().setModel(modelo);
            tela.repaint();
        }

    }

}
