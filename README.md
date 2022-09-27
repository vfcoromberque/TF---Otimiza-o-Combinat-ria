# TF-OtimizacaoCombinatoria
Heurística Tabu Aplicada ao Problema 3


Descrição busca Tabu:

• Permitir movimentos que pioram a solucao atual de maneira
determinıstica
• Para isso, mantem uma lista de movimentos proibidos, a lista
tabu
• Durante algumas iteracooes, o algoritmo nao pode realizar esses
movimentos
• Juntamente com os movimentos de piora, esse mecanismo
ajuda a sair de vales e chegar a novos otimos locais

• A lista tabu armazena movimentos que provavelmente nao
melhoram a solucao
• Exemplos de movimento:
  • No SAT, alterar uma variavel especıfica
  • No PCV, remover alguma aresta especıfica
• Geralmente coloca um movimento na lista tabu assim que ele e
feito na busca local
• A lista tabu muitas vezes tem tamanho fixo
  • Ao inserir um novo elemento, se a lista est´a cheia, retiramos o
mais antigo
• Duracao tabu / tabu tenure: numero de iteracoes que um
movimento continua tabu

• Um movimento tabu e um movimento que possui algum
componente na lista tabu
• PCV: se a aresta (u, v) esta na lista tabu, qualquer movimento
alterando (u, v) e tabu
• Movimentos tabu sao proibidos na busca local, apenas
movimentos nao-tabu sao considerados
• Ajuda a evitar que a busca volte a solucoes ja visitadas
• Permite piora, ajudando que a busca alcance novas regioes


Pseudo Código:

Input: Solucao inicial s
Output: Melhor solucao encontrada s∗

while nao atingiu o criterio de parada do
  Melhor vizinho s
0 ∈ N (s)
if movimento s − s
0 n˜ao ´e tabu then
s := s
0
end
if s ´e a melhor solu¸c˜ao at´e aqui then
s
∗
:= s
end
Atualiza lista tabu T com o movimento s − s
0
end
return s
∗

![image](https://user-images.githubusercontent.com/57137727/192568681-9d9244e0-cd7f-4f2c-a0db-f30026a3091e.png)


