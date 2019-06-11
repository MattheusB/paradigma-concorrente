## Explicação sobre a questão 1:

### CONTEXTUALIZAÇÃO:

Nessa questão foi passado um programa que usa de três threads para incrementar um contador compartilhado entre essas threads.
Foi exigido que existisse duas versões do programa: A versão que foi passada em que não há controle de concorrência nem exclusão mútua,
e uma segunda versão que fizesse uso de locks para manter um comportamento determinístico (em que é possível prever o resultado final, nesse caso o valor final do contador deve ser 30000000) implementando exclusão mútua no contador compartilhado.

Também foi pedido que fosse feita análise do desempenho das duas versões do programa, comparando-os e identificando métricas que indicassem a diferença entre eles.

### IMPLEMENTAÇÃO

O código passado pelo professor (semLOCKS.c) necessitou de pequenas alterações para que a exclusão mútua fosse adicionada como pode ser visto no código do arquivo comLOCKS.c, em que fizemos uso das funções lock e unlock fornecidos pela biblioteca pthread para coordenar o acesso a variável counter compartilhada entre as três threads, de forma a não perdermos nenhuma alteração dessa variável.

### ANÁLISE DO DESEMPENHO

Usamos a ferramenta *perf* para extrair métricas de desempenho da execução dos dois programas. O resultado geral retornado com o comando `perf stats` estão no arquivo [estatisticas.txt](./estatisticas.txt).
Algumas métricas indicam com mais firmeza a razão da diferença de desempenho entre os programas, uma delas é `context-switching` que indica a quantidade de armazenamento e recuperação do estado das threads quando elas saem e voltam do processador, respectivamente.
Para o programa com locks houveram 25 trocas de contexto enquanto que no programa sem locks houveram 99. Acreditamos que esta métrica é a que tem mais influência no resultado final, por sabermos que as trocas de contexto podem envolver muitas operações de leitura e escrita do estado das threads na memória e/ou no disco.

Outras duas métricas que divergem bastante entre os programas são: `task-clock (msec)` e `cycles`, em que no programa com locks o valor destas foi bem menor do que no programa sem o uso de locks, exibindo que o programa com locks exigiu menos esforço do processador do que o programa sem locks, mesmo os dois tendo gerado um número aproximadamente igual de instruções assembly.
