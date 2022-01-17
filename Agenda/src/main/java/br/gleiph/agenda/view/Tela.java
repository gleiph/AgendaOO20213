/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleiph.agenda.view;

import br.gleiph.agenda.model.Contato;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author gleiph
 */
public class Tela extends JFrame{
    
    private JPanel painelPrincipal;
    private JPanel painelMenu;
    private JPanel painelFormulario;

    public Tela() {
        super("Agenda");
    }
    
    
    
    
    public void desenha(){
        
        this.setSize(400, 300);
        this.setVisible(true);
        
        this.painelPrincipal = new JPanel();
        
        this.painelPrincipal.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        this.painelPrincipal.add(this.painelMenu, BorderLayout.WEST);
        
        
        this.add(this.painelPrincipal);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    private void desenhaMenu(){
        
        this.painelMenu = new JPanel();
        this.painelMenu.setBorder(BorderFactory.createTitledBorder("Contatos"));
        this.setLayout(new BorderLayout());
        this.painelMenu.setPreferredSize(new Dimension(120, 300));
        
        DefaultListModel<Contato> model = new DefaultListModel<>();
        model.addElement(new Contato("Maria", "(32) 99999-8888", "Celular"));
        model.addElement(new Contato("Joao", "(32) 99999-8887", "Celular"));
        model.addElement(new Contato("Joao", "(32) 99999-8887", "Celular"));
        
        JList<Contato> listaContatos = new JList<>(model);
        listaContatos.setVisible(true);
        listaContatos.setPreferredSize(new Dimension(100, 300));
        listaContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        painelMenu.add(new JScrollPane(listaContatos), BorderLayout.CENTER);
        
    }
    
    public static void main(String[] args) {
        Tela tela = new Tela();
        tela.desenha();
    }
}
