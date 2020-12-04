# Project-undercover-2020

Team: Theo Portmann, Michael Schaetzel, Lucas Lagel, Maxime Roellinger, Gourdes Matis

## Inhaltsverzeichnis:

1. [Abstrakt](https://github.com/MatisGourdes/Project-undercover-2020#1-abstrakt)

2. [Anforderungen](https://github.com/MatisGourdes/Project-undercover-2020#2-anforderungen)

3. [Das Spiel](https://github.com/MatisGourdes/Project-undercover-2020#3-das-spiel)

4. [Timeline](https://github.com/MatisGourdes/Project-undercover-2020#4-timeline)

5. [User Stories](https://github.com/MatisGourdes/Project-undercover-2020#5-user-stories)

6. [Build Anleitung](https://github.com/MatisGourdes/Project-undercover-2020#6-build-anleitung) 

7. [Das Programm](https://github.com/MatisGourdes/Project-undercover-2020#7-das-programm)

8. [Dokumentation Sprint 1](https://github.com/MatisGourdes/Project-undercover-2020#8-documentation-sprint-1)
- [Taskliste der User Stories](https://github.com/MatisGourdes/Project-undercover-2020#--taskliste-der-user-stories)
- [Anreicherung der User Stories]()
- [UML Package, Klassen- und Sequenzdiagramme]()
- [Dokumentation wichtiger Code Snippets]()
- [Testfaelle bedingt durch Aktzeptanzkriterium]()

9. [Dokumentatin Sprint 2](https://github.com/MatisGourdes/Project-undercover-2020#9-documentation-sprint-2)
- [Taskliste der User Stories (mit Schätzung)]()
- [Anreicherung der User Stories]()
- [UML Package, Klassen- und Sequenzdiagramme]()
- [Dokumentation wichtiger Code Snippets]()
- [Testfaelle bedingt durch Aktzeptanzkriterium]()

## 1. Abstrakt
Unser Team besteht aus Mechatronik-Trinational Studierenden. Im Rahmen des Moduls SWE und Informatik II entwickeln wir eine etwas komplexere Software, um den zuvor gelernten Stoff durch die Implementierung einer lauffähigen Applikation zu vertiefen. Dabei wird die Komplexität der Applikation abgestimmt auf die individuellen Vorkenntnisse der Studierenden. 
Zeitspanne der Bearbeitung: Herbstsemester 2020.


## 2. Einleitung
### Ziele
Das Ziel mit diesem Projekt ist es, als Studierende, unsere Kenntnisse in Programmierung anzuwenden und als Team den Vincent-Driessen Workflow (mittels Jira und GitHub) auszuüben.
Demzufolge haben wir uns entschlossen, ein Spiel zu programmieren: presentation.

### Anforderungen
- Die Programmierung soll in JAVA erfolgen mittels Eclipse und IntelliJ, mit grafischen Benutzerinterface mittels JavaFx. 
- Der Code soll uber die entsprechenden Unit Test verfugen.
- Das Projekt soll auf Github veröffentlicht werden.
- Die Build Automatisierung soll mit MAVEN erfolgen.

- Epic und User Stories mit Akzeptanzkriterien (Agile Workflow)
- Aufwandsschätzung: Story Points für User Stories und Stundenschätzung pro Sprint und Task
- Planung: Langfristige Planung mit Release plan, kurzfristige Planung pro Sprint
- Design Artefakte: UML – Unified Modelling Language 


### MVP (Minimal Viable Project):
Das MVP besteht also aus : *(siehe User Stories mit Priorisierung 1)*
- Ein Hauptmenü um das Spiel zu starten und Zugang zu den Spielregeln zu haben.
- Eine JavaFx Szene, auf welcher ein Wort und eine Rolle für jeden Spieler gegeben werden kann.
- Eine JavaFx Szene, auf welcher jeder Spieler den Namen des ausgeschlossenen Spielers eingeben kann.
- Eine JavaFx Szene für Mr White, damit er das Wort raten kann, nachdem er angeklagt wurde.
- Java Klassen, die die genannten Szenen steuern.

## 3. Das Spiel

presentation ist ein Multiplayer-Spiel, bei welchem jedem Spieler einer der folgenden Rollen zugewiesen wird:

- "**Citizen**" : der Spieler bekommt ein Wort, das auch die anderen Citizen bekommen. 
- "**presentation**" : der presentation bekommt auch ein Wort, welches aber ein Synonym des Worts der Citizen.
- "**Mr White**" : bekommt kein Wort. Der Mr White muss das Wort der Citizen erraten und versuchen, sich in die Masse zu verbergen.


Bemerkenswert können sich Citizen und presentation voneinander nicht unterscheiden; sie haben zwar ein Wort bekommen, wissen aber nicht, ob es das zu erratende Wort ist.
Jeder Spieler wird nacheinander ein Synonym seines Worts geben, hier müssen die Mr White ein Wort finden, welches sich daran genug annähert, damit die anderen nicht erraten, dass sie keine Wörter bekommen haben. 
Am Ende jeder Runde dürfen alle Spieler miteinander diskutieren und wählen, wer vom Spiel ausgeschlossen werden muss. Das Ziel der Citizen ist es, alle presentation und alle Mr White vom Spiel zu entfernen.
Das Gewinn sichern sich die Mr White, wenn sie - *als sie ausgeschlossen werden* - das Wort der Citizen erraten.
Die presentation gewinnen, wenn nur noch presentation spielen und alle anderen ausgeschlossen wurden.


**So verläuft das Spiel:**

Als erstes darf jeder sein Nickname eingeben. Dabei werden im Hintergrund vom Programm die Rollen willkürlich zugewiesen.
Am Anfang des Spiels bekommt jeder Spieler ein Wort (oder nicht!), dann darf das Spiel beginnen.
Das Programm besagt, wer anfangen soll. Diese Person spricht dann als erstes, die nächste Person ist diejenige rechts davon usw.

***Achtung**: Es darf kein Wort mehrmals eingegeben werden.*

Wenn jeder gesprochen hat und sein Wort im Programm eingegeben hat, ist die Runde zu Ende. Die Wahl beginnt.
Die Spieler wissen anfangs nicht mit wem sie zusammenarbeiten müssen, alle diskutieren und entscheiden, wer entlassen wird.
Den Namen der ausgeschlossenen Person wird im Computer eingetippt, seine Rolle wird bekannt gegeben. 

Solange keines der untenstehenden Ereignisse vorkommt, geht es in der nächsten Runde mit derselben Vorgehensweise.

**Ende des Spiels:**
- Citizen gewinnen, wenn es nur noch Citizen gibt. (es wird anfangs bekannt gegeben, wie viel presentation und Mr White im Spiel sind)
- presentation gewinnen, wenn es nur noch presentation gibt.
- Mr White gewinnen, wenn sie das Wort der Citizen erraten. Dies darf nur geschehen, nachdem sie ausgeschlossen wurden.

### Visuelle Darstellung des Spielvorgangs:
![Bild Das Spiel](https://github.com/MatisGourdes/Project-undercover-2020/blob/master/Documentation/Undercover_mindmap.png?raw=true)

## 4. Timeline
| Sprint | Zeit | Deadline | Arbeit |
|----------|---------------------|----------------|--------------------|
| Sprint 0 | 02.11.2020 - 20.11.2020 | 20.11.2020 | Review mit Demo, Retrospektive, Planning 1 und 2 |
| Sprint 1 | 20.11.2020 - 04.12.2020 | 04.12.2020 | Umsetzung MVP |
| Sprint 2 | 04.12.2020 - 15.12.2020 | 15.12.2020 | Umsetzung Ausbaustufen |

## 5. User Stories
Priorisierung:  1 = Basis‐Merkmal
                2 = Leistungs‐Merkmal
                3 = Begeisterungs‐Merkmal
                
| Name | User Story | Priorisierung | Story Points | Akzeptanzkriterium (DoD)|
|:----------:|:---------------------:|:---------------:|:---------:|:-----:|
| 1. *Spiel Regeln erklären* | Als Spieler möchte ich die Spiel Regeln sehen können. Wenn ich auf den Hauptmenü bin. | 2 | 2 Stunden | Die Spiel Regeln sind verfügbar |
| 2. *Hauptmenü Seite* | Als Spieler möchte ich ein Hauptmenü haben, damit ich das Spiel starten kann. | 1 | 3 Stunden | Vom Hauptmenü den Spiel starten können |
| 3. *Mitspielerzahl wählen* | Als Spieler, möchte ich die Anzahl  Spieler und den Namen jedes Mitspielers einstellen können, um eine Runde zu erstellen. | 2 | 4 Stunden | Von 4 bis 8 Spieler einstellen können |
| 4. *Rolle zuteilen* | Als Spieler möchte ich eine Rolle zugewiesen werden (ohne es zu wissen), um eine Runde spielen zu können. | 1 | 5 Stunden | Jede Spieler kriegt eine Rolle |
| 5. *Einleitung* | Als Spieler möchte ich wissen wer als nächstes dran kommt. Ich möchte auch dass der Computer erklärt an jeden Schritt was wir machen müssen. | 2 | 2 Stunden | Verständliche Anzeigen |
| 6. *Wörterverteilung* | Als Spieler möchte ich ein Wort empfangen, um eine Runde spielen zu können. | 1 | 5 Stunden | Jeder Spieler bekommt ein Wort |
| 7. *Wort eingeben* | Als Spieler möchte ich in jede runde ein Wort eingeben und dass er in einer Tabelle erscheint. | 3 | 4 Stunden | Textfeld + Anzeige |
| 8. *Wahl eine Person zu entfernen* | Als Spieler möchte ich die Möglichkeit haben an jede Runde ein anderen Spieler zu wählen um den Entfernen. | 1 | 5 Stunden | Eine Person kann entfernt sein |
| 9. *Wort raten* | Als Spieler(Mr White) möchte ich versuchen den Wort zu raten , wenn ich angeklagt wurde um eine Runde zu gewinnen. | 1 | 2 Stunden | Textfeld + Wort raten |
| 10. *Spiel ende* | Als Spieler möchte ich wissen wer gewonnen hat und wieder auf den Hauptmenü kommen. | 3 | 4 Stunden | Scene mit Resultat und Hauptmenü Taste |
| 11. *Verschiedene Wörter* | Als Spieler möchte ich jedes neuen Spiel ein anderes Wort, sodass ich mehrmals mit verschiedenen Wörter spielen kann. | 2 | 3 Stunden | Mehr als 30 verschiedene Wörter|

## 6. Build Anleitung
Git clone:  https://github.com/MatisGourdes/Project-undercover-2020
In Git program: 
1. Speichern Sie Ihre src Datei von Ihrem Git Projekt auf Ihre Rechner.
2. Löschen Sie Ihre src Datei von Ihrem Git Projekt.
3. Fügen Sie die pom.xml Datei mit dem geeignete Initialisierung in das Git Projekt.
4. Fügen Sie die src Ordner von einem Maven Projekt in das Git Projekt.
5. Klicken Sie auf den rechten Maus Taste in "presentation": ->Configure ->Convert to Maven.
6. Fügen Sie Ihre eigene Package in das Ordner src/main/java.
7. Klicken Sie auf den rechten Maus Taste in "presentation": ->Run as ->Maven clean.
8. Klicken Sie auf den rechten Maus Taste in "presentation": ->Run as ->Maven install.
9. Prüfen Sie in das Ordner "target" ob Sie eine Datei .jar haben.

- Oder
- 1. Gehen sie auf unsere Github repository.
- 2. Speichern Sie die Datei auf Ihre Rechner.
- 3. Entpacken Sie die Datei und Setzen sie an den gewünschten Ort. 
- 4. Stellen Sie sicher, dass Sie eine javaFx Runtime-Umgebung haben.
- 5. Doppelklicken Sie auf den Datei Paket
- 6. Doppelklicken Sie auf  Undercoverlauncher.jar um den Software zu starten.



## 7. Das Programm
  Da die Natur des Endprodukts ein Spiel ist, hat die grafische Benutzeroberfläche (GUI) in unserem Programm vorherrschende Stellung. Damit das Projekt ein Erfolg ist, war es uns wichtig, dass die Spieler intuitiv mit unserer GUI interagieren können, damit sie für jeden verständlich ist und, dass das Spiel reibungslos verlaufen kann. Dementsprechend wurde viel Zeit darin investiert, diese GUI zu entwickeln mit SceneBuilder.

Für jede Szene wurde eine FXML-Datei mit SceneBuilder editiert, welche mit einem Hauptcontroller namens *Controller* verbunden wird. Dieser Controller ist im Kern unseres Programms, er bedient alle Funktionen des GUI und wechselt Szenen je nach dem, welcher Schritt als nächstes vorkommt. Ferner nimmt der Controller zugriff auf externe Informationen, wie den Konstruktor *Spieler* für die herstellung zusätzlicher Spielern, oder auf die Klasse *WortReserve* für das Auslesen der Wörter aus der .txt-Datei. Die Zuweisung der Rollen erfolgt auch extern, da die Funktionsweise etwa komplexer ist. Mehr Informationen dazu sind in der Dokumentation des Sprints 1 zu finden. Im Sprint 2 wurde die Klasse *Einstellungen* addiert, damit zusätzliche Wörter hinzugefügt werden können.

### 7.1 Übersicht der Struktur des Programms
### 7.2 Ausführliches Klassendiagramm (latest update: release_v1.0_MVP)
![Diagramm Klassen](https://github.com/MatisGourdes/Project-undercover-2020/blob/release_v1.0_MVP/Documentation/Klassendiagramm%20MVP.png)


## 8. Documentation Sprint 1
### 8.1 Taskliste der User Stories 

| 20.11.2020 - 04.12.2020 | Task | User Story | Zeitaufwandschätzung |
|:---------:|:------------:|:------------:|:---------:|
| Task 1 | Rahmen Hauptmenü | User Story 2 | 1 Stunde |
| Task 2 | Javafx Seite Hauptmenü | User Story 2 | 2 Stunde |
| Task 3 | Klasse Rollen | User Story 4 | 3 Stunden |
| Task 4 | Zuweisung der Rolle zu ein Spieler | User Story 4 | 2 Stunden |
| Task 5 | Javafx Jeder Spieler kriegt ein Wort | User Story 6 | 2 Stunden |
| Task 6 | Programm um Wörter Austeilen | User Story 6 | 3 Stunden |
| Task 7 | Auswahl ein Spieler zu entfernen(javafx) | User Story 8 | 2 Stunden |
| Task 8 | Programm um eine Person zu Entfernen | User Story 8 | 3 Stunden |
| Task 9 | Mr White will Wort eingeben (javafx) | User Story 9 | 1 Stunde |
| Task 10 | Mr White gewinnt oder Spiel geht weiter | User Story 9 | 1 Stunde |

*Velocity: 20 Std*

Task 1: Ein controller muss erstellt werden. Er soll den Start des Spiels ermöglichen und zu den Regeln führen, wenn die Spieler es wollen.

Task 2: Ein fxml-datei soll erstellt werden, um den Spiel vor zu stellen. Er soll mit dem Controller verbunden sein.

Task 3: Die Klasse RolleZuweisung soll erstellt werden, um zu jede Spieler eine Rolle zufällig zuweisen, d.h. entweder MrWhite, Undercover oder Citizen. 

Task 4: In Abhängigkeit von den Spielerzhal soll mehr oder weniger MrWhite erstellt werden (zwischen 0 und 4 MrWhite). Es soll immer mehr Citizen als Undercover und MrWhite geben.

Task 5: Ein fxml-datei soll erstellt werden, um zu jeder Spieler sein Wort zu teilen. Die Mitspielern sollen nicht das Wort von den ander sehen.

Task 6: Eine klasse soll erstellt werden und mit dem fxml der 5. Task verbunden sein. In diese Klasse soll zufällig zwei Wörter, die Synonyme sind, wählen (ein für die Undercover und den anderen für die Citizen. Nur Citizen und UNdercover sollen einen Wort empfangen.

Task 7: Ein fxml-datei soll erstellt werden, um ein Spieler zu entfernen. Eine Liste mit allen lebendigen Spieler soll gezeigt werden. Der Name des Spielers, der entfernt werden soll, muss in der Liste gewählt werden können.

Task 8: Hier soll der Status (tot oder lebendig) der Spieler geändert werden, wenn er von den anderen gewählt wurde. 

Task 9:  Ein fxml-datei soll erstellt werden, um zu den MrWhite die Chance geben, das Wort von den Citizen zu raten als er entfernt wurde.

Task 10: Hier muss getestet werden, ob der MrWhite das richtigen Wort erraten hat oder nicht. Wenn ja, hat MrWhite das Spiel gewonnen. Wenn nein soll den Spiel weiter laufen.

### 8.2 Klassendiagramm
![Klassendiagramm Sprint 1:](https://github.com/MatisGourdes/Project-undercover-2020/blob/release_v0.3_WortAusgabe%2BclassSpieler/Documentation/Klassendiagramm_sprint1.png)
### 8.3 Wichtige Code snippets
Wichtig ist es in unser Programm, dass die Zuweisung der Rollen zu jedem Spieler zufällig stattfindet. Ferner muss bei einem neuen Spiel die Zuweisung erneut stattfinden, damit die Spieler eine neue Rolle bekommen.
Diesbezüglich haben wir uns im Laufe dieses Sprints damit befasst, eine *Rollezuweisung* Klasse zu programmieren, die all diese Anforderungen berücksichtigt. Hier ein Überblick darauf:

    public static void randomRolle() {
        rolleVerteilung();
        //willkürliche Zuweisung der Rollen in Betrachtung auf Anfangsbedingungen
        while (zahlGeteilteteRolle < Controller.getSpielerListe().size()) {
            for (int j = 0; j < Controller.getSpielerListe().size(); j++) {
                if (Controller.getSpielerListe().elementAt(j).getRolle() == 4) {
                    rolle = (int) (Math.random() * variabelRandom);
                    if (rolle == 0 && zahlCitizen < citizen) {
                        zahlCitizen++;
                        Controller.getSpielerListe().elementAt(j).setRolle(rolle);
                        zahlGeteilteteRolle++;
                    } else if (rolle == 1 && zahlUndercover < undercover) {
                        zahlUndercover++;
                        Controller.getSpielerListe().elementAt(j).setRolle(rolle);
                        zahlGeteilteteRolle++;
                    } else if (rolle == 2 && zahlMrWhite < mrWhite) {
                        zahlMrWhite++;
                        Controller.getSpielerListe().elementAt(j).setRolle(rolle);
                        zahlGeteilteteRolle++;
                    }}}}}
    //Bestimmung der Anzahl von Citizen und presentation
    public static void rolleVerteilung() {
        zahlMrWhite();
        citizen = (int) ((Controller.getSpielerListe().size() - mrWhite) * 0.8);
        undercover = Controller.getSpielerListe().size() - mrWhite - citizen;
        System.out.println("Citizen: " + citizen + "  presentation: " + undercover + " MrWhite: " + mrWhite);
    }
    // Berechnung der Anzahl von Mr White bzg. der Anzahl Gesamtspieler
    public static void zahlMrWhite() {
        if(4<=Controller.getSpielerListe().size() &&  Controller.getSpielerListe().size()  <=6) {
            mrWhite = (int) (Math.random()*2);
        }
        else if (7<=Controller.getSpielerListe().size() &&  Controller.getSpielerListe().size()  <=10) {
            mrWhite = (int) (Math.random()*3);
        }
    }

### 8.4 Testfälle
Testfall #1: Überprüfung der korrekten Zuweisung der Rollen (Methode *Rollezuweisung* und Speicherung im Konstruktor *Spieler*):

    RolleZuweisung.randomRolle();
    assertNotSame(testSpieler.getRolle(), 4);
    
Testfall #2: Überprüfung der Ausschliessung eines Spielers (Status wird auf "false" gesetzt):

    testSpieler.setStatus(false);
    assertEquals(new Spieler(1, "Test", false, 4).getRolle(), testSpieler.getRolle());    
    
Testfall #3:
        
### 8.5 Fazit und Retrospektive
Alle Tasks wurden gemäss der Akzeptanzkriterien (*siehe 5. User Stories*) erfolgreich durchgesetzt und die wichtigsten Bestandteile des Spiels sind funktionsfähig. Das MVP konnte ohne grosse Hindernisse erstellt werden, selbst es wenn noch viel Raum für Verbesserungen gibt. Die Benutzeroberfläche ist noch primitiv und unklar, während das Programm selbst optimiert werden kann und die FXML-Bestandteile von den Java-Klassen noch getrennt werden müssen. Jedoch haben wir bereits einige Tasks vom Sprint 2 erledigt, wie zum Beispiel die Möglichkeit Wörter aus einer Text-Datei einzulesen bzw. in der Datei zu schreiben, weil es an diesem Zeitpunkt der Programmierung am sinnvollsten war.

Zur Umsetzung des Sprints 2 wurden bereits grundlegene Bausteine gelegt, dazu müssen meistens Optimierungen durchgeführt werden. Das Ziel für den 2. Sprint ist es, dass das Spiel einerseits reibungslos und intuitiv wirkt und andererseits, begeisterungs-Funktionalitäten zu implementieren, um die Erfahrung zu bessern.

## 9. Documentation Sprint 2
### 9.1 Taskliste der User Stories 
| 04.12.2020 - 15.12.2020 | Task | User Story | Zeitaufwandsschätzung |
|:---------:|:------------:|:------------:|:---------:|
| Task 11 | Regeln Schreiben | User Story 1 | 1/2 Stunde |
| Task 12 | MindMap machen für Github und Javafx | User Story 1 | 1/2 Stunde |
| Task 13 | Regeln auf den Hauptmenü implementieren | User Story 1 | 1 Stunde |
| Task 14 | Anzahl der Spieler ändern | User Story 3 | 2 Stunden |
| Task 15 | Task 14 Javafx implementierung auf den Hauptmenü | User Story 3 | 2 Stunden |
| Task 16 | Befehle/ Einleitungen in eine Klasse Schreiben | User Story 5 | 1 Stunde |
| Task 17 | Befehle in Javafx implementieren | User Story 5 | 1 Stunde |
| Task 18 | Vektor zur Speicherung und Ausgabe der Wörter | User Story 7 | 2 Stunden |
| Task 19 | Tabelle mit alle eingegebene Wörter (javafx) | User Story 7 | 2 Stunden |
| Task 20 | Javafx Spiel ende Seite | User Story 10 | 2 Stunden |
| Task 21 | Programm um zu anzeigen wer gewonnen hat | User Story 10 | 2 Stunden |
| Task 22 | Eine Wörter Liste machen | User Story 11 | 1 Stunde |
| Task 23 | Text datei einlesen um an Jede Runde ein anderes Wort zu haben | User Story 11 | 2 Stunde |

*Velocity: 19 Std*

### 9.2 Klassendiagramm
### 9.3 Wichtige Code-snippets
### 9.4 Testfälle
### 9.5 Fazit und Retrospektive
