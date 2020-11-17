package Hauptmenue;
import java.util.ArrayList;
import java.util.Random;

public class pioche extends Person {

    private final int SpielerZahl;
    private ArrayList<Integer> nombres=new ArrayList<Integer>();


    // Constructeur de l'objet
    public pioche(int SpielerZahl)
    {
        this.SpielerZahl = SpielerZahl; // nombre d'éléments dans la liste, défini par l'utilisateur
        setTableau(); // On appelle la fonction qui rempli la liste des éléments à tirer au sort
    }

    private void setTableau()
    {
        // On rempli le tableau "nombres" de 1 à nb
        for(int i=0;i<=(this.SpielerZahl-1);i++) {nombres.add(i);}
    }
    // Méthode pour ne pas tirer au sort les même nombres plusieurs fois de suite :
    // 1) on tire un nombre au hasard parmi ceux présents dans la liste
    // 2) on retire ce nombre de la liste
    //    ainsi, à chaque tirage, la liste comprend n-1 éléments et on piochera parmi n-1 élements
    public  Integer getPif()
    {
        if(nombres.size()==0) {setTableau();}
        int i=pif(0,nombres.size()-1);
        int retour=nombres.get(i);
        nombres.remove(i); // (2)
        return retour;
    }

    // Tirage au sort
    // ENTREE : la valeur min (ex : 0) et la valeur max (ex : 63)
    // SORTIE : un nombre entier compris entre min et max
    private static int pif(int min,int max)
    {
        Random rand=new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}
