package com.sparta.group3.controller;

import com.sparta.group3.model.Employee;
import com.sparta.group3.model.EmployeeTreeDecorator;
import com.sparta.group3.view.Menu;

import java.util.HashMap;

public class Controller {
    private HashMap<String, Menu> menus = new HashMap<>();
    EmployeeTreeDecorator tree;
    public Controller(EmployeeTreeDecorator tree){
        this.tree = tree;
        generateMenus();
    }

    private void generateMenus(){
        Menu menu = new Menu(new String[] {"y", "n"}, (x, additionalInfo)->{
            switch(x){
                case 0:
                    return new MenuResponse(MenuResponse.ResponseCode.OK);
                case 1:
                    return new MenuResponse(MenuResponse.ResponseCode.FALSE);
                default:
                    return new MenuResponse(MenuResponse.ResponseCode.BAD_REQUEST);
            }
        });
        menus.put("proceed", menu);

        menu = new Menu(new String[] {"Get employees sorted by last name ascending",
                "Get employees sorted by last name descending",
                "Get employee with a given last name",
                "Get number of employees",
                "Get next employee in alphabetical order",
                "Get previous employee in alphabetical order",
                "Get all employees with a given last name",
                "Get first employee listed"}, (x, additionalInfo)->{
            switch(x){
                case 0:
                    Employee[] results = tree.getSortedTreeAsc();
                    StringBuilder responseMessage = new StringBuilder();
                    for(Employee employee : results)
                        responseMessage.append(employee.toString()).append("\n");
                    if(responseMessage.isEmpty())
                        return new MenuResponse(MenuResponse.ResponseCode.NOT_FOUND, "No results found");
                    return new MenuResponse(MenuResponse.ResponseCode.OK, responseMessage.toString());
                case 1:
                    results = tree.getSortedTreeDesc();
                    responseMessage = new StringBuilder();
                    for(Employee employee : results)
                        responseMessage.append(employee.toString()).append("\n");
                    if(responseMessage.isEmpty())
                        return new MenuResponse(MenuResponse.ResponseCode.NOT_FOUND, "No results found");
                    return new MenuResponse(MenuResponse.ResponseCode.OK, responseMessage.toString());
                case 2:
                    if(additionalInfo.equals(""))
                        return new MenuResponse(MenuResponse.ResponseCode.ADDITIONAL_INFO_REQUIRED, x + ";Please enter last name:");
                    else {
                        Employee result = tree.findElement(additionalInfo);
                        String message = result == null ? "No result found" : result.toString();
                        if(result == null){
                            return new MenuResponse(MenuResponse.ResponseCode.NOT_FOUND, message);
                        }else {
                            return new MenuResponse(MenuResponse.ResponseCode.OK, message);
                        }
                    }
                case 3:
                    return new MenuResponse(MenuResponse.ResponseCode.OK, ""+tree.getNumberOfElements());
                case 4:
                    if(additionalInfo.equals(""))
                        return new MenuResponse(MenuResponse.ResponseCode.ADDITIONAL_INFO_REQUIRED, x + ";Please enter last name:");
                    else {
                        Employee result = tree.getRightChildValue(additionalInfo);
                        String message = result == null ? "No result found" : result.toString();
                        if(result == null){
                            return new MenuResponse(MenuResponse.ResponseCode.NOT_FOUND, message);
                        }else {
                            return new MenuResponse(MenuResponse.ResponseCode.OK, message);
                        }
                    }
                case 5:
                    if(additionalInfo.equals(""))
                        return new MenuResponse(MenuResponse.ResponseCode.ADDITIONAL_INFO_REQUIRED, x + ";Please enter last name:");
                    else {
                        Employee result = tree.getLeftChildValue(additionalInfo);
                        String message = result == null ? "" : result.toString();
                        if(message.equals(""))
                            return new MenuResponse(MenuResponse.ResponseCode.NOT_FOUND, "No result found");
                        else
                            return new MenuResponse(MenuResponse.ResponseCode.OK, message);
                    }
                case 6:
                    if(additionalInfo.equals(""))
                        return new MenuResponse(MenuResponse.ResponseCode.ADDITIONAL_INFO_REQUIRED, x + ";Please enter last name:");
                    else {
                        Employee[] result = tree.findElements(additionalInfo);
                        responseMessage = new StringBuilder();
                        for(Employee employee : result)
                            responseMessage.append(employee.toString()).append("\n");
                        if(responseMessage.isEmpty())
                            return new MenuResponse(MenuResponse.ResponseCode.NOT_FOUND, "No result for\"" + additionalInfo + "\"");
                        else
                            return new MenuResponse(MenuResponse.ResponseCode.OK, responseMessage.toString());
                    }
                case 7:
                    Employee result = tree.getRootElement();
                    if(result == null)
                        return new MenuResponse(MenuResponse.ResponseCode.NOT_FOUND, "No results...");
                    else
                        return new MenuResponse(MenuResponse.ResponseCode.OK, result.toString());
                default:
                    return new MenuResponse(MenuResponse.ResponseCode.BAD_REQUEST);
            }
        });
        menus.put("action", menu);
    }


    public Menu getMenu(String name){
        return menus.get(name);
    }

}
