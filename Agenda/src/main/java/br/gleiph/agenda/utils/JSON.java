/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.gleiph.agenda.utils;

import br.gleiph.agenda.model.Contato;
import br.gleiph.agenda.model.EmailException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gleip
 */
public class JSON {
    
    public static String toJSON(Contato contato){
        Gson gson = new Gson();
        return gson.toJson(contato);
    }

    public static String toJSON(List<Contato> contatos){
        Gson gson = new Gson();
        return gson.toJson(contatos);
    }
    
    public static Contato toContato(String json){
        Gson gson = new Gson();
        Contato contato = gson.fromJson(json, Contato.class);
        return contato;
    }
    
    public static List<Contato> toContatos(String json){
        Gson gson = new Gson();
        Type contatosTipo = new TypeToken<ArrayList<Contato>>(){}.getType();
        List<Contato> contatos = gson.fromJson(json, contatosTipo);
        return contatos;
    }
    
    
    public static void main(String[] args) {

        try {
            List<Contato> contatos = new ArrayList<>();
            
            
            contatos.add(new Contato("Mario", "(32) 99999-8888", "Casa", "mario@gmail.com"));
            contatos.add(new Contato("Maria", "(32) 99999-9999", "DCC", "maria@gmail.com"));
            
            String json = JSON.toJSON(contatos);
            System.out.println("json = " + json);
            
            for (Contato contato : JSON.toContatos(json)) {
                System.out.println(contato);
            }
        } catch (EmailException ex) {
            Logger.getLogger(JSON.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
