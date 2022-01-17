/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleiph.agenda.controller;

import br.gleiph.agenda.view.Tela;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author gleip
 */
public class LimparFormulario implements ActionListener{
    
    private Tela tela;

    public LimparFormulario(Tela tela) {
        this.tela = tela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        tela.getJtNome().setText("");
        tela.getJtTelefone().setText("");
        tela.getJtDetalhe().setText("");
        
        tela.repaint();
    }
    
    
    
}
