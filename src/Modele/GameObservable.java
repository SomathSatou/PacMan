package Modele;

import View.Observateur;

public interface GameObservable {
    public void enregistrerObservateur(Observateur observateur);
    public void supprimerObservateur(Observateur observer);
    public void notifierObservateur();

}
