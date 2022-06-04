# BikeIbmec
Trabalho A4 Aplicativos Móveis

O Trabalho deverá ser realizado em equipes de 4 alunos e deverá ser carregado na plataforma Canvas em Atividade Avaliativa até o dia 31/05/2022, somente em um dos dois seguintes formatos: .doc ou .pdf. Os trabalhos serão apresentados nos dias 02, 09 e 16/06/2022.
Trabalhos entregues após a data de entrega definida (31/05/2022), serão penalizados com a perda de 2,0 pontos. A data limite para entrega dessa Atividade Avaliativa é até o dia 09/06/2022.
Uma entrega parcial deve ser realizada até o dia 15/04/2022 em Entrega Parcial. As atividades 1, 2 e 3 fazem parte dessa entrega parcial.
No seu trabalho deve constar: Capa com nome completo dos alunos, matrículas, nome do curso, nome da disciplina. Sumário, Introdução, Desenvolvimento, Conclusão e Referências Bibliográficas.

## Divisao de tarefas

Os fragments ja estao criados, faltando apenas implementar os fragments (e layouts) das respectivcas funcionalidades...

- Menu: Luis Mattos <DONE>
- Home: 
- Agendamentos: 
- Cadastro de Clientes: Luis Mattos <DONE>
- Missao: 
- Pedaladas: 
- Programa Milhas: 
- Sobre: 

## Desenvolva as seguintes atividades:

### Parte 1

- [x] 01. Faça pesquisa sobre as seguintes plataformas para desenvolvimento Mobile: React Native, Flutter, Ionic, Xamarim. Ao final faça uma comparação dessas plataformas; (1,0 ponto)
- [x] 02. Pesquise sobre as linguagens de programação Swift e Objective-C. Fale sobre suas características, pontos positivos, negativos e faça uma comparação dessas duas linguagens; (1,0 ponto)
- [x] 03. Faça uma pesquisa sobre a linguagem de programação Kotlin. Apresente as suas características e apresente uma aplicação rodando com o uso dessa linguagem de programação; (1,0 ponto)

### Parte 2

#### Projeto 1 (3,0 pontos)

- [ ] 04
  - [ ] Desenvolva um projeto com o nome de BikeIbmec
  - [ ] Neste projeto você deve criar uma interface (MainActivity) de apresentação do projeto.
  - [ ] apresentando um texto de Boas-vindas e falando sobre a possibilidade de utilização de bikes pelos alunos da Ibmec.
  - [ ] Esta interface deve ter um botão para uma segunda Activity de cadastro do aluno;
- [ ] 05
  - [x] Na segunda Activity(CadastroDadosPessoaisActitvity), desenvolva uma interface para realizar o cadastro do aluno com os seguintes dados:
  ```
    Aluno {
        matricula,
        nome,
        sobrenome,
        sexo (Masculino ou Feminino – utilize um RadioGroup),
        Curso(coloque as opções dos Cursos de Graduação em Engenharia (utilize um checkbox): Computação, Civil, Produção e Mecânica,
        número do celular,
        e-mail,
        dados do cartão de crédito {
            bandeira do cartão(utilize um radio group),
            número do cartão,
            nome do titular,
            data de validade,
            cv,
        },
    }
  ```
  - [ ] Criar mascara para os inputs do form, quando necessario
  - [x] Realizar uma validacao dos dados ao submeter o formulario
  - [x] Após o preenchimento dos dados na segunda activity, uma terceira acitivity deve ser chamada
- [x] 06. A terceira acitivity deve
  - [x] apresentar os dados informados e
  - [x] requisitar confirmação pelo usuário.
  - [x] Caso os dados estejam corretos: o usuário deve clicar em um botão OK e receber uma mensagem “Dados Corretos!” (utilize um Toast).
  - [x] Caso contrário, o usuário deve clicar em um botão CANCELAR e a aplicação deve retornar para a Activity anterior;
- [ ] 07. Desenvolva as interfaces para as seguintes funcionalidades que devem estar disponíveis para serem acessadas através de Botões na MainActivity):
  - [ ] Pedaladas (Históricos de utilização das bicicletas),
  - [ ] Agendamentos,
  - [ ] Programa de Milhas Pedaladas.
  - [ ] Analise, descreva e desenvolva as interfaces gráficas para cada uma dessas funcionalidades do aplicativo.

#### Projeto 2 (4,0 pontos)

- [x] 08. Desenvolva o projeto BikeIbmec utilizando um Navigation Drawer, com as seguintes opções de Menu:
  - [x] Menu 
  - [x] Cadastro Clientes,
  - [ ] Pedaladas,
  - [ ] Agendamentos,
  - [ ] Programa Milhas,
  - [ ] Missão e
  - [ ] Sobre.
- [ ] 09. Na opção Sobre, crie duas opções:
  - [ ] Contato. Na opção de Contatos coloque: E-mail e Site.
  - [ ] Redes Sociais. Na opção de Redes Sociais coloque: Facebook, Instagram, Twitter e Download App.
- [ ] 10.
  - [x] Logo criada e importada para o projeto.
  - [ ] Coloque uma logo para a empresa.
  - [ ] No fragmento Principal, coloque o texto de Boas-vindas!
