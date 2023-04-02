package com.sparta.group3.view;

import com.sparta.group3.controller.MenuAction;
import com.sparta.group3.controller.MenuResponse;

public class Menu {
    private final String[] menu;
    MenuAction action;
    public Menu(String[] menu, MenuAction action){
        this.menu = menu.clone();
        this.action = action;
    }

    public MenuAction getMenuAction(){
        return action;
    }

    public MenuResponse handleAction(String input, String additionalInfo){
       return action.performAction(getMenuSelection(input), additionalInfo);
    }

    private int getMenuSelection(String input){
        int selection = -1;
        try{
            int numberSelection = Integer.parseInt(input);
            if(numberSelection >= 0 && numberSelection < menu.length){
                selection = numberSelection;
            }
        }catch(Exception e){
            if(input.matches("^[\sA-Za-z()-]+$")) {
                for (int i = 0; i < menu.length; i++) {
                    if (menu[i].equals(input)){
                        selection = i;
                        break;
                    }
                }
            }
        }
        return selection;
    }

    @Override
    public String toString(){
        StringBuilder menuOptions = new StringBuilder();
        for(int i = 0; i < menu.length; i++){
            menuOptions.append("[" + i + "] " + menu[i]);
            if(i < menu.length - 1) menuOptions.append("\n");
        }
        return menuOptions.toString();
    }
}
