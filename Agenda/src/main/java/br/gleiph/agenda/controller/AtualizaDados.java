/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleiph.agenda.controller;

import br.gleiph.agenda.controller.utils.Arquivo;
import br.gleiph.agenda.controller.utils.JSON;
import br.gleiph.agenda.model.Contato;
import br.gleiph.agenda.view.Tela;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListModel;

/**
 *
 * @author gleip
 */
public class AtualizaDados implements WindowListener{

    private Tela tela;

    public AtualizaDados(Tela tela) {
        this.tela = tela;
    }
    
    
    @Override
    public void windowOpened(WindowEvent e) {
        System.out.println("windowOpened");
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
            
            Arquivo.escreverArquivo("dados.json", toJSON);
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
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
    }
    
}
