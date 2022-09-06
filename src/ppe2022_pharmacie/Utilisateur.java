/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ppe2022_pharmacie;

/**
 *
 * @author sio2021
 */
public class Utilisateur {
    private int idUser;
    private String hash;
    private String login;
    private Service unService;

    public Utilisateur(String login, Service unService, int idUser, String Hash) {
        this.hash = Hash;
        this.login = login;
        this.unService = unService;
        this.idUser = idUser;
    }

    public Service getService() {
        return unService;
    }

    public String getLogin() {
        return login;
    }
    
    public int getIdUser(){
        return idUser;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Service getUnService() {
        return unService;
    }

    public void setUnService(Service unService) {
        this.unService = unService;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setService(Service service) {
        this.unService = service;
    }

    
    
    @Override
    public String toString() {
        return "login=" + login + " | service=" + unService.getLibelle() + " | idService=" + unService.getIdService();
    }
    
    
    
}
