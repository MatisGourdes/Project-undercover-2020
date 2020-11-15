# Project-undercover-2020

Team: Theo Portmann, Michael Schaetzel, Lucas Lagel, Maxime Roellinger, Gourdes Matis

## Inhaltsverzeichnis:

1. [Abstrakt](https://github.com/MatisGourdes/Project-undercover-2020#1-abstrakt)

2. [Das Spiel](https://github.com/MatisGourdes/Project-undercover-2020#2-das-spiel)

3. [Anforderungen](https://github.com/MatisGourdes/Project-undercover-2020#3-anforderungen)

4. [Timeline](https://github.com/MatisGourdes/Project-undercover-2020#4-timeline)

5. [Diagramm Klassen](https://github.com/MatisGourdes/Project-undercover-2020#5-diagramm-klassen) 

6. [User Stories](https://github.com/MatisGourdes/Project-undercover-2020#6-user-stories)

7. [Dokumentation Sprint 1](https://github.com/MatisGourdes/Project-undercover-2020#7-documentation-sprint-1)
- [Taskliste der User Stories](https://github.com/MatisGourdes/Project-undercover-2020#--taskliste-der-user-stories)
- [Anreicherung der User Stories]()
- [UML Package, Klassen- und Sequenzdiagramme]()
- [Dokumentation wichtiger Code Snippets]()
- [Testfaelle bedingt durch Aktzeptanzkriterium]()

8. [Dokumentatin Sprint 2](https://github.com/MatisGourdes/Project-undercover-2020#8-documentation-sprint-2)
- [Taskliste der User Stories (mit Schätzung)]()
- [Anreicherung der User Stories]()
- [UML Package, Klassen- und Sequenzdiagramme]()
- [Dokumentation wichtiger Code Snippets]()
- [Testfaelle bedingt durch Aktzeptanzkriterium]()

## 1. Abstrakt
Im Rahmen des Moduls SWE und Informatik II entwickeln die Studierenden eine etwas komplexere Software, um den zuvor gelernten Stoff durch die Implementierung einer lauffähigen Applikation zu vertieften. Dabei wird die Komplexität der Applikation abgestimmt auf die individuellen Vorkenntnisse der Studierenden.

## 2. Das Spiel

Undercover ist ein Multiplayer-Spiel, bei welchem jedem Spieler einer der folgenden Rollen zugewiesen wird:

- "**Citizen**" : der Spieler bekommt ein Wort, das auch die anderen Citizen bekommen. 
- "**Undercover**" : der Undercover bekommt auch ein Wort, welches aber ein Synonym des Worts der Citizen.
- "**Mr White**" : bekommt kein Wort. Der Mr White muss das Wort der Citizen erraten und versuchen, sich in die Masse zu verbergen.


Bemerkenswert können sich Citizen und Undercover voneinander nicht unterscheiden; sie haben zwar ein Wort bekommen, wissen aber nicht ob es das zu erratende Wort ist.
Jeder Spieler wird nacheinander ein Synonym seines Worts geben, hier müssen die Mr White ein Wort finden, welches sich daran genug annähert, damit die anderen nicht erraten, dass sie keine Wörter bekommen haben. 
Am Ende jeder Runde dürfen alle Spieler miteinander diskutieren und wählen, wer vom Spiel ausgeschlossen werden muss. Das Ziel der Citizen ist es, alle Undercover und alle Mr White vom Spiel zu entfernen.
Das Gewinn sichern sich die Mr White, wenn sie - *als sie ausgeschlossen werden* - das Wort der Citizen erraten.
Die Undercover gewinnen, wenn nur noch Undercover spielen und alle anderen ausgeschlossen wurden.


**So verläuft das Spiel:**

Als erstes darf jeder sein Nickname eingeben. Dabei werden im Hintergrund vom Programm die Rollen willkürlich zugewiesen.
Am Anfang des Spiels bekommt jeder Spieler ein Wort (oder nicht!), dann darf das Spiel beginnen.
Das Programm besagt, wer anfangen soll. Diese Person spricht dann als erstes, die nächste Person ist diejenige rechts davon usw.

***Achtung**: Es darf kein Wort mehrmals eingegeben werden.*

Wenn jeder gesprochen hat und sein Wort im Programm eingegeben hat ist die Runde zu Ende. Die Wahl beginnt.
Die Spieler wissen anfangs nicht mit wem sie zusammenarbeiten müssen, alle diskutieren und entscheiden, wer entlassen wird.
Den Namen der ausgeschlossenen Person wird im Komputer eingetippt, seine Rolle wird bekanntgegeben. 

Solange keines der untenstehenden Ereignisse vorkommt, geht es in der nächsten Runde mit der selben Vorgehensweise.

**Ende des Spiels:**
- Citizen gewinnen, wenn es nur noch Citizen gibt. (es wird anfangs bekanntgegeben, wieviel Undercover und Mr White im Spiel sind)
- Undercover gewinnen, wenn es nur noch Undercover gibt.
- Mr White gewinnen, wenn sie das Wort der Citizen erraten. Dies darf nur geschehen, nachdem sie ausgeschlossen wurden.

### Visuelle Darstellung des Spielvorgangs:
![Bild Das Spiel](https://github.com/MatisGourdes/Project-undercover-2020/blob/master/Documentation/Undercover_mindmap.png?raw=true)

## 3. Einleitung
###Anforderung
Programmiersprache: Java

Test Coverage mit Unit Tests: Normal mindestens 70%, für diese Aufgabe 50% ist genügend

Blackbox Testing: Manuell mit Testfällen und Protokoll

Source Code Management: GitHub

Git-Workflow: Vincent Driessen

Build Automation: Maven oder Gradle

Vorgehensmodell: Scrum Anforderungen:

Epic und User Stories mit Akzeptanzkriterien Aufwandschätzung: Story Points für User Stories und Stundenschätzung pro Sprint und Task

Planung: Langfristige Planung mit Releaseplan, kurzfristige Planung pro Sprint

Design Artefakte: UML – Unified Modelling Language (z.B draw.io)
### Randbedingungen
- Die Programmierung der Anwendung soll in JAVA erfolgen.
- Die Klassen des Programms sollen über die entsprechenden Unit-Tests verfügen.
- Das Projekt soll auf GitHub veröffentlich werden.
- Die Buildautomatisierung soll mit MAVEN erfolgen.
- Das Programm soll mittels einer dafür erstellten JAR-Datei und dem Befehl java-jar xxxxx.jar ausgeführt werden können.

## 4. Timeline
| Sprint | Zeit | Deadline | Arbeit |
|----------|---------------------|----------------|--------------------|
| Sprint 0 | 02.11.2020 - 20.11.2020 | 20.11.2020 | Review mit Demo, Retrospektive, Planning 1 und 2 |
| Sprint 1 | 20.11.2020 - 04.12.2020 | 04.12.2020 | Umsetzung MVP |
| Sprint 2 | 04.12.2020 - 15.12.2020 | 15.12.2020 | Umsetzung Ausbaustufen |

## 5. Build Anleitung
Git clone:  https://github.com/MatisGourdes/Project-undercover-2020
In Git program: 
1. Speichern Sie Ihre src Datei von Ihre Git Projekt auf Ihre Rechner.
2. Löschen Sie Ihre src Datei von Ihre Git Projekt.
3. Fügen Sie die pom.xml Datei mit die geeignete Initialiesierung in das Git Projekt.
4. Fügen Sie die src Ordner von einen Maven Projekt in das Git Projekt.
5. Klicken Sie auf den rechten Maus Taste in "trinat-EBAE": ->Configure ->Convert to Maven.
6. Fügen Sie Ihre eigene Package in das Ordner src/main/java.
7. Klicken Sie auf den rechten Maus Taste in "trinat-EBAE": ->Run as ->Maven clean.
8. Klicken Sie auf den rechten Maus Taste in "trinat-EBAE": ->Run as ->Maven install.
9. Prüfen Sie in das Ordner "target" ob Sie eine Datei .jar haben.

## 6. User Stories
Priorisierung:  1 = Basis‐Merkmal Priorität 
                2 = Leistungs‐Merkmal Priorität
                3 = Begeisterungs‐Merkmal Priorität
                
| Name | User Story | Priorisierung | Story Points | Akzeptanzkriterium |
|:----------:|:---------------------:|:---------------:|:---------:|:-----:|
| 1. *Spiel Regeln erklären* | Als Spieler möchte ich die Spiel Regeln sehen können. Wenn ich auf den Hauptmenü bin. | 3 | 2 Stunden | |
| 2. *Hauptmenü Seite* | Als Spieler möchte ich ein Hauptmenü haben, damit ich das Spiel starten kann. | 1 | 3 Stunden | |
| 3. *Mitspielerzahl wählen* | Als Spieler, möchte ich die Anzahl  Spieler und den Namen jedes Mitspielers einstellen können, um eine Runde zu erstellen. | 2 | 4 Stunden | |
| 4. *Rolle zuteilen* | Als Spieler möchte ich eine Rolle zugewiesen werden (ohne es zu wissen), um eine Runde spielen zu können. | 1 | 5 Stunden | |
| 5. *Einleitung* | Als Spieler möchte ich wissen wer als nächstes dran kommt. Ich möchte auch dass der Komputer erklärt an jeden Schritt was wir machen müssen. | 2 | 2 Stunden | |
| 6. *Wörterverteilung* | Als Spieler möchte ich ein Wort empfangen, um eine Runde spielen zu können. | 1 | 5 Stunden | |
| 7. *Wort eingeben* | Als Spieler möchte ich in jede runde ein Wort eingeben und dass er in einer Tabeller erscheint. | 3 | 4 Stunden | |
| 8. *Wahl eine Person zu entfernen* | Als Spieler möchte ich die Möglichkeit haben an jede Runde ein anderen Spieler zu wählen um den Entfernen. | 1 | 5 Stunden | |
| 9. *Wort raten* | Als Spieler(Mr White) möchte ich versuchen den Wort zu raten , wenn ich angeklagt wurde um eine Runde zu gewinnen. | 1 | 2 Stunden | |
| 10. *Spiel ende* | Als Spieler möchte ich wissen wer gewonnen hat und wieder auf den Hauptmenü kommen. | 3 | 4 Stunden | |
| 11. *Verschiedene Worter* | Als Spieler möchte ich jedes neuen Spiel ein anderes Wort, sodass ich mehrmals mit verschiedenen Wörter spielen kann. | 2 | 3 Stunden | |

### Diagramm von alle Klassen
![Diagramm Klassen](https://github.com/MatisGourdes/Project-undercover-2020/blob/master/Documentation/KlassenDiagramm.png)


## 7. Documentation Sprint 1
### - Taskliste der User Stories 

|  | Task | User Story |
|:---------:|:------------:|:------------:|
| Task 1 | Rahmen Hauptmenü | User Story 2 |
| Task 2 | Javafx Seite Hauptmenü | User Story 2 |
| Task 3 | Klasse Rollen | User Story 2 |
| Task 4 | Zuweisung der Rolle zu ein Spieler | User Story 4 |
| Task 5 | Javafx Jeder Spieler kriegt ein Wort | User Story 6 |
| Task 6 | Programm um Wörte Austeilen | User Story 6 |
| Task 7 | Auswahl ein Spieler zu entfernen(javafx) | User Story 8 |
| Task 8 | Programm um eine personn zu Entfernen | User Story 8 |
| Task 9 | Mr White will Wort eingeben (javafx) | User Story 8 |
| Task 10 | Programm und verschiedene möglichkeiten für Mr White | User Story 8 |

## 8. Documentation Sprint 2

