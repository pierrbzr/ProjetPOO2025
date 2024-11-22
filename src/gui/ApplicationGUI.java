package gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Represente l'interface graphique de l'application
 * 
 * @author Tristan AZZOU et Pierre BAZIRE
 */
public class ApplicationGUI {

    /** Le fichier actuellement selectionne */
    private static File imageSelectionnee;

    /**
     * Point d'entree principal de l'application
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            creerEtAfficherInterfaceGraphique();
        });
    }

    /**
     * Cree et affiche l'interface graphique
     */
    private static void creerEtAfficherInterfaceGraphique() {
        // Création de la fenêtre principale
        JFrame fenetre = new JFrame("Images et Metadonees avec JAVA");
        fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setSize(1000, 700);

        JPanel panneauPrincipal = new JPanel(new BorderLayout());
        fenetre.add(panneauPrincipal);

        // Création du bouton "Parcourir"
        JButton boutonParcourir = new JButton("Parcourir");
        boutonParcourir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                imageSelectionnee = afficherExplorateurFichiers();
            }
        });

        JButton afficherStatistiquesRep = new JButton("Afficher Statistiques du Répertoire");
        JButton afficherStatistiquesImageSelect = new JButton("Extraire Principales Statistiques");
        JButton extraireMetaImageSelect = new JButton("Extraire Métadonnées");

        JPanel panneauBoutons = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panneauBoutons.add(boutonParcourir);
        panneauBoutons.add(afficherStatistiquesRep);
        panneauBoutons.add(afficherStatistiquesImageSelect);
        panneauBoutons.add(extraireMetaImageSelect);
        panneauPrincipal.add(panneauBoutons, BorderLayout.SOUTH);

        fenetre.setVisible(true);

    }

    private static File afficherExplorateurFichiers() {
        JFileChooser explorateurFichiers = new JFileChooser();
        explorateurFichiers.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg", "png", "jpeg", "webp");
        explorateurFichiers.addChoosableFileFilter(filter);
        explorateurFichiers.setAcceptAllFileFilterUsed(false);

        int resultat = explorateurFichiers.showOpenDialog(null);

        if (resultat == JFileChooser.APPROVE_OPTION) {
            return explorateurFichiers.getSelectedFile();
        }
        return null;

    }

}
