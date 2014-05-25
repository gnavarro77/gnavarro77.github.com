---
layout: post
title: Jeu de conception
tags : [conception]
---

Je tire ce petit jeu de conception d'un exemple concr&#232;t 
auquel j'ai &#233;t&#233; confront&#233; sur un projet r&#233;cent.

# Besoin

De mani&#232;re tr&#232;s pratique, nous avons un volume **V** et nous voulons savoir &#224; combien 
de paquets correspond ce volume?

Nous disposons des trois types de paquets suivants :

- *petit* avec un volume maximum de 1 (**PVM**) litre
- *moyen* avec un volume maximum de 2 (**MVM**) litres
- *grand* avec un volume maximum de 5 (**GVM**) litres

, de la r&#232;gle de remplissage suivante :

- si **V** < **PVM** alors **1** *petit* paquet
- si **V** < **MVM** alors **1** *moyen* paquet
- si **V** < **GVM** alors **1** *grand* paquet
- si **V** >= **GVM** alors **1** *grand* paquet + calcule sur le volume restant **(V - GVM)**

et de la r&#232;gle, qui fait tout l'int&#232;r&#234;t du jeu, suivante :

- si **cas 1** alors je ne peux utiliser que des paquets *moyen* ou *grand*
- si **cas 2** alors je peux utiliser n'importe quel type de paquet

# Conception

Nous allons commencer par cr&#233;er une *interface* qui aura pour responsablit&#233; 
de r&#233;soudre le nombre et le type de paquets pour un volume donn&#233;.

{% highlight php linenos %}
{% include emballe-c-est-pese/src/PackageDistributionResolver.php %}
{% endhighlight %}