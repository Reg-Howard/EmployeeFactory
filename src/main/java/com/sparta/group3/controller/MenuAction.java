package com.sparta.group3.controller;

@FunctionalInterface
public interface MenuAction {
    MenuResponse performAction(int selection, String additionalInfo);
}
