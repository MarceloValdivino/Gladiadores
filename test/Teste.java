/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.seven.lsi.facade.Facade;
import br.com.seven.lsi.model.Item;

/**
 *
 * @author Marcelo
 */
public class Teste {
    
    public static void main(String[] args){
        Item item = new Item();
        item.setNome("Vibranium");
        item.setValor("5000");
        
        Facade facade = new Facade();
        facade.salvarItem(item);
    }
}
