# NaveRovers

Al llegar a la atmósfera de Marte la nave sufre un problema técnico y las familias deben eyectarse en
unos pods, que aterrizarán aleatoriamente en un sistema de rutas que un equipo explorador había
demarcado, compuesto de nodos y las distancias en KM entre ellos:
Cada pod tiene la funcionalidad de rover, pero con un límite de oxígeno, el cual corresponde a 100. Cada
persona sobreviviente de los pods consume un total de 2 de oxígeno por Kilómetro. La misión de cada
familia es llegar al Nodo #6, que es donde se encuentra la base.
Implementar un algoritmo que nos dé la siguiente información:
- Nodo en el que aterrizó cada familia sobreviviente.
- Razón de muerte de una familia, si es posible.
- Recorrido que hizo cada rover para llegar a la base o el último punto al que llegó antes de
quedarse sin oxígeno.
- Cantidad de rovers que lograron llegar, la cantidad de miembros de cada uno y el nombre de sus
tripulantes.
- Cantidad de rovers que no llegaron, cantidad de miembros y sus nombres (fallecidos)
Consideraciones:
- Si una familia no tiene sobrevivientes, obviamente no aterrizará en ningún pod.
- Las rutas son estrictas y si un nodo no obtiene comunicación dirigida la familia morirá.
- El nodo de la base es el #6.
