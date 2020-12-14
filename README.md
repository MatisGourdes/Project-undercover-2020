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
- [7.1 Übersicht der Struktur](https://github.com/MatisGourdes/Project-undercover-2020#71-%C3%BCbersicht-der-struktur-des-programms)
- [7.2 Ausführliches Klassendiagramm](https://github.com/MatisGourdes/Project-undercover-2020#72-ausf%C3%BChrliches-klassendiagramm)
- [7.3 Sequenzdiagramm](https://github.com/MatisGourdes/Project-undercover-2020#73-sequenz-diagramm)
- [7.4 Package-Diagramm](https://github.com/MatisGourdes/Project-undercover-2020#74-package-diagramm)

8. [Dokumentation Sprint 1](https://github.com/MatisGourdes/Project-undercover-2020#8-documentation-sprint-1)
- [8.1 Taskliste der User Stories](https://github.com/MatisGourdes/Project-undercover-2020#81-taskliste-der-user-stories)
- [8.2 Klassendiagramm](https://github.com/MatisGourdes/Project-undercover-2020#82-klassendiagramm)
- [8.3 Wichtige Code-Snippets](https://github.com/MatisGourdes/Project-undercover-2020#83-wichtige-code-snippets)
- [8.4 Testfälle](https://github.com/MatisGourdes/Project-undercover-2020#84-testf%C3%A4lle)
- [8.5 Retrospektive](https://github.com/MatisGourdes/Project-undercover-2020#85-fazit-und-retrospektive)

9. [Dokumentation Sprint 2](https://github.com/MatisGourdes/Project-undercover-2020#9-documentation-sprint-2)
- [9.1 Taskliste der User Stories](https://github.com/MatisGourdes/Project-undercover-2020#91-taskliste-der-user-stories)
- [9.2 Klassendiagramm](https://github.com/MatisGourdes/Project-undercover-2020#92-klassendiagramm)
- [9.3 Wichtige Code-Snippets](https://github.com/MatisGourdes/Project-undercover-2020#93-wichtige-code-snippets)
- [9.4 Testfälle](https://github.com/MatisGourdes/Project-undercover-2020#94-testf%C3%A4lle)
- [9.5 Retrospektive](https://github.com/MatisGourdes/Project-undercover-2020#95-fazit-und-retrospektive)

## 1. Abstrakt
Unser Team besteht aus Mechatronik-Trinational Studierenden. Im Rahmen des Moduls SWE und Informatik II entwickeln wir eine etwas komplexere Software, um den zuvor gelernten Stoff durch die Implementierung einer lauffähigen Applikation zu vertiefen. Dabei wird die Komplexität der Applikation abgestimmt auf die individuellen Vorkenntnisse der Studierenden. 
Zeitspanne der Bearbeitung: Herbstsemester 2020.


## 2. Einleitung
### Ziele
Das Ziel mit diesem Projekt ist es, als Studierende, unsere Kenntnisse in Programmierung anzuwenden und als Team den Vincent-Driessen Workflow (mittels Jira und GitHub) auszuüben.
Demzufolge haben wir uns entschlossen, ein Spiel zu programmieren: Undercover.

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

Undercover ist ein Multiplayer-Spiel, bei welchem jedem Spieler einer der folgenden Rollen zugewiesen wird:

- "**Citizen**" : der Spieler bekommt ein Wort, das auch die anderen Citizen bekommen. 
- "**Undercover**" : der Undercover bekommt auch ein Wort, welches aber ein Synonym des Worts der Citizen.
- "**Mr White**" : bekommt kein Wort. Der Mr White muss das Wort der Citizen erraten und versuchen, sich in die Masse zu verbergen.


Bemerkenswert können sich Citizen und Undercover voneinander nicht unterscheiden; sie haben zwar ein Wort bekommen, wissen aber nicht, ob es das zu erratende Wort ist.
Jeder Spieler wird nacheinander ein Synonym seines Worts geben, hier müssen die Mr White ein Wort finden, welches sich daran genug annähert, damit die anderen nicht erraten, dass sie keine Wörter bekommen haben. 
Am Ende jeder Runde dürfen alle Spieler miteinander diskutieren und wählen, wer vom Spiel ausgeschlossen werden muss. Das Ziel der Citizen ist es, alle Undercover und alle Mr White vom Spiel zu entfernen.
Das Gewinn sichern sich die Mr White, wenn sie - *als sie ausgeschlossen werden* - das Wort der Citizen erraten.
Die Undercover gewinnen, wenn nur noch Undercover spielen und alle anderen ausgeschlossen wurden.


**So verläuft das Spiel:**

Als erstes darf jeder sein Nickname eingeben. Dabei werden im Hintergrund vom Programm die Rollen willkürlich zugewiesen.
Am Anfang des Spiels bekommt jeder Spieler ein Wort (oder nicht!), dann darf das Spiel beginnen.
Das Programm besagt, wer anfangen soll. Diese Person spricht dann als erstes, die nächste Person ist diejenige rechts davon usw.

***Achtung**: Es darf kein Wort mehrmals eingegeben werden.*

Wenn jeder gesprochen hat und sein Wort im Programm eingegeben hat, ist die Runde zu Ende. Die Wahl beginnt.
Die Spieler wissen anfangs nicht mit wem sie zusammenarbeiten müssen, alle diskutieren und entscheiden, wer entlassen wird.

Solange keines der untenstehenden Ereignisse vorkommt, geht es in der nächsten Runde mit derselben Vorgehensweise.

**Ende des Spiels:**
- Citizen gewinnen, wenn es nur noch Citizen gibt. (es wird anfangs bekannt gegeben, wie viel Undercover und Mr White im Spiel sind)
- Undercover gewinnen, wenn es nur noch Undercover gibt.
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
| 7. *Schönes Programm* | Als Spieler möchte ich dass der Programm angenehm ist und dass man schnell versteht wie es geht. | 3 | 4 Stunden | Ein css mit schöne farben und alles schön verständlich |
| 8. *Wahl eine Person zu entfernen* | Als Spieler möchte ich die Möglichkeit haben an jede Runde ein anderen Spieler zu wählen um den Entfernen. | 1 | 5 Stunden | Eine Person kann entfernt sein |
| 9. *Wort raten* | Als Spieler(Mr White) möchte ich versuchen den Wort zu raten , wenn ich angeklagt wurde um eine Runde zu gewinnen. | 1 | 2 Stunden | Textfeld + Wort raten |
| 10. *Spiel ende* | Als Spieler möchte ich wissen wer gewonnen hat und wieder auf den Hauptmenü kommen. | 3 | 4 Stunden | Scene mit Resultat und Hauptmenü Taste |
| 11. *Verschiedene Wörter* | Als Spieler möchte ich jedes neuen Spiel ein anderes Wort, sodass ich mehrmals mit verschiedenen Wörter spielen kann. | 2 | 3 Stunden | Mehr als 30 verschiedene Wörter|

## 6. Build Anleitung
Git clone:  https://github.com/MatisGourdes/Project-undercover-2020

#### In einem IDE (hier IntelliJ): 
1. Laden Sie den Master als Zip-Datei aus dem Repo herunter, entpacken Sie ihn.
2. In IntelliJ, klicken Sie auf *File* -> *New* -> *Project from existing Sources* und wählen Sie die entpackte Datei.
3. Wählen Sie *Import project from external model* und klicken Sie auf *Maven*. Bestätigen Sie mittels *Finish*.
4. Stellen Sie sicher, dass Ihre Umgebung auf Java 11 eingestellt ist.
5. Überprüfen Sie ob Sources, Tests und Resources korrekt anerkannt sind unter *Project Structure* -> *Modules*.
6. Im Terminal, lassen Sie folgenden Commands laufen:
    ```Javascript
    mvn clean compile
    mvn clean package
    java -jar /shade/Projekt-Undercover-2020.jar
    ```
Alternativ können Sie ein Pull-Request erstellen und dann in IntelliJ ein neues Projekt aus *Version Control* erstellen.

#### Das Spiel ohne IDE laufen lassen:
1. Laden Sie den Master als Zip-Datei herunter und entpacken Sie ihn.
2. Stellen Sie sicher, dass Sie auf Ihrem Rechner über eine aktuelle Version der Java-Umgebung verfügen.
3. Im Verzeichnis *shade* finden Sie die Datei **Undercover-Projekt-2020.jar**, die Sie starten können. Viel Spass !


## 7. Das Programm
  Da die Natur des Endprodukts ein Spiel ist, hat die grafische Benutzeroberfläche (GUI) in unserem Programm vorherrschende Stellung. Damit das Projekt ein Erfolg ist, war es uns wichtig, dass die Spieler intuitiv mit unserer GUI interagieren können, damit sie für jeden verständlich ist und, dass das Spiel reibungslos verlaufen kann. Dementsprechend wurde viel Zeit darin investiert, diese GUI mit SceneBuilder zu entwickeln.

Für jede Szene wurde eine FXML-Datei mit SceneBuilder editiert, welche mit einem zugehörigen Controller verbunden wird. Dieser Controller ist im Kern unseres Programms, er bedient alle Funktionen des GUI und wechselt Szenen je nach dem, welcher Schritt als nächstes vorkommt. Ferner nimmt der Controller zugriff auf externe Informationen, wie den Konstruktor *Spieler* für die herstellung zusätzlicher Spielern, oder auf die Klasse *WortReserve* für das Auslesen der Wörter aus der .txt-Datei. Die Zuweisung der Rollen erfolgt auch extern, da die Funktionsweise etwa komplexer ist. Mehr Informationen dazu sind in der Dokumentation des Sprints 1 zu finden. Im Sprint 2 wurde die Klasse *Einstellungen* addiert, damit zusätzliche Wörter hinzugefügt werden können.

### 7.1 Übersicht der Struktur des Programms
![Diagramm Klassen](https://github.com/MatisGourdes/Project-undercover-2020/blob/master/Documentation/KlassenDiagramm.png)
### 7.2 Ausführliches Klassendiagramm
*siehe 9.2* ![Dokumentation Sprint 2](https://github.com/MatisGourdes/Project-undercover-2020#9.2-Klassendiagramm)
### 7.3 Sequenz-Diagramm
![Diagramm Sequenz](https://github.com/MatisGourdes/Project-undercover-2020/blob/master/Documentation/Sequenzdiagramm.png)
### 7.4 Package-Diagramm
![Package-Diagramm](https://github.com/MatisGourdes/Project-undercover-2020/blob/master/Documentation/Package_Diagram.png)
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

Task 1: Ein Kontroller muss erstellt werden. Er soll den Start des Spiels ermöglichen und die Spielregeln anbieten.

Task 2: Eine fxml-Datei soll erstellt werden, um den Spiel vorzustellen. Er soll mit dem Kontroller verbunden sein.

Task 3: Die Klasse RolleZuweisung soll erstellt werden, um jeden Spieler eine Rolle zufällig zuzuweisen, d.h. entweder MrWhite, Undercover oder Citizen. 

Task 4: In Abhängigkeit von der Spieleranzahl soll mehr oder weniger MrWhite erstellt werden (zwischen 0 und 4 MrWhite). Es soll immer mehr Citizen als Undercover und MrWhite geben.

Task 5: Eine fxml-Datei soll erstellt werden, damit jeder Spieler sein zugehöriges Wort bekommt. Die Mitspielern sollen nicht das Wort von den Anderen sehen.

Task 6: Eine Klasse soll erstellt werden und mit der fxml-Datei der 5. Task verbunden sein. In diese Klasse sollen zwei synonyme Wörter zufällig ausgesucht werden (ein für die Undercover und ein wieteres für die Citizen). Nur Citizen und Undercover sollen ein Wort empfangen.

Task 7: Ein fxml-Datei soll erstellt werden, um ein Spieler zu entfernen. Eine Liste mit allen lebendigen Spieler soll gezeigt werden. Der Name des Spielers, der entfernt werden soll, muss in der Liste gewählt werden können.

Task 8: Hier soll der Status (tot oder lebendig) der Spielern geändert werden können, wenn er von den Anderen ausgeschlossen wurde. 

Task 9: Ein fxml-Datei soll erstellt werden, um den MrWhite die Chance zu geben, das Wort von den Citizen zu raten, als er entfernt wurde.

Task 10: Hier muss getestet werden, ob der MrWhite das richtig Wort erraten hat oder nicht. Wenn ja, hat MrWhite das Spiel gewonnen. Wenn nein, soll das Spiel weiter laufen.

### 8.2 Klassendiagramm
![Klassendiagramm Sprint 1:](https://github.com/MatisGourdes/Project-undercover-2020/blob/release_v0.3_WortAusgabe%2BclassSpieler/Documentation/Klassendiagramm_sprint1.png)
### 8.3 Wichtige Code snippets
Wichtig ist es in unser Programm, dass die Zuweisung der Rollen zu jedem Spieler zufällig stattfindet. Ferner muss bei einem neuen Spiel die Zuweisung erneut stattfinden, damit die Spieler eine neue Rolle bekommen.
Diesbezüglich haben wir uns im Laufe dieses Sprints damit befasst, eine *Rollezuweisung* Klasse zu programmieren, die all diese Anforderungen berücksichtigt. Hier ein Überblick darauf:
```Javascript
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
    //Bestimmung der Anzahl von Citizen und Undercover
    public static void rolleVerteilung() {
        zahlMrWhite();
        citizen = (int) ((Controller.getSpielerListe().size() - mrWhite) * 0.8);
        undercover = Controller.getSpielerListe().size() - mrWhite - citizen;
        System.out.println("Citizen: " + citizen + "  Undercover: " + undercover + " MrWhite: " + mrWhite);
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
```
### 8.4 Testfälle
Testfall #1: Überprüfung der korrekten Zuweisung der Rollen (Methode *Rollezuweisung* und Eintragung im Konstruktor *Spieler*):
```Javascript
    RolleZuweisung.randomRolle();
    assertNotSame(testSpieler.getRolle(), 4);
``` 
Testfall #2: Überprüfung der Ausschliessung eines Spielers (Status wird auf "false" gesetzt):
```Javascript
    testSpieler.setStatus(false);
    assertEquals(new Spieler(1, "Test", false, 4).getStatus(), testSpieler.getStatus());    
```    
        
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
| Task 18 | Ein css schreiben wo alle farben und Typographie definiert ist | User Story 7 | 2 Stunden |
| Task 19 | Alle Tasten und Tabellen organisieren + Photo hinzufügen | User Story 7 | 2 Stunden |
| Task 20 | Javafx Spiel ende Seite | User Story 10 | 2 Stunden |
| Task 21 | Programm um zu anzeigen wer gewonnen hat | User Story 10 | 2 Stunden |
| Task 22 | Eine Wörter Liste machen | User Story 11 | 1 Stunde |
| Task 23 | Text datei einlesen um an Jede Runde ein anderes Wort zu haben | User Story 11 | 2 Stunde |

*Velocity: 19 Std*

Task 11: Hier sollen die Spielregeln so deutlich wie möglich geschrieben werden.

Task 12: Weil die Regeln schwierig nachvollziehbar sind, haben wir beschlossen, dass ein Diagramm nützlich wäre, um den Verlauf des Spiels deutlicher zu machen. In dieser Task soll das Diagramm erstellt werden und soll in eine FXML-Datei und im Readme implementiert werden.

Task 13: Die Regeln sollen in eine FXML-Datei implementiert werden und mit dem Hauptmenü verbunden werden.

Task 14: Der Benutzer soll die Spieleranzahl ändern können von (minimum 4 Spieler).

Task 15: Die Task 14 soll mit einer FXML-Datei verbunden werden und dann auch mit dem Hauptmenü.

Task 16: Bei jeder Ansicht sollen Befehle erscheinen, damit die Vorgehensweise deutlich erklärt wird.

Task 17: Diese Befehle sollen mit javaFx implementiert werden.

Task 18: Eine CSS-Datei soll geschrieben werden, um den Spiel schöner und angenehmer zu machen.

Task 19: Bei jeder Szene müssen die *Label*, *Buttons* und *TableView* intuitiv gestaltet werden. Fotos sollen auch hingefügt werden.

Task 20: Am Ende des Spiels soll mithilfe einer FXML-Datei gezeigt werden, wer gewonnen hat und was waren die Rolle von jedem Spieler.

Task 21: Hier soll eine Funktion programmiert werden, um zu testen wer gewonnen hat.

Task 22: Eine Text-Datei mit den Wörter für Citizen und Undercover soll erstellt werden. Hier soll es auch die Möglichgkeit geben, Wörter in die Liste einzutragen.

Task 23: Jedes neues Spiel soll ein neues Wort in der Text-Datei eingelesen werden und Citizen und Undercover mitgeteilt werden.


### 9.2 Klassendiagramm
#### 9.2.1 Klassendiagramm Package domain:

![Klassendiagramm domain Sprint 2:](https://github.com/MatisGourdes/Project-undercover-2020/blob/master/Documentation/UML%20Diagramm%20Package%20domain%20.png)

#### 9.2.2 Klassendiagramm Package presentation:

![Klassendiagramm presentation Sprint 2:](https://github.com/MatisGourdes/Project-undercover-2020/blob/master/Documentation/UML%20Diagramm%20package%20presentation.png)

### 9.3 Wichtige Code-snippets

Eine der letzten User-Stories war die Möglichkeit für die Benutzer ihre eigene Wörter zur Liste zu addieren. Zu diesem Zweck mussten vorerst alle Wörter in einer .txt-Datei gespeichert werden, was im Sprint 1 erledigt wurde. Damit die hinzugefügte Wörter (für Citizen und Undercover) in einer TableView direkt angezeigt werden konnten, mussten sie in einem Konstruktor *Wort* gepeichert werden. Dieses begeisterungs-Merkmal ermöglicht eine unendliche Vielfalt von Wörter zu speichern und verlängert drastisch die Lebensdauer des Spiels.
```Javascript
        //speichert alle Wörter der txt-Datei in einem Vektor
        public static void readFile(){
            woerterListe.clear();
            System.out.println("file read, path: " + wortFilePath); //debug
    
            try (FileReader f = new FileReader(wortFilePath)) {
                char c[] = new char[10000];
                f.read(c);
                String s = new String(c);
                String[] result = s.split("\n|;");
    
                for (int i = 0; i < result.length; i++) {
                    if (!result[i].equals("") && result[i] != null){
                        woerterListe.add(result[i]);
                        f.close();
                    }
                }
            }
            catch (IOException e) {
                System.err.println("Fehler beim Einlesen der Datei.");
                System.err.println(e.getMessage());
            }
    
        }
        //Speichere das Wort in der Text-Datei
        public static void wortAddieren(String wortC,String wortU){
            try (FileWriter w = new FileWriter(wortFilePath, true)) {
                String eingabe = wortC + ";" + wortU + "\n";
                w.write(eingabe);
            }
            catch (IOException e) {
                System.err.println("Fehler beim Schreiben in der Datei.");
                System.err.println(e.getMessage());
            }
        }
```
### 9.4 Testfälle
#### 9.4.1 Black Box testing
![Wer bekommt ein Wort](https://github.com/MatisGourdes/Project-undercover-2020/blob/master/Documentation/WortVerteilung.PNG)

![Wer darf das Wort erraten:](https://github.com/MatisGourdes/Project-undercover-2020/blob/331f47478602a9f6dfc6661f5cc3b579cc945786/Documentation/WortRaten.PNG)
### 9.5 Fazit und Retrospektive
Die Priorität in diesem Sprint war das MVP so zu erweitern, dass das Spiel intuitiv und angenehm wirkt. Zu diesem Zweck wurden Zugang zu den Spielregeln eingebaut, die Möglichkeit der Spieleranzahl zu ändern eingeführt und im Laufe des Spiels konkrete Befehle gegeben. Eine CSS-Datei wurde erstellt, damit das Format der FXML-Dateien einheitlich definiert ist, gemäss der geplanten Tasks.
Schwierig war ein lauffähiges Package zu bekommen, da es eine .txt Datei mit den Wörter innerhalb des Verzeichnises des Users erstellt werden, falls nicht bereits vorhanden. Dabei waren sämtliche Unterschiede zwischen OS in Betrachtung zu nehmen, einerseits beim Überspringen einer Linie (hier wird einschliesslich ein *Line feed \n* hinzugefügt) und andererseits mit den Path, welches in Windows und MacOS unterschiedlich ist. Hier war die Nutzung der Funktion *File.separator* von grosser Hilfe. 

Zur Verbesserung bzw. Erweiterung der Erfahrung könnte beispielsweise ein Leaderboard eingeführt werden, in welchem die Sieger jeweils eingetragen werden könnten. Ausserdem könnte auch die Liste der Spieler bei einem neuen Spiel behalten werden, damit jeder nicht erneut sein Namen eingeben muss. 

Schlussendlich sind wir mit unserem Programm zufrieden, wir haben uns die verschiedenen Tools zur Umsetzung eingeeignet (Maven, SceneBuilder, GitHub, Jira, Confluence), und konnten gemäss der erstellten User Stories das MVP umsetzen. Ferner haben wir im Laufe dieses Projekts gelernt wie man unser Produkt beschreibt, sei es mit UML-Dateien (Klassen-, Package- und Sequenzdiagramme) oder im Readme, damit es für jeden übersichtlich und verständlich ist.
