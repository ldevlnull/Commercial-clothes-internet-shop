package ua.com.gui.menu_main.menu_offer;

import ua.com.control.Main;
import ua.com.service.OfferFuncService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by devnull on 14.10.16.
 */
public class Menu_Offer extends Thread{

    private JFrame frame;
    private JPanel main_panel;
    private JButton createOffer_button;
    private JButton deleteComplitedOffer_button;
    private JButton showAllOffer_button;
    private JButton showUncomplitedOffer_button;
    private OfferFuncService offerService = (OfferFuncService)Main.context.getBean("OfferService");

    public Menu_Offer(){

        deleteComplitedOffer_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                offerService.deleteComplitedOffers();
                JOptionPane.showMessageDialog(null, "Удалены завершеные заказы.", "Удалено", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        showAllOffer_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new ShowAllMenu_Offer().run();
            }
        });
        showUncomplitedOffer_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new ShowUncomplitedMenu_Offer().run();
            }
        });
        createOffer_button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                new CreateMenu_Offer().run();
            }
        });
    }

    @Override
    public void run(){
        frame = new JFrame("Меню заказов");
        frame.setSize(512, 512);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.add(main_panel);
    }
}
