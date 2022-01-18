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

/**
 *
 * @author gleip
 */
public class EditarContato implements ActionListener{

    private Tela tela;

    public EditarContato(Tela tela) {
        this.tela = tela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        DefaultListModel<Contato> modelo = (DefaultListModel<Contato>) tela.getListaContatos().getModel();
        Contato contato = modelo.getElementAt(tela.getLastIndex());
        
        contato.setNome(tela.getJtNome().getText());
        contato.setTelefone(tela.getJtTelefone().getText());
        contato.setDetalhe(tela.getJtDetalhe().getText());
      
//        tela.getListaContatos().setModel(modelo);
        
        tela.repaint();
    }
    
    
}
