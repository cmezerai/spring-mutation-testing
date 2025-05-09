# Projet de Test de Mutation 🧬

Ce projet implémente des tests de mutation à l'aide de [PIT](http://pitest.org/), un framework de test de mutation pour Java. Il s'agit d'un projet utilisant GitHub Actions pour automatiser les tests de mutation à chaque commit ou pull request sur la branche principale (`main`), et pour publier les résultats sur GitHub Pages.

## Table des matières

- [Introduction](#introduction)
- [Configuration des Tests de Mutation](#configuration-des-tests-de-mutation)
- [Intégration Continue avec GitHub Actions](#intégration-continue-avec-github-actions)
- [Consulter le Rapport de Mutation](#consulter-le-rapport-de-mutation)
- [Installation et Exécution des Tests Locaux](#installation-et-exécution-des-tests-locaux)
- [Contribuer](#contribuer)
- [Licence](#licence)

## Introduction

Ce projet utilise des tests de mutation pour évaluer la qualité des tests unitaires existants. PIT génère des mutations du code source pour vérifier si les tests actuels peuvent détecter des erreurs. Si les tests échouent sur une mutation, cela signifie qu'ils sont capables de détecter les erreurs et d'améliorer la couverture de code.

## Configuration des Tests de Mutation

Le projet utilise [PIT Mutation Testing](http://pitest.org/) pour exécuter des tests de mutation. Les tests sont définis dans le fichier `pom.xml` et exécutés via Maven. Lorsqu'une mutation est appliquée, PIT tente de la tuer (c'est-à-dire de vérifier si les tests échouent lorsque le code est modifié).

### Configuration dans le `pom.xml` :
Le fichier `pom.xml` est configuré avec le plugin `pitest-maven-plugin` pour effectuer les tests de mutation lors de l'exécution des tests Maven. Il est essentiel que ce plugin soit correctement configuré pour que les tests de mutation soient générés.

## Intégration Continue avec GitHub Actions

Ce projet utilise [GitHub Actions](https://github.com/features/actions) pour automatiser le processus de test de mutation et de publication des rapports. Le workflow est configuré pour s'exécuter sur chaque push ou pull request vers la branche `main`.

### Workflow GitHub Actions :

Le fichier `.github/workflows/mutation-testing.yml` contient la configuration suivante :

1. **Checkout du code** : Le code est récupéré depuis le dépôt.
2. **Configuration de JDK 21** : Le JDK 21 est installé pour exécuter les tests Java.
3. **Création du répertoire `pit-history`** : Le répertoire pour stocker l'historique des mutations est créé.
4. **Mise en cache des dépendances Maven et de l'historique PIT** : Les caches pour les dépendances Maven et l'historique des mutations sont créés afin d'accélérer les builds.
5. **Exécution des tests de mutation avec PIT** : Les tests de mutation sont exécutés via la commande Maven.
6. **Publication du rapport de mutation sur GitHub Pages** : Si les tests de mutation sont réussis, les rapports sont publiés sur la branche `gh-pages` du dépôt.

### Exemple de fichier GitHub Actions :

```yaml
name: Mutation Testing 🧬

on:
  workflow_dispatch:
  push:
    branches:
      - main
  pull_request:
    branches:
      - main

jobs:
  build-and-test:
    name: Java (build & test) ☕️
    runs-on: ubuntu-latest
    permissions:
      contents: write
      id-token: write

    steps:
      - name: Checkout code
        uses: actions/checkout@v3

      - name: Set up JDK 21
        uses: actions/setup-java@v3
        with:
          distribution: 'temurin'
          java-version: '21'

      - name: Ensure pit-history directory exists
        run: mkdir -p target/pit-history

      - name: Cache Pitest history
        uses: actions/cache@v4
        with:
          path: target/pit-history
          key: pitest-history-${{ github.ref }}-${{ hashFiles('**/pom.xml') }}
          restore-keys: |
            pitest-history-refs/heads/main
            pitest-history-

      - name: Cache Maven dependencies
        uses: actions/cache@v3
        with:
          path: ~/.m2/repository
          key: ${{ runner.os }}-maven-${{ hashFiles('**/pom.xml') }}
          restore-keys: |
            ${{ runner.os }}-maven-

      - name: Running PIT Mutation Testing 🧬
        run: |
          mvn test-compile org.pitest:pitest-maven:mutationCoverage

      - name: Publish PIT Mutation Report to GitHub Pages
        if: success()
        run: |
          git config --global user.name 'GitHub Actions'
          git config --global user.email 'actions@github.com'
          git clone --depth 1 --branch gh-pages https://x-access-token:${{ secrets.GITHUB_TOKEN }}@github.com/${{ github.repository }} gh-pages 
          cp -r target/pit-reports/* gh-pages/
          cd gh-pages
          git add .
          git commit -m "Update PIT mutation report"
          git push origin gh-pages

```
## Consulter le Rapport de Mutation

Une fois les tests de mutation exécutés, un rapport détaillé est généré et publié sur la branche `gh-pages` de ce dépôt. Ce rapport peut être consulté via [GitHub Pages](https://<votre-nom-utilisateur>.github.io/<nom-du-dépot>/).

## Installation et Exécution des Tests Locaux

### Prérequis :

- **Java 21** (JDK 21)
- **Maven** pour gérer les dépendances et les tests.

### Étapes d'installation :

1. Clonez le dépôt :
   ```bash
   git clone https://github.com/<votre-nom-utilisateur>/<nom-du-dépot>.git
   cd <nom-du-dépot>
   ```

2. Installez les dépendances Maven :
   ```bash
   mvn install
   ```

3. Exécutez les tests de mutation localement :
   ```bash
   mvn test-compile org.pitest:pitest-maven:mutationCoverage
   ```

## Contribuer

Les contributions sont les bienvenues ! Pour contribuer, suivez ces étapes :

1. Fork ce projet.
2. Créez une nouvelle branche (`git checkout -b feature/ma-fonctionnalité`).
3. Faites vos modifications et committez-les (`git commit -am 'Ajout d\'une fonctionnalité'`).
4. Poussez votre branche (`git push origin feature/ma-fonctionnalité`).
5. Créez une Pull Request pour fusionner vos modifications.

## Licence

Ce projet est sous licence MIT - voir le fichier [LICENSE](LICENSE) pour plus de détails.

