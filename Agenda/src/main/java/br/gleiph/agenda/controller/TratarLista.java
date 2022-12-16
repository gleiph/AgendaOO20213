/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleiph.agenda.controller;

import br.gleiph.agenda.model.Contato;
import br.gleiph.agenda.view.Tela;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author gleip
 */
public class TratarLista implements ListSelectionListener{

    private Tela tela;

    public TratarLista(Tela tela) {
        this.tela = tela;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
    
        int index = tela.getListaContatos().getSelectedIndex();
        
        if(index != -1){
            Contato contato = tela.getListaContatos().getModel().getElementAt(index);
            
            tela.getJtNome().setText(contato.getNome());
            tela.getJtTelefone().setText(contato.getTelefone());
            tela.getJtDetalhe().setText(contato.getDetalhe());
            tela.getJtEmail().setText(contato.getEmail());
            
            tela.setLastIndex(index);
            
        }
    }
    
}
