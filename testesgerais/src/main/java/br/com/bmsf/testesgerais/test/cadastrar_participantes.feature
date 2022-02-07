#
#

@Interado
@Participante
Funcionalidade: Cadastrar Participante

@CadastrarParticipanteSucesso (I, II)
Esquema do Cenario: Cadastrar participante do tipo pessoa juridica com sucesso na plataforma fazendo vinculo ao cadastro no sistema corporativo de pessoas do banco  
	Dado que estou na plataforma de seguros para a criação de um participante "<pessoaExisteEQ3>"
	Quando informo os dados de cadastro "<statusDadosParticipante>" de um participante "<participanteExiste>" do tipo pessoa "<tipoPessoa>"
	Entao ao realizar o cadastro na plataforma receberei um status "<statusApp>"
	E devera ser realizado um novo cadastrado no sistema corporativo de pessoas do banco "<statusEQ3>"
	Exemplos:
		| pessoaExisteEQ3 | statusDadosParticipante | participanteExiste | tipoPessoa | statusApp | statusEQ3
		|       NAO	      |        COMPLETOS        |         NAO	     |  JURIDICA  |	   200	  |	  200
		|       SIM	      |        COMPLETOS     	|         NAO	     |  JURIDICA  |	   200	  |	  200	
				

@CadastrarParticipanteFalha (III, IV, V)
Esquema do Cenario: Cadastrar participante do tipo pessoa juridica com falha na plataforma quando ja existente
	Dado que estou na plataforma de seguros para a criação de um participante "<pessoaExisteEQ3>"
	Quando informo os dados de cadastro "<statusDadosParticipante>" de um participante "<participanteExiste>" do tipo pessoa "<tipoPessoa>"
	Entao ao realizar o cadastro na plataforma receberei um status "<statusApp>"
	E devera ser exibida uma mensagem de falha no cadastro do participante "<mensagemFalha>"
	Exemplos:
	    | pessoaExisteEQ3 | statusDadosParticipante | participanteExiste | tipoPessoa | statusApp | mensagemFalha
		|       NAO		  |        COMPLETOS	  	| 		  SIM		 |  JURIDICA  |	   422	  |	Participante ja existente na plataforma
		|       NAO	  	  |       INCOMPLETOS	    |  		  NAO		 |  JURIDICA  |	   400	  |	Informacoes faltam para o cadastro
		|       NAO	  	  |        INVALIDO	       	|  		  NAO		 |  JURIDICA  |	   400	  |	Informacoes invalidas para o cadastro	
		|       NAO	  	  |        COMPLETOS	    |  		  NAO		 |   FISICA   |	   422	  |	Cadastro de pessoa fisica ainda nao habilitado			
		