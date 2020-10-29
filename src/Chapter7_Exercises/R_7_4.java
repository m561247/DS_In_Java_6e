package Chapter7_Exercises;

/**
 * Give a justification of the running times shown in Table 7.1 for the methods
 * of an array list implemented with a (nonexpanding) array.
 */
public class R_7_4 {
//  size() O(1): executa em tempo contante, pois ele retorna o valor armazenado em apenas uma variavel.

//  isEmpty() O(1): executa em tempo constante, pois faz apenas comparação do valor armazenado pela variavel size.

//  get(i) O(1): executa em tempo constante, pois tem apenas o custo de checar o indice se esta em um intervalo valido e acessar esse indice retonando o objeto armazenado.

//  set(i, e) O(1): executa em tempo constante, checar se o indice é valido, armazenar o objeto em uma variavel local,
//  trocar o objeto atual pelo novo recebido pelo paramentro do metodo e retornar o objeto antigo. Todas essas operações cutam tempo O(1).

//  add(i, e) O(n): executa em tempo linear, pois na implementacao em Array, adicionar um elemento em determinado indice, voce precisa de um laço que deslocara
//  todos os elementos n casas à direita para abrir espaço para o elemento a ser inserido.

//  remove(i) O(n) executa em tempo linear, segue o mesmo principio do metodo add(i, e), pois ao remover um determinado elemento
//  o laço deslocará n casas a esquerda para tampar o buraco no array que ficou apos o elemento ser removido.
}
