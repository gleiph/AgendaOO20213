/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleiph.agenda.view;

import br.gleiph.agenda.controller.AdicionarContato;
import br.gleiph.agenda.controller.AtualizaDados;
import br.gleiph.agenda.controller.EditarContato;
import br.gleiph.agenda.controller.LimparFormulario;
import br.gleiph.agenda.controller.RemoverContato;
import br.gleiph.agenda.controller.TratarLista;
import br.gleiph.agenda.model.Contato;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 *
 * @author gleiph
 */
public class Tela extends JFrame{
    
    private JPanel painelPrincipal;

    private JList<Contato> listaContatos;
    
    private JTextField jtNome;
    private JTextField jtTelefone;
    private JTextField jtDetalhe;
    
    private int lastIndex;
    
    public Tela() {
        super("Agenda");
        this.addWindowListener(new AtualizaDados(this));
    }
    
    
    
    
    public void desenha(){
//        this.addWindowListener(new AtualizaDados(this));
        this.setSize(400, 300);
        this.setVisible(true);
        
        
        this.painelPrincipal = new JPanel();
        this.painelPrincipal.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        
        
        desenhaFormulario();
        
        

        this.add(this.painelPrincipal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        this.repaint();
    }
    
    private void desenhaMenu(){
        
        JPanel painelMenu;
        painelMenu = new JPanel();
        painelMenu.setBorder(BorderFactory.createTitledBorder("Contatos"));
        this.setLayout(new BorderLayout());
        painelMenu.setPreferredSize(new Dimension(120, 300));
        
        DefaultListModel<Contato> model = new DefaultListModel<>();
        model.addElement(new Contato("Maria", "(32) 99999-8888", "Celular"));
        model.addElement(new Contato("Joao", "(32) 99999-8887", "Celular"));
        
        listaContatos = new JList<>(model);
        listaContatos.setVisible(true);
        listaContatos.setPreferredSize(new Dimension(100, 300));
        listaContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        listaContatos.addListSelectionListener(new TratarLista(this));
        
        painelMenu.add(new JScrollPane(listaContatos), BorderLayout.CENTER);
        
        this.painelPrincipal.add(painelMenu, BorderLayout.WEST);
    }
    
    private void desenhaFormulario(){
        
        JPanel painelFormulario;
        painelFormulario = new JPanel();
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Formulário"));
        painelFormulario.setLayout(new GridLayout(0, 2));
        
        
        JLabel jlNome = new JLabel("Nome: ");
        jtNome = new JTextField(20);
        painelFormulario.add(jlNome);
        painelFormulario.add(jtNome);
        
        JLabel jlTelefone = new JLabel("Telefone: ");
        jtTelefone = new JTextField(20);
        painelFormulario.add(jlTelefone);
        painelFormulario.add(jtTelefone);
        
        JLabel jlDetalhe = new JLabel("Detalhe: ");
        jtDetalhe = new JTextField(20);
        painelFormulario.add(jlDetalhe);
        painelFormulario.add(jtDetalhe);
        
        
        JButton btnAdiciona = new JButton("Adiciona");
        btnAdiciona.addActionListener(new AdicionarContato(this));
        painelFormulario.add(btnAdiciona);
        
        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new RemoverContato(this));
        painelFormulario.add(btnRemove);
        
        JButton btnAtualiza = new JButton("Atualiza");
        btnAtualiza.addActionListener(new EditarContato(this));
        painelFormulario.add(btnAtualiza);
        
        JButton btnLimpa = new JButton("Limpa");
        btnLimpa.addActionListener(new LimparFormulario(this));
        painelFormulario.add(btnLimpa);
        
        this.painelPrincipal.add(painelFormulario, BorderLayout.CENTER);
        
    }
    
    public static void main(String[] args) {
        Tela tela = new Tela();
        
        tela.desenha();
        tela.pack();
    }

    public JList<Contato> getListaContatos() {
        return listaContatos;
    }

    public void setListaContatos(JList<Contato> listaContatos) {
        this.listaContatos = listaContatos;
    }

    public JTextField getJtNome() {
        return jtNome;
    }

    public void setJtNome(JTextField jtNome) {
        this.jtNome = jtNome;
    }

    public JTextField getJtTelefone() {
        return jtTelefone;
    }

    public void setJtTelefone(JTextField jtTelefone) {
        this.jtTelefone = jtTelefone;
    }

    public JTextField getJtDetalhe() {
        return jtDetalhe;
    }

    public void setJtDetalhe(JTextField jtDetalhe) {
        this.jtDetalhe = jtDetalhe;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    public void setLastIndex(int lastIndex) {
        this.lastIndex = lastIndex;
    }
    
    
    
}
