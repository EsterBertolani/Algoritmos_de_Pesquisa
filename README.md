# Algoritmos_de_Pesquisa
Trabalho C2 da matéria Pesquisa e Ordenação

Desenvolver uma aplicação em Java que funcione através de um menu interativo, oferecendo ao
usuário as seguintes funcionalidades:

## Parte 1: Preparação e Análise dos Dados (1,0 ponto)
### 1. [0,5 ponto] Gerenciar Vetor:
o Criar Vetor: O usuário informa o tamanho desejado e o programa preenche o vetor
com números inteiros aleatórios.
o Carregar de Arquivo: O programa lê números inteiros de um arquivo de texto (.txt) e
os carrega para o vetor.

### 2. [0,5 ponto] Análise do Vetor:
o Encontrar Maior e Menor Valor: Percorre o vetor e exibe qual é o maior e o menor
número presente nele.
o Calcular a Moda: Identifica e exibe o número que mais se repete no vetor (a moda
estatística).

## Parte 2: Algoritmos de Pesquisa (2,5 pontos)
O usuário deverá informar um valor para ser buscado no vetor, e o programa oferecerá os seguintes
algoritmos:
### 3. [0,5 ponto] Pesquisa Sequencial Simples: 
Implementa a busca sequencial padrão. O programa
deve informar a posição do elemento, se encontrado, ou uma mensagem de "não encontrado".
### 4. [0,5 ponto] Pesquisa Sequencial Otimizada: 
Uma versão melhorada da pesquisa sequencial que funciona em um vetor ordenado. A busca deve parar assim que encontrar um elemento
maior que o valor procurado.
o Observação: Lembre-se de ordenar o vetor antes de executar esta busca!
### 5. [0,5 ponto] Pesquisa Binária: 
Implementa a busca binária. Assim como na anterior, o vetor
precisa estar ordenado para que o algoritmo funcione.
### 6. [1,0 ponto] Pesquisa com Hashing (Tabela de Dispersão):
o Implemente uma estrutura de dados baseada em Hashing para armazenar os elementos
do vetor.
o Escolha e implemente uma função de hash (ex: método da divisão) para mapear os
valores.
o Implemente um método para tratar colisões (ex: encadeamento ou endereçamento
aberto).
o Realize a busca de um valor usando a tabela de hash criada.

## Parte 3: Análise de Desempenho (0,5 ponto)
### 7. [0,5 ponto] Comparar Desempenho:
o O usuário escolhe um valor para ser buscado.
o O programa executa a Pesquisa Sequencial Simples e a Pesquisa Binária para o
mesmo valor, medindo o tempo de execução e/ou o número de comparações de cada
uma.
o Ao final, exiba um relatório comparativo simples mostrando qual foi mais eficiente.

## Requisitos:
• Organização do Código: O projeto deve ser modular, ou seja, dividido em classes e métodos
que separem as responsabilidades (ex: uma classe para os algoritmos, uma classe principal com
o menu, etc.).
• Tratamento de Erros: A aplicação deve ser robusta, utilizando try-catch para lidar com
possíveis erros, como arquivos não encontrados (FileNotFoundException) ou entradas
inválidas do usuário (ex: digitar texto em vez de número).
• Escalabilidade: Seu código deve funcionar eficientemente mesmo com vetores grandes (teste
com pelo menos 10.000 elementos para ver a diferença de desempenho!).
• Comentários: Adicione comentários em partes importantes do seu código para explicar o que
cada método faz e as decisões que você tomou
