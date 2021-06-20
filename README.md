# Poker-ACH2003-04

Exercício de Computação Orientada a Objeto da turma ACH2003-04, ministrada pelo Professor Marcelo Chaim.<br>

## Instruções e Observações

Sintam-se livres para editar e adicionar qualquer classe e método que acharem necessário.<br>

Os métodos que devem ser criados estão na parte de "Issues". Nessas Issues, tem comentários com sugesões de implementação, mas vocês não precisam seguí-las, vocês estão livres para implementar esse programa do jeito que quiserem.

MAS É IMPORTANTE EXPLICAR O FUNCIONAMENTO DOS MÉTODOS ATRAVÉS DE COMENTÁRIOS E DA DOCUMENTAÇÃO.

OBS: Escrever uma boa documentação no README conta como contribuição ;)
Então não deixem de registrar como o programa funciona.

No final desse README tem uma sessão "Contribuidores" para vocês se registrarem.

## Explicação das classes

### Card

Carta possui dois atributos: seu valor (rank) e seu naipe (suit).

### Player

Jogador possui dois atributos: Array de Cards e um valor indicando o quão alta sua mão é

### Table

Possui três atributos:

- Array de Players
- Valor inteiro highHandIndex
- Array final de Strings da Classe hands com a sequência ordenada do maior para o menor das possíveis mãos do poker

Os métodos são:

- defineHand chama os métodos que identificam cada uma das mãos do poker
- isRoyalFlush, isStraightFlush, isFourKind, isFullHouse, isFlush, isStraight, isThreeKind, isTwoPair, isPair
- individualTest imprime as 5 cartas testadas e a sua respectiva classificação
- sortCards é o método que ordena da maior carta para a menor carta. Ela utiliza o algoritmo Quicksort. Para isso ela utiliza os métodos:
  - Quicksort, trocaValorEntreCards, particiona

## Contribuidores

<b> Escreva aqui seu nome, NUSP e usuário do Github </b>

- Felipe Furquim - 11208030 - FvFurquim
- Fábio Yamada - 5690619 - fabioheiji
- Silas Bovolin Reis  - 11796739 - SilasReisUSP
- Felipe Oliveira - 11925242 - felipeoes
