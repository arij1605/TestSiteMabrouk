Feature: clique un produit de la page Chemise et Blouses

Scenario: ajouter un produit au panier

Given utilisateur est sur chemises et blouses

When utilisateur clique sur le produit "CHEMISE À COL CLASSIQUE ET COUPE AMPLE"

Then utilisateur est sur la page du produit "CHEMISE À COL CLASSIQUE ET COUPE AMPLE"

When  utilisateur clique sur le couleur "ecru"  apres sur la taille "M" apres clique sur "Ajouter au panier"

And utilisateur clique sur View Cart

Then utilisateur verifie l'ajout du produit par la presence du bouton "Commander" dans le panier


