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
    private JTextField jtEmail;
    
    private int lastIndex;
    
    public Tela() {
        super("Agenda");
        this.addWindowListener(new AtualizaDados(this));
    }
    
    
    
    
    public void desenha(){
//        this.addWindowListener(new AtualizaDados(this));
        this.setSize(300, 200);
        this.setVisible(true);
        
        
        this.painelPrincipal = new JPanel();
        this.painelPrincipal.setLayout(new BorderLayout());
        
        desenhaMenu();
        
        
        
        desenhaFormulario();
        
        

        this.add(this.painelPrincipal);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        this.repaint();
    }
    
    private void desenhaMenu() {
        
        JPanel painelMenu;
        painelMenu = new JPanel();
        painelMenu.setBorder(BorderFactory.createTitledBorder("Contatos"));
//        this.setLayout(new BorderLayout());
        painelMenu.setPreferredSize(new Dimension(120, 200));
        
        DefaultListModel<Contato> model = new DefaultListModel<>();
        
        listaContatos = new JList<>(model);
        listaContatos.setVisible(true);
        listaContatos.setPreferredSize(new Dimension(95, 300));
        listaContatos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        listaContatos.addListSelectionListener(new TratarLista(this));
        
        painelMenu.add(new JScrollPane(listaContatos), BorderLayout.EAST);
        
        
        this.painelPrincipal.add(painelMenu, BorderLayout.WEST);
    }
    
    private void desenhaFormulario(){
        
        JPanel painelFormulario;
        painelFormulario = new JPanel();
        painelFormulario.setBorder(BorderFactory.createTitledBorder("Formulário"));
        painelFormulario.setLayout(new BorderLayout());
        
        JPanel painelLabel = new JPanel(new GridLayout(0, 1));
        JPanel painelTextField = new JPanel(new GridLayout(0, 1));
        
        JLabel jlNome = new JLabel("Nome: ");
        jtNome = new JTextField(20);
        painelLabel.add(jlNome);
        painelTextField.add(jtNome);
        
        JLabel jlTelefone = new JLabel("Telefone: ");
        jtTelefone = new JTextField(20);
        painelLabel.add(jlTelefone);
        painelTextField.add(jtTelefone);
        
        JLabel jlDetalhe = new JLabel("Detalhe: ");
        jtDetalhe = new JTextField(20);
        painelLabel.add(jlDetalhe);
        painelTextField.add(jtDetalhe);
        
        JLabel jlEmail = new JLabel("Email: ");
        jtEmail = new JTextField(20);
        painelLabel.add(jlEmail);
        painelTextField.add(jtEmail);
        
        painelFormulario.add(painelLabel, BorderLayout.WEST);
        painelFormulario.add(painelTextField, BorderLayout.EAST);
        
        JPanel painelBotoes = new JPanel();
        
        JButton btnAdiciona = new JButton("Adiciona");
        btnAdiciona.addActionListener(new AdicionarContato(this));
        painelBotoes.add(btnAdiciona);
        
        JButton btnRemove = new JButton("Remove");
        btnRemove.addActionListener(new RemoverContato(this));
        painelBotoes.add(btnRemove);
        
        JButton btnAtualiza = new JButton("Atualiza");
        btnAtualiza.addActionListener(new EditarContato(this));
        painelBotoes.add(btnAtualiza);
        
        JButton btnLimpa = new JButton("Limpa");
        btnLimpa.addActionListener(new LimparFormulario(this));
        painelBotoes.add(btnLimpa);
        
        painelFormulario.add(painelBotoes, BorderLayout.SOUTH);
        
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

    public JTextField getJtEmail() {
        return jtEmail;
    }
    
    
    
}
