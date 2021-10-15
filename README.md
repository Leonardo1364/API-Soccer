# Mercado da Bola

![Arena](https://portoimagem.files.wordpress.com/2013/08/blog-grc3aamio-1903-c3a0-noite-a-arena-fica-ainda-mais-bela.jpg)

Segundo a [BBC](https://www.bbc.com/portuguese/geral-41240143), todos os anos, centenas de milhões de dólares são movimentados entre os clubes de futebol do mundo para a contratação de serviços de novos jogadores. A negociação entre os clubes e os jogadores se vale do interesse, momento e custos de ambos os lados. Sendo assim, nossa aplicação deve simular este processo, passando pelas etapas de consulta de interesse do atleta em jogar no clube em questão, avaliação do investimento necessário e a contratação do atleta.

## Classes

Modele uma solução na qual as principais classes são **Jogador** e **Clube**. O detalhamento de cada uma delas está específicado ao longo desta seção.

### Clube

O clube deve possuir atributos como: **nome**, **reputacao historica** e **saldo disponivel em caixa**.

### Jogador
O Jogador deve possuir atributos como: **nome**, **idade**, **clube atual**, **reputacao historica**, **apetite financeiro**, **preco**. Nenhum objeto pode ser do tipo jogador. Ao instaciar um jogador, o objeto deve ser de um dos tipos de especialização detalhados a seguir na sessão **Tipos de Jogador**.

_Regras de Negócio do Jogador_

RN01.: o jogador deve possuir um método que retorna o nome do clube que está atuando. Se o atleta estiver sem clube, deve retornar _Sem Clube_.

RN02: a reputação histórica do atleta deve estar em uma faixa de zero (baixa reputatação) à dez (alta reputação).

RN03: o apetite finaceiro do jogador deve ser, somente, de três tipos. São eles:

    1. INDIFERENTE: o valor da oferta deve ser de, no mínimo, o mesmo o valor do seu preço.
    
    2. CONSERVADOR: o valor da oferta deve ser de, no mínimo, 40% acima do seu preço.
    
    3. MERCENARIO: o valor da oferta deve ser de, no mínimo, 80% acima do seu preço.

RN04: o jogador deve possuir um método que, dado um clube de entrada, retorne uma informação que determine se o jogador possui interesse em ser transferido para o clube em questão e, por padrão, o jogador só deve estar interessado em jogar por um clube que tenha uma reputação histórica de, no mínimo, 1 ponto.

RN06: o jogador deve possuir um método que retorna o seu valor de compra e, por padrão, o cálculo do valor de compra do jogador retorna o seu preço acrescido pelo percentual correspondente ao seu apetite financeiro.

RN07: o jogador deve possuir um método para transferencia de clube que, por consequencia, irá atualizar seu clube atual.

#### Tipos de Jogador

##### Goleiro

<img src="https://static-wp-tor15-prd.torcedores.com/wp-content/uploads/2018/12/gremio-marcelo-grohe.png"  width="200" height="120">

_Regras de Negócio do Goleiro_

RN08: o goleiro deve possuir a informação da quantidade de penaltis defendidos no ano.

RN09: o cálculo do valor de compra do goleiro tem um acréscimo de 4% para cada penalti defendido sobre o valor do calculo padrão (RN06).

##### Zagueiro

<img src="https://www.rbsdirect.com.br/imagesrc/25219958.jpg?w=700"  width="200" height="120">

_Regras de Negócio do Zagueiro_

RN10: o cálculo do valor de compra do zagueiro tem um desconto de 20% sobre o valor do calculo padrão (RN06), mas apenas para atletas com mais de 30 anos.

##### Meio-Campo

<img src="https://radaramazonico.com.br/wp-content/uploads/2019/08/naom_5d5670e6f3326.jpg"  width="200" height="120">

_Regras de Negócio do Meio-Campo_

RN11: o cálculo do valor de compra do meio-campo tem um desconto de 30% sobre o valor do calculo padrão (RN06), mas apenas para atletas com mais de 30 anos.

RN12: meio-campista tem interesse em mudar de clube somente quando a reputação histórica do time é, no minimo, 2 pontos menores que a sua. (Sim, só aceita trocar pra um time pior, por algum motivo)

##### Lateral

<img src="https://s2.glbimg.com/qPjch9R4-retq7FwiP_D5yPiZVI=/1200x/smart/filters:cover():strip_icc()/s.glbimg.com/es/ge/f/original/2020/01/13/ferraz.jpg"  width="200" height="120">

_Regras de Negócio do Lateral_

RN13: o lateral deve possuir a informação da quantidade de cruzamentos certeiros no ano.

RN14: o cálculo do valor de compra do lateral tem um acréscimo de 2% para cada cruzamento certeiro calculado sobre o valor do calculo padrão (RN06).

RN15: o cálculo do valor de compra do lateral tem um desconto de 30% sobre o valor calculado com os acréscimos da RN14, mas apenas para atletas com mais de 28 anos. (Primeiro contrato da historia onde o cara recebe menos por jogar melhor)

##### Atacante

<img src="https://i0.statig.com.br/bancodeimagens/cb/kb/b4/cbkbb4p1cqbf03n7dtyp1cy5n.jpg"  width="200" height="120">

_Regras de Negócio do Atacante_

RN16: o atacante deve possuir a informação da quantidade de gols feitos no ano.

RN17: o cálculo do valor de compra do atacante tem um acréscimo de 1% para cada gol sobre o valor do calculo padrão (RN06).

RN18: o cálculo do valor de compra do atacante tem um desconto de 25% sobre o valor do calculado e com os acréscimos (RN18), mas apenas para atletas com mais de 30 anos.

RN19: atancante tem interesse em mudar de clube somente quando a reputação histórica do clube é maior que a sua.

### Negociacao

Esta **será a classe central** da solução, onde serão feitos todas as verificações e trâmites necessários para a negociação.

_Regras de Negócio da Negociação_

RN20: na negociação deve ser verificado se o jogador possui interesse em jogar pelo clube ofertante.

RN21: na negociação deve ser verificado se o clube tem como pagar o valor de compra do jogador.

RN22: a transferencia de clube do jogador deve ocorrer na **Negociacao**, desde que as RN20 e RN21 sejam positivas.

RN23: se efetuada a trasnferência, o saldo disponível em caixa do clube deve ser atualizado.

## Regras Gerais

RN24: o unico método público da classe negociação deve ser possuir seguinte assinatura `public boolean negociar(Clube clubeInteressado, Jogador jogadorDeInteresse)`.

RN25: de acordo com as regras descritas ao longo do enunciado, o método `negociar` deve retornar _true_ quando foi possível realizar a transferência e _false_ quando não.

# Exemplos de Testes

``` Java   
@Test
public void deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa() {

    Negociacao negociacao = new Negociacao();
    Clube clube = new Clube("Grêmio", 10, BigDecimal.valueOf(100000000));
    Goleiro goleiro = new Goleiro("Marcelo Grohe", 33, null, 8, new Indiferente(), BigDecimal.valueOf(800500), 12);

    boolean foiPossivelNegociar = negociacao.negociar(clube, goleiro);

    Assert.assertTrue(foiPossivelNegociar);
}

@Test
public void naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua() {

    Negociacao negociacao = new Negociacao();
    Clube clube = new Clube("Internacional", 3, BigDecimal.valueOf(100000000));
    Atacante atacante = new Atacante("Cristiano Ronaldo", 35, null, 10, new Conservador(), BigDecimal.valueOf(800500), 20);

    boolean foiPossivelNegociar = negociacao.negociar(clube, atacante);

    Assert.assertFalse(foiPossivelNegociar);
}
```

## Testes Obrigatórios

* Devem existir **obrigatóriamente** na solução entregue testes unitários com os seguintes nomes:

    - deveSerPossivelNegociarUmGoleiroComUmClubeQueTemSaldoEmCaixa
    - naoDeveSerPossivelNegociarUmAtacanteComUmClubeQueTemReputacaoHistoricaMenorQueASua
    - naoDeveSerPossivelNegociarPorFaltaDeCaixaDisponivel
    - deveCalcularCorretamenteOPrecoDoMeioCampoComMenosDeTrintaAnos
    - deveCalcularCorretamenteOPrecoDoMeioCampoComMaisDeTrintaAnos
