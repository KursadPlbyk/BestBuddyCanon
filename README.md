# Canon Best Buddy

## Die Herausforderung
Fotografie gehört zu deinem Leben und die Kamera ist dein ständiger Begleiter. Aber Du bist nicht immer zufrieden mit Deinen Ergebnissen. Manchmal sind die Füße abgeschnitten, manchmal der Kopf. Bei Gruppenaufnahmen bei der letzten Hochzeit waren zwei Personen versehentlich nicht mit im Bild, was zu Ärger im Nachhinein führte. Die atemberaubende Landschaft wurde nicht so fotografiert, dass die Stimmung eingefangen wurde – etwas stimmte mit der Bildgestaltung nicht. Und bei dem Foto von der Sehenswürdigkeit waren so viele Touristen mit im Bild, dass sie wirklich störten. Irgendwie bräuchtest Du also Hilfe. Kann die Kamera dir nicht zur Seite stehen, wie ein Best Buddy, mit Hilfestellungen und Ideen?

## Die Aufgabe
Entwirf ein Tool, dass dich unterwegs bei deinen Aufnahmen unterstützt, das Fehler vermeiden hilft, dich auf neue Ideen bringt und dich in deiner Fotografie coacht. Nicht wie ein langweiliges Buch zum Nachschlagen, was man sowieso nicht dabeihat. Es unterstützt dich live, bei deinen eigenen Bildideen vor Ort.

## Unsere Lösung
Mit Hilfe des ML Kit von Google ist es uns gelungen innerhalb von 24 Stunden eine App zu entwickeln, die den Fotograf in drei Modi untsertützt. 
Im Porträt-Modus wird das Gesicht erkannt und die Entfernung zum Objekt abgeschätzt. Der Nutzer wird so hingewiesen, dass das Gesicht den Großteil des Fotos einnimmt, aber keine Teile des Gesichts abgeschnitten werden. 

<img src=""/>

Für Ganzkörperbilder erkennt der Best Buddy die Pose und weist den Fotograf hin, falls der ganze Körper von Kopf bis Fuß nicht auf dem Foto ist. Des weiteren wird zur Besserung der Bildgestaltung erkannt, ob die Komposition der "Rule of Thirds" entspricht. 

<img src""/>
